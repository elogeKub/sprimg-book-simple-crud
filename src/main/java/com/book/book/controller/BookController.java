package com.book.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.book.model.Book;
import com.book.book.service.BookService;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    private BookService bookService;

    // adding book controller
    @PostMapping("/add_book")
    public Book addBookController(@RequestBody Book book) {
        return bookService.addBookService(book);
    }

    @PostMapping("/add_products")
    public List<Book> addBookController(@RequestBody List<Book> listbBooks) {
        return bookService.addMultpleBookService(listbBooks);
    }

    @GetMapping("/get_book_by_name/{name}")
    public Book getBookByNameController(@PathVariable String name) {
        return bookService.getbookByTileService(name);

    }

    @GetMapping("/get_book_by_id/{id}")
    public Book getBookByIdController(@PathVariable int id) {
        return bookService.getOneBookService(id);
    }

    @PutMapping("/update_book")
    public Book updateBookController(@RequestBody Book book) {
        Book existingBook = bookService.getOneBookService(book.getId());
        existingBook.setName(book.getName());
        existingBook.setAuthor(book.getAuthor());
        return bookService.addBookService(existingBook);
    }

    @GetMapping("/get_all_books")
    public List<Book> getAllBooksController() {
        return bookService.getAllBook();
    }

    @DeleteMapping("/delete_book/{id}")
    public String deleteBookController(@PathVariable int id) {
        return bookService.deleteBookService(id);
    }
}