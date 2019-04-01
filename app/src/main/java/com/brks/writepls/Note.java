package com.brks.writepls;

public class Note {

    private String Name;
    private String Date;
    private int favourite;
    private String Text;

    public Note() {

    }

    public Note(String name, String date, int favourite, String text) {
        Name = name;
        Date = date;
        this.favourite = favourite;
        Text = text;
    }

    //Getters


    public String getName() {
        return Name;
    }

    public String getDate() {
        return Date;
    }

    public int getFavourite() {
        return favourite;
    }

    public String getText() {
        return Text;
    }

    // Setters


    public void setName(String name) {
        Name = name;
    }

    public void setDate(String date) {
        Date = date;
    }

    public void setFavourite(int favourite) {
        this.favourite = favourite;
    }

    public void setText(String text) {
        Text = text;
    }
}
