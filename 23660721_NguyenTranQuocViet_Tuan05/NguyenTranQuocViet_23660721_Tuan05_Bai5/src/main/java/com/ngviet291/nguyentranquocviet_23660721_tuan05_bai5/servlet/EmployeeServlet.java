package com.ngviet291.nguyentranquocviet_23660721_tuan05_bai5.servlet;

import com.ngviet291.nguyentranquocviet_23660721_tuan05_bai5.dao.DepartmentDAO;
import com.ngviet291.nguyentranquocviet_23660721_tuan05_bai5.dao.EmployeeDAO;
import com.ngviet291.nguyentranquocviet_23660721_tuan05_bai5.model.Employee;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet("/employees")
public class EmployeeServlet extends HttpServlet {
    @Resource(name = "jdbc/employee_db")
    private DataSource dataSource;
    private EmployeeDAO employeeDAO;
    private DepartmentDAO departmentDAO;

    @Override
    public void init() throws ServletException {
//        super.init();
        try{
            employeeDAO = new EmployeeDAO(dataSource);
        }catch (Exception e){
            throw new ServletException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        String action = req.getParameter("action");
        if(action == null){
            action = "list";
        }
        switch (action){
            case "list"->{
                List<Employee> employees = employeeDAO.getAllEmployees();
                req.setAttribute("employees", employees);
                req.getRequestDispatcher("/employee-list.jsp").forward(req, resp);
            }
            case "new"->{
                req.setAttribute("departments", departmentDAO.getAllDepartments());
                req.getRequestDispatcher("/employee-form.jsp").forward(req, resp);
            }
            case "edit"->{
                int id = Integer.parseInt(req.getParameter("id"));
                Employee employee = employeeDAO.getById(id);
                req.setAttribute("employee", employee);
                req.setAttribute("departments", departmentDAO.getAllDepartments());
                req.getRequestDispatcher("/employee-form.jsp").forward(req, resp);
            }
            case "delete"->{
                int id = Integer.parseInt(req.getParameter("id"));
                employeeDAO.delete(id);
                resp.sendRedirect(req.getContextPath() + "/employees");
            }
            case "view-by-id"->{
                String deptId= req.getParameter("departmentId");
                List<Employee> list;
                if(deptId != null && !deptId.isEmpty()){
                    list = employeeDAO.getByDepartmentId(Integer.parseInt(deptId));
                }else{
                    list = employeeDAO.getAllEmployees();
                }
                req.setAttribute("employees", list);
                req.setAttribute("departments", departmentDAO.getAllDepartments());
                req.getRequestDispatcher("/employee-list.jsp").forward(req, resp);

            }
            default->{
                resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        String idParam = req.getParameter("id");
        int id;
        if(idParam != null || !idParam.isEmpty()) {
            id = Integer.parseInt(idParam);
        }else {
            id = 0;
        }
        String name = req.getParameter("name");
        double salary = Double.parseDouble(req.getParameter("salary"));
        int departmentId = Integer.parseInt(req.getParameter("departmentId"));
        Employee employee = new Employee(id, name, salary, departmentId);
        if (id > 0) {
            employeeDAO.update(employee);
        } else {
            employeeDAO.save(employee);
        }
        resp.sendRedirect("/employees?departmentId=" + departmentId);
    }
}
