package org.mentoring.practice.stream.service;

import org.mentoring.practice.stream.entity.Contract;
import org.mentoring.practice.stream.entity.Employee;
import org.mentoring.practice.stream.entity.MajorityLevel;

import java.util.List;
import java.util.Map;

public interface EmployeeService {

    List<Contract> raiseSalaryOnPercentFor(double percent, MajorityLevel majority);

    Employee findEmployeeWithHigherSalary(MajorityLevel majority);

    Map<MajorityLevel, Double> findAverageSalaryByMajority();

}
