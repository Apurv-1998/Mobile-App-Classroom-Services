package com.mobileapplication.app.classroom.service.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mobileapplication.app.classroom.service.Service.StudentService;
import com.mobileapplication.app.classroom.service.Service.TeacherService;
import com.mobileapplication.app.classroom.service.dto.AddSectionDetailsDto;
import com.mobileapplication.app.classroom.service.dto.AddSubjectDto;
import com.mobileapplication.app.classroom.service.dto.AddTestDetailsDto;
import com.mobileapplication.app.classroom.service.dto.StudentDto;
import com.mobileapplication.app.classroom.service.dto.StudentLoginDto;
import com.mobileapplication.app.classroom.service.dto.TeacherDto;
import com.mobileapplication.app.classroom.service.entity.TestEntity;
import com.mobileapplication.app.classroom.service.request.model.AddSectionDetailsModel;
import com.mobileapplication.app.classroom.service.request.model.AddTestScoreRequestDetailsModel;
import com.mobileapplication.app.classroom.service.request.model.CreateStudentsRequestDetailsModel;
import com.mobileapplication.app.classroom.service.request.model.CreateTeacherRequestDetailsModel;
import com.mobileapplication.app.classroom.service.request.model.StudentLoginDetails;
import com.mobileapplication.app.classroom.service.request.model.SubjectDetailsModel;
import com.mobileapplication.app.classroom.service.response.model.StudentRest;
import com.mobileapplication.app.classroom.service.response.model.TeacherRest;

@RestController
@RequestMapping("/classroom")
public class UserController {
	

	
	
	@Autowired
	StudentService studentService;
	
	
	@Autowired
	TeacherService teacherService;
	
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
	public boolean performSignIn(@RequestBody StudentLoginDetails loginDetails) {
		
		StudentLoginDto loginDto = mapper.map(loginDetails,StudentLoginDto.class);
				
		return studentService.loginStudent(loginDto);
		
		
	}
	
	
	/*------- Student Add Subject Method ----------*/
	@PostMapping(path = "/student/{studentId}/addSubjects",produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public StudentRest addSubjectForStudent(@PathVariable String studentId,@RequestBody SubjectDetailsModel subjectDetails) {
		
		AddSubjectDto addSubjectDto = mapper.map(subjectDetails,AddSubjectDto.class);
		
		
		
		StudentDto studentDto = studentService.addSubject(addSubjectDto,studentId);
		
		StudentRest returnValue = mapper.map(studentDto,StudentRest.class);
		
		return returnValue;
		
		
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

}
