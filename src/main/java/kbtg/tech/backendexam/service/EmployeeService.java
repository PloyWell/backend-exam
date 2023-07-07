package kbtg.tech.backendexam.service;

import kbtg.tech.backendexam.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(Integer id);
    void save(Employee employee);
    void delete(Employee employee);
}
