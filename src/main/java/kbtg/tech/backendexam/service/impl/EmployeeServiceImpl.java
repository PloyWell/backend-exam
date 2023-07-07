package kbtg.tech.backendexam.service.impl;

import kbtg.tech.backendexam.entity.Employee;
import kbtg.tech.backendexam.exception.EmployeeNotFoundException;
import kbtg.tech.backendexam.repository.EmployeeRepository;
import kbtg.tech.backendexam.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(Integer id) {
        Optional<Employee> empOpt = employeeRepository.findById(id);
        return empOpt.get();
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void delete(Employee employee) {
        employee.setStatus("deleted");
        employeeRepository.save(employee);
    }
}
