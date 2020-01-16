package com.CezaryZal.api.note.manager.mapper;

import com.CezaryZal.api.note.entity.Note;
import com.CezaryZal.api.note.entity.NoteDto;
import org.springframework.stereotype.Service;

@Service
public class DtoToNoteConverter {

    public Note mappingEntity(NoteDto noteDto) {
        return new Note(
                noteDto.getId(),
                noteDto.getHeader(),
                noteDto.getDetailsNote(),
                noteDto.getDayId()
        );
    }
}
