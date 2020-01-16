package com.CezaryZal.api.note.manager.mapper;

import com.CezaryZal.api.note.entity.Note;
import com.CezaryZal.api.note.entity.NoteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListNoteToListDtoConverter {

    private final NoteToDtoConverter noteToDtoConverter;

    @Autowired
    public ListNoteToListDtoConverter(NoteToDtoConverter noteToDtoConverter) {
        this.noteToDtoConverter = noteToDtoConverter;
    }

    public List<NoteDto> mappingList(List<Note> notes) {
        return notes.stream()
                .map(noteToDtoConverter::mappingEntity)
                .collect(Collectors.toList());
    }
}
