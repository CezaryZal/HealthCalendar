package com.CezaryZal.api.note.manager;

import com.CezaryZal.api.note.entity.Header;
import com.CezaryZal.api.note.entity.Note;
import com.CezaryZal.api.note.entity.NoteDto;
import com.CezaryZal.api.note.manager.creator.HeadersCreator;
import com.CezaryZal.api.note.manager.mapper.DtoToNoteConverter;
import com.CezaryZal.api.note.manager.mapper.ListNoteToListDtoConverter;
import com.CezaryZal.api.note.manager.mapper.NoteToDtoConverter;
import com.CezaryZal.api.note.manager.repo.NoteRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService{

    private final NoteRepoService noteRepoService;
    private final NoteToDtoConverter noteToDtoConverter;
    private final DtoToNoteConverter dtoToNoteConverter;
    private final ListNoteToListDtoConverter  listNoteToListDtoConverter;
    private final HeadersCreator headersCreator;

    @Autowired
    public NoteService(NoteRepoService noteRepoService,
                       NoteToDtoConverter noteToDtoConverter,
                       DtoToNoteConverter dtoToNoteConverter,
                       ListNoteToListDtoConverter listNoteToListDtoConverter,
                       HeadersCreator headersCreator) {
        this.noteRepoService = noteRepoService;
        this.noteToDtoConverter = noteToDtoConverter;
        this.dtoToNoteConverter = dtoToNoteConverter;
        this.listNoteToListDtoConverter = listNoteToListDtoConverter;
        this.headersCreator = headersCreator;
    }

    public NoteDto getNoteDtoById(Long id){
        return noteToDtoConverter.mappingEntity(noteRepoService.getNoteById(id));
    }

    public List<Header> getHeadersByDay(Long dayId){
        return getHeadersByNotes(noteRepoService.getNotesByDayId(dayId));
    }

    public List<Header> getHeadersByNotes(List<Note> notes){
        return headersCreator.getHeadersByNotes(notes);
    }

    public List<NoteDto> getNotesDtoByDay(Long dayId){
        return listNoteToListDtoConverter.mappingList(noteRepoService.getNotesByDayId(dayId));
    }

    public List<NoteDto> getAllNote (){
        return listNoteToListDtoConverter.mappingList(noteRepoService.getAll());
    }

    public String addNoteByDto (NoteDto noteDto){
        noteRepoService.addNote(dtoToNoteConverter.mappingEntity(noteDto));
        return "Przesłana notatka została zapisana w bazie danych";
    }

    public String updateNoteByDto (NoteDto noteDto){
        noteRepoService.updateNote(dtoToNoteConverter.mappingEntity(noteDto));
        return "Przesłana notatka została uaktualniona";
    }

    public String deleteNoteDtoById (Long id){
        noteRepoService.deleteNoteById(id);
        return "Notatka o przesłanym id została usunieta";
    }
}
