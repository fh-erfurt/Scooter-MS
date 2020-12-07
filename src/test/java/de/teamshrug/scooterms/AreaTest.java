package de.teamshrug.scooterms;

import de.teamshrug.scooterms.Area;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;
//import junit.framework.Test;


public class AreaTest {

    private final boolean isinarea = true;



    @Test
    public void isInAreaTest()
    {


        Area TestArea = new Area("TestArea",50.94f,51.11f, 10.98f,11.04f);
        Coordinate TestPositionInArea = new Coordinate(50.978966f,11.029587f);


        Assert.assertEquals(isinarea, TestArea.isInArea(TestPositionInArea));

    }

}
