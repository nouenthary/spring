package com.spring.springbootdemo.controller;

import com.spring.springbootdemo.model.Book;
import com.spring.springbootdemo.services.Imp.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BookController {


    @Autowired
    private BookService bookService;

    @RequestMapping("/book")
    public List<Book> getAllBook(){
        return bookService.getAllBook();
    }

//    @RequestMapping("/book/{book}")
//    public Book getBook(@PathVariable String book){
//        return bookService.getBook(book);
//    }
}
