package com.mobileapplication.app.classroom.service.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mobileapplication.app.classroom.service.entity.TeacherEntity;

@Repository
public interface TeacherRepository extends CrudRepository<TeacherEntity, Long> {
	
	List<TeacherEntity> findAllTeachersBySubject(String subjectName);
	
	TeacherEntity findTeachersByTeacherId(String teacherId);

}
