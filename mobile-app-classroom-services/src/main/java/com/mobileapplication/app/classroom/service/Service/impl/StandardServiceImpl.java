package com.mobileapplication.app.classroom.service.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobileapplication.app.classroom.service.Service.StandardService;
import com.mobileapplication.app.classroom.service.dto.AddSectionDetailsDto;
import com.mobileapplication.app.classroom.service.entity.StandardEntity;
import com.mobileapplication.app.classroom.service.shared.Utils;


@Service
public class StandardServiceImpl implements StandardService {
	
	@Autowired
	Utils utils;

	@Override
	public boolean CheckIfTeacherAlreadyHasStandard(AddSectionDetailsDto addSectionDetailsDto,List<StandardEntity> currentStandards) {
		
		String sectionToBeAdded = addSectionDetailsDto.getStandard()+" "+addSectionDetailsDto.getSection();
		
		List<String> alreadyAddeddSections = utils.GeneratedAlreadyStandardsString(currentStandards);
		
		
		return alreadyAddeddSections.contains(sectionToBeAdded);
	}

}
