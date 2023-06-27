package org.mentoring.practice.stream.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class ListJoinerImplTest {

    @InjectMocks
    private ListJoinerImpl service;

    @Test
    public void join() {
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<List<Integer>> source = asList(asList(1), asList(2, 3), asList(4, 5, 6), asList(7, 8, 9, 10));

        List<Integer> actual = service.join(source);

        assertThat(actual).isEqualTo(expected);
    }
}