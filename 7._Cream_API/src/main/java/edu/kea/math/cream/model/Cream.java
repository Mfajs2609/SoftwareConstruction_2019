package edu.kea.math.cream.model;

public class Cream {

    private int id;
    private boolean expired;

    //constructor
    public Cream(int id, boolean expired){
        this.id = id;
        this.expired = expired;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean getExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }
}
