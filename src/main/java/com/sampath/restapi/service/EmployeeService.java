package com.sampath.restapi.service;
import com.sampath.restapi.exception.ResourceNotFoundException;
import com.sampath.restapi.model.Employee;
import com.sampath.restapi.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class EmployeeService {
 private final EmployeeRepository repository;
 public EmployeeService(EmployeeRepository repository){this.repository=repository;}
 public List<Employee> getAllEmployees(){return repository.findAll();}
 public Employee getEmployeeById(Long id){return repository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee not found with id: "+id));}
 public Employee createEmployee(Employee e){repository.findByEmailIgnoreCase(e.getEmail()).ifPresent(x->{throw new IllegalArgumentException("An employee with this email already exists");}); return repository.save(e);}
 public Employee updateEmployee(Long id,Employee r){Employee e=getEmployeeById(id); repository.findByEmailIgnoreCase(r.getEmail()).filter(x->!x.getId().equals(id)).ifPresent(x->{throw new IllegalArgumentException("An employee with this email already exists");}); e.setName(r.getName());e.setEmail(r.getEmail());e.setDepartment(r.getDepartment());e.setDesignation(r.getDesignation());return repository.save(e);}
 public void deleteEmployee(Long id){repository.delete(getEmployeeById(id));}
 public List<Employee> searchByName(String name){return repository.findByNameContainingIgnoreCase(name);}
 public List<Employee> searchByDepartment(String department){return repository.findByDepartmentIgnoreCase(department);}
}
