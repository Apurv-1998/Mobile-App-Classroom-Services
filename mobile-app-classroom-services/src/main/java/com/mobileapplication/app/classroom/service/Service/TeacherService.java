package com.mobileapplication.app.classroom.service.Service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.mobileapplication.app.classroom.service.dto.AddLibraryDetailsDto;
import com.mobileapplication.app.classroom.service.dto.AddSectionDetailsDto;
import com.mobileapplication.app.classroom.service.dto.AddTeacherToSportsDto;
import com.mobileapplication.app.classroom.service.dto.AddTestDetailsDto;
import com.mobileapplication.app.classroom.service.dto.AttendanceDto;
import com.mobileapplication.app.classroom.service.dto.SessionDetailsDto;
import com.mobileapplication.app.classroom.service.dto.TeacherDto;
import com.mobileapplication.app.classroom.service.entity.BookEntity;
import com.mobileapplication.app.classroom.service.entity.FilesEntity;
import com.mobileapplication.app.classroom.service.entity.LibraryEntity;
import com.mobileapplication.app.classroom.service.entity.TeacherEntity;
import com.mobileapplication.app.classroom.service.entity.TestEntity;

public interface TeacherService {
	
	TeacherDto createTeacher(TeacherDto teacherDto);
	
	TeacherDto addTeacherInSection(String teacherId,AddSectionDetailsDto addSectionDetailsDto);
	
	TestEntity addTestScore(String teacherId,AddTestDetailsDto addTestDetailsDto);

	boolean uploadFiles(String teacherId, MultipartFile[] files);

	List<FilesEntity> getAllFiles();

	SessionDetailsDto addSessionDetails(String teacherId,SessionDetailsDto sessionDetailsDto);

	void markAttendance(String teacherId, AttendanceDto attendanceDto);

	LibraryEntity addBooksInLibrary(AddLibraryDetailsDto addLibraryDetailsDto, String teacherId, String libraryId);

	BookEntity addCopiesForTheBook(String libraryId, String teacherId, String bookId, int copies);

	TeacherEntity addTeacherToSports(String teacherId, AddTeacherToSportsDto addTeacherToSportsDto);

}
