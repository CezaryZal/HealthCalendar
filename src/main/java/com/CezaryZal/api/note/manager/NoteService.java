package com.CezaryZal.api.note.manager;

import com.CezaryZal.api.note.repo.NoteRepository;
import com.CezaryZal.api.note.model.Header;
import com.CezaryZal.api.note.model.NoteDto;
import com.CezaryZal.api.note.model.entity.Note;
import com.CezaryZal.exceptions.not.found.NoteNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService{

    private final NoteRepository noteRepository;
    private final NoteConverter noteConverter;
    private final NoteCreator noteCreator;

    @Autowired
    public NoteService(NoteRepository noteRepository,
                       NoteConverter noteConverter,
                       NoteCreator noteCreator) {
        this.noteRepository = noteRepository;
        this.noteConverter = noteConverter;
        this.noteCreator = noteCreator;
    }

    public NoteDto getNoteDtoById(Long id){
        Note note = noteRepository.findById(id)
                .orElseThrow(() -> new NoteNotFoundException("Details note not found by id"));
        return noteConverter.mappingNoteToDto(note);
    }

    public String getDetailsById(Long id){
        return noteRepository.getDetailsById(id)
                .orElseThrow(() -> new NoteNotFoundException("Note not found by id"));
    }

    public List<Header> getHeadersForNoteControllerByDayId(Long dayId){
        List<Header> headersByDayId = noteRepository.getHeadersById(dayId);
        if (headersByDayId.isEmpty()){
            throw new NoteNotFoundException("Headers note not found by id");
        }
        return headersByDayId;
    }

    public List<Header> getHeadersForLongReportByDayId(Long dayId){
        return noteRepository.getHeadersById(dayId);
    }

    public List<NoteDto> getNotesDtoByDay(Long dayId){
        List<Note> notes = noteRepository.findNoteListByDayId(dayId);
        return notes.isEmpty() ? null : noteConverter.mappingListNoteToListDto(notes);
    }

    public List<NoteDto> getAllNote (){
        return noteConverter.mappingListNoteToListDto(noteRepository.findAll());
    }

    public String addNoteByDto (NoteDto noteDto){
        noteRepository.save(noteCreator.createNoteByDtoAndNoteId(noteDto));
        return "Received the note object has been saved to the database";
    }

    public String updateNoteByDto (NoteDto noteDto, Long noteId){
        noteRepository.save(noteCreator.createNoteToUpdateByDtoAndNoteId(noteDto, noteId));
        return "Received the note object has been updated";
    }

    public String deleteNoteDtoById (Long id){
        noteRepository.deleteById(id);
        return "The note has been removed based on Id";
    }
}
