package com.bridgelabz.payroll.service;

import com.bridgelabz.payroll.dto.EmployeeDTO;
import com.bridgelabz.payroll.entity.Employee;
import com.bridgelabz.payroll.exception.EmployeeNotFoundException;
import com.bridgelabz.payroll.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
//
@Service
// implement service class with dto
public class EmployeeService {
   @Autowired
    EmployeeRepository empRes;
   // method for find all employees
    public List<Employee> getAllEmployees(){
        return empRes.findAll();
    }

    // find employee by id
    public Employee getEmployeeById(int id){
        return empRes.findById(id).orElseThrow(()-> new EmployeeNotFoundException("this "+id+" employee not found"));
    }

    // save employee
//    public Employee saveEmployee(Employee emp){
//        return empRes.save(emp);
//    }
     public Employee saveEmployee(EmployeeDTO empDto){
        Employee emp  = new Employee();
        emp.setName(empDto.getName());
        emp.setSalary(empDto.getSalary());
        emp.setGender(empDto.getGender());
        return empRes.save(emp);
     }
    // for delete employee
    public boolean deleteEmployee(int id){
        if(empRes.existsById(id)) {
            empRes.deleteById(id);
            return true;
        }
        return false;
    }

    // update employee details
//    public Employee updateEmployee(int id, Employee emp){
//        if(empRes.existsById(id)){
//            emp.setId(id);
//            return empRes.save(emp);
//        }
//        return null;
//    }

    public Employee updateEmployee(int id, EmployeeDTO empDto){
        Optional<Employee> optEmp = empRes.findById(id);
        if(optEmp.isPresent()){
            Employee emp = optEmp.get();
            emp.setName(empDto.getName());
            emp.setSalary(empDto.getSalary());
            empRes.save(emp);
            return emp;
        }
        return null;
    }
}


//  <-------------  Using ArrayList  ------------------>

//
//@Slf4j
//@Service
//public class EmployeeService {
//
//    private List<Employee> employeeList = new ArrayList<>();
//
//    // Save a new employee (store it in memory)
//    public Employee saveEmployee(EmployeeDTO employeeDTO) {
//        log.info("Attempting to save new employee with name: {}", employeeDTO.getName()); // Log before saving
//        Employee employee = new Employee();
//        employee.setName(employeeDTO.getName());
//        employee.setSalary(employeeDTO.getSalary());
//        employee.setStartDate(LocalDate.now());  // Default start date to current date
//        employee.setGender("Not Specified");  // Default gender
//        employeeList.add(employee);
//        log.info("Employee saved successfully: {}", employee); // Log after saving
//        return employee;
//    }
//
//    // Get all employees
//    public List<Employee> getAllEmployees() {
//        log.info("Fetching all employees from the memory store."); // Log before fetching data
//        return employeeList;
//    }
//
//    // Get employee by ID
//    public Employee getEmployeeById(int id) {
//        log.info("Fetching employee with ID: {}", id);  // Log before fetching employee by ID
//        Optional<Employee> employee = employeeList.stream()
//                .filter(emp -> emp.getId() == id)
//                .findFirst();
//        if (employee.isPresent()) {
//            log.info("Employee found: {}", employee.get()); // Log when the employee is found
//            return employee.get();
//        } else {
//            log.warn("Employee with ID: {} not found.", id); // Log a warning if employee is not found
//            return null;
//        }
//    }
//
//    // Update employee
//    public Employee updateEmployee(int id, EmployeeDTO employeeDTO) {
//        log.info("Updating employee with ID: {}", id);  // Log before updating employee
//        Employee employee = getEmployeeById(id);
//        if (employee != null) {
//            employee.setName(employeeDTO.getName());
//            employee.setSalary(employeeDTO.getSalary());
//            log.info("Employee updated successfully: {}", employee); // Log after updating employee
//            return employee;
//        } else {
//            log.warn("Employee with ID: {} not found for update.", id); // Log a warning if update fails
//            return null;
//        }
//    }
//
//    // Delete employee
//    public boolean deleteEmployee(int id) {
//        log.info("Attempting to delete employee with ID: {}", id);  // Log before deleting
//        Employee employee = getEmployeeById(id);
//        if (employee != null) {
//            employeeList.remove(employee);
//            log.info("Employee with ID: {} deleted successfully.", id);  // Log after deleting employee
//            return true;
//        } else {
//            log.warn("Employee with ID: {} not found for deletion.", id);  // Log a warning if employee not found
//            return false;
//        }
//    }
//}
//

