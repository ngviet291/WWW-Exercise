package com.ngviet291._3660721_nguyentranquocviet_jdbc_library.controller;

import com.ngviet291._3660721_nguyentranquocviet_jdbc_library.dto.PublisherBook;
import com.ngviet291._3660721_nguyentranquocviet_jdbc_library.model.Book;
import com.ngviet291._3660721_nguyentranquocviet_jdbc_library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    @GetMapping
    public List<Book> getAll(){
        return bookService.getAll();
    }
    @GetMapping("/publisher")
    public List<PublisherBook> findByPublisherNameTre(@RequestParam String name){
        return bookService.findByPublisherName(name);
    }
}
