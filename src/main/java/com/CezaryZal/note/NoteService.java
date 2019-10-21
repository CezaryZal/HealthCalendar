package com.CezaryZal.note;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class NoteService {

    private NoteRepository NoteR;

    @Autowired
    public NoteService(NoteRepository NRepository) {
        this.NoteR = NRepository;
    }

    public NoteDB findById (int id){
        return NoteR.findById(id);
    }

    public List<HeaderByDay> getHeadersByDay(int dayId){
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

    public List<HeaderByDay> getHeadersByNotesDB(List<NoteDB> listNoteDB){
        List<HeaderByDay> listHeaders = new ArrayList<>();
        for(NoteDB noteDB : listNoteDB){
            if(noteDB!=null){
                HeaderByDay header = new HeaderByDay(noteDB.getId(), noteDB.getHeader());
                listHeaders.add(header);
            }
        }
        return listHeaders;
    }
}
