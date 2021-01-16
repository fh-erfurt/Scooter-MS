package de.teamshrug.scooterms;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ScooterTest
{

    static Area Erfurt = new Area("Erfurt",50.95f,51.01f, 11.00f,11.06f);
    static MaintenanceDepartment MD_Erfurt = new MaintenanceDepartment("MD_Erfurt",new Coordinate(50.975f,11.073f),8);
    Scooter TestScooter1 = new Scooter(Erfurt, MD_Erfurt);
    Scooter TestScooter2 = new Scooter(Erfurt, MD_Erfurt);
    Scooter TestScooter3 = new Scooter(Erfurt, MD_Erfurt);
    Customer TestCustomer = new Customer("Driver1","1234");



    @Test
    public void constructorTest()
    {

        /*
        assertEquals(1,TestScooter1.getId(),"ID should be 1");
        assertEquals(2,TestScooter2.getId(),"ID should be 2");
        assertEquals(3,TestScooter3.getId(),"ID should be 3");
         */

        assertEquals(3,TestScooter1.getNumberofscooters(),"After instantitation of 3 Scooters, the static variable should be 3");

        TestScooter3.finalize();

        assertEquals(2,TestScooter1.getNumberofscooters(),"After removing one Scooter, the static variable should be 2");

        assertEquals("String".getClass(),TestScooter1.getLicensePlate().getClass(), "Licenseplate should be a string");
    }

    @Test
    public void driveTest()
    {
        TestCustomer.setBalance(10.00f);
        TestCustomer.logIn("1234");
        TestCustomer.useScooter(TestScooter1);
        TestCustomer.setPosition(new Coordinate(50.9634f,11.0123f));
        TestCustomer.endDrive();
    }

}
