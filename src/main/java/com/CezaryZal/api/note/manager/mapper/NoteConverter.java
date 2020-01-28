package com.CezaryZal.api.note.manager.mapper;

import com.CezaryZal.api.note.model.entity.Note;
import com.CezaryZal.api.note.model.NoteDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NoteConverter {

    public NoteDto mappingNoteToDto(Note note) {
        return NoteDto.Builder.builder()
                .id(note.getId())
                .header(note.getHeader())
                .details(note.getDetailsNote())
                .dayId(note.getDayId())
                .build();
    }

    public List<NoteDto> mappingListNoteToListDto(List<Note> notes) {
        return notes.stream()
                .map(this::mappingNoteToDto)
                .collect(Collectors.toList());
    }
}
