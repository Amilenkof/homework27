package com.example.homework2_7.Controller;

import com.example.homework2_7.Exceptions.EmployeeNotFound;
import com.example.homework2_7.Model.DeptEmployeeServiceImpl;
import com.example.homework2_7.Model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DeptController {
    private final DeptEmployeeServiceImpl deptEmployeeService;

    public DeptController(DeptEmployeeServiceImpl deptEmployeeService) {
        this.deptEmployeeService = deptEmployeeService;
    }

    @GetMapping(value = "/all", params = "departmentId")
    public List<Employee> getEmployeeInDept(@RequestParam("departmentId") int department) {
        return deptEmployeeService.getEmployeeInDept(department);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> getEmployeeInDept() {
        return deptEmployeeService.getAllEmployees();
    }

    @GetMapping("/max-salary")
    public Employee getEmployeeMaxSalary(@RequestParam("departmentId") int department) {
        try {
            return deptEmployeeService.getEmployeeMaxSalary(department);
        } catch (EmployeeNotFound exp) {
            throw new RuntimeException(exp);
        }
    }

    @GetMapping("/min-salary")
    public Employee getEmployeeMinSalary(@RequestParam("departmentId") int department) {
        try {
            return deptEmployeeService.getEmployeeMinSalary(department);
        } catch (EmployeeNotFound exp) {
            throw new RuntimeException(exp);
        }
    }
}
