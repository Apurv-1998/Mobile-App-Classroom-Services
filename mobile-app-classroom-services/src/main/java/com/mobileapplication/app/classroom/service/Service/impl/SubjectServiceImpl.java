package com.mobileapplication.app.classroom.service.Service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobileapplication.app.classroom.service.Service.SubjectService;
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
	Utils utils;
	
	@Override
	public SubjectEntity addTeacherInSubject(TeacherEntity teacherEntity) {
		
		SubjectEntity returnValue = new SubjectEntity();
		
		List<TeacherEntity> teachers = new ArrayList<>();
		teachers.add(teacherEntity);
		
		String name = teacherEntity.getSubject();
		
		SubjectEntity entity = subjectRepository.findSubjectByName(name);
		
		if(entity==null) {
			entity = new SubjectEntity();
			entity.setSubjectId(utils.GenerateSubjectId(20));
			entity.setName(teacherEntity.getSubject());
			entity.setTeacherDetails(teachers);
			entity.setStandardDetails(teacherEntity.getStandard());
		}
		else {
			teachers = entity.getTeacherDetails();
			teachers.add(teacherEntity);
			entity.setTeacherDetails(teachers);
		}

		
		
		teacherEntity.setSubjectDetails(entity);
		
		returnValue = subjectRepository.save(entity);
		
		return returnValue;
		
		
	}

}
