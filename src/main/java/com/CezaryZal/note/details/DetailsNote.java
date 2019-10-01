package com.CezaryZal.note.details;

import javax.persistence.*;

@Entity
@Table(name = "details_note")
public class DetailsNote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "details")
    private String details;

    public DetailsNote() {
    }

    public DetailsNote(String details) {
        this.details = details;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details1) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "DetailsNote{" +
                "id=" + id +
                ", details='" + details + '\'' +
                '}';
    }
}
