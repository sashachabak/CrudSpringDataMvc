package com.spring.crudspringdatamvc.service;

import com.spring.crudspringdatamvc.entity.Book;
import com.spring.crudspringdatamvc.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    @PreAuthorize("hasAuthority('developers:write')")
    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    @PreAuthorize("hasAuthority('developers:delete')")
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    @PreAuthorize("hasAuthority('developers:read')")
    public Book findById(Long id) {
        return bookRepository.getById(id);
    }

    @Override
    @PreAuthorize("hasAuthority('developers:read')")
    public List<Book> getBooksList() {
        return bookRepository.findAll();
    }
}
