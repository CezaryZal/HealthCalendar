package com.CezaryZal.api.note.manager;

import com.CezaryZal.api.note.NoteRepository;
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
public class NoteService extends NoteRepoService {

    private final NoteToDtoConverter noteToDtoConverter;
    private final DtoToNoteConverter dtoToNoteConverter;
    private final ListNoteToListDtoConverter  listNoteToListDtoConverter;
    private final HeadersCreator headersCreator;

    @Autowired
    public NoteService(NoteRepository noteRepository,
                       NoteToDtoConverter noteToDtoConverter,
                       DtoToNoteConverter dtoToNoteConverter,
                       ListNoteToListDtoConverter listNoteToListDtoConverter,
                       HeadersCreator headersCreator) {
        super(noteRepository);
        this.noteToDtoConverter = noteToDtoConverter;
        this.dtoToNoteConverter = dtoToNoteConverter;
        this.listNoteToListDtoConverter = listNoteToListDtoConverter;
        this.headersCreator = headersCreator;
    }

    public NoteDto getNoteDtoById(Long id){
        return noteToDtoConverter.mappingEntity(getNoteById(id));
    }

    public List<Header> getHeadersByDay(Long dayId){
        List<Note> listNote = getNotesByDayId(dayId);
        return headersCreator.getHeadersByNotes(listNote);
    }

    public List<NoteDto> getNotesDtoByDay(Long dayId){
        return listNoteToListDtoConverter.mappingList(getNotesByDayId(dayId));
    }

    public List<NoteDto> getAllNote (){
        return listNoteToListDtoConverter.mappingList(getAll());
    }

    public String addNoteByDto (NoteDto noteDto){
        addNote(dtoToNoteConverter.mappingEntity(noteDto));
        return "Przesłana notatka została zapisana w bazie danych";
    }

    public String updateNoteByDto (NoteDto noteDto){
        updateNote(dtoToNoteConverter.mappingEntity(noteDto));
        return "Przesłana notatka została uaktualniona";
    }

    public String deleteNoteDtoById (Long id){
        deleteNoteById(id);
        return "Notatka o przesłanym id została usunieta";
    }
}
