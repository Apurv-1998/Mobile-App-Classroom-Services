package com.mobileapplication.app.classroom.service.Service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mobileapplication.app.classroom.service.Service.OrganizationService;
import com.mobileapplication.app.classroom.service.Service.StandardService;
import com.mobileapplication.app.classroom.service.Service.SubjectService;
import com.mobileapplication.app.classroom.service.Service.TeacherService;
import com.mobileapplication.app.classroom.service.Service.TestService;
import com.mobileapplication.app.classroom.service.dto.AddSectionDetailsDto;
import com.mobileapplication.app.classroom.service.dto.AddTestDetailsDto;
import com.mobileapplication.app.classroom.service.dto.SessionDetailsDto;
import com.mobileapplication.app.classroom.service.dto.SessionsDto;
import com.mobileapplication.app.classroom.service.dto.StandardDto;
import com.mobileapplication.app.classroom.service.dto.StudentScoresDto;
import com.mobileapplication.app.classroom.service.dto.TeacherDto;
import com.mobileapplication.app.classroom.service.entity.FilesEntity;
import com.mobileapplication.app.classroom.service.entity.SessionDetailsEntity;
import com.mobileapplication.app.classroom.service.entity.StandardEntity;
import com.mobileapplication.app.classroom.service.entity.StudentEntity;
import com.mobileapplication.app.classroom.service.entity.SubjectEntity;
import com.mobileapplication.app.classroom.service.entity.TeacherEntity;
import com.mobileapplication.app.classroom.service.entity.TestEntity;
import com.mobileapplication.app.classroom.service.repository.FilesRepository;
import com.mobileapplication.app.classroom.service.repository.OrganizationRepository;
import com.mobileapplication.app.classroom.service.repository.SessionDetailsRepository;
import com.mobileapplication.app.classroom.service.repository.SessionsRepository;
import com.mobileapplication.app.classroom.service.repository.StudentRepository;
import com.mobileapplication.app.classroom.service.repository.SubjectRepository;
import com.mobileapplication.app.classroom.service.repository.TeacherRepository;
import com.mobileapplication.app.classroom.service.repository.TestRepository;
import com.mobileapplication.app.classroom.service.shared.Utils;


@Service
public class TeacherServiceImpl implements TeacherService {
	
	@Autowired
	ModelMapper mapper;
	
	@Autowired
	TeacherRepository teacherRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	OrganizationRepository organizationRepository;
	
	@Autowired
	TestRepository testRepository;
	
	@Autowired
	FilesRepository filesRepository;
	
	@Autowired
	SubjectRepository subjectRepository;
	
	@Autowired
	SessionDetailsRepository sessionDetailsRepository;
	
	@Autowired
	SessionsRepository sessionsRepository;
	
	@Autowired
	OrganizationService organizationService;
	
	@Autowired
	SubjectService subjectService;
	
	@Autowired
	StandardService standardService;
	
	@Autowired
	TestService testService;
	
	@Autowired
	Utils utils;

	@Override
	public TeacherDto createTeacher(TeacherDto teacherDto) {
		
		TeacherDto returnValue = new TeacherDto();
		
	//	System.out.println(teacherDto.getStandard());
		
		for(int i=0;i<teacherDto.getStandard().size();i++) {
			
			StandardDto standard =  teacherDto.getStandard().get(i);
			
			standard.setTeacherDetails(teacherDto);
			
			teacherDto.getStandard().set(i, standard);
		}
		
	//	System.out.println(teacherDto.getStandard());
		
		
		TeacherEntity entity = new TeacherEntity();
		
		entity = mapper.map(teacherDto,TeacherEntity.class);
		
		System.out.println(entity);
		
		/*
		 * 1)Set TeacherId
		 * 2) Set Encrypted Password
		 * */
		
		entity.setTeacherId(utils.GenerateTeachersId(20));
		entity.setEncryptedPassword(utils.generateEncryptedPassword(30));
		entity.setEncrpytedRegId(utils.GenerateEncryptedRegId(20));
		
		System.out.println(entity.getStandard().size());
		
		entity = subjectService.addTeacherInSubject(entity);
		
		
		TeacherEntity savedTeached = teacherRepository.save(entity);
		
		System.out.println("Saved Teacher "+savedTeached);
		
		
		returnValue = mapper.map(savedTeached, TeacherDto.class);
		
		
		return returnValue;
	}

	@Override
	public TeacherDto addTeacherInSection(String teacherId,AddSectionDetailsDto addSectionDetailsDto) {
		TeacherDto returnValue = new TeacherDto();
		
		TeacherEntity entity = teacherRepository.findTeachersByTeacherId(teacherId);
		
		if(entity==null) {
			System.out.println("Entered Entity Null");
			return returnValue;
		}
		
		List<StandardEntity> currentStandards = entity.getStandard();
		
		if(currentStandards.size()>=3)
			return returnValue;
		
		boolean verifyStandard = standardService.CheckIfTeacherAlreadyHasStandard(addSectionDetailsDto,currentStandards);
		
		if(verifyStandard)
			return returnValue;
		
		StandardEntity standardEntity = new StandardEntity();
		standardEntity.setStandardName(addSectionDetailsDto.getStandard());
		standardEntity.setSection(addSectionDetailsDto.getSection());
		standardEntity.setTeacherDetails(entity);
		
		currentStandards.add(standardEntity);
		
		entity.setStandard(currentStandards);
		
		TeacherEntity savedTeacher = teacherRepository.save(entity);
		
		returnValue = mapper.map(savedTeacher,TeacherDto.class);
		
		return returnValue;
	}

