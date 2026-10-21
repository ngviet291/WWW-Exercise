package _3660721_nguyentranquocviet_tuan6_mongodb.controller;

import _3660721_nguyentranquocviet_tuan6_mongodb.service.DepartmentService;
import _3660721_nguyentranquocviet_tuan6_mongodb.service.EmployeeService;
import _3660721_nguyentranquocviet_tuan6_mongodb.service.PositionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/reports")
public class ReportController {

    private final EmployeeService employeeService;
    private final DepartmentService departmentService;
    private final PositionService positionService;

    public ReportController(EmployeeService employeeService,
                            DepartmentService departmentService,
                            PositionService positionService) {
        this.employeeService = employeeService;
        this.departmentService = departmentService;
        this.positionService = positionService;
    }

    @GetMapping
    public String reports(@RequestParam(required = false) Integer departmentId,
                          @RequestParam(defaultValue = "5") int n,
                          Model model) {
        model.addAttribute("counts", employeeService.countEmployeesByDepartment());
        model.addAttribute("salaryStats", employeeService.salaryStatsByDepartment());
        model.addAttribute("emptyDepartments", departmentService.findDepartmentsWithoutEmployees());
        model.addAttribute("departments", departmentService.findAll());
        model.addAttribute("positionTitles", positionService.titleById());
        model.addAttribute("departmentId", departmentId);
        model.addAttribute("n", n);
        if (departmentId != null) {
            model.addAttribute("topEmployees",
                    employeeService.findTopByDepartmentIdOrderBySalaryDesc(departmentId, Math.max(n, 1)));
        }
        return "reports/index";
    }
}
