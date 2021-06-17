package com.spring.crudspringdatamvc.service;

import com.spring.crudspringdatamvc.entity.Book;

import java.util.List;

public interface BookService {
    public void save(Book book);
    public void deleteById(Long id);
    public Book findById(Long id);
    public List<Book> getBooksList();
}
