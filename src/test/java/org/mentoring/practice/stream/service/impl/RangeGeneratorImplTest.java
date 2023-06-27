package org.mentoring.practice.stream.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(MockitoJUnitRunner.class)
public class RangeGeneratorImplTest {

    @InjectMocks
    private RangeGeneratorImpl service;

    @Test(expected = IllegalArgumentException.class)
    public void createRangeList_shouldThrowIllegalArgumentExceptionWhenFromIsLessThanTo() {
        service.createRangeList(2, 1);
    }

    @Test(expected = IllegalArgumentException.class, timeout = 100)
    public void createRangeList_shouldThrowIllegalArgumentExceptionWhenStepIsZero() {
        service.createRangeList(1, 2, 0);
    }

    @Test
    public void createRangeList_shouldGenerateSingleNumberRangeWhenFromEqualsTo() {
        List<Integer> expected = Collections.singletonList(1);
        List<Integer> actual = service.createRangeList(1, 1);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void createRangeList_shouldGenerateRangeOfPositiveNumbers() {
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> actual = service.createRangeList(1, 10);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void createRangeList_shouldGenerateOddRangeOfPositiveNumbers() {
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> actual = service.createRangeList(1, 9);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void createRangeList_shouldGenerateEvenRangeOfNegativeNumbers() {
        List<Integer> expected = Arrays.asList(-10, -9, -8, -7, -6, -5, -4, -3, -2, -1);
        List<Integer> actual = service.createRangeList(-10, -1);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void createRangeList_shouldGenerateOddRangeOfNegativeNumbers() {
        List<Integer> expected = Arrays.asList(-9, -8, -7, -6, -5, -4, -3, -2, -1);
        List<Integer> actual = service.createRangeList(-9, -1);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void createRangeList_shouldGenerateEvenRangeOfPositiveNumbersWithStepSpecified() {
        List<Integer> expected = Arrays.asList(1, 4, 7, 10);
        List<Integer> actual = service.createRangeList(1, 10, 3);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void createRangeList_shouldGenerateOddRangeOfPositiveNumbersWithStepSpecified() {
        List<Integer> expected = Arrays.asList(1, 3, 5, 7, 9);
        List<Integer> actual = service.createRangeList(1, 10, 2);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void createRangeList_shouldGenerateOddRangeOfNegativeNumbersWithStepSpecified() {
        List<Integer> expected = Arrays.asList(-10, -8, -6, -4, -2);
        List<Integer> actual = service.createRangeList(-10, -1, 2);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void createRangeList_shouldGenerateOddRangeOfBothPositiveAndNegativeNumbers() {
        List<Integer> expected = Arrays.asList(-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5);
        List<Integer> actual = service.createRangeList(-5, 5);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void createRangeList_shouldGenerateOddRangeOfBothPositiveAndNegativeNumbersWithStep() {
        List<Integer> expected = Arrays.asList(-5, 0, 5);
        List<Integer> actual = service.createRangeList(-5, 5, 5);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void createRangeList_shouldGenerateEvenRangeOfBothPositiveAndNegativeNumbersWithStep() {
        List<Integer> expected = Arrays.asList(-5, 0);
        List<Integer> actual = service.createRangeList(-5, 4, 5);

        assertThat(actual).isEqualTo(expected);
    }
}