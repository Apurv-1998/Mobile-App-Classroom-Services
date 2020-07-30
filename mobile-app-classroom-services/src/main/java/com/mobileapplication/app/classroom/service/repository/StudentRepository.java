package com.mobileapplication.app.classroom.service.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mobileapplication.app.classroom.service.entity.StudentEntity;

@Repository
public interface StudentRepository extends CrudRepository<StudentEntity, Long> {
	
	StudentEntity findStudentByEmail(String email);
	
	StudentEntity findStudentByStudentId(String studentId);

	//List<StudentEntity> findStudentBySubject(String name);

	StudentEntity findStudentByRollNumber(String rollNumber);

	List<StudentEntity> findStudentByStandard(String standard);
	
}
