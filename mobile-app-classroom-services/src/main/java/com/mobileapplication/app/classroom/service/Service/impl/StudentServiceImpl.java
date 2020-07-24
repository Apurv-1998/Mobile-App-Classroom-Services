package com.mobileapplication.app.classroom.service.Service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobileapplication.app.classroom.service.Service.OrganizationService;
import com.mobileapplication.app.classroom.service.Service.StudentService;
import com.mobileapplication.app.classroom.service.dto.AddSubjectDto;
import com.mobileapplication.app.classroom.service.dto.StudentDto;
import com.mobileapplication.app.classroom.service.dto.StudentLoginDto;
import com.mobileapplication.app.classroom.service.entity.OrganizationEntity;
import com.mobileapplication.app.classroom.service.entity.StandardEntity;
import com.mobileapplication.app.classroom.service.entity.StudentEntity;
import com.mobileapplication.app.classroom.service.entity.SubjectEntity;
import com.mobileapplication.app.classroom.service.entity.TeacherEntity;
import com.mobileapplication.app.classroom.service.repository.OrganizationRepository;
import com.mobileapplication.app.classroom.service.repository.StudentRepository;
import com.mobileapplication.app.classroom.service.repository.SubjectRepository;
import com.mobileapplication.app.classroom.service.repository.TeacherRepository;
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
	public boolean loginStudent(StudentLoginDto loginDto) {
		boolean returnValue = false;
		
		
		String organization_name = loginDto.getOrganization();
		String user_mail = loginDto.getEmail();
		String user_password = loginDto.getPassword();
		
		
		OrganizationEntity organization_found = organizationRepository.findOrganizationByName(organization_name);
		if(organization_found==null)
			return returnValue;
		
		StudentEntity student_found = studentRepository.findStudentByEmail(user_mail);
		
		if(student_found==null || !student_found.getPassword().equals(user_password) || !student_found.getOrganization().equals(organization_name))
			return returnValue;
		else
			returnValue = true;
		
		
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
		
		TeacherEntity teachers = teacherRepository.findTeacherBySubject(subjectName);
		
		if(teachers==null)
			return returnValue;
		
		List<StandardEntity> standards = teachers.getStandard();
		
		String standard = addSubjectDto.getStandard();
		String section = addSubjectDto.getSection();
		
		boolean flag = false;
		
		for(StandardEntity standardEntity:standards) {
			if(standardEntity.getStandardName().equalsIgnoreCase(standard) && standardEntity.getSection().equalsIgnoreCase(section)) {
				flag = true;
				break;
			}
		}
		
		if(!flag)
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

}
