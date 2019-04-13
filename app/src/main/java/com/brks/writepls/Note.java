package com.brks.writepls;

import java.util.HashMap;
import java.util.Map;

public class Note {

    private String Name;
    private String Date;
    private String Text;


    private String key;

    public Note() {

    }

    public Note(String name, String date, String text, String key) {
        Name = name;
        Date = date;
        Text = text;
        this.key = key;
    }

    //Getters


    public String getName() {
        return Name;
    }

    public String getDate() {
        return Date;
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

    public void setText(String text) {
        Text = text;
    }
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("name",Name);
        result.put("text", Text);
        result.put("date",Date);
        result.put("key",key);

        return result;
    }
}



