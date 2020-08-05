package com.mobileapplication.app.classroom.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
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
	
	
	@Query(value = "SELECT * FROM students s WHERE s.standard = ?1 AND s.section = ?2",nativeQuery = true)
	List<StudentEntity> findStudentsByStandardAndSection(String standard, String section);
	
}
