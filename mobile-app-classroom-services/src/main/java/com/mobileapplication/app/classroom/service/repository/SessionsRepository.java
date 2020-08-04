package com.mobileapplication.app.classroom.service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mobileapplication.app.classroom.service.entity.SessionsEntity;


@Repository
public interface SessionsRepository extends CrudRepository<SessionsEntity, Long> {

}
