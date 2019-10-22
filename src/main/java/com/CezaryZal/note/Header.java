package com.CezaryZal.note;


public class Header {

    private int id;
    private String header;

    public Header(int id, String header) {
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
