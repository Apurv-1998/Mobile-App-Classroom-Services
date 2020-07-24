package com.mobileapplication.app.classroom.service.Service;

import com.mobileapplication.app.classroom.service.dto.StudentDto;
import com.mobileapplication.app.classroom.service.dto.StudentLoginDto;

public interface StudentService {
	
	StudentDto createStudent(StudentDto studentDto);
	
	boolean loginStudent(StudentLoginDto loginDto);
	
}
