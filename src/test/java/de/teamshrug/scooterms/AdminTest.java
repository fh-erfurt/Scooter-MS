package de.teamshrug.scooterms;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdminTest {

    static Area TestArea = new Area("TestArea",50.95f,51.01f, 11.00f,11.06f);
    static MaintenanceDepartment MD_Test = new MaintenanceDepartment("MD_Test", new Coordinate(41.2345f,51.2345f),8);

    static Admin TestAdmin = new Admin("Admin1","1234");

    @BeforeAll
    static void createTestInstances()
    {
        for (int _i = 1 ; _i <= 100 ; _i++ )
        {
            Scooter _scooter = new Scooter(TestArea, MD_Test);
        }

        float nmin = TestArea.getNdegree1();
        float nmax = TestArea.getNdegree2();
        float emin = TestArea.getEdegree1();
        float emax = TestArea.getEdegree2();

        for (int _i = 0 ; _i < Scooter.scooterlist.size() ; _i++)
        {
            float rndegree = (float)Math.random() * (nmax - nmin ) + nmin;
            float redegree = (float)Math.random() * (emax - emin ) + emin;

            Scooter.scooterlist.get(_i).setPosition(new Coordinate(rndegree,redegree));
        }
    }

    @Test
    public void printAllScootersTest()
    {
        TestAdmin.logIn("1234");

        assertEquals(MD_Test,TestAdmin.returnLocalMaintenanceDepartmentFromScooter(Scooter.scooterlist.get(1)));
        TestAdmin.printAllScooters();
    }

    @Test
    public void returnNearestScooterTest()
    {
        TestAdmin.logIn("1234");
        System.out.println(TestAdmin.returnNearestScooter());
    }
}