package com.bridgelabz.payroll.repository;

import com.bridgelabz.payroll.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// using sql database
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query(value = "SELECT * FROM employees WHERE department = 'Sales'", nativeQuery = true)
    List<Employee> findEmployeesBySalesDepartment();
}

