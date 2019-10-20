package com.CezaryZal.note;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class NoteService {

    private NoteRepository NRepository;

    @Autowired
    public NoteService(NoteRepository NRepository) {
        this.NRepository = NRepository;
    }

    public NoteDB findById (int id){
        NoteDB noteDB = NRepository.findById(id);

        return noteDB;
    }

    public List<HeaderByDay> getHeadersByDay(int dayId){
        List<NoteDB> listNoteDB = getNotesDBByDay(dayId);
        List<HeaderByDay> listHeaders = null;
        for(NoteDB noteDB : listNoteDB){
            if(noteDB!=null){
                HeaderByDay header = new HeaderByDay(noteDB.getId(), noteDB.getHeader());
                listHeaders.add(header);
            }
        }
        return listHeaders;
    }

    public List<NoteDB> getNotesDBByDay (int dayId){
        List<NoteDB> listNoteDb = NRepository.findByDayId(dayId);

        return listNoteDb;
    }


    public List<NoteDB> getAll (){
        List<NoteDB> listNoteDB = NRepository.getAll();

        return listNoteDB;
    }

    public boolean addNote (NoteDB noteDB){
        NRepository.save(noteDB);

        return true;
    }

    public boolean updateNote (NoteDB noteDB){
        NRepository.update(noteDB);

        return true;
    }

    public String deleteNoteById (int id){
        NoteDB noteDB = NRepository.findById(id);
        if(NRepository.delete(noteDB)){
            return "delete record";
        }
        return "Note id not found";
    }
}
