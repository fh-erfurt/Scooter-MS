package de.teamshrug.scooterms;

public class Scooter
{

    public Scooter(Status _state, Area _registeredArea)
    {
        state = _state;
        registeredarea = _registeredArea;
        battery = 100;
        id = ++numberofscooters;

        Coordinate position = new Coordinate(0,0);
    }



    public Area getRegisteredArea() {
        return registeredarea;
    }

    public void setRegisteredArea(Area _registeredArea) {
        registeredarea = _registeredArea;
    }



    public int getId() {
        return id;
    }

    public Status getState() {
        return state;
    }

    public void setState(Status _state) {
        state = _state;
    }

    public int getBattery() {
        return battery;
    }

    public Coordinate getPosition() {
        return position;
    }

    public void setPosition(Coordinate position) {this.position = position;}

    public static int getNumberofscooters() {
        return numberofscooters;
    }


    private Area registeredarea;
    private Coordinate position;
    private int id;
    private Status state;
    private int battery;
    private static int numberofscooters;



}
