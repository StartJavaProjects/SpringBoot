package com.ruku.spring.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ruku.spring.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
