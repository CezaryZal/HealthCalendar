package com.CezaryZal.api.note.repo;

import com.CezaryZal.api.note.model.Header;
import com.CezaryZal.api.note.model.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

    Optional<List<Note>> findAllByDayId(Long dayId);

    @Query(value = "select * from note where day_id =:inputDayId", nativeQuery = true)
    List<Note> findNoteListByDayId(@Param("inputDayId") Long dayId);

    @Query(value = "select details_note from note where id=:noteId", nativeQuery = true)
    Optional<String> getDetailsById(@Param("noteId") Long id);

    @Query(name = "Result", nativeQuery = true)
    List<Header> getHeadersById(@Param("dayId") Long dayId);

}
