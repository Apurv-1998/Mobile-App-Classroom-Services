package com.mobileapplication.app.classroom.service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mobileapplication.app.classroom.service.entity.FilesEntity;

@Repository
public interface FilesRepository extends CrudRepository<FilesEntity, Long> {

	FilesEntity findAllFilesByFilesId(String fileId);

}
