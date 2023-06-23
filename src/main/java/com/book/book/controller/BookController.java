package com.book.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.book.book.model.Book;
import com.book.book.service.BookService;

@RestController
// @RequestMapping("/api")
public class BookController {

    @Autowired
    private BookService bookService;

    // adding book controller
    @PostMapping("/add_book")
    public Book addBookController(@RequestBody Book book) {
        return bookService.addBookService(book);
    }

}