package com.mobileapplication.app.classroom.service.Service;

import java.text.ParseException;
import java.util.LinkedHashMap;
import java.util.List;

import com.mobileapplication.app.classroom.service.dto.AddSubjectDto;
import com.mobileapplication.app.classroom.service.dto.GetFilesDetailsDto;
import com.mobileapplication.app.classroom.service.dto.StudentDto;
import com.mobileapplication.app.classroom.service.dto.StudentLoginDto;
import com.mobileapplication.app.classroom.service.entity.FilesEntity;
import com.mobileapplication.app.classroom.service.response.model.SessionsRest;

public interface StudentService {
	
	StudentDto createStudent(StudentDto studentDto);
	
	boolean loginStudent(StudentLoginDto loginDto) throws ParseException;
	
	StudentDto addSubject(AddSubjectDto addSubjectDto,String studentId);

	List<FilesEntity> getAllFiles(GetFilesDetailsDto getFilesDetailsDto);

	FilesEntity getFiles(String fileId, String studentId);

	LinkedHashMap<String, List<List<SessionsRest>>> getAllSessions(String studentId);

	boolean performSignout(String studentId);
}
