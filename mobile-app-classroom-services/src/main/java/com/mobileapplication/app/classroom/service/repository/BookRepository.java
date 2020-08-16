package com.mobileapplication.app.classroom.service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mobileapplication.app.classroom.service.entity.BookEntity;

@Repository
public interface BookRepository extends CrudRepository<BookEntity, Long> {

	BookEntity findBookByBookId(String bookId);

}
