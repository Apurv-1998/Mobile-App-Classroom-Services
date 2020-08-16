package com.mobileapplication.app.classroom.service.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mobileapplication.app.classroom.service.Service.OrganizationService;
import com.mobileapplication.app.classroom.service.Service.StudentService;
import com.mobileapplication.app.classroom.service.Service.TeacherService;
import com.mobileapplication.app.classroom.service.dto.AddLibraryDetailsDto;
import com.mobileapplication.app.classroom.service.dto.AddPlayGroundDto;
import com.mobileapplication.app.classroom.service.dto.AddRestRoomDto;
import com.mobileapplication.app.classroom.service.dto.AddSectionDetailsDto;
import com.mobileapplication.app.classroom.service.dto.AddStaffRoomDto;
import com.mobileapplication.app.classroom.service.dto.AddStandardRequestDetailsDto;
import com.mobileapplication.app.classroom.service.dto.AddSubjectDto;
import com.mobileapplication.app.classroom.service.dto.AddTeacherToSportsDto;
import com.mobileapplication.app.classroom.service.dto.AddTestDetailsDto;
import com.mobileapplication.app.classroom.service.dto.AttendanceDto;
import com.mobileapplication.app.classroom.service.dto.GetFilesDetailsDto;
import com.mobileapplication.app.classroom.service.dto.SessionDetailsDto;
import com.mobileapplication.app.classroom.service.dto.StudentDto;
import com.mobileapplication.app.classroom.service.dto.StudentLoginDto;
import com.mobileapplication.app.classroom.service.dto.TeacherDto;
import com.mobileapplication.app.classroom.service.entity.BookEntity;
import com.mobileapplication.app.classroom.service.entity.FilesEntity;
import com.mobileapplication.app.classroom.service.entity.LibraryEntity;
import com.mobileapplication.app.classroom.service.entity.PlayGroundEntity;
import com.mobileapplication.app.classroom.service.entity.RestRoomEntity;
import com.mobileapplication.app.classroom.service.entity.StaffRoomEntity;
import com.mobileapplication.app.classroom.service.entity.TeacherEntity;
import com.mobileapplication.app.classroom.service.entity.TestEntity;
import com.mobileapplication.app.classroom.service.request.model.AddLibraryDetailsModel;
import com.mobileapplication.app.classroom.service.request.model.AddPlayGroundDetailsModel;
import com.mobileapplication.app.classroom.service.request.model.AddRestRoomRequestDetailsModel;
import com.mobileapplication.app.classroom.service.request.model.AddSectionDetailsModel;
import com.mobileapplication.app.classroom.service.request.model.AddStaffRoomDetailsRequestModel;
import com.mobileapplication.app.classroom.service.request.model.AddStandardRequestDetailsModel;
import com.mobileapplication.app.classroom.service.request.model.AddTeachersToSportsRequestDetailsModel;
import com.mobileapplication.app.classroom.service.request.model.AddTestScoreRequestDetailsModel;
import com.mobileapplication.app.classroom.service.request.model.AttendanceDetailsModel;
import com.mobileapplication.app.classroom.service.request.model.CreateStudentsRequestDetailsModel;
import com.mobileapplication.app.classroom.service.request.model.CreateTeacherRequestDetailsModel;
import com.mobileapplication.app.classroom.service.request.model.GetFilesDetailsModel;
import com.mobileapplication.app.classroom.service.request.model.SessionDetailsModel;
import com.mobileapplication.app.classroom.service.request.model.StudentLoginDetails;
import com.mobileapplication.app.classroom.service.request.model.SubjectDetailsModel;
import com.mobileapplication.app.classroom.service.response.model.AttendanceRest;
import com.mobileapplication.app.classroom.service.response.model.BookRest;
import com.mobileapplication.app.classroom.service.response.model.FilesRest;
import com.mobileapplication.app.classroom.service.response.model.LibraryRest;
import com.mobileapplication.app.classroom.service.response.model.PlayGroundRest;
import com.mobileapplication.app.classroom.service.response.model.RestRoomRest;
import com.mobileapplication.app.classroom.service.response.model.SessionDetailsRest;
import com.mobileapplication.app.classroom.service.response.model.SessionsRest;
import com.mobileapplication.app.classroom.service.response.model.SportTeacherRest;
import com.mobileapplication.app.classroom.service.response.model.StaffRoomRest;
import com.mobileapplication.app.classroom.service.response.model.StudentRest;
import com.mobileapplication.app.classroom.service.response.model.TeacherRest;
import com.mobileapplication.app.classroom.service.shared.Utils;

