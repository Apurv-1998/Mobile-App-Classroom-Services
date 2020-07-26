package com.mobileapplication.app.classroom.service.Service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobileapplication.app.classroom.service.Service.OrganizationService;
import com.mobileapplication.app.classroom.service.Service.SubjectService;
import com.mobileapplication.app.classroom.service.entity.OrganizationEntity;
import com.mobileapplication.app.classroom.service.entity.SubjectEntity;
import com.mobileapplication.app.classroom.service.entity.TeacherEntity;
import com.mobileapplication.app.classroom.service.repository.SubjectRepository;
import com.mobileapplication.app.classroom.service.repository.TeacherRepository;
import com.mobileapplication.app.classroom.service.shared.Utils;

@Service
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	SubjectRepository subjectRepository;
	
	@Autowired
	TeacherRepository teacherRepository;
	
	@Autowired
	OrganizationService organizationService;
	
	@Autowired
	Utils utils;
	
	@Override
	public TeacherEntity addTeacherInSubject(TeacherEntity teacherEntity) {
		
		@SuppressWarnings("unused")
		TeacherEntity returnValue = new TeacherEntity();
		
		List<TeacherEntity> teachers = new ArrayList<>();
		teachers.add(teacherEntity);
		
		String name = teacherEntity.getSubject();
		
		SubjectEntity entity = subjectRepository.findSubjectByName(name);
		
		if(entity==null) {
//			System.out.println("New Subject");
			entity = new SubjectEntity();
			entity.setSubjectId(utils.GenerateSubjectId(20));
			entity.setName(teacherEntity.getSubject());
			entity.setTeacherDetails(teachers);
			entity.setStandardDetails(teacherEntity.getStandard());
		}
		else {
//			System.out.println("Subject Exists");
			teachers = entity.getTeacherDetails();
			if(teacherEntity.getId()!=0L) {
				teachers.add(teacherEntity);
				System.out.println("Teachers "+teachers);
				entity.setTeacherDetails(teachers);
			}
		}

		SubjectEntity subjectSaved = subjectRepository.save(entity);
		
		teacherEntity.setSubjectDetails(subjectSaved);
		
		OrganizationEntity organizationEntity = organizationService.addTeacherInOrganization(teacherEntity);
		
		teacherEntity.setOrganizationDetails(organizationEntity);
		
		System.out.println("Return Value "+teacherEntity);
		
		return teacherEntity;
		
		
	}

}
