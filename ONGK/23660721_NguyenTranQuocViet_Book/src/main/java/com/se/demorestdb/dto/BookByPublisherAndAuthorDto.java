package com.se.demorestdb.dto;

import com.se.demorestdb.model.Book;
import com.se.demorestdb.model.Publisher;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BookByPublisherAndAuthorDto {
    private Publisher publisher;
    private List<Book> books;
}
