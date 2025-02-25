package com.bridgelabz.payroll.service;

import com.bridgelabz.payroll.entity.Employee;
import com.bridgelabz.payroll.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
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
    public Employee saveEmployee(Employee emp){
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
    public Employee updateEmployee(int id, Employee emp){
        if(empRes.existsById(id)){
            emp.setId(id);
            return empRes.save(emp);
        }
        return null;
    }
}
