package com.ruku.spring.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ruku.spring.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {


}
