package com.mobileapplication.app.classroom.service.Service;

import com.mobileapplication.app.classroom.service.dto.AddSectionDetailsDto;
import com.mobileapplication.app.classroom.service.dto.AddTestDetailsDto;
import com.mobileapplication.app.classroom.service.dto.TeacherDto;
import com.mobileapplication.app.classroom.service.entity.TestEntity;

public interface TeacherService {
	
	TeacherDto createTeacher(TeacherDto teacherDto);
	
	TeacherDto addTeacherInSection(String teacherId,AddSectionDetailsDto addSectionDetailsDto);
	
	TestEntity addTestScore(String teacherId,AddTestDetailsDto addTestDetailsDto);

}
