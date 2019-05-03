package com.brks.writepls;

import java.util.HashMap;
import java.util.Map;

public class Reminder {
    public Reminder(int hour,int minute, boolean flag, String text, String Key) {
        this.hour = hour;
        this.minute = minute;
        this.flag = flag;
        Text = text;
        this.key = key;
    }

    public Reminder(){
    }

    private int hour;
    private int minute;
    private boolean flag;
    private String Text;

    private String key;

//Getters

    public int getHour() {
        return hour;
    }

    public boolean isFlag() {
        return flag;
    }

    public String getText() {
        return Text;
    }

//Setters

    public void setHour(int time) {
        hour = time;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void setText(String text) {
        Text = text;
    }

    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("flag", flag);
        result.put("hour",hour);
        result.put("minute",minute);
        result.put("Text",Text);
        result.put("key",key);

        return result;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }
}