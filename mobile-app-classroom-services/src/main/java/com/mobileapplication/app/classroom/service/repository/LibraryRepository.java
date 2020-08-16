package com.mobileapplication.app.classroom.service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mobileapplication.app.classroom.service.entity.LibraryEntity;

@Repository
public interface LibraryRepository extends CrudRepository<LibraryEntity, Long> {

	LibraryEntity findLibraryByLibraryId(String libraryId);

}
