package com.CezaryZal.api.note.manager.repo;

import com.CezaryZal.api.note.NoteRepository;
import com.CezaryZal.api.note.model.Header;
import com.CezaryZal.api.note.model.entity.Note;
import com.CezaryZal.exceptions.not.found.NoteNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteRepoService {

    private final NoteRepository noteRepository;

    @Autowired
    public NoteRepoService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public Note getNoteById(Long id){
        return noteRepository.findById(id)
                .orElseThrow(() -> new NoteNotFoundException("Details note not found by id"));
    }

    public String getDetailsNoteById(Long id){
        return noteRepository.getDetailsById(id)
                .orElseThrow(() -> new NoteNotFoundException("Note not found by id"));
    }

    public List<Header> getListHeaderById(Long id){
        List<Header> headersById = noteRepository.getHeadersById(id);
        if (headersById.isEmpty()){
            throw new NoteNotFoundException("Headers note not found by id");
        }
        return headersById;
    }

    public List<Note> getNotesByDayId(Long dayId){
        return noteRepository.findAllByDayId(dayId)
                .orElseThrow(() -> new NoteNotFoundException("Notes not found by id"));
    }

    public List<Note> getAll (){
        return noteRepository.findAll();
    }

    public void addNote (Note note){
        noteRepository.save(note);
    }

    public void updateNote (Note note){
        noteRepository.save(note);
    }

    public void deleteNoteById (Long id){
        noteRepository.deleteById(id);
    }
}
