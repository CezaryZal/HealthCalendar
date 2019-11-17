package com.CezaryZal.note;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/note")
public class NoteController {

    private NoteService NoteS;

    public NoteController(NoteService NService) {
        this.NoteS = NService;
    }

    @GetMapping("/id/{nrId}")
    public NoteDB getNoteDBById (@PathVariable int nrId){
        return NoteS.getNoteDBById(nrId);
    }

    @GetMapping("/getHeadersByDayId/{dayId}")
    public List<Header> getListHeaderByDayId(@PathVariable int dayId){
        return NoteS.getHeadersByDay(dayId);
    }

    @GetMapping("/getNotesByDayId/{dayId}")
    public List<NoteDB> getListNoteDBByDayId(@PathVariable int dayId){
        return NoteS.getNotesDBByDay(dayId);
    }

    @GetMapping("/getAll")
    public List<NoteDB> getAll(){
        return NoteS.getAll();
    }

    @PostMapping("/add")
    public boolean addDiet (@RequestBody NoteDB noteDB){
        return NoteS.addNote(noteDB);
    }

    @PutMapping("/update")
    public boolean updateMeal (@RequestBody NoteDB noteDB){
        return NoteS.updateNote(noteDB);
    }

    @DeleteMapping("/delete/{id}")
    public String delete (@PathVariable int id){
        return NoteS.deleteNoteById(id);
    }
}
