package com.ngviet291._3660721_nguyentranquocviet_jpa_library.service;

import com.ngviet291._3660721_nguyentranquocviet_jpa_library.model.Book;
import com.ngviet291._3660721_nguyentranquocviet_jpa_library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    public List<Book> getAll(){
        return  bookRepository.findAll();
    }
    public Book getByID(Integer id){
        return  bookRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    public Book create(Book book){
        book.setId(null);
        return bookRepository.save(book);
    }
    public Book update(Integer id, Book book){
        Book book1 = getByID(id);
        book1.setTitle(book.getTitle());
        book1.setAuthor(book.getAuthor());
        book1.setPrice(book.getPrice());
        book1.setPublisher(book.getPublisher());
        return bookRepository.save(book1);
    }
    public void delete(Integer id){
        getByID(id);
        bookRepository.deleteById(id);
    }
}
