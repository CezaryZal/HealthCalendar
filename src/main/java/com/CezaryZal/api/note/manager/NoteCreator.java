package com.CezaryZal.api.note.manager;

import com.CezaryZal.api.note.model.NoteDto;
import com.CezaryZal.api.note.model.entity.Note;
import org.springframework.stereotype.Service;

@Service
public class NoteCreator {

    Note createNoteToUpdateByDtoAndNoteId(NoteDto noteDto, Long id){
        Note.Builder builder = mappingDtoToNoteBuilder(noteDto);
        return builder
                .id(id)
                .build();
    }

    Note createNoteByDto(NoteDto noteDto){
        return mappingDtoToNoteBuilder(noteDto).build();
    }

    private Note.Builder mappingDtoToNoteBuilder(NoteDto noteDto) {
        return Note.builder()
                .header(noteDto.getHeader())
                .details(noteDto.getDetailsNote())
                .dayId(noteDto.getDayId());
    }
}
