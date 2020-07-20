package com.swayam.employee.service;

import com.swayam.employee.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Employee employee);

    Employee updateEmployee(Employee employee);

    List< Employee > getAllEmployee();

    Employee getEmployeeById(long employeeId);

    void deleteEmployee(long id);
}
