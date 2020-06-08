package com.spring.springbootdemo.repository;

import com.spring.springbootdemo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
