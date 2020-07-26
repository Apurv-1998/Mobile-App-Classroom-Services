package com.mobileapplication.app.classroom.service.Service;

import java.util.List;

import com.mobileapplication.app.classroom.service.dto.AddSectionDetailsDto;
import com.mobileapplication.app.classroom.service.entity.StandardEntity;

public interface StandardService {
	
	boolean CheckIfTeacherAlreadyHasStandard(AddSectionDetailsDto addSectionDetailsDto,List<StandardEntity> currentStandards);

}
