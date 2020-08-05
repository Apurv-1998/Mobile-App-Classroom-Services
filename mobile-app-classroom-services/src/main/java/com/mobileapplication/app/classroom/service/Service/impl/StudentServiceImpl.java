package com.mobileapplication.app.classroom.service.Service.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobileapplication.app.classroom.service.Service.OrganizationService;
import com.mobileapplication.app.classroom.service.Service.StudentService;
import com.mobileapplication.app.classroom.service.dto.AddSubjectDto;
import com.mobileapplication.app.classroom.service.dto.GetFilesDetailsDto;
import com.mobileapplication.app.classroom.service.dto.StudentDto;
import com.mobileapplication.app.classroom.service.dto.StudentLoginDto;
import com.mobileapplication.app.classroom.service.entity.AttendanceEntity;
import com.mobileapplication.app.classroom.service.entity.FilesEntity;
import com.mobileapplication.app.classroom.service.entity.OrganizationEntity;
import com.mobileapplication.app.classroom.service.entity.SessionDetailsEntity;
import com.mobileapplication.app.classroom.service.entity.SessionsEntity;
import com.mobileapplication.app.classroom.service.entity.StandardEntity;
import com.mobileapplication.app.classroom.service.entity.StudentEntity;
import com.mobileapplication.app.classroom.service.entity.SubjectEntity;
import com.mobileapplication.app.classroom.service.entity.TeacherEntity;
import com.mobileapplication.app.classroom.service.repository.AttendanceRepository;
import com.mobileapplication.app.classroom.service.repository.FilesRepository;
import com.mobileapplication.app.classroom.service.repository.OrganizationRepository;
import com.mobileapplication.app.classroom.service.repository.SessionDetailsRepository;
import com.mobileapplication.app.classroom.service.repository.SessionsRepository;
import com.mobileapplication.app.classroom.service.repository.StandardRepository;
import com.mobileapplication.app.classroom.service.repository.StudentRepository;
import com.mobileapplication.app.classroom.service.repository.SubjectRepository;
import com.mobileapplication.app.classroom.service.repository.TeacherRepository;
import com.mobileapplication.app.classroom.service.response.model.SessionsRest;
import com.mobileapplication.app.classroom.service.shared.Utils;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	ModelMapper mapper;
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	OrganizationService organizationService;
	
	@Autowired
	OrganizationRepository organizationRepository;
	
	@Autowired
	SubjectRepository subjectRepository;
	
	@Autowired
	TeacherRepository teacherRepository;
	
	@Autowired
	StandardRepository standardRepository;
	
	@Autowired
	FilesRepository filesRepository;
	
	@Autowired
	SessionDetailsRepository sessionDetailsRepository;
	
	@Autowired
	SessionsRepository sessionsRepository;
	
	@Autowired
	AttendanceRepository attendanceRepository;
	
	@Autowired
	Utils utils;
	
	@Override
	public StudentDto createStudent(StudentDto studentDto) {
		
		StudentEntity entity = mapper.map(studentDto, StudentEntity.class);
		
		/*
		 * 1) Set User Id
		 * 2) Set Encrypted Password.
		 * */
		
		entity.setStudentId(utils.generateStudentId(20));
		entity.setEncryptedPassword(utils.generateEncryptedPassword(30));
		OrganizationEntity dto =  organizationService.addInOrganization(entity);
		
		entity.setOrganizationDetails(dto);
		
		System.out.println(dto);
		
		StudentEntity savedUser = studentRepository.save(entity);
		
		studentDto = mapper.map(savedUser,StudentDto.class);
		
		return studentDto;
	}

	@Override
	public boolean loginStudent(StudentLoginDto loginDto) throws ParseException {
		boolean returnValue = false;
		
		
		String organization_name = loginDto.getOrganization();
		String user_mail = loginDto.getEmail();
		String user_password = loginDto.getPassword();
		
		
		OrganizationEntity organization_found = organizationRepository.findOrganizationByName(organization_name);
		if(organization_found==null)
			return returnValue;
		
		StudentEntity student_found = studentRepository.findStudentByEmail(user_mail);
		
		if(student_found==null || !student_found.getPassword().equals(user_password) || !student_found.getOrganization().equals(organization_name) || student_found.isSignedIn())
			return returnValue;
		else {
			student_found.setLoginTime(utils.ManageDate(System.currentTimeMillis()));
			student_found.setLogoutTime(null);
			student_found.setSignedIn(true);
			studentRepository.save(student_found);
			returnValue = true;
		}
		
		
		return returnValue;
	}

	@SuppressWarnings("unused")
	@Override
	public StudentDto addSubject(AddSubjectDto addSubjectDto,String studentId) {
		StudentDto returnValue = new StudentDto();
		
		String subjectName = addSubjectDto.getName();
		
		SubjectEntity subjectEntity = subjectRepository.findSubjectByName(subjectName);
		
		
		StudentEntity studentEntity = studentRepository.findStudentByStudentId(studentId);
		
		if(subjectEntity==null)
			return returnValue;
		
		List<TeacherEntity> teachers = teacherRepository.findAllTeachersBySubject(subjectName);
		
		if(teachers==null)
			return returnValue;
		
		System.out.println(teachers.size());
		
		
		List<String> standards = utils.GeneratedStandardsString(teachers);
		
		System.out.println("Available Standards "+standards);
		
		String studentClass = studentEntity.getStandard()+" "+studentEntity.getSection();
		
		if(!standards.contains(studentClass))
			return returnValue;
		
		
		
		Collection<SubjectEntity> subjects = studentEntity.getSubjectDetails();
		subjects.add(subjectEntity);
		studentEntity.setSubjectDetails(subjects);
		
		
		StudentEntity entity = studentRepository.save(studentEntity);
		
		
		if(studentEntity==null)
			return returnValue;
		
		
		Collection<StudentEntity> students = subjectEntity.getStudentDetails();
		students.add(studentEntity);
		
		subjectEntity.setStudentDetails(students);
		
		subjectRepository.save(subjectEntity);
		
		returnValue = mapper.map(entity, StudentDto.class);
		
		return returnValue;
	}

	@Override
	public List<FilesEntity> getAllFiles(GetFilesDetailsDto getFilesDetailsDto) {
		
		List<StandardEntity> standards = standardRepository.findAllStandardsByStandardName(getFilesDetailsDto.getStandard());
		
		if(standards==null)
			return null;
		
	    List<TeacherEntity> teachers = new ArrayList<>();
	    
	    for(StandardEntity standard:standards) {
	    	teachers.add(standard.getTeacherDetails());
	    }
	    
	    TeacherEntity teacher = null;
	    boolean flag = false;
	    
	    for(TeacherEntity entity:teachers) {
	    	List<StandardEntity> standardEntity = entity.getStandard();
	    	
	    	for(StandardEntity standard:standardEntity) {
	    		if(standard.getSection().equals(getFilesDetailsDto.getSection())) {
	    			teacher = entity;
	    			flag = true;
	    			break;
	    		}
	    	}
	    	if(flag)
	    		break;
	    }
	    
	    if(teacher==null)
	    	return null;
		
	    if(!teacher.getSubject().equalsIgnoreCase(getFilesDetailsDto.getSubjectName()))
	    	return null;
	    
	    return teacher.getFileDetails();
		
	}

	@Override
	public FilesEntity getFiles(String fileId, String studentId) {
		FilesEntity entity = filesRepository.findAllFilesByFilesId(fileId);
		
		return entity;
	}

	@Override
	public LinkedHashMap<String, List<List<SessionsRest>>> getAllSessions(String studentId) {
	
		StudentEntity student = studentRepository.findStudentByStudentId(studentId);
		
		List<SessionDetailsEntity> sessionDetailsEntity = sessionDetailsRepository.findSessionsByStandardAndSection(student.getStandard(),student.getSection());
		
		
		LinkedHashMap<String,List<List<SessionsRest>>> map = new LinkedHashMap<>();
		
		for(SessionDetailsEntity session:sessionDetailsEntity) {
			
			String subject = session.getTeacherDetails().getSubject();
			
			if(map.containsKey(subject)) {
				List<List<SessionsRest>> list = map.get(subject);
				
				list.add(utils.getSessionsRestFromSessionDetails(session));
				
				map.put(subject,list);
				
			}
			else {
				List<List<SessionsRest>> list = new ArrayList<>();
				
				list.add(utils.getSessionsRestFromSessionDetails(session));
				
				map.put(subject,list);
			}
			
		}
		
		return map;
		
		
	}

	@Override
	public boolean performSignout(String studentId) {
		boolean returnValue = false;
		
		StudentEntity entity = studentRepository.findStudentByStudentId(studentId);
		
		if(entity==null)
			throw new RuntimeException("Studnt With StudentId -> "+studentId+" Does Not Exist");
		
		if(!entity.isSignedIn())
			return returnValue;
		
		else {
			try {
				returnValue = true;
				entity.setSignedIn(false);
				entity.setLogoutTime(utils.ManageDate(System.currentTimeMillis()));
				studentRepository.save(entity);
			}catch(Exception e) {
				return returnValue;
			}
		}
		
		return returnValue;
	}

	@Override
	public List<AttendanceEntity> markStudentAttendance(AttendanceEntity attendanceEntity, SessionsEntity session,String standard,String section) {
		
		List<StudentEntity> students_in_class = studentRepository.findStudentsByStandardAndSection(standard,section);
		
		System.out.println(students_in_class.size());
		
		List<AttendanceEntity> list = new ArrayList<>();
		
		String session_start_time = session.getStartTime();
		String session_end_time = session.getEndTime();
		
		for(StudentEntity entity:students_in_class) {
			
			String entered_class = entity.getLoginTime();
			String exit_class = entity.getLogoutTime();
			
			if(utils.ComparableTimes(entered_class)<=utils.ComparableTimes(session_start_time) && utils.ComparableTimes(exit_class)>=utils.ComparableTimes(session_end_time)) {
				attendanceEntity.setAttendanceId(utils.GenerateSessionsId(5));
				attendanceEntity.setStudentDetails(entity);
				attendanceEntity.setSessionDetails(session);
				attendanceEntity.setPresent(true);
				
				
				list.add(attendanceEntity);
				
				entity.setAttendanceDetails(attendanceEntity);				
				session.setAttendanceDetails(attendanceEntity);
				attendanceRepository.save(attendanceEntity);
				studentRepository.save(entity);
				sessionsRepository.save(session);
				
			}
			else {
				attendanceEntity.setAttendanceId(utils.GenerateSessionsId(5));
				attendanceEntity.setStudentDetails(entity);
				attendanceEntity.setSessionDetails(session);
				
				list.add(attendanceEntity);
				
				entity.setAttendanceDetails(attendanceEntity);				
				session.setAttendanceDetails(attendanceEntity);
				attendanceRepository.save(attendanceEntity);
				studentRepository.save(entity);
				sessionsRepository.save(session);
			}
			
		}
		
		
		return list;
	}

	@Override
	public ArrayList getAttendancePercentage(String studentId, String subject) {
		
		StudentEntity student = studentRepository.findStudentByStudentId(studentId);
		
		AttendanceEntity attendance = student.getAttendanceDetails();
		
		List<StudentEntity> students = new ArrayList<>();
		
		if(attendance.getSessionDetails().getSessionDetails().getTeacherDetails().getSubject().equalsIgnoreCase(subject)) {
			
			Iterator<AttendanceEntity> it = attendanceRepository.findAll().iterator();
			
			while(it.hasNext()) {
				AttendanceEntity entity = it.next();
				
				if(entity.getStudentDetails().getStudentId().equals(studentId)) {
					students.add(entity.getStudentDetails());
				}
			}
			
		}
		
		int countPresent=0;
		
		for(int i=0;i<students.size();i++)
			if(students.get(i).getAttendanceDetails().isPresent()==true)
				countPresent++;
		System.out.println(countPresent);
		double ans = ((double)countPresent/(double)students.size())*100.0;
		
		ArrayList responseList = new ArrayList();
		
		responseList.add(ans);
		responseList.add(students.size());
		
		System.out.println(responseList);
		
		return responseList;
		
	}

}
