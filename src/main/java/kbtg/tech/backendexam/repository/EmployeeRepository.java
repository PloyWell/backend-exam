package kbtg.tech.backendexam.repository;

import kbtg.tech.backendexam.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
