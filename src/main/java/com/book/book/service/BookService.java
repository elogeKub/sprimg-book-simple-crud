package com.book.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.book.model.Book;
import com.book.book.repository.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // add book
    public Book addBookService(Book book) {
        return bookRepository.save(book);
    }

    // addmultple book
    public List<Book> addMultpleBookService(List<Book> listbook) {
        return bookRepository.saveAll(listbook);
    }

    // getbook by id
    public Book getOneBookService(int id) {
        return bookRepository.findById(id).orElse(null);
    }

    // get book by title
    // public Book getbookByTileService(String title) {
    // return bookRepository.findBookByTitle(title);
    // }
    // update book

    public Book updateBookService(Book book) {
        Book existingBook = bookRepository.findById(book.getId()).orElse(null);
        existingBook.setName(book.getName());
        existingBook.setAuthor(book.getAuthor());
        return bookRepository.save(existingBook);

    }

    // delete book

    public String deleteBookService(int id) {
        String deleted = "delete one with id";
        bookRepository.deleteById(id);
        return deleted;
    }
}
