package com.mobileapplication.app.classroom.service.Service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobileapplication.app.classroom.service.Service.OrganizationService;
import com.mobileapplication.app.classroom.service.Service.StandardService;
import com.mobileapplication.app.classroom.service.Service.SubjectService;
import com.mobileapplication.app.classroom.service.Service.TeacherService;
import com.mobileapplication.app.classroom.service.dto.AddSectionDetailsDto;
import com.mobileapplication.app.classroom.service.dto.StandardDto;
import com.mobileapplication.app.classroom.service.dto.TeacherDto;
import com.mobileapplication.app.classroom.service.entity.StandardEntity;
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
	SubjectService subjectService;
	
	@Autowired
	StandardService standardService;
	
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

}
