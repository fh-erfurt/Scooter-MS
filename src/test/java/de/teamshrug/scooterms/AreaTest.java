package de.teamshrug.scooterms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



public class AreaTest {

    @Test
    public void isInAreaTest()
    {
        Area TestArea = new Area("TestArea",50.94f,51.11f, 10.98f,11.04f);
        Coordinate TestPositionInArea = new Coordinate(50.978966f,11.029587f);

        assertTrue(TestArea.isInArea(TestPositionInArea), "If ndegree is between ndegree1 and ndegree2 (same for edegree), the scooter is in the area");
    }

}
