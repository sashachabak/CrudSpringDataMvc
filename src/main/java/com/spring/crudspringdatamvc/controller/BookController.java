package com.spring.crudspringdatamvc.controller;

import com.spring.crudspringdatamvc.entity.Book;
import com.spring.crudspringdatamvc.service.BookService;
import com.spring.crudspringdatamvc.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookController {
    private final BookService bookService;
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    private String showBooks (Model model) {
        model.addAttribute("books", bookService.getBooksList());
        return "books_list";
    }
    @GetMapping("/book/edit/{id}")
    private String editBookPage(@PathVariable("id") Long id, @ModelAttribute("book") Book book) {
        return "book_edit";
    }
    @PostMapping("/book/edit/{id}")
    private String editBook(@ModelAttribute("book") Book book) {
        bookService.save(book);
        return "redirect:/books";
    }
    @GetMapping("/book/new")
    private String newBookPage(@ModelAttribute("book") Book book) {
        return "new_book";
    }
    @PostMapping("/book/new")
    private String newBook(@ModelAttribute("book") Book book) {
        bookService.save(book);
        return "redirect:/books";
    }
    @GetMapping("/book/delete/{id}")
    private String deleteBook(@PathVariable("id") Long id) {
        bookService.deleteById(id);
        return "redirect:/books";
    }
}
