package com.spring.crudspringdatamvc.repository;

import com.spring.crudspringdatamvc.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface BookRepository extends CrudRepository<Book, Long>, JpaRepository<Book, Long> {
}
