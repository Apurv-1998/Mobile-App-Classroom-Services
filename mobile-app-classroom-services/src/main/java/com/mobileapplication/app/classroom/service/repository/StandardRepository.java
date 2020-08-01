package com.mobileapplication.app.classroom.service.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mobileapplication.app.classroom.service.entity.StandardEntity;

@Repository
public interface StandardRepository extends CrudRepository<StandardEntity, Long> {

	List<StandardEntity> findAllStandardsByStandardName(String standard);

}
