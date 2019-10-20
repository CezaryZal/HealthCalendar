package com.CezaryZal.note;


public class HeaderByDay {

    private int id;
    private String header;

    public HeaderByDay(int id, String header) {
        this.id = id;
        this.header = header;
    }

    public int getId() {
        return id;
    }

    public String getHeader() {
        return header;
    }

    @Override
    public String toString() {
        return "HeadersByDay{" +
                "id=" + id +
                ", header='" + header + '\'' +
                '}';
    }
}
