package de.teamshrug.scooterms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class CoordinateTest
{
    Coordinate TestCoordinate = new Coordinate(10f,20f);

    @Test
    public void testCoordinate()
    {
        assertEquals(10,TestCoordinate.ndegree);
        assertEquals(20,TestCoordinate.edegree);
    }
}
