package com.mobileapplication.app.classroom.service.Service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobileapplication.app.classroom.service.Service.OrganizationService;
import com.mobileapplication.app.classroom.service.Service.TeacherService;
import com.mobileapplication.app.classroom.service.dto.StandardDto;
import com.mobileapplication.app.classroom.service.dto.TeacherDto;
import com.mobileapplication.app.classroom.service.entity.OrganizationEntity;
import com.mobileapplication.app.classroom.service.entity.TeacherEntity;
import com.mobileapplication.app.classroom.service.repository.OrganizationRepository;
import com.mobileapplication.app.classroom.service.repository.TeacherRepository;
import com.mobileapplication.app.classroom.service.shared.Utils;


@Service
public class TeacherServiceImpl implements TeacherService {
	
	@Autowired
	ModelMapper mapper;
	
	@Autowired
	TeacherRepository teacherRepository;
	
	@Autowired
	OrganizationRepository organizationRepository;
	
	@Autowired
	OrganizationService organizationService;
	
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
		
		
		OrganizationEntity organizationEntity = organizationService.addTeacherInOrganization(entity);
		
		entity.setOrganizationDetails(organizationEntity);
		
		TeacherEntity savedTeached = teacherRepository.save(entity);
		
		
		returnValue = mapper.map(savedTeached, TeacherDto.class);
		
		
		return returnValue;
	}

}
