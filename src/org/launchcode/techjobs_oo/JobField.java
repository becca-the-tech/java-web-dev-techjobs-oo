package org.launchcode.techjobs_oo;

import java.util.Objects;


public abstract class JobField {
    private int id;
    private static int nextId = 1;
    private String value;

    //Constructors

    public JobField() {
        id = nextId;
        nextId++;
    }

    public JobField(String value){
        this();
        this.value = value;
    }



    //Equals and HashCode and toString

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobField jobField = (JobField) o;
        return id == jobField.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return value;
    }

//Setters and Getters

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }



}
