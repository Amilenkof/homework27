package com.example.homework2_7.Controller;

import com.example.homework2_7.Model.Employee;
import com.example.homework2_7.Model.EmployeeBookImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class Controller {
    private final EmployeeBookImpl employeeBook;

    public Controller(EmployeeBookImpl employeeBook) {
        this.employeeBook = employeeBook;
    }

    @GetMapping("/add")
    public Employee add(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return employeeBook.add(firstName, lastName);
    }

    @GetMapping("/remove")
    public Employee remove(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return employeeBook.remove(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee find(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return employeeBook.find(firstName, lastName);
    }
}
