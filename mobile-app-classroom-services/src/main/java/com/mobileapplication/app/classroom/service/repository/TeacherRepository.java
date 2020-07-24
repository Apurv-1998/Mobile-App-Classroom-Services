package com.mobileapplication.app.classroom.service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mobileapplication.app.classroom.service.entity.TeacherEntity;

@Repository
public interface TeacherRepository extends CrudRepository<TeacherEntity, Long> {
	
	TeacherEntity findTeacherBySubject(String subjectName);

}
