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
import com.mobileapplication.app.classroom.service.Service.StudentService;
import com.mobileapplication.app.classroom.service.Service.SubjectService;
import com.mobileapplication.app.classroom.service.Service.TeacherService;
import com.mobileapplication.app.classroom.service.Service.TestService;
import com.mobileapplication.app.classroom.service.dto.AddBooksDetailsDto;
import com.mobileapplication.app.classroom.service.dto.AddLibraryDetailsDto;
import com.mobileapplication.app.classroom.service.dto.AddSectionDetailsDto;
import com.mobileapplication.app.classroom.service.dto.AddSportDto;
import com.mobileapplication.app.classroom.service.dto.AddTeacherToSportsDto;
import com.mobileapplication.app.classroom.service.dto.AddTestDetailsDto;
import com.mobileapplication.app.classroom.service.dto.AttendanceDto;
import com.mobileapplication.app.classroom.service.dto.SessionDetailsDto;
import com.mobileapplication.app.classroom.service.dto.SessionsDto;
import com.mobileapplication.app.classroom.service.dto.StandardDto;
import com.mobileapplication.app.classroom.service.dto.StudentScoresDto;
import com.mobileapplication.app.classroom.service.dto.TeacherDto;
import com.mobileapplication.app.classroom.service.entity.AttendanceEntity;
import com.mobileapplication.app.classroom.service.entity.BookEntity;
import com.mobileapplication.app.classroom.service.entity.FilesEntity;
import com.mobileapplication.app.classroom.service.entity.LibraryEntity;
import com.mobileapplication.app.classroom.service.entity.SessionDetailsEntity;
import com.mobileapplication.app.classroom.service.entity.SessionsEntity;
import com.mobileapplication.app.classroom.service.entity.SportEntity;
import com.mobileapplication.app.classroom.service.entity.StandardEntity;
import com.mobileapplication.app.classroom.service.entity.StudentEntity;
import com.mobileapplication.app.classroom.service.entity.SubjectEntity;
import com.mobileapplication.app.classroom.service.entity.TeacherEntity;
import com.mobileapplication.app.classroom.service.entity.TestEntity;
import com.mobileapplication.app.classroom.service.repository.AttendanceRepository;
import com.mobileapplication.app.classroom.service.repository.BookRepository;
import com.mobileapplication.app.classroom.service.repository.FilesRepository;
import com.mobileapplication.app.classroom.service.repository.LibraryRepository;
import com.mobileapplication.app.classroom.service.repository.OrganizationRepository;
import com.mobileapplication.app.classroom.service.repository.SessionDetailsRepository;
import com.mobileapplication.app.classroom.service.repository.SessionsRepository;
import com.mobileapplication.app.classroom.service.repository.SportRepository;
import com.mobileapplication.app.classroom.service.repository.StandardRepository;
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
	AttendanceRepository attendanceRepository;
	
	@Autowired
	StandardRepository standardRepository;
	
	@Autowired
	LibraryRepository libraryRepository;
	
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	SportRepository sportRepository;
	
	@Autowired
	OrganizationService organizationService;
	
	@Autowired
	SubjectService subjectService;
	
	@Autowired
	StandardService standardService;
	
	@Autowired
	TestService testService;
	
	@Autowired
	StudentService studentService;
	
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

	@Override
	public void markAttendance(String teacherId,AttendanceDto attendanceDto) {
		
		String date = utils.HandleDate(attendanceDto.getDate());
		
		String intendedStandard = attendanceDto.getStandard()+" "+attendanceDto.getSection();
		
		TeacherEntity teacher = teacherRepository.findTeachersByTeacherId(teacherId);
		
		boolean flag = false;
		
		List<StandardEntity> standards =  teacher.getStandard();
		
		for(StandardEntity standard:standards) {
			String standardString = standard.getStandardName()+" "+standard.getSection();
			
			if(intendedStandard.equalsIgnoreCase(standardString)) {
				flag = true;
				break;
			}
		}
		
		if(!flag)
			return;
		
		// Getting the session for that teacher on the entered date
		
		
		List<SessionDetailsEntity> sessionDetails = new ArrayList<>();
		
		List<SessionDetailsEntity> sessionsDetails = teacher.getSessionDetails();
		
		
		for(SessionDetailsEntity entity:sessionsDetails) {
			String standard = entity.getStandard()+" "+entity.getSection();
			
			if(standard.equalsIgnoreCase(intendedStandard))
				sessionDetails.add(entity);
		}
		
		SessionsEntity requiredSession  = null;
		
		flag = false;
		
		for(int i=0;i<sessionDetails.size();i++) {
			
			List<SessionsEntity> entity = sessionDetails.get(i).getSessions();
			
			for(SessionsEntity session:entity) {
				
				String session_date = utils.HandleDate(session.getSessionDate());
				
				System.out.println(date+" "+session_date);
				
				if(session_date.equals(date)){
					requiredSession = session;
					flag = true;
					break;
				}
			}
			if(flag)
				break;
			
		}
		
		if(!flag || requiredSession==null)
			return;
		
		
		
		AttendanceEntity attendanceEntity = mapper.map(attendanceDto,AttendanceEntity.class);
		
//		attendanceEntity.setAttendanceId(utils.GenerateAttendanceId(20));
		
		
		List<AttendanceEntity> list = studentService.markStudentAttendance(attendanceEntity,requiredSession,attendanceEntity.getStandard(),attendanceEntity.getSection());
		
		
		List<StandardEntity> standard_s = standardRepository.findStandardsByStandardNameAndSection(attendanceEntity.getStandard(),attendanceEntity.getSection());
		
		for(StandardEntity standard:standard_s) {
			standard.setAttendanceDetails(list);
			
			standardRepository.save(standard);
			
			attendanceEntity.setStandardDetails(standard);
			attendanceRepository.save(attendanceEntity);
		}
		
	}

	@Override
	public LibraryEntity addBooksInLibrary(AddLibraryDetailsDto addLibraryDetailsDto,String teacherId,String libraryId) {
		
		TeacherEntity librarian = teacherRepository.findTeachersByTeacherId(teacherId);
		
		LibraryEntity library = libraryRepository.findLibraryByLibraryId(libraryId);
		
		System.out.println(library);
		
		if(librarian==null)
			throw new RuntimeException("No Librarian Exists");
		
		if(!librarian.getRole().equalsIgnoreCase("Librarian"))
			throw new RuntimeException("No Librarian Exists");
		
		if(library==null)
			throw new RuntimeException("No Library Exists");
		
		if(!addLibraryDetailsDto.getName().equalsIgnoreCase(library.getName()))
			throw new RuntimeException("Wrong Library Name");
		
		LibraryEntity dummy = mapper.map(addLibraryDetailsDto,LibraryEntity.class);
		List<BookEntity> books = dummy.getBookDetails();
		
		for(int i=0;i<books.size();i++) {
			BookEntity book = books.get(i);
			
			book.setBookId(utils.GenerateLibraryId(15));
			book.setLibraryDetails(library);
			
			books.set(i, book);
		}
		library.setBookDetails(books);
		
		
		List<BookEntity> booksEntity = library.getBookDetails();
		
		for(int i=0;i<booksEntity.size();i++) {
			BookEntity book = booksEntity.get(i);
			
			SubjectEntity subject = subjectRepository.findSubjectByName(book.getSubject());
			
			List<BookEntity> entity = subject.getBookDetails();
			entity.add(book);
			subject.setBookDetails(entity);
			
			
			book.setSubjectDetails(subject);
			
			System.out.println(book);
			
			books.set(i, book);

			subjectRepository.save(subject);
		}
		
		System.out.println(books);
		
		library.setBookDetails(books);
		
		LibraryEntity response =  libraryRepository.save(library);
		
		
		return response;
	}

	@Override
	public BookEntity addCopiesForTheBook(String libraryId, String teacherId, String bookId, int copies) {
		
		LibraryEntity library = libraryRepository.findLibraryByLibraryId(libraryId);
		
		if(library==null)
			throw new RuntimeException("No Library In The Organization");
		
		TeacherEntity librarian = teacherRepository.findTeachersByTeacherId(teacherId);
		
		if(librarian==null)
			throw new RuntimeException("No Librarian In The Organization");
		
		BookEntity book = bookRepository.findBookByBookId(bookId);
		
		if(book==null)
			throw new RuntimeException("No Book With The Given Id Exists");
		
		int total = book.getTotalCopies();
		
		book.setTotalCopies(total+copies);
		
		BookEntity saved = bookRepository.save(book);
		
		return saved;
	}

	@Override
	public TeacherEntity addTeacherToSports(String teacherId,AddTeacherToSportsDto addTeacherToSportsDto) {
		
		TeacherEntity teacher = teacherRepository.findTeachersByTeacherId(teacherId);
		
		if(!teacher.getRole().equalsIgnoreCase("PT") && !teacher.getRole().equalsIgnoreCase("PE") && !teacher.getRole().equalsIgnoreCase("PTE"))
			throw new RuntimeException("The mentioned Teacher is Not a sports teacher");
		
		List<SportEntity> sports = new ArrayList<>();
		
		List<AddSportDto> sportNames =  addTeacherToSportsDto.getSportDetails();
		
		
		for(AddSportDto sportName:sportNames) {
			SportEntity sport = sportRepository.findSportsBySportName(sportName.getSportName());
			if(sport==null)
				continue;
			sports.add(sport);
		}
		
		if(sports.size()==0)
			throw new RuntimeException("Mentioned Sports Have Not Been Started Yet.");
		
		teacher.setSportDetails(sports);
		
		TeacherEntity saved = teacherRepository.save(teacher);
		
		
		for(SportEntity sport:sports) {
			if(sport.getTeacherDetails()==null) {
				List<TeacherEntity> teachers = new ArrayList<>();
				teachers.add(saved);
				sport.setTeacherDetails(teachers);
			}
			else {
				if(sport.getTeacherDetails().size()>2) {
					System.out.println("Maximum SportTeachers Already Assigned "+sport.getTeacherDetails());
					continue;
				}
				List<TeacherEntity> teachers = sport.getTeacherDetails();
				teachers.add(saved);
				sport.setTeacherDetails(teachers);
			}
			sportRepository.save(sport);
		}
		
		
		return saved;
		
		
		
		
	}

}
