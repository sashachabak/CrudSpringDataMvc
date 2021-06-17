package com.spring.crudspringdatamvc.repository;

import com.spring.crudspringdatamvc.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long>, JpaRepository<Book, Long> {

}
