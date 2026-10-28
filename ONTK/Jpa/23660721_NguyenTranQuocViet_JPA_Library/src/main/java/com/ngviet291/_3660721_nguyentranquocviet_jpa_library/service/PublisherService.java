package com.ngviet291._3660721_nguyentranquocviet_jpa_library.service;

import com.ngviet291._3660721_nguyentranquocviet_jpa_library.model.Book;
import com.ngviet291._3660721_nguyentranquocviet_jpa_library.model.Publisher;
import com.ngviet291._3660721_nguyentranquocviet_jpa_library.projection.PublisherAuthorResponse;
import com.ngviet291._3660721_nguyentranquocviet_jpa_library.projection.PublisherAvg;
import com.ngviet291._3660721_nguyentranquocviet_jpa_library.repository.BookRepository;
import com.ngviet291._3660721_nguyentranquocviet_jpa_library.repository.PublisherRepository;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PublisherService {
    private final PublisherRepository publisherRepository;
    private final BookRepository bookRepository;

    public List<Publisher> getAll(){
        return publisherRepository.findAll();
    }
    public PublisherAuthorResponse findByPublisherAndAuthor(int publisherId, String authorKeyword) {
        Publisher p = publisherRepository.findById(publisherId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        List<Book> books = bookRepository.findByPublisherIdAndAuthorContainingIgnoreCase(publisherId, authorKeyword);
        return new PublisherAuthorResponse(p, books);
    }
    public List<PublisherAvg> getAvgPrice(){
        return  publisherRepository.getAvgPrice();
    }
}
