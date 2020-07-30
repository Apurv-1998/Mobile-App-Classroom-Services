package com.mobileapplication.app.classroom.service.Service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobileapplication.app.classroom.service.Service.TestService;
import com.mobileapplication.app.classroom.service.entity.StudentEntity;
import com.mobileapplication.app.classroom.service.entity.StudentScoresEntity;
import com.mobileapplication.app.classroom.service.entity.SubjectEntity;
import com.mobileapplication.app.classroom.service.entity.TestEntity;
import com.mobileapplication.app.classroom.service.repository.StudentRepository;
import com.mobileapplication.app.classroom.service.repository.SubjectRepository;
import com.mobileapplication.app.classroom.service.shared.Utils;


@Service
public class TestServiceImpl implements TestService {
	
	@Autowired
	SubjectRepository subjectRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	Utils utils;

	@Override
	public SubjectEntity addTestScoreToSubject(TestEntity testEntity, SubjectEntity subjectEntity) {
		
		List<TestEntity> testEntities = subjectEntity.getTestDetails();
		
		if(testEntities == null) {
			testEntities = new ArrayList<>();
			testEntities.add(testEntity);
			subjectEntity.setTestDetails(testEntities);
		}
		else {
			for(int i=0;i<testEntities.size();i++) {
				TestEntity entity = testEntities.get(i);
				
				if(entity.getTestType().equalsIgnoreCase(testEntity.getTestType())) {
					entity.setAverageScore(utils.FindAverageScore(testEntity.getStudentScoresDetails()));
					
					testEntities.set(i, entity);
					break;
				}
			}
			subjectEntity.setTestDetails(testEntities);
		}
		
		return subjectRepository.save(subjectEntity);

	}

	@Override
	public List<StudentEntity> addTestScoreToSubject(TestEntity testEntity, List<StudentEntity> students) {
		
		List<StudentScoresEntity> studentScoresEntity =  testEntity.getStudentScoresDetails();
		
		List<StudentEntity> savedStudents = new ArrayList<>();
		
		for(StudentScoresEntity entity: studentScoresEntity) {
			
			StudentEntity student = studentRepository.findStudentByRollNumber(entity.getRollNumber());
			
			if(student==null)
				continue;
			else {
				List<StudentScoresEntity> scores = testEntity.getStudentScoresDetails();
				scores = new ArrayList<>();
				scores.add(entity);
				
				TestEntity savedEntity = testEntity;
				savedEntity.setStudentScoresDetails(scores);
				
				Collection<TestEntity> tests = student.getTestDetails();
				
				if(tests == null) {
					tests = new ArrayList<>();
					tests.add(savedEntity);
					student.setTestDetails(tests);
				}
				else {
					tests.add(savedEntity);
					student.setTestDetails(tests);
				}
				
				StudentEntity saved = studentRepository.save(student);
				savedStudents.add(saved);
			}
			
		}
		System.out.println("Printing "+savedStudents);
		return savedStudents;
	}

}
