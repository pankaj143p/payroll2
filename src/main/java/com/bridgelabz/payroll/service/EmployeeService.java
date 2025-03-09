package com.bridgelabz.payroll.service;

import com.bridgelabz.payroll.dto.EmployeeDTO;
import com.bridgelabz.payroll.entity.Employee;
import com.bridgelabz.payroll.exception.EmployeeNotFoundException;
import com.bridgelabz.payroll.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EmployeeService {

    @Autowired
    private EmployeeRepository empRes;

    private ModelMapper modelMapper = new ModelMapper();

    // Fetch all employees
    public List<Employee> getAllEmployees() {
        log.info("Fetching all employees");
        List<Employee> employees = empRes.findAll();
        log.info("Found {} employees", employees.size());
        return employees;
    }

    // Fetch employee by ID
    public Employee getEmployeeById(int id) {
        log.info("Fetching employee with ID: {}", id);
        return empRes.findById(id)
                .orElseThrow(() -> {
                    log.error("Employee with ID: {} not found", id);
                    return new EmployeeNotFoundException("Employee with ID " + id + " not found");
                });
    }

    // Save employee
    @Transactional
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        log.info("Saving new employee: {}", employeeDTO.getName());

//        Employee employee = modelMapper.map(employeeDTO, Employee.class);
//        employee.setDepartments(List.of(String.valueOf(employeeDTO.getDepartments()))); // Convert array to List
//
//        Employee savedEmployee = empRes.save(employee);
//        log.info("Employee saved with ID: {}", savedEmployee.getId());
//        Employee emp = new Employee();
//        emp.setName(employeeDTO.getName());
//        emp.setGender(employeeDTO.getGender());
//        emp.setNote(employeeDTO.getNote());
//        emp.setStartDate(employeeDTO.getStartDate());
//        emp.setProfilePicture(employeeDTO.getProfilePicture());
//        emp.setSalary(employeeDTO.getSalary());
//        emp.setDepartments(employeeDTO.getDepartments());
//        Employee savedEmployee = empRes.save(emp);
        try {
            log.info("ADDED EMPLOYEE");
            return modelMapper.map(empRes.save(modelMapper.map(employeeDTO, Employee.class)),EmployeeDTO.class);
        }catch (Exception e){
            log.error("EMPLOYEE NOT ADDED");
            return new EmployeeDTO();
        }
//        return savedEmployee;
    }

    // Delete employee by ID
    public boolean deleteEmployee(int id) {
        log.info("Attempting to delete employee with ID: {}", id);
        if (empRes.existsById(id)) {
            empRes.deleteById(id);
            log.info("Employee with ID: {} deleted successfully", id);
            return true;
        } else {
            log.warn("Employee with ID: {} not found", id);
            return false;
        }
    }

    // Update employee details
    public EmployeeDTO updateEmployee(int id, EmployeeDTO employeeDTO) {
        log.info("Attempting to update employee with ID: {}", id);

        Optional<Employee> existingEmployeeOpt = empRes.findById(id);
        if (existingEmployeeOpt.isPresent()) {
            Employee existingEmployee = existingEmployeeOpt.get();
            modelMapper.typeMap(EmployeeDTO.class, Employee.class)
                    .addMappings(mapper -> { mapper.skip(Employee::setId);                    });
            existingEmployee.setDepartments(employeeDTO.getDepartments());

            modelMapper.map(employeeDTO, existingEmployee);
            Employee updatedEmployee = empRes.save(existingEmployee);
            log.info("UPDATED EMPLOYEE: " + updatedEmployee);
            return modelMapper.map(updatedEmployee, EmployeeDTO.class);
        }
        log.error("EMPLOYEE NOT EXISTING");
        return new EmployeeDTO();
    }
}
