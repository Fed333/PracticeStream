package org.mentoring.practice.stream.service;

import java.util.List;

public interface ListJoiner {

    <T> List<T> join(List<List<T>> subLists);

}
