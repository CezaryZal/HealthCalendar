package com.CezaryZal.api.note.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public abstract class FormNote {

    private Long id;
    private String header;
    private String detailsNote;
    private Long dayId;
}
