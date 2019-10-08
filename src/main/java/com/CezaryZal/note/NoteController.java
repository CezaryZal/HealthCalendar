//package com.CezaryZal.note;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/note")
//public class NoteController {
//
//    private NoteService noteService;
//
//    @Autowired
//    public NoteController(NoteService noteService) {
//        this.noteService = noteService;
//    }
//
//    @GetMapping("/id/{noteId}")
//    public Note getNote (@PathVariable int noteId){
//        Note note = noteService.getNote(noteId);
//
//        return note;
//    }
//}
