package com.CezaryZal.note;


import javax.persistence.*;

@Entity
@Table(name = "note")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "header")
    private String header;

    @Column(name = "details_note")
    private String detailsNote;

    @Column(name = "day_id")
    private Long dayId;

    public Note() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getDetailsNote() {
        return detailsNote;
    }

    public void setDetailsNote(String detailsNote) {
        this.detailsNote = detailsNote;
    }

    public Long getDayId() {
        return dayId;
    }

    public void setDayId(Long dayId) {
        this.dayId = dayId;
    }

    @Override
    public String toString() {
        return "NoteDB{" +
                "id=" + id +
                ", header='" + header + '\'' +
                ", detailsNote='" + detailsNote + '\'' +
                ", dayId=" + dayId +
                '}';
    }
}
