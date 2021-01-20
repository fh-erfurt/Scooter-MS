package de.teamshrug.scooterms;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    /*
    static Area TestArea = new Area("TestArea",50.95f,51.01f, 11.00f,11.06f);
    static MaintenanceDepartment MD_Test = new MaintenanceDepartment("MD_Test", new Coordinate(41.2345f,51.2345f),8);
     */
    static Area Erfurt = new Area("Erfurt",50.95f,51.01f, 11.00f,11.06f);
    static MaintenanceDepartment MD_Erfurt = new MaintenanceDepartment("MD_Erfurt",new Coordinate(50.975f,11.073f),8);

    static Customer TestCustomer = new Customer("1234");

    @BeforeAll
    static void createTestInstances()
    {
        for (int _i = 1 ; _i <= 10 ; _i++ )
        {
            Scooter scooter = new Scooter(Erfurt, MD_Erfurt);
        }
    }

    @Test
    public void testReturnNearestScooter()
    {
        TestCustomer.logIn("1234");
        TestCustomer.changePassword("12345");
        System.out.println(TestCustomer.returnNearestScooter());
        TestCustomer.logOut();
    }

}