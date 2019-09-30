package com.CezaryZal.note;

import com.CezaryZal.note.detailsNote.DetailsNote;

import javax.persistence.*;

@Entity
@Table(name = "note")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "header1")
    private String header1;

    @Column(name = "header2")
    private String header2;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "details_note_id")
    private DetailsNote detailsNote;

    public Note() {
    }

    public Note(String header1, String header2, DetailsNote detailsNote) {
        this.header1 = header1;
        this.header2 = header2;
        this.detailsNote = detailsNote;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeader1() {
        return header1;
    }

    public void setHeader1(String header1) {
        this.header1 = header1;
    }

    public String getHeader2() {
        return header2;
    }

    public void setHeader2(String header2) {
        this.header2 = header2;
    }

    public DetailsNote getDetailsNote() {
        return detailsNote;
    }

    public void setDetailsNote(DetailsNote detailsNote) {
        this.detailsNote = detailsNote;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", header1='" + header1 + '\'' +
                ", header2='" + header2 + '\'' +
                ", detailsNote=" + detailsNote +
                '}';
    }
}
