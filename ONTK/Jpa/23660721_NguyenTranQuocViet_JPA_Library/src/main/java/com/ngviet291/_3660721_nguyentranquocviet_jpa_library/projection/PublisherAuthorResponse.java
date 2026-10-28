package com.ngviet291._3660721_nguyentranquocviet_jpa_library.projection;

import com.ngviet291._3660721_nguyentranquocviet_jpa_library.model.Book;
import com.ngviet291._3660721_nguyentranquocviet_jpa_library.model.Publisher;

import java.util.List;

public record PublisherAuthorResponse(Publisher publisher, List<Book> books) {
}
