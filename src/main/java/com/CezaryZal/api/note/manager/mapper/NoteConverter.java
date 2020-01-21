package com.CezaryZal.api.note.manager.mapper;

import com.CezaryZal.api.note.entity.Note;
import com.CezaryZal.api.note.entity.NoteDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NoteConverter {

    public Note mappingDtoToNote(NoteDto noteDto) {
        return new Note(
                noteDto.getId(),
                noteDto.getHeader(),
                noteDto.getDetailsNote(),
                noteDto.getDayId()
        );
    }

    public NoteDto mappingNoteToDto(Note note) {
        return new NoteDto(
                note.getId(),
                note.getHeader(),
                note.getDetailsNote(),
                note.getDayId()
        );
    }

    public List<NoteDto> mappingListNoteToListDto(List<Note> notes) {
        return notes.stream()
                .map(this::mappingNoteToDto)
                .collect(Collectors.toList());
    }
}
