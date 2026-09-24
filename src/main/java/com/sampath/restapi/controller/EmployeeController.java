package com.sampath.restapi.controller;
import com.sampath.restapi.model.Employee; import com.sampath.restapi.service.EmployeeService;
import jakarta.validation.Valid; import org.springframework.http.*; import org.springframework.web.bind.annotation.*; import java.util.*;
@RestController @RequestMapping("/api/employees") @CrossOrigin(origins="*")
public class EmployeeController {
 private final EmployeeService service; public EmployeeController(EmployeeService service){this.service=service;}
 @GetMapping public ResponseEntity<List<Employee>> getAll(){return ResponseEntity.ok(service.getAllEmployees());}
 @GetMapping("/{id}") public ResponseEntity<Employee> get(@PathVariable Long id){return ResponseEntity.ok(service.getEmployeeById(id));}
 @GetMapping("/search") public ResponseEntity<List<Employee>> search(@RequestParam(required=false) String name,@RequestParam(required=false) String department){if(name!=null&&!name.isBlank())return ResponseEntity.ok(service.searchByName(name));if(department!=null&&!department.isBlank())return ResponseEntity.ok(service.searchByDepartment(department));return ResponseEntity.ok(service.getAllEmployees());}
 @PostMapping public ResponseEntity<Employee> create(@Valid @RequestBody Employee e){return ResponseEntity.status(HttpStatus.CREATED).body(service.createEmployee(e));}
 @PutMapping("/{id}") public ResponseEntity<Employee> update(@PathVariable Long id,@Valid @RequestBody Employee e){return ResponseEntity.ok(service.updateEmployee(id,e));}
 @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id){service.deleteEmployee(id);return ResponseEntity.noContent().build();}
}
