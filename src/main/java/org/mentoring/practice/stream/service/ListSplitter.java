package org.mentoring.practice.stream.service;

import java.util.List;

public interface ListSplitter {

    <T> List<List<T>> split(List<T> list, int subListSize);

}