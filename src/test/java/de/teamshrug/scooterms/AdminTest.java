package de.teamshrug.scooterms;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdminTest {

    /*
    static Area TestArea = new Area("TestArea",50.95f,51.01f, 11.00f,11.06f);
    static MaintenanceDepartment MD_Test = new MaintenanceDepartment("MD_Test", new Coordinate(41.2345f,51.2345f),8);
     */
    static Area Erfurt = new Area("Erfurt",50.95f,51.01f, 11.00f,11.06f);
    static MaintenanceDepartment MD_Erfurt = new MaintenanceDepartment("MD_Erfurt",new Coordinate(50.975f,11.073f),8);

    static Admin TestAdmin = new Admin("1234");
    static Customer TestCustomer = new Admin("1234");

    @BeforeAll
    static void CreateInstances()
    {
        for (int _i = 1 ; _i <= 10 ; _i++ )
        {
            Scooter _scooter = new Scooter(Erfurt, MD_Erfurt);

        }

        TestAdmin.setPosition(new Coordinate(51.004f,11.002f));

        TestCustomer.reportScooterDamaged(Scooter.scooterlist.get(0));
        TestCustomer.reportScooterDamaged(Scooter.scooterlist.get(1));
    }


    @Test
    public void shouldPrintAllScooters()
    {
        TestAdmin.logIn("1234");

        TestAdmin.printAllScooters();
    }

    @Test
    public void shouldPrintNearestScooter()
    {
        TestAdmin.logIn("1234");

        System.out.println(TestAdmin.returnNearestScooter());
    }

    @Test
    public void shouldPrintDamagedScooters()
    {
        TestAdmin.logIn("1234");

        TestAdmin.printScootersReportedAsDamaged();
    }

    @Test
    public void shouldSendScooterToMD()
    {
        TestAdmin.logIn("1234");

        TestAdmin.sendScooterToLocalMaintenanceDepartment(TestAdmin.returnDamagedScooter());
        MD_Erfurt.repairScooter();
    }
}