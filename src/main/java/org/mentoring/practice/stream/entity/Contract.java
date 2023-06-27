package org.mentoring.practice.stream.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Contract {

    private Long employeeId;

    private Double salary;

}