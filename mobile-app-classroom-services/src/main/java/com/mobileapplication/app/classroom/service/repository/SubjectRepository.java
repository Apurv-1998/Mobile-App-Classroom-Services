package com.mobileapplication.app.classroom.service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mobileapplication.app.classroom.service.entity.SubjectEntity;

@Repository
public interface SubjectRepository extends CrudRepository<SubjectEntity, Long> {
	
	SubjectEntity findSubjectByName(String name);

}
