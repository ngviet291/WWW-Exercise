package com.se.demorestdb.service;

import com.se.demorestdb.dto.BooksOfPublisher;
import com.se.demorestdb.dto.Statics;
import com.se.demorestdb.model.Book;
import com.se.demorestdb.model.Publisher;
import com.se.demorestdb.repo.PublisherRepository;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Map;

public class PublisherService {
    @Inject
    private PublisherRepository publisherRepository;
    public List<Publisher> getPublishers(){
        return publisherRepository.getPublishers();
    }
    public Publisher getPublisher(int id){
        return publisherRepository.getPublisher(id);
    }
    public Map<Publisher, List<Book>> findByPublisherAndAuthor(int publisherId, String authorKeyword){
        return  publisherRepository.findByPublisherAndAuthor(publisherId,authorKeyword);
    }
    public List<Statics> getStatistics(){
        return publisherRepository.getStatistics();
    }
    public List<BooksOfPublisher> countBooksByPublisher(){
        return publisherRepository.countBooksByPublisher();
    }
}
