package _3660721_nguyentranquocviet_tuan6_jdbctemplate.controller;

import jakarta.validation.Valid;
import _3660721_nguyentranquocviet_tuan6_jdbctemplate.model.Department;
import _3660721_nguyentranquocviet_tuan6_jdbctemplate.model.Employee;
import _3660721_nguyentranquocviet_tuan6_jdbctemplate.model.Position;
import _3660721_nguyentranquocviet_tuan6_jdbctemplate.service.DepartmentService;
import _3660721_nguyentranquocviet_tuan6_jdbctemplate.service.EmployeeService;
import _3660721_nguyentranquocviet_tuan6_jdbctemplate.service.PositionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService service;
    private final DepartmentService departmentService;
    private final PositionService positionService;

    public EmployeeController(EmployeeService service,
                              DepartmentService departmentService,
                              PositionService positionService) {
        this.service = service;
        this.departmentService = departmentService;
        this.positionService = positionService;
    }

    @ModelAttribute("departments")
    public List<Department> departments() { return departmentService.findAll(); }

    @ModelAttribute("positions")
    public List<Position> positions() { return positionService.findAll(); }

    @GetMapping
    public String list(@RequestParam(required = false) String keyword,
                       @RequestParam(required = false) Integer minAge,
                       @RequestParam(required = false) Integer maxAge,
                       @RequestParam(required = false) Double minSalary,
                       @RequestParam(required = false) Integer departmentId,
                       @RequestParam(required = false) Integer positionId,
                       Model model) {
        List<Employee> result;
        if (keyword != null && !keyword.isBlank()) {
            result = service.findByNameContainingIgnoreCase(keyword.trim());
        } else if (minAge != null && maxAge != null) {
            result = service.findByAgeBetween(minAge, maxAge);
        } else if (minSalary != null) {
            result = service.findBySalaryGreaterThan(minSalary);
        } else if (departmentId != null && positionId != null) {
            result = service.findByDepartmentIdAndPositionId(departmentId, positionId);
        } else if (positionId != null) {
            result = service.findByPositionId(positionId);
        } else if (departmentId != null) {
            result = service.findByDepartmentId(departmentId);
        } else {
            result = service.findAll();
        }
        model.addAttribute("employees", result);
        model.addAttribute("keyword", keyword);
        model.addAttribute("minAge", minAge);
        model.addAttribute("maxAge", maxAge);
        model.addAttribute("minSalary", minSalary);
        model.addAttribute("departmentId", departmentId);
        model.addAttribute("positionId", positionId);
        return "employees/list";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employees/form";
    }

    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Integer id, Model model, RedirectAttributes ra) {
        return service.findById(id).map(e -> {
            model.addAttribute("employee", e);
            return "employees/form";
        }).orElseGet(() -> {
            ra.addFlashAttribute("error", "Không tìm thấy nhân viên #" + id);
            return "redirect:/employees";
        });
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("employee") Employee employee,
                       BindingResult result, RedirectAttributes ra) {
        if (result.hasErrors()) return "employees/form";
        service.save(employee);
        ra.addFlashAttribute("message", "Đã lưu nhân viên thành công");
        return "redirect:/employees";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Integer id, RedirectAttributes ra) {
        service.deleteById(id);
        ra.addFlashAttribute("message", "Đã xóa nhân viên #" + id);
        return "redirect:/employees";
    }
}
