package com.brks.writepls;

public class Reminder {
    public Reminder(String time, boolean flag, String text) {
        Time = time;
        this.flag = flag;
        Text = text;
    }

    public Reminder(){
    }

    private String Time;
    private boolean flag;
    private String Text;

    //Getters


    public String getTime() {
        return Time;
    }



    public boolean isFlag() {
        return flag;
    }

    public String getText() {
        return Text;
    }

    //Setters


    public void setTime(String time) {
        Time = time;
    }


    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void setText(String text) {
        Text = text;
    }
}
