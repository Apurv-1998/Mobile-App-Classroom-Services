package com.mobileapplication.app.classroom.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mobileapplication.app.classroom.service.entity.StandardEntity;

@Repository
public interface StandardRepository extends CrudRepository<StandardEntity, Long> {

	List<StandardEntity> findAllStandardsByStandardName(String standard);
	
	
	@Query(value = "SELECT * FROM standards s WHERE s.standard_name = ?1 AND s.section = ?2",nativeQuery = true)
	List<StandardEntity> findStandardsByStandardNameAndSection(String standard, String section);
	
	@Query(value = "SELECT * FROM standards s WHERE s.standard_name = ?1 AND s.section = ?2",nativeQuery = true)
	StandardEntity findStandardByStandardNameAndSection(String standard, String section);

}
