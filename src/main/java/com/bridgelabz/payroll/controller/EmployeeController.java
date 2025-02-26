package com.bridgelabz.payroll.controller;

import com.bridgelabz.payroll.dto.EmployeeDTO;
import com.bridgelabz.payroll.entity.Employee;
import com.bridgelabz.payroll.repository.EmployeeRepository;
import com.bridgelabz.payroll.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeService empSer;

    @GetMapping("/all")
    // for show all emplees and details
    public List<Employee> getAllEmployees(){
        return empSer.getAllEmployees();
    }

    @GetMapping({"/get/{id}"})
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id)
    {
        Employee emp = empSer.getEmployeeById(id);
        return (emp!=null) ? ResponseEntity.ok(emp) : ResponseEntity.notFound().build();
    }

    // post mapping
    @PostMapping("/create")
    public ResponseEntity<Employee> addEmployee(@RequestBody EmployeeDTO empDto){
        Employee emp = empSer.saveEmployee(empDto);
        return ResponseEntity.status(201).body(emp);
    }

    // for delete employee by id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable int id) {
        boolean isDeleted = empSer.deleteEmployee(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // for update employee
    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @Valid @RequestBody EmployeeDTO empDto){
        Employee emp = empSer.updateEmployee(id, empDto);
        return (emp!=null) ? ResponseEntity.ok(emp) : ResponseEntity.notFound().build();
    }

}
