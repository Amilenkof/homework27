package com.example.homework2_7.Model;

import com.example.homework2_7.Model.Employee;

public interface EmployeeBook {
    Employee add(String firstName, String lastName);

    Employee remove(String firstName, String lastName);

    Employee find(String firstName, String lastName);
}
