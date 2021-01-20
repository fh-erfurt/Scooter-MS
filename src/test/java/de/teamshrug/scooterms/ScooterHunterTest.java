package de.teamshrug.scooterms;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScooterHunterTest {
    /*
    static Area TestArea = new Area("TestArea",50.95f,51.01f, 11.00f,11.06f);
    static MaintenanceDepartment MD_Test = new MaintenanceDepartment("MD_Test", new Coordinate(41.2345f,51.2345f),8);
     */

    static Area Erfurt = new Area("Erfurt",50.95f,51.01f, 11.00f,11.06f);
    static MaintenanceDepartment MD_Erfurt = new MaintenanceDepartment("MD_Erfurt",new Coordinate(50.975f,11.073f),8);

    static ScooterHunter TestScooterHunter = new ScooterHunter("1234");


    @BeforeAll
    static void createTestInstances()
    {
        for (int _i = 1 ; _i <= 10 ; _i++ )
        {
            Scooter _scooter = new Scooter(Erfurt, MD_Erfurt);
        }

        TestScooterHunter.setPosition(new Coordinate(51.003f,11.001f));
    }


    @Test
    public void testReturnScootersLowOnBattery()
    {
        TestScooterHunter.logIn("1234");

        TestScooterHunter.setPosition(new Coordinate(50.975f,11.073f));

        System.out.println("Alle mit wenig Akku");
        TestScooterHunter.printScootersLowOnBattery();
        System.out.println("Jetzt der Naheste mit wenig Akku");
        System.out.println(TestScooterHunter.returnNearestScooterLowOnBattery());
    }
}