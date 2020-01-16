package com.CezaryZal.api.note.manager.mapper;

import com.CezaryZal.api.note.entity.Note;
import com.CezaryZal.api.note.entity.NoteDto;
import org.springframework.stereotype.Service;

@Service
public class NoteToDtoConverter {

    public NoteDto mappingEntity(Note note) {
        return new NoteDto(
                note.getId(),
                note.getHeader(),
                note.getDetailsNote(),
                note.getDayId()
        );
    }
}
