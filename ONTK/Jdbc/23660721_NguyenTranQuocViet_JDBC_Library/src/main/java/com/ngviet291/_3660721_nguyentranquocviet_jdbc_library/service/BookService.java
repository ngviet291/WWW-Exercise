package com.ngviet291._3660721_nguyentranquocviet_jdbc_library.service;

import com.ngviet291._3660721_nguyentranquocviet_jdbc_library.dto.BookPublisherResponse;
import com.ngviet291._3660721_nguyentranquocviet_jdbc_library.dto.PublisherBook;
import com.ngviet291._3660721_nguyentranquocviet_jdbc_library.model.Book;
import com.ngviet291._3660721_nguyentranquocviet_jdbc_library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    public List<Book> getAll(){
        return  bookRepository.findAll();
    }
    public List<PublisherBook> findByPublisherName( String name){
        return  bookRepository.findByPublisherName(name);
    }
}
