package com.mobileapplication.app.classroom.service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mobileapplication.app.classroom.service.entity.PlayGroundEntity;

@Repository
public interface PlayGroundRepository extends CrudRepository<PlayGroundEntity, Long> {

}
