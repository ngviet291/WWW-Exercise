package com.ngviet291.nguyentranquocviet_23660721_tuan05_bai04.servlet;

import com.ngviet291.nguyentranquocviet_23660721_tuan05_bai04.dao.BookDAO;
import com.ngviet291.nguyentranquocviet_23660721_tuan05_bai04.model.Book;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet({ "/books", "/book" })
public class BookServlet extends HttpServlet {

    @Resource(name = "jdbc/storedb")
    private DataSource dataSource;

    private BookDAO bookDAO;

    @Override
    public void init() throws ServletException {
        bookDAO = new BookDAO(dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");
        if (id != null && !id.isEmpty()) {
            Book book = bookDAO.getBookById(id);

            request.setAttribute("book", book);
            request.getRequestDispatcher("/book-detail.jsp")
                    .forward(request, response);

            return;
        }
        String keyword = request.getParameter("keyword");
        List<Book> books;

        if (keyword != null && !keyword.trim().isEmpty()) {
            books = bookDAO.searchBooks(keyword.trim());
            request.setAttribute("keyword", keyword.trim());
        } else {
            books = bookDAO.getAllBooks();
        }

        request.setAttribute("books", books);

        request.getRequestDispatcher("/books.jsp")
                .forward(request, response);
    }
}