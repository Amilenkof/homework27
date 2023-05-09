package com.example.homework2_7.Model;

import com.example.homework2_7.Exceptions.EmployeeNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service


public class DeptEmployeeServiceImpl {
    @Autowired
    private EmployeeBookImpl employeeBook;

    public List<Employee> getEmployeeInDept(int department) {
        return employeeBook.getEmployees().values().stream()
                .filter(employee -> employee.getDepartament() == department)
                .collect(Collectors.toList());

    }
    public Map<Integer,List<Employee>> getAllEmployees () {
        return employeeBook.getEmployees().values().stream()
                .collect(Collectors.groupingBy((Employee::getDepartament)));

    }
    public Employee getEmployeeMaxSalary (int department) {
        return employeeBook.getEmployees().values().stream()
                .filter((employee -> employee.getDepartament() == department))
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow( ()-> new EmployeeNotFound("В указанном отделе сотрудник не найден"));
    }
    public Employee getEmployeeMinSalary (int department) {
        return employeeBook.getEmployees().values().stream()
                .filter((employee -> employee.getDepartament() == department))
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow( ()-> new EmployeeNotFound("В указанном отделе сотрудник не найден"));
    }


}
//```java
//Comparator.comparingInt(employee -> employee.getSalary())
//```
//Следующее будет классифицировать объекты Person по городам:
// Map<String, List<Person>> peopleByCity      = personStream.collect(Collectors.groupingBy(Person::getCity));