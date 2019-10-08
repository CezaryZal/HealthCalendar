//package com.CezaryZal.note;
//
//import com.CezaryZal.note.details.DetailsNote;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "note")
//public class Note {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private int id;
//
//    @Column(name = "header")
//    private String header;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "details_note_id")
//    private DetailsNote detailsNote;
//
//    public Note() {
//    }
//
//    public Note(String header, DetailsNote detailsNote) {
//        this.header = header;
//        this.detailsNote = detailsNote;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getHeader() {
//        return header;
//    }
//
//    public void setHeader(String header1) {
//        this.header = header;
//    }
//
//    public DetailsNote getDetailsNote() {
//        return detailsNote;
//    }
//
//    public void setDetailsNote(DetailsNote detailsNote) {
//        this.detailsNote = detailsNote;
//    }
//
//    @Override
//    public String toString() {
//        return "Note{" +
//                "id=" + id +
//                ", header='" + header + '\'' +
//                ", detailsNote=" + detailsNote +
//                '}';
//    }
//}
