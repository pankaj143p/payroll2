package com.bridgelabz.payroll.service;

import com.bridgelabz.payroll.dto.EmployeeDTO;
import com.bridgelabz.payroll.entity.Employee;
import com.bridgelabz.payroll.exception.EmployeeNotFoundException;
import com.bridgelabz.payroll.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j  // This annotation will automatically create a logger instance for this class.
public class EmployeeService {

    @Autowired
    private EmployeeRepository empRes;

    private ModelMapper modelMapper = new ModelMapper();

    // Method to fetch all employees
    public List<Employee> getAllEmployees() {
        log.info("Fetching all employees");
        List<Employee> employees = empRes.findAll();
        log.info("Number of employees found: {}", employees.size());
        return employees;
    }

    // Method to fetch employee by ID
    public Employee getEmployeeById(int id) {
        log.info("Fetching employee with ID: {}", id);
        return empRes.findById(id)
                .orElseThrow(() -> {
                    log.error("Employee with ID: {} not found", id);
                    return new EmployeeNotFoundException("This employee with ID " + id + " is not found");
                });
    }

    // Method to save a new employee
    public Employee saveEmployee(EmployeeDTO employeeDTO) {
        log.info("Saving new employee: {}", employeeDTO.getName());

        Employee employee = new Employee();
        employee.setName(employeeDTO.getName());
        employee.setSalary(employeeDTO.getSalary());
        employee.setDepartments(employeeDTO.getDepartment());  // Set the departments
        employee.setGender(employeeDTO.getGender());
        employee.setNote(employeeDTO.getNote());
        employee.setProfilePicture(employeeDTO.getProfilePicture());
        employee.setStartDate(employeeDTO.getStartDate());

        Employee savedEmployee = empRes.save(employee);
        log.info("Employee saved successfully with ID: {}", savedEmployee.getId());
        return savedEmployee;
    }


    // Method to delete employee by ID
    public boolean deleteEmployee(int id) {
        log.info("Attempting to delete employee with ID: {}", id);
        if (empRes.existsById(id)) {
            empRes.deleteById(id);
            log.info("Employee with ID: {} deleted successfully", id);
            return true;
        } else {
            log.warn("Employee with ID: {} not found for deletion", id);
            return false;
        }
    }

    // Method to update employee details
    public Employee updateEmployee(int id, EmployeeDTO employeeDTO) {
        log.info("Attempting to update employee with ID: {}", id);
        Optional<Employee> optEmployee = empRes.findById(id);
        if (optEmployee.isPresent()) {
            Employee employee = optEmployee.get();
            employee.setName(employeeDTO.getName());
            employee.setSalary(employeeDTO.getSalary());
            employee.setDepartments(employeeDTO.getDepartment());
            employee.setGender(employeeDTO.getGender());
            employee.setNote(employeeDTO.getNote());
            employee.setProfilePicture(employeeDTO.getProfilePicture());
            employee.setStartDate(employeeDTO.getStartDate());

            empRes.save(employee);
            log.info("Employee with ID: {} updated successfully", id);
            return employee;
        } else {
            log.error("Employee with ID: {} not found for update", id);
            return null;
        }
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

