package _3660721_nguyentranquocviet_tuan6_jpa.controller;

import _3660721_nguyentranquocviet_tuan6_jpa.entity.Employee;
import _3660721_nguyentranquocviet_tuan6_jpa.service.DepartmentService;
import _3660721_nguyentranquocviet_tuan6_jpa.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/reports")
public class ReportController {

    private final EmployeeService employeeService;
    private final DepartmentService departmentService;

    public ReportController(EmployeeService employeeService, DepartmentService departmentService) {
        this.employeeService = employeeService;
        this.departmentService = departmentService;
    }

    @GetMapping
    public String reports(@RequestParam(required = false) Integer departmentId,
                          @RequestParam(defaultValue = "5") int n,
                          Model model) {
        model.addAttribute("counts", employeeService.countEmployeesByDepartment());
        model.addAttribute("salaryStats", employeeService.salaryStatsByDepartment());
        model.addAttribute("emptyDepartments", departmentService.findDepartmentsWithoutEmployees());
        model.addAttribute("departments", departmentService.findAll());
        model.addAttribute("departmentId", departmentId);
        model.addAttribute("n", n);

        if (departmentId != null) {
            List<Employee> top = (n == 5)
                    ? employeeService.findTop5ByDepartmentIdOrderBySalaryDesc(departmentId)
                    : employeeService.findTopNByDepartmentIdOrderBySalaryDesc(departmentId, Math.max(n, 1));
            model.addAttribute("topEmployees", top);
        }
        return "reports/index";
    }
}
