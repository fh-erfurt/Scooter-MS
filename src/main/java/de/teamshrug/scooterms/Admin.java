package de.teamshrug.scooterms;

import java.util.LinkedList;
import java.util.logging.*;

/**
 * Can do what a Customer can do, but is able to see information about all Scooter and sending them to the local repair facility
 */
public class Admin extends Customer
{
    public Admin(String password)
    {
        super(password);
    }

    /**
     * Uses toStrin method from Scooter to deliver useful information
     */
    public void printAllScooters()
    {
        if (getIsLoggedIn())
        {
            for (Scooter scooter : Scooter.scooterlist)
            {
                System.out.println(scooter);
            }
        }
    }

    /**
     * Uses toStrin method from Scooter to deliver information about non-working Scooters
     */
    public void printScootersReportedAsDamaged()
    {
        if (getIsLoggedIn())
        {
            for (Scooter scooter : Scooter.scooterlist)
            {
                if (scooter.getState().equals(Status.damaged))
                {
                    System.out.println(scooter);
                }
            }
        }
    }




    /**
     * @param scooter Scooter which is damaged/defective
     * @return If Admin is logged in and MaintenanceDepartment has capacity, true should be returned
     */
     public boolean sendScooterToLocalMaintenanceDepartment(Scooter scooter)
     {
         if (getIsLoggedIn())
         {
             return scooter.getRegisteredMaintenanceDepartment().receiveScooter(scooter);
         }
         else
             return false;
     }
}