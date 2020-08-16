package com.mobileapplication.app.classroom.service.Service;

import com.mobileapplication.app.classroom.service.dto.AddLibraryDetailsDto;
import com.mobileapplication.app.classroom.service.dto.AddPlayGroundDto;
import com.mobileapplication.app.classroom.service.dto.AddRestRoomDto;
import com.mobileapplication.app.classroom.service.dto.AddStaffRoomDto;
import com.mobileapplication.app.classroom.service.dto.AddStandardRequestDetailsDto;
import com.mobileapplication.app.classroom.service.entity.OrganizationEntity;
import com.mobileapplication.app.classroom.service.entity.PlayGroundEntity;
import com.mobileapplication.app.classroom.service.entity.RestRoomEntity;
import com.mobileapplication.app.classroom.service.entity.StaffRoomEntity;
import com.mobileapplication.app.classroom.service.entity.StudentEntity;
import com.mobileapplication.app.classroom.service.entity.TeacherEntity;

public interface OrganizationService {
	
	OrganizationEntity addInOrganization(StudentEntity studentDetails);

	OrganizationEntity addTeacherInOrganization(TeacherEntity entity);

	boolean addLibrary(String organizationId, AddLibraryDetailsDto addLibraryDetailsDto);

	void addStandard(String organizationId, AddStandardRequestDetailsDto addStandardRequestDetailsDto);

	RestRoomEntity addRestRooms(String organizationId, String floorId, AddRestRoomDto addRestRoomDto);

	StaffRoomEntity addStaffRoom(String organizationId, String floorId, AddStaffRoomDto staffRoomDto);

	PlayGroundEntity addPlayGround(String organizationId, AddPlayGroundDto addPlayGroundDto);

}
