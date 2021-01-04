package de.teamshrug.scooterms;

import java.util.LinkedList;
import java.util.Random;


public class Scooter
{

    public Scooter(Area _registeredArea)
    {
        this.state = Status.ready;
        this.registeredarea = _registeredArea;
        this.battery = 100;
        this.id = ++numberofscooters;

        requestLicensePlate();

        //Coordinate position = new Coordinate(1.0f,1.0f);
        this.setPosition(new Coordinate(0,0));
    }

    protected void finalize()
    {
        --numberofscooters;
    }



    void requestLicensePlate()
    {
        if (this.licenseplate == null)
        {
            this.licenseplate = genRandomNumber(100,999) + genChars();
        }
    }

    private int genRandomNumber(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public String genChars(){
        char one   = (char)(Math.random()*26 + 'A');
        char two   = (char)(Math.random()*26 + 'A');
        char three = (char)(Math.random()*26 + 'A');
        return String.valueOf(one) + String.valueOf(two) + String.valueOf(three);
    }


    public Area getRegisteredArea() {
        return registeredarea;
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

    public String getLicensePlate() {
        return licenseplate;
    }

    public void setLicensePlate(String licenseplate) {
        this.licenseplate = licenseplate;
    }

    @Override
    public String toString()
    {
        StringBuilder strBuilder = new StringBuilder("Scooter ");
        strBuilder.append(this.id);
        strBuilder.append(" with Licenseplate ");
        strBuilder.append(this.licenseplate);
        strBuilder.append(" is ");
        strBuilder.append(this.state);
        strBuilder.append(" and has ");
        strBuilder.append(this.battery);
        strBuilder.append("% Battery and ");
        if (registeredarea.isInArea(this.position))
        {
            strBuilder.append("it in his registered Area ");
        }
        else
        {
            strBuilder.append("is NOT in his registered Area ");
        }

        strBuilder.append(this.registeredarea);

        return strBuilder.toString();
    }

    private Area registeredarea;
    private Coordinate position;
    private final int id;
    private Status state;
    private int battery;
    private String licenseplate;
    private static int numberofscooters;



}
