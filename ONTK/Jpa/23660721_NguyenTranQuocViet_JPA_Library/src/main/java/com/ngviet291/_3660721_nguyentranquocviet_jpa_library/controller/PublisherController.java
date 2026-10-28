package com.ngviet291._3660721_nguyentranquocviet_jpa_library.controller;

import com.ngviet291._3660721_nguyentranquocviet_jpa_library.model.Publisher;
import com.ngviet291._3660721_nguyentranquocviet_jpa_library.projection.PublisherAuthorResponse;
import com.ngviet291._3660721_nguyentranquocviet_jpa_library.projection.PublisherAvg;
import com.ngviet291._3660721_nguyentranquocviet_jpa_library.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/publishers")
@RequiredArgsConstructor
public class PublisherController {
    private final PublisherService publisherService;
    @GetMapping
    public List<Publisher> getAll(){
        return publisherService.getAll();
    }
    @GetMapping("/{publisherId}/books/search")
    public PublisherAuthorResponse findByPublisherAndAuthor(@PathVariable int publisherId,@RequestParam String authorKeyword){
        return publisherService.findByPublisherAndAuthor(publisherId,authorKeyword);
    }
    @GetMapping("/avgPrice")
    public List<PublisherAvg> getAvgPrice(){
        return  publisherService.getAvgPrice();
    }
}
