package com.se.demorestdb.service;

import com.se.demorestdb.model.Book;
import com.se.demorestdb.model.Publisher;
import com.se.demorestdb.repo.BookRepository;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Map;

public class BookService {
    @Inject
    private BookRepository bookRepository;

    public BookService() {
    }

    public List<Book> getAll(){
        return bookRepository.findAll();
    }
    public  Book findByAuthor(String author){
        return  bookRepository.findByAuthor(author);
    }
    public boolean save(Book book){
        return  bookRepository.save(book);
    }

}
