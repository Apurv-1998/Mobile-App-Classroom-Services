package com.mobileapplication.app.classroom.service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mobileapplication.app.classroom.service.entity.FloorEntity;

@Repository
public interface FloorRepository extends CrudRepository<FloorEntity, Long> {

	FloorEntity findFloorByFloorNumber(int num);

	FloorEntity findFloorByFloorId(String floorId);

}
