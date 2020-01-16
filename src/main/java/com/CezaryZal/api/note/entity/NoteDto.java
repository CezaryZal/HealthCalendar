package com.CezaryZal.api.note.entity;

public class NoteDto extends FormNote{

    public NoteDto(
            Long id,
            String header,
            String detailsNote,
            Long dayId) {
        super(id, header, detailsNote, dayId);
    }
}
