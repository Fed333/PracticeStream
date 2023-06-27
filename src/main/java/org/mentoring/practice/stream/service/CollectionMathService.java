package org.mentoring.practice.stream.service;

import java.util.List;

public interface CollectionMathService {

    <T extends Comparable<T>> T max(List<T> list);

    <T extends Comparable<T>> T min(List<T> list);

    Double sum(List<Double> list);

    Double avg(List<Double> list);

    Integer countEven(List<Integer> list);

    Integer countOdd(List<Integer> list);

    Long multiply(List<Integer> list);

}
