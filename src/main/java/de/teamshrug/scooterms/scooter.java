package de.teamshrug.scooterms;

public class scooter
{

    public scooter(status state, int battery, area registeredArea)
    {
        State = state;
        Battery = battery;
        RegisteredArea = registeredArea;
    }



    public area getRegisteredArea() {
        return RegisteredArea;
    }

    public void setRegisteredArea(area registeredArea) {
        RegisteredArea = registeredArea;
    }

    private area RegisteredArea;

    public int getID() {
        return ID;
    }

    public status getState() {
        return State;
    }

    public void setState(status state) {
        State = state;
    }

    public int getBattery() {
        return Battery;
    }

    public coordinate getPosition() {
        return Position;
    }

    public void setPosition(coordinate position) {
        Position = position;
    }





    private int ID;
    private status State;
    private int Battery;
    private coordinate Position;

}
