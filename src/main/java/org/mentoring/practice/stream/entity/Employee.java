package org.mentoring.practice.stream.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Employee {

    private Long id;

    private String name;

    private Integer age;

    private Contract contract;

    private MajorityLevel majority;

}
