package com.example.demoRestApp.service;

import com.example.demoRestApp.exceptionHanlder.CustomException;
import com.example.demoRestApp.model.entity.Employee;

import java.util.List;

public interface DemoService {


    List<Employee> getAllEmployee();

    Employee getEmployeeById(Long id) throws CustomException;

    String saveEmployee(Employee employee);

    String updateEmployee(Employee employee);

    String deleteEmployee(Long id);

    String saveAllEmployee(List<Employee> employee);
}
