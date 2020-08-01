package com.mobileapplication.app.classroom.service.Service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
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
import com.mobileapplication.app.classroom.service.repository.TestRepository;
import com.mobileapplication.app.classroom.service.shared.Utils;


@Service
public class TestServiceImpl implements TestService {
	
	@Autowired
	SubjectRepository subjectRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	TestRepository testRepository;
	
	@Autowired
	Utils utils;

	@Override
	public SubjectEntity addTestScoreToSubject(TestEntity testEntity, SubjectEntity subjectEntity) {
		
//		System.out.println(subjectEntity);
		
		List<TestEntity> testEntities = subjectEntity.getTestDetails();
		
		if(testEntities.size()==0) {
//			System.out.println("Entering Here");
			testEntities = new ArrayList<>();
			testEntities.add(testEntity);
			subjectEntity.setTestDetails(testEntities);
		}
		else {
//			System.out.println("Entering Else ");
			testEntities.add(testEntity);
			subjectEntity.setTestDetails(testEntities);
		}
		
		SubjectEntity savedSubject =  subjectRepository.save(subjectEntity);
		
//		System.out.println(savedSubject);
		
		return savedSubject;

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
	//	System.out.println("Printing "+savedStudents);
		return savedStudents;
	}

	@Override
	public void improveService(TestEntity returnValue) {
		
		Iterator<TestEntity> iterator = testRepository.findAll().iterator();
		
		while(iterator.hasNext()) {
			TestEntity entity = iterator.next();
			
			if(entity.getSubjectDetails()==null) {
				System.out.println("Entered Here");
				testRepository.delete(entity);
			}
		}
		
	}

}
