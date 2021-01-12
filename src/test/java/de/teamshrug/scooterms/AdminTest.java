package de.teamshrug.scooterms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedList;

public class AdminTest {

    @Test
    public void printAllScootersTest()
    {

        Area TestArea = new Area("TestArea",50.95f,51.01f, 11.00f,11.06f);
        MaintenanceDepartment MD_Test = new MaintenanceDepartment("MD_Test", new Coordinate(41.2345f,51.2345f),8);


        LinkedList<Scooter> ScooterList = new LinkedList<Scooter>();

        for (int _i = 1 ; _i <= 100 ; _i++ )
        {
            Scooter _scooter = new Scooter(TestArea, MD_Test);
        }
    }
}