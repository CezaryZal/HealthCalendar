package com.CezaryZal.api.note;

import com.CezaryZal.api.note.model.Header;
import com.CezaryZal.api.note.model.NoteDto;
import com.CezaryZal.api.note.manager.NoteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@Api(tags = "Note")
@RestController
@RequestMapping("/api/note")
public class NoteController {

    private final NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @ApiOperation(value = "This will get a `details of Note` by id")
    @GetMapping("/{id}")
    public ResponseEntity<String> getDetailsNoteById (@PathVariable Long id){
        return new ResponseEntity<>(noteService.getDetailsById(id), HttpStatus.OK);
    }

    @ApiOperation(value = "This will get a list `header` by day id")
    @GetMapping("/headers/day-id/{dayId}")
    public ResponseEntity<List<Header>> getListHeaderByDayId(@PathVariable Long dayId){
        return new ResponseEntity<>(noteService.getHeadersByDay(dayId), HttpStatus.OK);
    }

    @ApiOperation(value = "This will get a list `Note` by day id")
    @GetMapping("/day-id/{dayId}")
    public ResponseEntity<List<NoteDto>> getListNoteByDayId(@PathVariable Long dayId){
        return new ResponseEntity<>(noteService.getNotesDtoByDay(dayId), HttpStatus.OK);
    }

    @ApiOperation(value = "This endpoint addition `Note`")
    @PostMapping
    public ResponseEntity<String> addDiet (@RequestBody NoteDto noteDto){
        return new ResponseEntity<>(noteService.addNoteByDto(noteDto), HttpStatus.CREATED);
    }

    @ApiOperation(value = "This endpoint input `Note` object update ")
    @PutMapping
    public ResponseEntity<String> updateMeal (@RequestBody NoteDto noteDto){
        return new ResponseEntity<>(noteService.updateNoteByDto(noteDto), HttpStatus.OK);
    }

    @ApiOperation(value = "This endpoint remove `Note` by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete (@PathVariable Long id){
        return new ResponseEntity<>(noteService.deleteNoteDtoById(id), HttpStatus.NO_CONTENT);
    }
}
