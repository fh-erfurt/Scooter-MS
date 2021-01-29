package de.teamshrug.scooterms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ScooterHotspotTest {

    Area TestArea = new Area("TestArea",50.94f,51.11f, 10.98f,11.04f);
    ScooterHotspot TestScooterHotspot = new ScooterHotspot("TestScooterHotspot", new Coordinate(10f,20f), TestArea, 10);

    @Test
    public void test()
    {
        assertEquals(TestArea, TestScooterHotspot.getRegisteredArea());
    }
}