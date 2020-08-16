package com.mobileapplication.app.classroom.service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mobileapplication.app.classroom.service.entity.OrganizationEntity;

@Repository
public interface OrganizationRepository extends CrudRepository<OrganizationEntity, Long> {

	OrganizationEntity findOrganizationByName(String name);

	OrganizationEntity findOrganizationByOrganizationId(String organizationId);
	
}
