package org.mentoring.practice.stream.service;

import java.util.List;

public interface RangeGenerator {

    /**
     * Creates a range list
     * @param from lower bound of range, inclusive
     * @param to higher bound of range, inclusive
     * */
    List<Integer> createRangeList(int from, int to, int step);

    /**
     * Creates a range list with step equal to 1
     * @param from lower bound of range, inclusive
     * @param to higher bound of range, inclusive
     * */
    List<Integer> createRangeList(int from, int to);

}
