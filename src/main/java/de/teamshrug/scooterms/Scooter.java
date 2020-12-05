package de.teamshrug.scooterms;

public class Scooter
{

    public Scooter(Status _state, Area _registeredArea)
    {
        state = _state;
        battery = 100;
        registeredarea = _registeredArea;

        Coordinate position = new Coordinate(0,0);
    }



    public Area getRegisteredArea() {
        return registeredarea;
    }

    public void setRegisteredArea(Area _registeredArea) {
        registeredarea = _registeredArea;
    }



    public int getID() {
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



    private Area registeredarea;
    private Coordinate position;
    private int id;
    private Status state;
    private int battery;



}
