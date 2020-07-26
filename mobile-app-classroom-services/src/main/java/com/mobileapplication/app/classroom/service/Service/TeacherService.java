package com.mobileapplication.app.classroom.service.Service;

import com.mobileapplication.app.classroom.service.dto.AddSectionDetailsDto;
import com.mobileapplication.app.classroom.service.dto.TeacherDto;

public interface TeacherService {
	
	TeacherDto createTeacher(TeacherDto teacherDto);
	
	TeacherDto addTeacherInSection(String teacherId,AddSectionDetailsDto addSectionDetailsDto);

}
