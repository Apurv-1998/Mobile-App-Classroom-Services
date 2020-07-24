package com.mobileapplication.app.classroom.service.Service;

import com.mobileapplication.app.classroom.service.entity.OrganizationEntity;
import com.mobileapplication.app.classroom.service.entity.StudentEntity;
import com.mobileapplication.app.classroom.service.entity.TeacherEntity;

public interface OrganizationService {
	
	OrganizationEntity addInOrganization(StudentEntity studentDetails);

	OrganizationEntity addTeacherInOrganization(TeacherEntity entity);

}
