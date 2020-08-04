package com.mobileapplication.app.classroom.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mobileapplication.app.classroom.service.entity.SessionDetailsEntity;

@Repository
public interface SessionDetailsRepository extends CrudRepository<SessionDetailsEntity, Long> {
	
	
	@Query(value = "SELECT * FROM sessions_details s WHERE s.standard = ?1 AND s.section = ?2",nativeQuery = true)
	List<SessionDetailsEntity> findSessionsByStandardAndSection(String standard, String section);

}
