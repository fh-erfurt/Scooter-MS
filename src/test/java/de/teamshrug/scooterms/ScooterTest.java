package de.teamshrug.scooterms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ScooterTest
{

    @Test
    public void constructorTest()
    {
        Area TestArea = new Area("TestArea",40.123f,45.321f,50.123f,55.321f);
        Scooter TestScooter1 = new Scooter(Status.ready,TestArea);
        Scooter TestScooter2 = new Scooter(Status.ready,TestArea);
        Scooter TestScooter3 = new Scooter(Status.ready,TestArea);

        assertEquals(1,TestScooter1.getId(),"ID should be 1");
        assertEquals(2,TestScooter2.getId(),"ID should be 2");
        assertEquals(3,TestScooter3.getId(),"ID should be 3");

        assertEquals(100,TestScooter1.getBattery(),"Battery should be 100 after instantiation");

        assertEquals(3,TestScooter1.getNumberofscooters(),"After instantitation of 3 Scooters, the static variable should be 3");


    }

}
