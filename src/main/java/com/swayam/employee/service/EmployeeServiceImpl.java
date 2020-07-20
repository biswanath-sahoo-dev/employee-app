package com.swayam.employee.service;

import com.swayam.employee.entity.Employee;
import com.swayam.employee.exception.ResourceNotFoundException;
import com.swayam.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        Optional< Employee > employeeDb = this.employeeRepository.findById(employee.getId());

        if (employeeDb.isPresent()) {
            Employee employeeUpdate = employeeDb.get();
            employeeUpdate.setName(employee.getName());
            employeeUpdate.setAge(employee.getAge());
            employeeRepository.save(employeeUpdate);
            return employeeUpdate;
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + employee.getId());
        }
    }

    @Override
    public List< Employee > getAllEmployee() {
        return this.employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long employeeId) {

        Optional < Employee > employeeDb = this.employeeRepository.findById(employeeId);

        if (employeeDb.isPresent()) {
            return employeeDb.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + employeeId);
        }
    }

    @Override
    public void deleteEmployee(long employeeId) {
        Optional < Employee > employeeDb = this.employeeRepository.findById(employeeId);

        if (employeeDb.isPresent()) {
            this.employeeRepository.delete(employeeDb.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + employeeId);
        }

    }
}

