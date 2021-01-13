package de.teamshrug.scooterms;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScooterHunterTest {

    static Area TestArea = new Area("TestArea",50.95f,51.01f, 11.00f,11.06f);
    static MaintenanceDepartment MD_Test = new MaintenanceDepartment("MD_Test", new Coordinate(41.2345f,51.2345f),8);

    static ScooterHunter ScooterHunter1 = new ScooterHunter("ScooterHunter1","1234");


    @BeforeAll
    static void createTestInstances()
    {
        for (int _i = 1 ; _i <= 100 ; _i++ )
        {
            Scooter _scooter = new Scooter(TestArea, MD_Test);
        }
    }


    @Test
    public void printAllScootersTest()
    {
        ScooterHunter1.logIn("1234");
        ScooterHunter1.setPosition(new Coordinate(50.975f,11.073f));
        ScooterHunter1.returnScootersLowOnBattery();
    }
}