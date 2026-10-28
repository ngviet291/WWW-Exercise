package com.ngviet291._3660721_nguyentranquocviet_jdbc_library.controller;

import com.ngviet291._3660721_nguyentranquocviet_jdbc_library.dto.BookPublisherResponse;
import com.ngviet291._3660721_nguyentranquocviet_jdbc_library.dto.BookQuantityOfPublisher;
import com.ngviet291._3660721_nguyentranquocviet_jdbc_library.dto.PublisherAvg;
import com.ngviet291._3660721_nguyentranquocviet_jdbc_library.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/publishers")
@RequiredArgsConstructor
public class PublisherController {
    private final PublisherService publisherService;
    @GetMapping("{publisherId}/books/search")
    public BookPublisherResponse findByPublisherAndAuthor(@PathVariable Integer publisherId,@RequestParam String authorKeyword){
        return  publisherService.findByPublisherAndAuthor(publisherId,authorKeyword);
    }
    @GetMapping("/count")
    public List<BookQuantityOfPublisher> countBookOfPublishers(){
        return publisherService.countBookOfPublishers();
    }
    @GetMapping("/countMin2")
    public List<BookQuantityOfPublisher> countMin2BookOfPublishers(){
        return publisherService.countMin2BookOfPublishers();
    }
    @GetMapping("/avgPrice")
    public List<PublisherAvg> avgPrice(){
        return publisherService.avgPrice();
    }
}
