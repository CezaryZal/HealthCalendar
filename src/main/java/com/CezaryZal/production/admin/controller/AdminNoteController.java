package com.CezaryZal.production.admin.controller;

import com.CezaryZal.api.note.entity.NoteDto;
import com.CezaryZal.api.note.manager.NoteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@Api(tags = "Admin note controller")
@RestController
@RequestMapping("/admin/api/note")
public class AdminNoteController {

    private final NoteService noteService;

    @Autowired
    public AdminNoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @ApiOperation(value = "This will get a list `Note`, all records")
    @GetMapping
    public ResponseEntity<List<NoteDto>> getAll(){
        return new ResponseEntity<>(noteService.getAllNote(), HttpStatus.OK);
    }
}
