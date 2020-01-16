package com.CezaryZal.api.note.manager.repo;

import com.CezaryZal.api.note.NoteRepository;
import com.CezaryZal.api.note.entity.Note;
import com.CezaryZal.exceptions.not.found.NoteNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class NoteRepoService {

    private final NoteRepository noteRepository;

    @Autowired
    public NoteRepoService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    protected Note getNoteById(Long id){
        return noteRepository.findById(id)
                .orElseThrow(() -> new NoteNotFoundException("Note not found by id"));
    }

    protected List<Note> getNotesByDayId(Long dayId){
        return noteRepository.findAllByDayId(dayId);
    }

    protected List<Note> getAll (){
        return noteRepository.findAll();
    }

    protected void addNote (Note note){
        noteRepository.save(note);
    }

    protected void updateNote (Note note){
        noteRepository.save(note);
    }

    protected void deleteNoteById (Long id){
        noteRepository.deleteById(id);
    }
}
