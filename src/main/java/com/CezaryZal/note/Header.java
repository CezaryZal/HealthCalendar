package com.CezaryZal.note;


public class Header {

    private Long id;
    private String header;

    public Header(Long id, String header) {
        this.id = id;
        this.header = header;
    }

    public Long getId() {
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
