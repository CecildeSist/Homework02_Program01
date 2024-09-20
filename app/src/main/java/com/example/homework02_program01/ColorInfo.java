package com.example.homework02_program01;

public class ColorInfo {
    //Store hex code, red progress, green progress, and blue progress
    private String hexaText;
    private int redProgress, greenProgress, blueProgress;

    //Constructor
    public ColorInfo() {

    }

    //Overloaded constructor
    public ColorInfo(String hT, int rP, int gP, int bP) {
        hexaText        = "CD3E7F";
        redProgress     = 205;
        greenProgress   = 62;
        blueProgress    = 127;
    }

    //Getters and setters

    public String getHexaText() {
        return hexaText;
    }

    public void setHexaText(String hexaText) {
        this.hexaText = hexaText;
    }

    public int getRedProgress() {
        return redProgress;
    }

    public void setRedProgress(int redProgress) {
        this.redProgress = redProgress;
    }

    public int getGreenProgress() {
        return greenProgress;
    }

    public void setGreenProgress(int greenProgress) {
        this.greenProgress = greenProgress;
    }

    public int getBlueProgress() {
        return blueProgress;
    }

    public void setBlueProgress(int blueProgress) {
        this.blueProgress = blueProgress;
    }
}
