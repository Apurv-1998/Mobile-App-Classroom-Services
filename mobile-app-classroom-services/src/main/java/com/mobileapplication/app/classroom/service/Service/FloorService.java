package com.mobileapplication.app.classroom.service.Service;

import java.util.List;

import com.mobileapplication.app.classroom.service.dto.AddStandardRequestDetailsDto;
import com.mobileapplication.app.classroom.service.entity.FloorEntity;
import com.mobileapplication.app.classroom.service.entity.TeacherEntity;

public interface FloorService {

	FloorEntity setFloorDetails(AddStandardRequestDetailsDto addStandardRequestDetailsDto);

	List<TeacherEntity> getTeachersOnFloor(FloorEntity floor);

}
