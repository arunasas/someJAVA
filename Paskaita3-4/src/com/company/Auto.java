package com.company;

public class Auto {
    private String marke;
    private String modelis;
    private double uzmiestis;
    private double miestas;
    private double vidutines;

    public Auto(String marke, String modelis, double uzmiestis, double miestas, double vidutines) {
        this.marke = marke;
        this.modelis = modelis;
        this.uzmiestis = uzmiestis;
        this.miestas = miestas;
        this.vidutines = vidutines;
    }

    public String getMarke() {
        return marke;
    }

    public String getModelis() {
        return modelis;
    }

    public double getUzmiestis() {
        return uzmiestis;
    }

    public double getMiestas() {
        return miestas;
    }

    public double getVidutines() {
        return vidutines;
    }

    @Override
    public String toString() {
        return marke + " " + modelis + " " + ", uzm " + uzmiestis;
    }
}
