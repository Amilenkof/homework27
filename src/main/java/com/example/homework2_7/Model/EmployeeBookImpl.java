package com.example.homework2_7.Model;

import com.example.homework2_7.Model.Employee;
import com.example.homework2_7.Exceptions.EmployeeAlreadyInList;
import com.example.homework2_7.Exceptions.EmployeeNotFound;
import com.example.homework2_7.Model.EmployeeBook;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeBookImpl implements EmployeeBook {
    private final Map<String, Employee> employees;


    public EmployeeBookImpl() {
        this.employees = new HashMap<>();
    }

    @Override
    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        boolean b = employees.containsKey(employee.getKeyEmp());
        if (b) {
            throw new EmployeeAlreadyInList("Указанный сотрудник уже есть в мап");
        }
        employees.put(employee.getKeyEmp(), employee);
        return employee;

    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        boolean b = employees.containsKey(employee.getKeyEmp());
        if (b) {
            employees.remove(employee.getKeyEmp());
            return employee;
        }
        throw new EmployeeNotFound("Сотрудник не найден");
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        boolean b = employees.containsKey(employee.getKeyEmp());
        if (b) {
            return employee;
        }
        throw new EmployeeNotFound("Сотрудник не найден");
    }

}

