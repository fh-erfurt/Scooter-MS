package de.teamshrug.scooterms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class MaintenanceDepartmentTest {


    Area Erfurt = new Area("Erfurt",50.95f,51.01f, 11.00f,11.06f);
    MaintenanceDepartment MD_Erfurt = new MaintenanceDepartment("MD_Erfurt",new Coordinate(50.975f,11.073f),8);

    Scooter TestScooter1 = new Scooter(Erfurt, MD_Erfurt);

    @Test
    public void testReceiveScooter()
    {
        assertTrue(MD_Erfurt.receiveScooter(TestScooter1));
    }

}