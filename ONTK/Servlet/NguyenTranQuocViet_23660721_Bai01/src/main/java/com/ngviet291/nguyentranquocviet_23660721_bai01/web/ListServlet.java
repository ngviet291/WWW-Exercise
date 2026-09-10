    package com.ngviet291.nguyentranquocviet_23660721_bai01.web;

    import com.ngviet291.nguyentranquocviet_23660721_bai01.model.Course;
    import com.ngviet291.nguyentranquocviet_23660721_bai01.service.CourseService;
    import com.ngviet291.nguyentranquocviet_23660721_bai01.service.UserService;
    import com.ngviet291.nguyentranquocviet_23660721_bai01.session.UserSession;
    import jakarta.servlet.ServletException;
    import jakarta.servlet.annotation.WebServlet;
    import jakarta.servlet.http.HttpServlet;
    import jakarta.servlet.http.HttpServletRequest;
    import jakarta.servlet.http.HttpServletResponse;

    import java.io.IOException;
    import java.util.ArrayList;
    import java.util.List;

    @WebServlet("/course/list")
    public class ListServlet extends HttpServlet {

        private final CourseService courseService = new CourseService();
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //        super.doGet(req, resp);
            if(!UserSession.isLoggedIn(req)){
                resp.sendRedirect(req.getContextPath()+"/login");
                return;
            }
            String keyword = req.getParameter("keyword");
            String cate = req.getParameter("category");
            List<Course> courses = courseService.search(keyword,cate);
            req.setAttribute("keyword",keyword);
            req.setAttribute("category",cate);
            req.setAttribute("courses",courses);
            req.getRequestDispatcher("/list.jsp").forward(req,resp);
        }

    }
