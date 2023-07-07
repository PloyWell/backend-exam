package kbtg.tech.backendexam.rest;

import kbtg.tech.backendexam.entity.Employee;
import kbtg.tech.backendexam.exception.EmployeeNotFoundException;
import kbtg.tech.backendexam.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import kbtg.tech.backendexam.entity.SalaryAdjustPercentage;
import kbtg.tech.backendexam.entity.EmployeeUpdateInfo;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getAllEmployee() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee getEmployeeById(@PathVariable(name = "id") Integer id) {
        try {
            Employee employee = employeeService.findById(id);
            return employee;
        } catch (NoSuchElementException e) {
            throw new EmployeeNotFoundException("Not found employee ID: " + id);
        }
    }

    @PostMapping("/employees")
    @ResponseStatus(HttpStatus.OK)
    public void addEmployee(@RequestBody Employee employee) {
        employeeService.save(employee);
    }

    @DeleteMapping("/employees/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable(name = "id") Integer id) {
        try {
            Employee employee = employeeService.findById(id);
            employeeService.delete(employee);
        } catch (NoSuchElementException e) {
            throw new EmployeeNotFoundException("Not found employee ID: " + id);
        }
    }

    @PutMapping("/employees")
    @ResponseStatus(HttpStatus.OK)
    public Employee updateEmployeeInfo(@RequestBody EmployeeUpdateInfo employeeUpdateInfo) {
        try {
            Employee employee = employeeService.findById(employeeUpdateInfo.getId());
            employee.setFirstName(employeeUpdateInfo.getFirstName());
            employee.setLastName(employeeUpdateInfo.getLastName());
            employee.setNickname(employeeUpdateInfo.getNickname());
            employee.setAddress(employeeUpdateInfo.getAddress());
            employeeService.save(employee);
            return employee;
        } catch (NoSuchElementException e) {
            throw new EmployeeNotFoundException("Not found employee ID: " + employeeUpdateInfo.getId());
        }
    }

    @PutMapping("/employees/salary/{id}")
    public void updateEmployeeSalary(@PathVariable(name = "id") Integer id, @RequestBody SalaryAdjustPercentage adjustPercentage) {
        Employee employee = employeeService.findById(id);
        float changePercentage = adjustPercentage.getPercent();
        System.out.println(changePercentage);
        float calculatedPercent = (100+changePercentage)/100;
        employee.setSalary(changePercentage*calculatedPercent);
        employeeService.save(employee);
    }
}
