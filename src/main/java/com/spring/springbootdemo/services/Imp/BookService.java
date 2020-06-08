package com.spring.springbootdemo.services.Imp;

import com.spring.springbootdemo.model.Book;
import com.spring.springbootdemo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBook(){
        return bookRepository.findAll();
    }

//    public Book getById(Long id){
//        return bookRepository.findById(id);
//    }
}

