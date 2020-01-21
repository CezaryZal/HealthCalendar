package com.CezaryZal.api.note.manager.creator;

import com.CezaryZal.api.note.model.Header;
import com.CezaryZal.api.note.model.entity.Note;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HeadersCreator {

    public List<Header> getHeadersByNotes(List<Note> listNote) {
        List<Header> listHeaders = new ArrayList<>();
        listNote.forEach(tmp -> listHeaders.add(new Header(tmp.getId(), tmp.getHeader())));

        return listHeaders;
    }
}
