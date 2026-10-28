package com.ngviet291._3660721_nguyentranquocviet_jdbc_library.dto;

import com.ngviet291._3660721_nguyentranquocviet_jdbc_library.model.Book;
import com.ngviet291._3660721_nguyentranquocviet_jdbc_library.model.Publisher;

import java.util.List;

public record BookPublisherResponse (Publisher publisher, List<Book> books){
}
