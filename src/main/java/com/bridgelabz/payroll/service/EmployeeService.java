package com.bridgelabz.payroll.service;

import com.bridgelabz.payroll.dto.EmployeeDTO;
import com.bridgelabz.payroll.entity.Employee;
import com.bridgelabz.payroll.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
// service class to implement service layer
public class EmployeeService {
   @Autowired
    EmployeeRepository empRes;
   // method for find all employees
    public List<Employee> getAllEmployees(){
        return empRes.findAll();
    }

    // find employee by id
    public Employee getEmployeeById(int id){
        return empRes.findById(id).orElse(null);
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
