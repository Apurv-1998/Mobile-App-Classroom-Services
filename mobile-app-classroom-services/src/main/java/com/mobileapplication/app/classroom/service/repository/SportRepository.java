package com.mobileapplication.app.classroom.service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mobileapplication.app.classroom.service.entity.SportEntity;

@Repository
public interface SportRepository extends CrudRepository<SportEntity, Long> {

	SportEntity findSportsBySportName(String string);

}
