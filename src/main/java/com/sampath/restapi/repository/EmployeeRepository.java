package com.sampath.restapi.repository;
import com.sampath.restapi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
 List<Employee> findByNameContainingIgnoreCase(String name);
 List<Employee> findByDepartmentIgnoreCase(String department);
 Optional<Employee> findByEmailIgnoreCase(String email);
}
