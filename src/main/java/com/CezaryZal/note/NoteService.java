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

    public NoteDB getNoteDBById (int id){
        return NoteR.findById(id);
    }

    public List<Header> getHeadersByDay(int dayId){
        List<NoteDB> listNoteDB = getNotesDBByDay(dayId);

        return getHeadersByNotesDB(listNoteDB);
    }

    public List<NoteDB> getNotesDBByDay (int dayId){
        return NoteR.findByDayId(dayId);
    }

    public List<NoteDB> getAll (){
        return NoteR.getAll();
    }

    public boolean addNote (NoteDB noteDB){
        NoteR.save(noteDB);

        return true;
    }

    public boolean updateNote (NoteDB noteDB){
        NoteR.update(noteDB);

        return true;
    }

    public String deleteNoteById (int id){
        NoteDB noteDB = NoteR.findById(id);
        if(NoteR.delete(noteDB)){
            return "delete record";
        }
        return "Note id not found";
    }

    public List<Header> getHeadersByNotesDB(List<NoteDB> listNoteDB){
        List<Header> listHeaders = new ArrayList<>();
        for(NoteDB noteDB : listNoteDB){
            if(noteDB!=null){
                Header header = new Header(noteDB.getId(), noteDB.getHeader());
                listHeaders.add(header);
            }
        }
        return listHeaders;
    }
}
