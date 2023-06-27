package org.mentoring.practice.stream.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class CollectionMathServiceImplTest {

    @InjectMocks
    private CollectionMathServiceImpl service;

    private List<Integer> sourceInt;
    private List<Double> sourceDouble;

    @Before
    public void setUp() {
        sourceInt = Arrays.asList(1, 2, 3, 4, 5);
        sourceDouble = Arrays.asList(1d, 2d, 3d, 4d, 5d);
    }

    @Test
    public void max() {
        Integer expected = 5;
        Integer actual = service.max(sourceInt);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void min() {
        Integer expected = 1;
        Integer actual = service.min(sourceInt);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void sum() {
        Double expected = 15d;
        Double actual = service.sum(sourceDouble);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void avg() {
        Double expected = 3d;
        Double actual = service.avg(sourceDouble);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void countEven() {
        Integer expected = 2;
        Integer actual = service.countEven(sourceInt);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void countOdd() {
        Integer expected = 3;
        Integer actual = service.countOdd(sourceInt);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void multiply() {
        Long expected = 120L;
        Long actual = service.multiply(sourceInt);

        assertThat(actual).isEqualTo(expected);
    }
}