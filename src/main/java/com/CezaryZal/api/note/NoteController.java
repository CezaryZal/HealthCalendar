package com.CezaryZal.api.note;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@Api(tags = "Note")
@RestController
@RequestMapping("/api/note")
public class NoteController {

    private NoteService NoteS;

    public NoteController(NoteService NService) {
        this.NoteS = NService;
    }

    @ApiOperation(value = "This will get a `Note` by id")
    @GetMapping("/{id}")
    public Note getNoteById (@PathVariable Long id){
        return NoteS.getNoteById(id);
    }

    @ApiOperation(value = "This will get a list `Header` by day id")
    @GetMapping("/headers/day-id/{dayId}")
    public List<Header> getListHeaderByDayId(@PathVariable Long dayId){
        return NoteS.getHeadersByDay(dayId);
    }

    @ApiOperation(value = "This will get a list `Note` by day id")
    @GetMapping("/day-id/{dayId}")
    public List<Note> getListNoteByDayId(@PathVariable Long dayId){
        return NoteS.getNotesByDay(dayId);
    }

    @ApiOperation(value = "This will get a list `Note`, all records")
    @GetMapping
    public List<Note> getAll(){
        return NoteS.getAll();
    }

    @PostMapping
    public void addDiet (@RequestBody Note note){
        NoteS.addNote(note);
    }

    @PutMapping
    public void updateMeal (@RequestBody Note note){
        NoteS.updateNote(note);
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable Long id){
        NoteS.deleteNoteById(id);
    }
}
