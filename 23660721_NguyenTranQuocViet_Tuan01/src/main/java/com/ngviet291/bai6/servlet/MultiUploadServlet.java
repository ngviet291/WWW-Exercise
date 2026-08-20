package com.ngviet291.bai6.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;

@WebServlet("/multi-upload")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1MB
        maxFileSize = 1024 * 1024 * 10,      // 10MB
        maxRequestSize = 1024 * 1024 * 50   // 100MB
)
public class MultiUploadServlet extends HttpServlet {
    public MultiUploadServlet() {
    }
    public static final String UPLOAD_DIR = "uploads";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        String uploadPath = getServletContext().getRealPath("") + UPLOAD_DIR;
        System.out.println("Upload Path: " + uploadPath);
        File uploadDir= new File(uploadPath);

        if(!uploadDir.exists()){
            uploadDir.mkdir();
        }
        for(Part part: req.getParts()){
            String fileName = getFileName(part);
            if(fileName!=null && !fileName.isEmpty()){
                System.out.println("Uploading: " + fileName);
                part.write(uploadPath + File.separator + fileName);
                System.out.println("Uploaded successfully: " + fileName);
            }
        }
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().println("<h3>Files uploaded successfully to "+uploadPath+"!</h3>");
    }

    private String getFileName(Part part) {
        String contentDisp=part.getHeader("content-disposition");
        String[] items=contentDisp.split(";");
        for(String s: items){
            if(s.trim().startsWith("filename")){
                return s.substring(s.indexOf("=")+2,s.length()-1);
            }
        }
        return "";
    }
}
