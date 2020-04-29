package com.CezaryZal.api.report.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BasicReport {

    private Long userId;
    private String nick;
    private String lastDateMeasureBody;

}
