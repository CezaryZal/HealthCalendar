package com.CezaryZal.note;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/note")
public class NoteController {

    private NoteService NService;

    @Autowired
    public NoteController(NoteService NService) {
        this.NService = NService;
    }

    @GetMapping("/id/{nrId}")
    public NoteDB getNoteById (@PathVariable int nrId){
        return NService.findById(nrId);
    }

    @GetMapping("/getHeadersByDayId/{dayId}")
    public List<HeaderByDay> getListHeaderByDayId(@PathVariable int dayId){
        return NService.getHeadersByDay(dayId);
    }

    @GetMapping("/getAll")
    public List<NoteDB> getAll(){
        return NService.getAll();
    }

    @PostMapping("/add")
    public boolean addDiet (@RequestBody NoteDB noteDB){
        return NService.addNote(noteDB);
    }

    @PutMapping("/update")
    public boolean updateMeal (@RequestBody NoteDB noteDB){
        return NService.updateNote(noteDB);
    }

    @DeleteMapping("/delete/{id}")
    public String delete (@PathVariable int id){
        return NService.deleteNoteById(id);
    }
}
