package de.teamshrug.scooterms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ScooterTest
{

    @Test
    public void constructorTest()
    {
        Area TestArea = new Area("TestArea",40.123f,45.321f,50.123f,55.321f);
        MaintenanceDepartment MD_Test = new MaintenanceDepartment("MD_Test", new Coordinate(41.2345f,51.2345f),8);
        Scooter TestScooter1 = new Scooter(TestArea, MD_Test);
        Scooter TestScooter2 = new Scooter(TestArea, MD_Test);
        Scooter TestScooter3 = new Scooter(TestArea, MD_Test);

        assertEquals(1,TestScooter1.getId(),"ID should be 1");
        assertEquals(2,TestScooter2.getId(),"ID should be 2");
        assertEquals(3,TestScooter3.getId(),"ID should be 3");

        assertEquals(100,TestScooter1.getBattery(),"Battery should be 100 after instantiation");

        assertEquals(3,TestScooter1.getNumberofscooters(),"After instantitation of 3 Scooters, the static variable should be 3");

        TestScooter3.finalize();

        assertEquals(2,TestScooter1.getNumberofscooters(),"After removing one Scooter, the static variable should be 2");

        assertEquals("String".getClass(),TestScooter1.getLicensePlate().getClass(), "Licenseplate should be a string");
    }

}
