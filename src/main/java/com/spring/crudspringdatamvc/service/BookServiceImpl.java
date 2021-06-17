package com.spring.crudspringdatamvc.service;

import com.spring.crudspringdatamvc.entity.Book;
import com.spring.crudspringdatamvc.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.getById(id);
    }
    @Override
    public List<Book> getBooksList() {
        return bookRepository.findAll();
    }
}
