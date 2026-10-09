package com.se.demorestdb.service;

import com.se.demorestdb.model.News;
import com.se.demorestdb.repo.NewsRepoImpl;
import jakarta.inject.Inject;

import java.util.List;

public class NewsService {
    @Inject
    private NewsRepoImpl newsRepo;
    public NewsService() {
    }
    public List<News> getAllNews() {
        return newsRepo.getAllNews();
    }
    public News getNewsById(int id) {
        return newsRepo.getNewsById(id);
    }
    public boolean addNews(News news) {
        return newsRepo.addNews(news);
    }
    public News updateNews(News news) {
        return newsRepo.updateNews(news);
    }
    public boolean deleteNews(int id) {
        return newsRepo.deleteNews(id);
    }
}
