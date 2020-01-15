package com.CezaryZal.api.note;

import com.CezaryZal.exceptions.not.found.NoteNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoteService {

    private NoteRepository NoteR;

    public NoteService(NoteRepository NRepository) {
        this.NoteR = NRepository;
    }

    public Note getNoteById(Long id){
        return NoteR.findById(id)
                .orElseThrow(() -> new NoteNotFoundException("Note not found by id"));
    }

    public List<Header> getHeadersByDay(Long dayId){
        List<Note> listNote = getNotesByDay(dayId);

        return getHeadersByNotesDB(listNote);
    }

    public List<Note> getNotesByDay(Long dayId){
        return NoteR.findAllByDayId(dayId);
    }

    public List<Note> getAll (){
        return (List<Note>) NoteR.findAll();
    }

    public void addNote (Note note){
        NoteR.save(note);
    }

    public void updateNote (Note note){
        NoteR.save(note);
    }

    public void deleteNoteById (Long id){
        NoteR.deleteById(id);
    }

    public List<Header> getHeadersByNotesDB(List<Note> listNote){
        List<Header> listHeaders = new ArrayList<>();
        for(Note note : listNote){
            if(note !=null){
                Header header = new Header(note.getId(), note.getHeader());
                listHeaders.add(header);
            }
        }
        return listHeaders;
    }
}
