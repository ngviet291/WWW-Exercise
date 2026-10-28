package com.ngviet291._3660721_nguyentranquocviet_jpa_library.controller;

import com.ngviet291._3660721_nguyentranquocviet_jpa_library.model.Book;
import com.ngviet291._3660721_nguyentranquocviet_jpa_library.service.BookService;
import jakarta.validation.Valid;
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
        return  bookService.getAll();
    }
    @GetMapping("/{id}")
    public Book getById(@PathVariable Integer id){
        return  bookService.getByID(id);
    }
    @PostMapping
    public Book create(@Valid @RequestBody Book book){
        return bookService.create(book);
    }
    @PutMapping("/{id}")
    public Book update(@PathVariable Integer id, @Valid @RequestBody Book book){
        return bookService.update(id,book);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        bookService.delete(id);
    }
}
