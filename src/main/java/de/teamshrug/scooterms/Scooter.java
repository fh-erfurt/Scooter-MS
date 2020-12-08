package de.teamshrug.scooterms;

public class Scooter
{

    public Scooter(Status _state, Area _registeredArea)
    {
        this.state = _state;
        this.registeredarea = _registeredArea;
        this.battery = 100;
        this.id = ++numberofscooters;

        Coordinate position = new Coordinate(0,0);
    }

    protected void finalize()
    {
        --numberofscooters;
    }



    public Area getRegisteredArea() {
        return this.registeredarea;
    }

    public void setRegisteredArea(Area _registeredArea) {
        this.registeredarea = _registeredArea;
    }

    public void drive()
    {
        battery--;
    }

    public int getId() {
        return id;
    }

    public Status getState() {
        return state;
    }

    public void setState(Status _state) {
        this.state = _state;
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
    private final int id;
    private Status state;
    private int battery;
    private static int numberofscooters;



}
