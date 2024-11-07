package com.example.shuffletrouble;

public class Timer {
    private int seconds;

    public Timer(int seconds) {
        this.seconds = seconds;
    }
    public String getSeconds() {
        return String.valueOf(seconds);
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public void onSecondPassed(){
        if(this.seconds == 0) {
            return;
        }
        else {
            this.seconds--;
        }


    }

}
