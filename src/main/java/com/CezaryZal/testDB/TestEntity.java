package com.CezaryZal.testDB;

public class TestEntity {

    private String name;
    private int nrIdent;

    public TestEntity() {
    }

    public TestEntity(String name, int nrIdent) {
        this.name = name;
        this.nrIdent = nrIdent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNrIdent() {
        return nrIdent;
    }

    public void setNrIdent(int nrIdent) {
        this.nrIdent = nrIdent;
    }
}
