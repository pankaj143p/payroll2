package com.bridgelabz.payroll.service;

import com.bridgelabz.payroll.dto.EmployeeDTO;
import com.bridgelabz.payroll.entity.Employee;
import com.bridgelabz.payroll.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
//
//@Service
//// implement service class with dto
//public class EmployeeService {
//   @Autowired
//    EmployeeRepository empRes;
//   // method for find all employees
//    public List<Employee> getAllEmployees(){
//        return empRes.findAll();
//    }
//
//    // find employee by id
//    public Employee getEmployeeById(int id){
//        return empRes.findById(id).orElse(null);
//    }
//
//    // save employee
////    public Employee saveEmployee(Employee emp){
////        return empRes.save(emp);
////    }
//     public Employee saveEmployee(EmployeeDTO empDto){
//        Employee emp  = new Employee();
//        emp.setName(empDto.getName());
//        emp.setSalary(empDto.getSalary());
//        emp.setGender(empDto.getGender());
//        return empRes.save(emp);
//     }
//    // for delete employee
//    public boolean deleteEmployee(int id){
//        if(empRes.existsById(id)) {
//            empRes.deleteById(id);
//            return true;
//        }
//        return false;
//    }
//
//    // update employee details
////    public Employee updateEmployee(int id, Employee emp){
////        if(empRes.existsById(id)){
////            emp.setId(id);
////            return empRes.save(emp);
////        }
////        return null;
////    }
//
//    public Employee updateEmployee(int id, EmployeeDTO empDto){
//        Optional<Employee> optEmp = empRes.findById(id);
//        if(optEmp.isPresent()){
//            Employee emp = optEmp.get();
//            emp.setName(empDto.getName());
//            emp.setSalary(empDto.getSalary());
//            empRes.save(emp);
//            return emp;
//        }
//        return null;
//    }
//}


//  <-------------  Using ArrayList  ------------------>

@Service
public class EmployeeService {

    // In-memory list to store employee data
    private List<Employee> employeeList = new ArrayList<>();

    // Save a new employee (store it in memory)
    public Employee saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setName(employeeDTO.getName());
        employee.setSalary(employeeDTO.getSalary());
        employee.setStartDate(LocalDate.now());  // Default start date to current date
        employee.setGender("Not Specified");  // Default gender
        // Add employee to in-memory list
        employeeList.add(employee);
        return employee;
    }

    // Get all employees from the in-memory list
    public List<Employee> getAllEmployees() {
        return employeeList;  // Return the list of employees
    }

    // Get employee by ID (searching through in-memory list)
    public Employee getEmployeeById(int id) {
        Optional<Employee> employee = employeeList.stream()
                .filter(emp -> emp.getId() == id)
                .findFirst();
        return employee.orElse(null);  // Return the employee if found, otherwise return null
    }

    // Update an employee's details (modify in-memory list)
    public Employee updateEmployee(int id, EmployeeDTO employeeDTO) {
        Employee employee = getEmployeeById(id);
        if (employee != null) {
            employee.setName(employeeDTO.getName());
            employee.setSalary(employeeDTO.getSalary());
            return employee;
        }
        return null;  // If employee not found, return null
    }

    // Delete an employee (remove from in-memory list)
    public boolean deleteEmployee(int id) {
        Employee employee = getEmployeeById(id);
        if (employee != null) {
            employeeList.remove(employee);  // Remove the employee from the list
            return true;
        }
        return false;  // Return false if employee wasn't found
    }
}

