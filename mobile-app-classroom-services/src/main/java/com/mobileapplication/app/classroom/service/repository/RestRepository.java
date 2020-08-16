package com.mobileapplication.app.classroom.service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mobileapplication.app.classroom.service.entity.RestEntity;

@Repository
public interface RestRepository extends CrudRepository<RestEntity, Long> {

}
