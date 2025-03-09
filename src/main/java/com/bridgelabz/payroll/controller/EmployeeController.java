package com.bridgelabz.payroll.controller;

import com.bridgelabz.payroll.dto.EmployeeDTO;
import com.bridgelabz.payroll.entity.Employee;
import com.bridgelabz.payroll.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService empSer;

    // Get all employees
    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        return empSer.getAllEmployees();
    }

    // Get employee by ID
    @GetMapping("/get/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
        Employee emp = empSer.getEmployeeById(id);
        return emp != null ? ResponseEntity.ok(emp) : ResponseEntity.notFound().build();
    }

    // Create a new employee
//    @PostMapping
//    public ResponseEntity<Employee> addEmployee(@RequestBody @Valid EmployeeDTO employeeDTO) {
//        Employee employee = empSer.saveEmployee(employeeDTO);
//        return new ResponseEntity<>(employee, HttpStatus.CREATED);
//    }
    @PostMapping
    public ResponseEntity<EmployeeDTO> createEmployee(@Valid @RequestBody EmployeeDTO employee) {
        EmployeeDTO employeeDTO = empSer.saveEmployee(employee);
        if(employeeDTO.getName()!=null) {
            return ResponseEntity.ok(employeeDTO);
        }else {
            return ResponseEntity.internalServerError().build();
        }
    }
    // Delete employee by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable int id) {
        boolean isDeleted = empSer.deleteEmployee(id);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    // Update employee by ID
    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateEmployee(@PathVariable int id, @Valid @RequestBody EmployeeDTO updatedEmployee) {
        EmployeeDTO employeeDTO = empSer.updateEmployee(id,updatedEmployee);
        if(employeeDTO.getName()!=null) return ResponseEntity.ok(empSer.updateEmployee(id,updatedEmployee));
        Map<String, String> errors = new HashMap<>();
        errors.put("error","ID not FOUND");
        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
    }
}
