package com.mobileapplication.app.classroom.service.Service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobileapplication.app.classroom.service.Service.OrganizationService;
import com.mobileapplication.app.classroom.service.entity.OrganizationEntity;
import com.mobileapplication.app.classroom.service.entity.StudentEntity;
import com.mobileapplication.app.classroom.service.entity.TeacherEntity;
import com.mobileapplication.app.classroom.service.repository.OrganizationRepository;
import com.mobileapplication.app.classroom.service.shared.Utils;

@Service
public class OrganizationServiceimpl implements OrganizationService {

	
	@Autowired
	OrganizationRepository organizationRepository;
	
	@Autowired
	Utils utils;
	
	@Override
	public OrganizationEntity addInOrganization(StudentEntity studentDetails) {
		
		OrganizationEntity returnValue = new OrganizationEntity();
		
		List<StudentEntity> students = new ArrayList<>();
		
		students.add(studentDetails);
		
		String name = studentDetails.getOrganization();
		
		OrganizationEntity found = organizationRepository.findOrganizationByName(name);
		
		if(found==null) {
			found = new OrganizationEntity();
			found.setName(name);
			found.setOrganizationId(utils.GenerateOrganizationId(20));
			found.setStudentDetails(students);
		}
		else {
			found.setStudentDetails(students);
		}
		
		OrganizationEntity saved = organizationRepository.save(found);
		
		returnValue = saved;
		
		
		return returnValue;
		
		
	}


	@Override
	public OrganizationEntity addTeacherInOrganization(TeacherEntity entity) {
		OrganizationEntity returnValue = new OrganizationEntity();
		
		if(entity==null)
			return returnValue;
		
		//Hello
		
		List<TeacherEntity> teachers = new ArrayList<>();
		teachers.add(entity);
		
		String name = entity.getOrganization();
		
		OrganizationEntity organization =  organizationRepository.findOrganizationByName(name);
		
		
		if(organization==null) {
			organization = new OrganizationEntity();
			organization.setName(name);
			organization.setOrganizationId(utils.GenerateOrganizationId(20));
			organization.setTeacherDetails(teachers);
		}
		else {
			teachers = organization.getTeacherDetails();
			teachers.add(entity);
			organization.setTeacherDetails(teachers);
		}
		
		returnValue = organizationRepository.save(organization);
		
		return returnValue;
	}

}
