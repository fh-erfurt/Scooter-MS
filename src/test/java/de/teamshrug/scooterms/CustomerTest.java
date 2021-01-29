package de.teamshrug.scooterms;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class CustomerTest {

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

        TestCustomer.setPosition(new Coordinate(50.964363f,11.02324f));
    }

    @Test
    public void shouldChangePassword()
    {
        TestCustomer.logIn("1234");
        TestCustomer.changePassword("12345");
        TestCustomer.changePassword("1234");
        TestCustomer.logOut();
    }

    @Test
    public void testReturnNearestScooter()
    {
        TestCustomer.logIn("1234");
        System.out.println(TestCustomer.returnNearestScooter());
        TestCustomer.logOut();
    }

    @Test
    public void testUseScooter()
    {
        TestCustomer.logIn("1234");

        TestCustomer.setBalance(10.00f);
        assertEquals(10,TestCustomer.getBalance());
        TestCustomer.useScooter(TestCustomer.returnNearestScooter());
        TestCustomer.endDrive();
        assertNotEquals(10,TestCustomer.getBalance());
        System.out.println(TestCustomer.getBalance());

        TestCustomer.logOut();
    }
}