package com.book.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.book.book.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
    Book findBookByName(String name);
}
