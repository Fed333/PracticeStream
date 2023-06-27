package org.mentoring.practice.stream.service.impl;

import org.mentoring.practice.stream.entity.Contract;
import org.mentoring.practice.stream.entity.Employee;
import org.mentoring.practice.stream.entity.MajorityLevel;
import org.mentoring.practice.stream.service.EmployeeService;

import java.util.List;
import java.util.Map;

public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public List<Contract> raiseSalaryOnPercentFor(double percent, MajorityLevel majority) {
        return null;
    }

    @Override
    public Employee findEmployeeWithHigherSalary(MajorityLevel majority) {
        return null;
    }

    @Override
    public Map<MajorityLevel, Double> findAverageSalaryByMajority() {
        return null;
    }
}