@RestController
@RequestMapping("/classroom")
public class UserController {
	
	@Autowired
	Utils utils;
	
	@Autowired
	StudentService studentService;
	
	
	@Autowired
	TeacherService teacherService;
	
	@Autowired
	OrganizationService organizationService;
	
	@Autowired 
	ModelMapper mapper;
	
	/*----Student Controller Methods -------*/
	
	@PostMapping(path = "/student/signup",produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public StudentRest createStudent(@RequestBody CreateStudentsRequestDetailsModel studentsModel) {
		
		StudentDto studentDto = mapper.map(studentsModel,StudentDto.class);
		
		StudentDto createdStudent = studentService.createStudent(studentDto);
		
		StudentRest response = mapper.map(createdStudent,StudentRest.class);
		
		return response;
		
	}
	
	@PostMapping(path = "/student/signin",produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public boolean performSignIn(@RequestBody StudentLoginDetails loginDetails) throws ParseException {
		
		StudentLoginDto loginDto = mapper.map(loginDetails,StudentLoginDto.class);
				
		return studentService.loginStudent(loginDto);
		
		
	}
	
	@GetMapping(path = "/student/{studentId}/signout")
	public boolean performSignOut(@PathVariable String studentId) {
		return studentService.performSignout(studentId);
	}
	
	/*------- Student Add Subject Method ----------*/
	@PostMapping(path = "/student/{studentId}/addSubjects",produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public StudentRest addSubjectForStudent(@PathVariable String studentId,@RequestBody SubjectDetailsModel subjectDetails) {
		
		AddSubjectDto addSubjectDto = mapper.map(subjectDetails,AddSubjectDto.class);
		
		
		
		StudentDto studentDto = studentService.addSubject(addSubjectDto,studentId);
		
		StudentRest returnValue = mapper.map(studentDto,StudentRest.class);
		
		return returnValue;
		
		
	}
	
	
	/*-------- Student Getting The List Of Files -----------*/
	
	@PostMapping(path = "/{studentId}/getFiles")
	public List<FilesRest> getFiles(@PathVariable String studentId,@RequestBody GetFilesDetailsModel getFilesDetailsModel) {
		
		GetFilesDetailsDto getFilesDetailsDto = mapper.map(getFilesDetailsModel,GetFilesDetailsDto.class);
		
		List<FilesEntity> files = studentService.getAllFiles(getFilesDetailsDto);
		
		List<FilesRest> response = new ArrayList<>();
		
		for(FilesEntity file:files) {
			FilesRest filesRest = mapper.map(file,FilesRest.class);
			response.add(filesRest);
		}
		
		return response;
		
	}
	
	/*----- Student Downloading The Required Files ----------*/
	
	@GetMapping(path = "/{studentId}/getFiles/{fileId}")
	public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable String studentId,@PathVariable String fileId){
		
		FilesEntity file = studentService.getFiles(fileId,studentId);
		
		return ResponseEntity.ok().contentType(MediaType.parseMediaType(file.getFileType()))
							 .header(HttpHeaders.CONTENT_DISPOSITION,"attachment:filename=\""+file.getFileName()+"\"")
							 .body(new ByteArrayResource(file.getData()));
		
	}
	
	
	@GetMapping(path = "/")
	public String getAllFiles(Model model) {
		List<FilesEntity> files = teacherService.getAllFiles();
		model.addAttribute("files", files);
		return "file";
	}
	
	
	/*-------------- Getting all the sessions for their classes -----------------*/
	
	@GetMapping(path = "/students/{studentId}/getSessions",produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public LinkedHashMap<String, List<List<SessionsRest>>> getAllSessions(@PathVariable String studentId) {
		
		return studentService.getAllSessions(studentId);
		
	}
	
	/*---- Getting The Attendance Percentage -----*/
	
	@GetMapping(path = "/students/{studentId}/getAttendance")
	public AttendanceRest getAttendance(@PathVariable String studentId,@RequestParam(name = "subject") String subject) {
		
		ArrayList attendance = studentService.getAttendancePercentage(studentId,subject);
		
		AttendanceRest response  =new AttendanceRest();
		
		response.setSubject(subject);
		response.setAttendance((double)attendance.get(0));
		response.setNumber_of_classes_to_attain_threshold(utils.CalculateNumberOfClassesToAttainThreshold(attendance));
		
		return response;
		
	}
	
	
	/*------- Teacher Controller Methods ---------*/
	
	@PostMapping(path = "/teacher/signup",produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public TeacherRest createTeacher(@RequestBody CreateTeacherRequestDetailsModel teacherModel) {
		
		System.out.println(teacherModel);
		
		TeacherDto teacherDto = mapper.map(teacherModel,TeacherDto.class);
		
		TeacherDto savedValue = teacherService.createTeacher(teacherDto);
		
		TeacherRest response = mapper.map(savedValue,TeacherRest.class);
		
		return response;
		
		
		
	}
	
	/*---- Add Section --------*/
	
	@PostMapping(path = "/teachers/{teacherId}/addSection",produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public TeacherRest AddSectionRequest(@PathVariable String teacherId, @RequestBody AddSectionDetailsModel addSectionDetailsModel) {
		
		AddSectionDetailsDto addSectionDetailsDto = mapper.map(addSectionDetailsModel,AddSectionDetailsDto.class);
		
		TeacherDto teacherDto =  teacherService.addTeacherInSection(teacherId,addSectionDetailsDto);
		
		TeacherRest response = mapper.map(teacherDto,TeacherRest.class);
		
		
		return response;
		
		
	}
	
	/*----- Teacher Add Score -------*/
	
	/*
	 *1) Teacher find all students by standards.
	 *2) Iterate through the list and add score.
	 * */
	
	@PostMapping(path = "/{teacherId}/addScore",produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public boolean addScore(@PathVariable String teacherId,@RequestBody AddTestScoreRequestDetailsModel addTestScoreDetailsModel) {
		
		AddTestDetailsDto addTestDetailsDto = mapper.map(addTestScoreDetailsModel,AddTestDetailsDto.class);
		
		TestEntity testEntity = teacherService.addTestScore(teacherId,addTestDetailsDto);
		
		return testEntity!=null;
		
	}
	
	
	/*------- Teacher Uploading files -------*/
	
	
	@PostMapping(path = "/{teacherId}/uploadFiles",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public boolean uploadFiles(@PathVariable String teacherId,@RequestParam(value = "files") MultipartFile[] files) {
		
		return teacherService.uploadFiles(teacherId,files);
	}
	
	
	/*----- Teacher Mark Sessions --------*/
	
	@PostMapping(path = "/teachers/{teacherId}/addSessions",produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public SessionDetailsRest addSessions(@PathVariable String teacherId,@RequestBody SessionDetailsModel sessionDetailsModel) {
		
		SessionDetailsDto sessionDetailsDto = mapper.map(sessionDetailsModel,SessionDetailsDto.class);
		
		SessionDetailsDto savedDto = teacherService.addSessionDetails(teacherId,sessionDetailsDto);
		
		SessionDetailsRest response = mapper.map(savedDto,SessionDetailsRest.class);
		
		return response;
		
	}
	
	/*---- Teacher Marking The Attendance -------*/
	
	@PostMapping(path = "teachers/{teacherId}/markAttendance",produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public void markAttendance(@PathVariable String teacherId,@RequestBody AttendanceDetailsModel attendanceDetailsModel) {
		
		AttendanceDto attendanceDto = mapper.map(attendanceDetailsModel,AttendanceDto.class);
		
		teacherService.markAttendance(teacherId,attendanceDto);
		
	}
	
	/*----Adding Sports Teacher To Sports -------*/
	
	@PostMapping(path = "/teachers/{teacherId}/addToSports",produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public SportTeacherRest addTeacherToSports(@PathVariable String teacherId,@RequestBody AddTeachersToSportsRequestDetailsModel addTeachersToSportsRequestDetailsModel){
		
		AddTeacherToSportsDto addTeacherToSportsDto = mapper.map(addTeachersToSportsRequestDetailsModel,AddTeacherToSportsDto.class);
		
		TeacherEntity sportTeacher = teacherService.addTeacherToSports(teacherId,addTeacherToSportsDto);
		
		return mapper.map(sportTeacher, SportTeacherRest.class);
		
	}
	
	
	
	
	/*------------------- Library Controllers --------------------------*/
	
	
	//Create The Library -> Organization
	
	@PostMapping(path = "/organization/{organizationId}/addLibrary",produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public boolean createLibrary(@PathVariable String organizationId,@RequestBody AddLibraryDetailsModel addLibraryDetailsModel) {
		
		AddLibraryDetailsDto addLibraryDetailsDto = mapper.map(addLibraryDetailsModel,AddLibraryDetailsDto.class);
		
		return organizationService.addLibrary(organizationId,addLibraryDetailsDto);
		
	}
	
	// Adding The Book
	@PostMapping(path = "/library/{libraryId}/librarian/{teacherId}/addBooks",produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public LibraryRest addBook(@PathVariable String libraryId,@PathVariable String teacherId,@RequestBody AddLibraryDetailsModel addLibraryDetailsModel) {
		
		AddLibraryDetailsDto addLibraryDetailsDto = mapper.map(addLibraryDetailsModel,AddLibraryDetailsDto.class);
		
		LibraryEntity entity= teacherService.addBooksInLibrary(addLibraryDetailsDto,teacherId,libraryId);
		
		LibraryRest response = mapper.map(entity,LibraryRest.class);
		
		return response;
	}
	
	//Adding The Copies
	@PostMapping(path = "/library/{libraryId}/librarian/{teacherId}/addBooks/{bookId}",produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public BookRest addCopies(@PathVariable String libraryId,@PathVariable String teacherId,@PathVariable String bookId,@RequestParam(name = "copies") int copies) {
		
		BookEntity entity =  teacherService.addCopiesForTheBook(libraryId,teacherId,bookId,copies);
		
		BookRest response = mapper.map(entity,BookRest.class);
		
		return response;
		
		
	}
	
	
	
	/*------- Organization Controller Methods -------*/
	
	
	/*Dividing School Into Floors*/
	
	@PostMapping(path = "/organization/{organizationId}/addToFloor",produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public void addToFloor(@PathVariable String organizationId,@RequestBody AddStandardRequestDetailsModel addStandardRequestDetailsModel) {
		
		AddStandardRequestDetailsDto addStandardRequestDetailsDto = mapper.map(addStandardRequestDetailsModel,AddStandardRequestDetailsDto.class);
		
		
		organizationService.addStandard(organizationId,addStandardRequestDetailsDto);
		
	}
	
	//Adding Rest-Rooms to the floor
	
	@PostMapping(path = "/organization/{organizationId}/floor/{floorId}/addRestRooms",produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public RestRoomRest addRestRooms(@PathVariable String organizationId, @PathVariable String floorId,@RequestBody AddRestRoomRequestDetailsModel addResRoomRequestdetailsModel) {
		
		AddRestRoomDto addRestRoomDto = mapper.map(addResRoomRequestdetailsModel,AddRestRoomDto.class);
		
		RestRoomEntity restRoom = organizationService.addRestRooms(organizationId,floorId,addRestRoomDto);
		
		return mapper.map(restRoom,RestRoomRest.class);
		
	}
	
	//Adding The Staff-Rooms
	
	@PostMapping(path = "/organization/{organizationId}/floor/{floorId}/addStaffRooms",produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public StaffRoomRest addStaffRoom(@PathVariable String organizationId,@PathVariable String floorId,@RequestBody AddStaffRoomDetailsRequestModel addStaffRoomDetailsRequestModel) {
		
		AddStaffRoomDto staffRoomDto = mapper.map(addStaffRoomDetailsRequestModel,AddStaffRoomDto.class);
		
		StaffRoomEntity staffRoomEntity = organizationService.addStaffRoom(organizationId,floorId,staffRoomDto);
		
		StaffRoomRest response =  mapper.map(staffRoomEntity,StaffRoomRest.class);
		
		return response;
		
	}
	
	//adding Play-grounds
	
	@PostMapping(path = "/organization/{organizationId}/addPlayGround",produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public PlayGroundRest addPlayGrounds(@PathVariable String organizationId,@RequestBody AddPlayGroundDetailsModel addPlayGoundDetailsModel) {
		
		AddPlayGroundDto addPlayGroundDto = mapper.map(addPlayGoundDetailsModel,AddPlayGroundDto.class);
		
		PlayGroundEntity playGround =  organizationService.addPlayGround(organizationId,addPlayGroundDto);
		
		return mapper.map(playGround,PlayGroundRest.class);
	}
	
	//Add Laboratories
	
	@PostMapping(path = "/organization/{organizationId}/addLabs",produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public void addlaboratories(@PathVariable String organizationId) {
		
	}

}
