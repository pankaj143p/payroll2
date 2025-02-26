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
// simple
//@RestController
//@RequestMapping("/employees")
//public class EmployeeController {
//
//    @Autowired
//    EmployeeService empSer;
//
//    @GetMapping("/all")
//    // for show all emplees and details
//    public List<Employee> getAllEmployees(){
//        return empSer.getAllEmployees();
//    }
//
//    @GetMapping({"/get/{id}"})
//    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id)
//    {
//        Employee emp = empSer.getEmployeeById(id);
//        return (emp!=null) ? ResponseEntity.ok(emp) : ResponseEntity.notFound().build();
//    }
//
//    // post mapping
//    @PostMapping("/create")
//    public ResponseEntity<Employee> addEmployee(@RequestBody EmployeeDTO empDto){
//        Employee emp = empSer.saveEmployee(empDto);
//        return ResponseEntity.status(201).body(emp);
//    }
//
//    // for delete employee by id
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<Void> deleteEmployee(@PathVariable int id) {
//        boolean isDeleted = empSer.deleteEmployee(id);
//        if (isDeleted) {
//            return ResponseEntity.noContent().build();
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    // for update employee
//    @PutMapping("/update/{id}")
//    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @Valid @RequestBody EmployeeDTO empDto){
//        Employee emp = empSer.updateEmployee(id, empDto);
//        return (emp!=null) ? ResponseEntity.ok(emp) : ResponseEntity.notFound().build();
//    }
//
//}





//  <-------------  Using ArrayList  ------------------>




@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Create new Employee
    @PostMapping("/create")
    public ResponseEntity<Employee> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        Employee employee = employeeService.saveEmployee(employeeDTO);
        return ResponseEntity.status(201).body(employee);
    }

    // Get All Employees
    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        if (!employees.isEmpty()) {
            return ResponseEntity.ok(employees);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    // Get Employee by ID
    @GetMapping("/get/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
        Employee employee = employeeService.getEmployeeById(id);
        if (employee != null) {
            return ResponseEntity.ok(employee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Update Employee
    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody EmployeeDTO employeeDTO) {
        Employee employee = employeeService.updateEmployee(id, employeeDTO);
        if (employee != null) {
            return ResponseEntity.ok(employee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete Employee by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable int id) {
        boolean isDeleted = employeeService.deleteEmployee(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
