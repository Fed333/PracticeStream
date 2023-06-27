package org.mentoring.practice.stream.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class ListSplitterImplTest {

    @InjectMocks
    private ListSplitterImpl service;

    @Test(expected = IllegalArgumentException.class)
    public void split_shouldThrowIllegalArgumentExceptionWhenSubListSizeIsNegative() {
        service.split(asList(1, 2), -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void split_shouldThrowIllegalArgumentExceptionWhenSubListSizeIsZero() {
        service.split(asList(1, 2), 0);
    }

    @Test
    public void split_shouldReturnEmptyListWhenSourceIsNull() {
        List<List<Object>> actual = service.split(null, 1);

        assertThat(actual).isEmpty();
    }

    @Test
    public void split_shouldSplitListOnToSubLists() {
        List<List<Integer>> expected = asList(asList(1, 2), asList(3, 4), asList(5, 6), asList(7, 8), asList(9, 10));
        List<Integer> source = asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<List<Integer>> actual = service.split(source, 2);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void split_shouldSplitListOnToSubListsWithRemainderSubList() {
        List<List<Integer>> expected = asList(asList(1, 2, 3), asList(4, 5, 6), asList(7, 8, 9), asList(10));
        List<Integer> source = asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<List<Integer>> actual = service.split(source, 3);

        assertThat(actual).isEqualTo(expected);
    }
}