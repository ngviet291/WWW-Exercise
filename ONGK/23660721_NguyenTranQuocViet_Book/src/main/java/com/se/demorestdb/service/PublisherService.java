package com.se.demorestdb.service;

import com.se.demorestdb.dto.*;
import com.se.demorestdb.model.Publisher;
import com.se.demorestdb.repo.PublisherRepository;
import jakarta.inject.Inject;

import java.util.List;

public class PublisherService {
    @Inject
    private PublisherRepository publisherRepository;
    public List<Publisher> getPublishers(){
        return publisherRepository.getPublishers();
    }
    public Publisher getPublisher(int id){
        return publisherRepository.getPublisher(id);
    }
    public BookByPublisherAndAuthorDto findByPublisherAndAuthor(int publisherId, String authorKeyword){
        return  publisherRepository.findByPublisherAndAuthor(publisherId,authorKeyword);
    }
    public List<Statics> getStatistics(){
        return publisherRepository.getStatistics();
    }
    public List<PublisherQuantityDto> countBooksByPublisher(){
        return publisherRepository.countBooksByPublisher();
    }
    public List<PublisherQuantityDto> findWithAtLeast(int n){
        return publisherRepository.findWithAtLeast(n);
    }
    public List<PublisherAveragePriceDto> avgPriceByPublisher(){
        return publisherRepository.avgPriceByPublisher();
    }
    public List<PublisherSumPriceDto> sumPriceByPublisher(){
        return publisherRepository.sumPriceByPublisher();
    }
    public List<PublisherSumPriceDto> findWithTotalAbove(Double x){
        return publisherRepository.findWithTotalAbove(x);
    }
    public List<PublisherQuantityDto> findWithAtLeastSortedDesc(int n){
        return publisherRepository.findWithAtLeastSortedDesc(n);
    }
    public List<PublisherQuantityDto> findWithoutBooks(){
        return publisherRepository.findWithoutBooks();
    }
}
