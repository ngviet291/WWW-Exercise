package _3660721_nguyentranquocviet_tuan6_jdbctemplate.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class Employee {
    private Integer id;

    @NotBlank(message = "Tên không được để trống")
    private String name;

    private String role;

    @Min(value = 18, message = "Tuổi tối thiểu là 18")
    private Integer age;

    @Min(value = 0, message = "Lương không được âm")
    private Double salary;

    private Integer departmentId;
    private Integer positionId;

    // Chỉ để hiển thị (lấy từ JOIN), không ghi xuống DB
    private String departmentName;
    private String positionTitle;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }
    public Double getSalary() { return salary; }
    public void setSalary(Double salary) { this.salary = salary; }
    public Integer getDepartmentId() { return departmentId; }
    public void setDepartmentId(Integer departmentId) { this.departmentId = departmentId; }
    public Integer getPositionId() { return positionId; }
    public void setPositionId(Integer positionId) { this.positionId = positionId; }
    public String getDepartmentName() { return departmentName; }
    public void setDepartmentName(String departmentName) { this.departmentName = departmentName; }
    public String getPositionTitle() { return positionTitle; }
    public void setPositionTitle(String positionTitle) { this.positionTitle = positionTitle; }
}
