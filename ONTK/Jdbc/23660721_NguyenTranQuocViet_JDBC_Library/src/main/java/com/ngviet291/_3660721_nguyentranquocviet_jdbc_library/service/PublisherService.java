package com.ngviet291._3660721_nguyentranquocviet_jdbc_library.service;

import com.ngviet291._3660721_nguyentranquocviet_jdbc_library.dto.BookPublisherResponse;
import com.ngviet291._3660721_nguyentranquocviet_jdbc_library.dto.BookQuantityOfPublisher;
import com.ngviet291._3660721_nguyentranquocviet_jdbc_library.dto.PublisherAvg;
import com.ngviet291._3660721_nguyentranquocviet_jdbc_library.model.Book;
import com.ngviet291._3660721_nguyentranquocviet_jdbc_library.model.Publisher;
import com.ngviet291._3660721_nguyentranquocviet_jdbc_library.repository.BookRepository;
import com.ngviet291._3660721_nguyentranquocviet_jdbc_library.repository.PublisherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PublisherService {
    private final PublisherRepository publisherRepository;
    private final BookRepository bookRepository;
    public BookPublisherResponse findByPublisherAndAuthor(Integer publisherId, String authorName){
        Publisher publisher = publisherRepository.findById(publisherId).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
        List<Book> books = bookRepository.findByPublisherIdAndAuthorContainingIgnoreCase(publisherId,authorName);
        return new BookPublisherResponse(publisher,books);
    }
    public List<BookQuantityOfPublisher> countBookOfPublishers(){
        return publisherRepository.countBookOfPublishers();
    }
    public List<BookQuantityOfPublisher> countMin2BookOfPublishers(){
        return publisherRepository.countMin2BookOfPublishers();
    }
    public List<PublisherAvg> avgPrice(){
        return publisherRepository.avgPrice();
    }
}
