package com.se.demorestdb.service;

import com.se.demorestdb.dto.BookSearchRequest;
import com.se.demorestdb.model.Book;
import com.se.demorestdb.repo.BookRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import org.jvnet.hk2.annotations.Service;

import java.util.List;
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
    public List<BookSearchRequest> findByPublisherAndAuthor(int publisherId, String authorKeyword){
        return  bookRepository.findByPublisherAndAuthor(publisherId,authorKeyword);
    }
}
