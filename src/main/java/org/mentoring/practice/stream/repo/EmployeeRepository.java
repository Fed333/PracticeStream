package org.mentoring.practice.stream.repo;

import org.mentoring.practice.stream.entity.Employee;

import java.util.List;

public interface EmployeeRepository {

    List<Employee> findAll();

}
