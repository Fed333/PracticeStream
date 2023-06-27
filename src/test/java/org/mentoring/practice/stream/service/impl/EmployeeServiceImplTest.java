package org.mentoring.practice.stream.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mentoring.practice.stream.entity.Contract;
import org.mentoring.practice.stream.entity.Employee;
import org.mentoring.practice.stream.entity.MajorityLevel;
import org.mentoring.practice.stream.repo.EmployeeRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mentoring.practice.stream.entity.MajorityLevel.JUNIOR;
import static org.mentoring.practice.stream.entity.MajorityLevel.MIDDLE;
import static org.mentoring.practice.stream.entity.MajorityLevel.SENIOR;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceImplTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl service;

    private List<Employee> source;

    private Comparator<Contract> contractComparator;

    @Before
    public void setUp() {
        source = Arrays.asList(
                createEmployee(1L, "Bob", 20, JUNIOR, 500d),
                createEmployee(2L, "Steve", 25, MIDDLE, 1700d),
                createEmployee(3L, "Bruce", 27, SENIOR, 3500d),
                createEmployee(4L, "Tony", 24, MIDDLE, 1600d),
                createEmployee(5L, "Natalia", 23, JUNIOR, 600d),
                createEmployee(6L, "Peter", 25, SENIOR, 2800d)
        );

        when(employeeRepository.findAll())
                .thenReturn(source);


        Comparator<Double> doubleDeltaComparator = createDoubleDeltaComparator(0.0001);

        contractComparator = Comparator.comparing(Contract::getEmployeeId)
                .thenComparing(Contract::getSalary, doubleDeltaComparator);
    }

    @Test
    public void raiseSalaryOnPercentFor_shouldRaiseForJuniors() {
        List<Contract> expected = Arrays.asList(
                createContract(1L,  750d),
                createContract(5L, 900d)
        );

        List<Contract> actual = service.raiseSalaryOnPercentFor(0.5, JUNIOR);

        assertThat(actual).usingElementComparator(contractComparator).isEqualTo(expected);
    }

    @Test
    public void raiseSalaryOnPercentFor_shouldRaiseForMiddles() {
        List<Contract> expected = Arrays.asList(
                createContract(2L,  2210d),
                createContract(4L, 2080d)
        );

        List<Contract> actual = service.raiseSalaryOnPercentFor(0.3, MIDDLE);

        assertThat(actual).usingElementComparator(contractComparator).isEqualTo(expected);
    }

    @Test
    public void raiseSalaryOnPercentFor_shouldRaiseForSeniors() {
        List<Contract> expected = Arrays.asList(
                createContract(3L,  4200d),
                createContract(6L, 3360d)
        );

        List<Contract> actual = service.raiseSalaryOnPercentFor(0.2, SENIOR);

        assertThat(actual).usingElementComparator(contractComparator).isEqualTo(expected);
    }

    @Test
    public void findEmployeeWithHigherSalary_shouldReturnJuniorEmployee() {
        Employee expected = source.get(4);

        Employee actual = service.findEmployeeWithHigherSalary(JUNIOR);

        assertThat(actual).isSameAs(expected);
    }

    @Test
    public void findEmployeeWithHigherSalary_shouldReturnMiddleEmployee() {
        Employee expected = source.get(1);

        Employee actual = service.findEmployeeWithHigherSalary(MIDDLE);

        assertThat(actual).isSameAs(expected);
    }

    @Test
    public void findEmployeeWithHigherSalary_shouldReturnSeniorEmployee() {
        Employee expected = source.get(2);

        Employee actual = service.findEmployeeWithHigherSalary(SENIOR);

        assertThat(actual).isSameAs(expected);
    }

    @Test
    public void findAverageSalaryByMajority_shouldCalculateAveragePerEachMajorityLevel() {
        Map<MajorityLevel, Double> expected = new HashMap<>();
        expected.put(JUNIOR, 550d);
        expected.put(MIDDLE, 1650d);
        expected.put(SENIOR, 3150d);

        Map<MajorityLevel, Double> actual = service.findAverageSalaryByMajority();

        assertThat(actual).isEqualTo(expected);
    }

    private Employee createEmployee(Long id, String name, Integer age, MajorityLevel majority, Double salary) {
        return Employee.builder()
                .id(id)
                .name(name)
                .age(age)
                .majority(majority)
                .contract(createContract(id, salary)).build();
    }

    private Contract createContract(Long id, Double salary) {
        return Contract.builder().employeeId(id).salary(salary).build();
    }

    @SuppressWarnings("SameParameterValue")
    private Comparator<Double> createDoubleDeltaComparator(double delta) {
        return (a, b) -> Math.abs(a - b) < delta ? 0 : (int) (a - b);
    }
}