package com.mobileapplication.app.classroom.service.Service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobileapplication.app.classroom.service.Service.FloorService;
import com.mobileapplication.app.classroom.service.dto.AddStandardRequestDetailsDto;
import com.mobileapplication.app.classroom.service.entity.FloorEntity;
import com.mobileapplication.app.classroom.service.entity.StandardEntity;
import com.mobileapplication.app.classroom.service.entity.TeacherEntity;
import com.mobileapplication.app.classroom.service.repository.FloorRepository;
import com.mobileapplication.app.classroom.service.shared.Utils;

@Service
public class FloorServiceImpl implements FloorService {

	@Autowired
	FloorRepository floorRepository;
	
	@Autowired
	Utils utils;
	
	@Override
	public FloorEntity setFloorDetails(AddStandardRequestDetailsDto addStandardRequestDetailsDto) {
		
		FloorEntity floor = new FloorEntity();
		
		String standard = addStandardRequestDetailsDto.getStandard();
		String section = addStandardRequestDetailsDto.getSection();
		
		floor.setFloorId(utils.GenerateFloorId(7));
		floor.setFloorNumber(utils.getFloorNumber(standard,section));
		floor.setFloorName(utils.getFloorName(utils.getFloorNumber(standard,section)));
		
		
		return floor;
		
		
	}

	@Override
	public List<TeacherEntity> getTeachersOnFloor(FloorEntity floor) {
		
		List<TeacherEntity> teachers = new ArrayList<>();
		
		List<StandardEntity> standards = floor.getStandardDetails();
		
		System.out.println(standards);
		
		for(StandardEntity standard:standards) {
			teachers.add(standard.getTeacherDetails());
		}
		System.out.println(teachers);
		return teachers;
	}

}