	@Override
	public TestEntity addTestScore(String teacherId, AddTestDetailsDto addTestDetailsDto) {
		
		List<StudentScoresDto> studentScores = addTestDetailsDto.getStudentScoresDetails();
		
		for(int i=0;i<studentScores.size();i++) {
			StudentScoresDto studentScore =  studentScores.get(i);
			
			studentScore.setTestDetails(addTestDetailsDto);
			
			studentScores.set(i, studentScore);
		}
		
		addTestDetailsDto.setStudentScoresDetails(studentScores);
		
		
		
		TeacherEntity teacherEntity = teacherRepository.findTeachersByTeacherId(teacherId);
		
		SubjectEntity subjectEntity = teacherEntity.getSubjectDetails();
		
		List<StudentEntity> found_students = studentRepository.findStudentByStandard(addTestDetailsDto.getStandard());
		
		String targetStandard = addTestDetailsDto.getStandard()+" "+addTestDetailsDto.getSection();
		
		List<StudentEntity> students = new ArrayList<>();
		
		for(StudentEntity entity:found_students) {
			
			String s = entity.getStandard()+" "+entity.getSection();
			
			if(s.equalsIgnoreCase(targetStandard))
				students.add(entity);
		}
		
		if(students.size()==0)
			return null;

		TestEntity testEntity = mapper.map(addTestDetailsDto,TestEntity.class);
		
		testEntity.setTestId(utils.GenerateTestId(20));
		
		SubjectEntity savedSubject = testService.addTestScoreToSubject(testEntity,subjectEntity);
		List<StudentEntity> savedStudents = testService.addTestScoreToSubject(testEntity,students);
		
		testEntity.setSubjectDetails(savedSubject);
		testEntity.setStudentDetails(savedStudents);
		
		testService.improveService(testEntity);
		
		return testRepository.save(testEntity);
		
	}

	@Override
	public boolean uploadFiles(String teacherId, MultipartFile[] files) {
		
		TeacherEntity teacher = teacherRepository.findTeachersByTeacherId(teacherId);
		
		SubjectEntity subject = teacher.getSubjectDetails();
		
		List<FilesEntity> savedFiles = new ArrayList<>();
		
		for(MultipartFile file:files) {
			savedFiles.add(saveFile(file,teacher,subject));
		}
		
		teacher.setFileDetails(savedFiles);
		subject.setFileDetails(savedFiles);
		
		List<TeacherEntity> teachers = subject.getTeacherDetails();
		
		for(int i=0;i<teachers.size();i++) {
			if(teachers.get(i).equals(teacher)) {
				teachers.set(i,teacher);
				break;
			}
		}
		
		subject.setTeacherDetails(teachers);
		teacher.setSubjectDetails(subject);
		
		subject = subjectRepository.save(subject);
		teacher = teacherRepository.save(teacher);
		
		
		return subject!=null && teacher!=null;
		
	}
	
	public FilesEntity saveFile(MultipartFile file,TeacherEntity teacher,SubjectEntity subject) {
		
		String fileName = file.getOriginalFilename();
		
		try {
			System.out.println("File Saved");
			FilesEntity fileEntity = new FilesEntity(fileName,file.getContentType(),file.getBytes());
			fileEntity.setFilesId(utils.GenerateFileId(30));
			fileEntity.setTeacherDetails(teacher);
			fileEntity.setSubjectDetails(subject);
			
			return filesRepository.save(fileEntity);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<FilesEntity> getAllFiles() {
		List<FilesEntity> files = new ArrayList<>();
		
		Iterator<FilesEntity> iterator =  filesRepository.findAll().iterator();
		
		while(iterator.hasNext())
			files.add(iterator.next());
		return files;
	}

	@Override
	public SessionDetailsDto addSessionDetails(String teacherId, SessionDetailsDto sessionDetailsDto) {
		
		TeacherEntity teacher = teacherRepository.findTeachersByTeacherId(teacherId);
		
		//Adding Standard Check
		boolean flag = false;
		
		String teacherStandard = sessionDetailsDto.getStandard()+" "+sessionDetailsDto.getSection();
		
		List<StandardEntity> standards = teacher.getStandard();
		
		for(StandardEntity standardEntity:standards) {
			String standard = standardEntity.getStandardName()+" "+standardEntity.getSection();
			
			if(standard.equalsIgnoreCase(teacherStandard)) {
				flag = true;
				break;
			}
		}
		
		if(!flag)
			throw new RuntimeException(teacher.getFirstName()+" "+teacher.getLastname()+" Is Not Associated With The Section");
		
		
		List<SessionsDto> sessionsDto = sessionDetailsDto.getSessions();
		
		for(int i=0;i<sessionsDto.size();i++) {
			SessionsDto sessions = sessionsDto.get(i);
			
			sessions.setSessionsId(utils.GenerateSessionsId(10));
			sessions.setSessionsPassword(utils.GenerateSessionsPassword(10));
			
			sessions.setSessionDetails(sessionDetailsDto);
			
			sessionsDto.set(i, sessions);
		}
		
		sessionDetailsDto.setSessions(sessionsDto);
		
		SessionDetailsEntity sessionDetailsEntity = mapper.map(sessionDetailsDto,SessionDetailsEntity.class);
		
		sessionDetailsEntity.setSessionId(utils.GenerateSessionDetailsId(20));
		
		sessionDetailsEntity.setTeacherDetails(teacher);
		
		SessionDetailsEntity savedEntity = sessionDetailsRepository.save(sessionDetailsEntity);
		
		
		List<SessionDetailsEntity> entity = teacher.getSessionDetails();
		entity.add(savedEntity);
		teacher.setSessionDetails(entity);
		teacherRepository.save(teacher);
		
		return mapper.map(savedEntity,SessionDetailsDto.class);
		
		
		
	}

}
