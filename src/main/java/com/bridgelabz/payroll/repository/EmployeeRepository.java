package com.bridgelabz.payroll.repository;

import com.bridgelabz.payroll.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

// using sql database
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}

