package com.CezaryZal.note.details;

import javax.persistence.*;

@Entity
@Table(name = "details_note")
public class DetailsNote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "details1")
    private String details1;

    @Column(name = "details2")
    private String details2;

    public DetailsNote() {
    }

    public DetailsNote(String details1, String details2) {
        this.details1 = details1;
        this.details2 = details2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDetails1() {
        return details1;
    }

    public void setDetails1(String details1) {
        this.details1 = details1;
    }

    public String getDetails2() {
        return details2;
    }

    public void setDetails2(String details2) {
        this.details2 = details2;
    }

    @Override
    public String toString() {
        return "DetailsNote{" +
                "id=" + id +
                ", details1='" + details1 + '\'' +
                ", details2='" + details2 + '\'' +
                '}';
    }
}
