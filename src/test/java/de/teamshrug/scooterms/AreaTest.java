package de.teamshrug.scooterms;

//import org.junit.jupiter.api.Assertions;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;



public class AreaTest {

    private boolean isinarea = true;

    @Test
    public void isInAreaTest()
    {
        Area TestArea = new Area("TestArea",50.94f,51.11f, 10.98f,11.04f);
        Coordinate TestPositionInArea = new Coordinate(50.978966f,11.029587f);

        Assert.assertEquals(isinarea, TestArea.isInArea(TestPositionInArea));
        //Assertions.assertEquals(isinarea,TestArea.isInArea(TestPositionInArea));
    }
}
