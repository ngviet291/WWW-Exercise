package com.ngviet291.bai4.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.File;
import java.io.IOException;

@WebServlet("/processFormUpload")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10,      // 10 MB
        maxRequestSize = 1024 * 1024 * 15    // 15 MB
)
public class FormUploadServlet  extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String gender = req.getParameter("gender");
        String[] hobbies = req.getParameterValues("hobbies");
        String country = req.getParameter("country");
        String birthDate = req.getParameter("birthDate");
        Part part = req.getPart("profilePicture");
        String fileName = part.getSubmittedFileName();

        String uploadPath = getServletContext().getRealPath("") + "uploads";

        File uploadDir = new File(uploadPath);
        if(!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        part.write(uploadPath + File.separator + fileName);

        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().println("<h3>Form submitted successfully!</h3>");
        resp.getWriter().println("<p>Name: " + name + "</p>");
        resp.getWriter().println("<p>Password: " + password + "</p>");
        resp.getWriter().println("<p>Gender: " + gender + "</p>");
        resp.getWriter().println("<p>Hobbies: " + String.join(", ", hobbies) + "</p>");
        resp.getWriter().println("<p>Country: " + country + "</p>");
        resp.getWriter().println("<p>Birth Date: " + birthDate + "</p>");
        resp.getWriter().println("<p>Upload File: " + (fileName!=null ? fileName:"No File") + "</p>");
        resp.getWriter().println("<p> Saved to: " + uploadPath + "</p>");
    }
}
