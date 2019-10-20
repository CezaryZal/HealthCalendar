package com.CezaryZal.note;


import javax.persistence.*;

@Entity
@Table(name = "note")
public class NoteDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "header")
    private String header;

    @Column(name = "details_note")
    private String detailsNote;

    @Column(name = "day_id")
    private int dayId;

    public NoteDB() {
    }

    public NoteDB(String header, String detailsNote, int dayId) {
        this.header = header;
        this.detailsNote = detailsNote;
        this.dayId = dayId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getDayId() {
        return dayId;
    }

    public void setDayId(int dayId) {
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
