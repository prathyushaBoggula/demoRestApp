package com.example.demoRestApp.controller;


import com.example.demoRestApp.exceptionHanlder.CustomException;
import com.example.demoRestApp.model.entity.Employee;
import com.example.demoRestApp.service.DemoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class DemoController {

   private static final Logger LOGGER = LogManager.getLogger(DemoController.class);


    @Autowired DemoService demoService ;

    @GetMapping("/all")
    public List<Employee> getAllEmployee() {
    LOGGER.info("Fetching all Employees");
        return demoService.getAllEmployee();
    }

    @GetMapping("{id}")
    public Employee getEmployeesById(@PathVariable Long id) throws CustomException {
        LOGGER.info("Fetching Employee using PathVariable");
        try {
            return demoService.getEmployeeById(id);

        } catch(CustomException exception) {
            throw new CustomException("ID not present");
        }
    }

    @GetMapping()  //api/employee?id=101
    public Employee getEmployeeIdUsingQueryParam(@RequestParam Long id) throws CustomException {
        LOGGER.info("Fetching Employee using RequestParam");
        return demoService.getEmployeeById(id);
    }

    @PostMapping()
    public String saveEmployee(@RequestBody Employee employee) {
        LOGGER.info("saved Employee");
        return demoService.saveEmployee(employee) ;
    }

    @PostMapping("/all")
    public String saveAllEmployee(@RequestBody List<Employee> employee) {
        LOGGER.info("saved Employee");
        return demoService.saveAllEmployee(employee) ;
    }

    @PutMapping()
    public String updateEmployee(@RequestBody Employee employee) {
        LOGGER.info("updated Employee ");
        return demoService.updateEmployee(employee);

    }
    @DeleteMapping()
    public String deleteEmployee(@RequestParam Long id) {
        LOGGER.info("deleted Employee");
        return demoService.deleteEmployee(id);
    }
}

