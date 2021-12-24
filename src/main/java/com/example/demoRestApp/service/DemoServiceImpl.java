package com.example.demoRestApp.service;

import com.example.demoRestApp.exceptionHanlder.CustomException;
import com.example.demoRestApp.model.entity.Employee;
import com.example.demoRestApp.repository.EmployeeRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.demoRestApp.utils.DemoConstant.*;

@Service
public class DemoServiceImpl implements DemoService{

    private static final Logger LOGGER = LogManager.getLogger(DemoServiceImpl.class);

    @Autowired EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) throws CustomException {
        if(employeeRepository.findById(id).isPresent())
        {
            return employeeRepository.findById(id).get();
        } else {
            throw new CustomException("Id not found");
        }

    }

    @Override
    public String saveEmployee(Employee employee) {

         employeeRepository.save(employee);
        return SAVE_MSG ;
    }

    @Override
    public String updateEmployee(Employee employee) {
        employeeRepository.save(employee);
        return UPDATE_MSG;
    }

    @Override
    public String deleteEmployee(Long id) {
        employeeRepository.delete(employeeRepository.findById(id).get());
        return DELETE_MSG;
    }

    @Override
    public String saveAllEmployee(List<Employee> employee) {
        employeeRepository.saveAll(employee);
        return SAVE_MSG;
    }
}
