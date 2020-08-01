package com.mobileapplication.app.classroom.service.Service;

import java.util.List;

import com.mobileapplication.app.classroom.service.entity.StudentEntity;
import com.mobileapplication.app.classroom.service.entity.SubjectEntity;
import com.mobileapplication.app.classroom.service.entity.TestEntity;

public interface TestService {
	
	SubjectEntity addTestScoreToSubject(TestEntity testEntity,SubjectEntity subjectEntity);
	List<StudentEntity> addTestScoreToSubject(TestEntity testEntity,List<StudentEntity> students);
	void improveService(TestEntity returnValue);

}
