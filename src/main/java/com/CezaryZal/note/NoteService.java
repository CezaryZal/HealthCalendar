package com.CezaryZal.note;

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
        return NoteR.findById(id);
    }

    public List<Header> getHeadersByDay(Long dayId){
        List<Note> listNote = getNotesByDay(dayId);

        return getHeadersByNotesDB(listNote);
    }

    public List<Note> getNotesByDay(Long dayId){
        return NoteR.findByDayId(dayId);
    }

    public List<Note> getAll (){
        return NoteR.getAll();
    }

    public boolean addNote (Note note){
        NoteR.save(note);

        return true;
    }

    public boolean updateNote (Note note){
        NoteR.update(note);

        return true;
    }

    public String deleteNoteById (Long id){
        Note note = NoteR.findById(id);
        if(NoteR.delete(note)){
            return "delete record";
        }
        return "Note id not found";
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
