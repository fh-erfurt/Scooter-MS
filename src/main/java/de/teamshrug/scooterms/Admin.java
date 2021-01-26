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
     * Uses toString method from Scooter to deliver useful information
     */
    public void printAllScooters()
    {
        try
        {
            if (getIsLoggedIn())
            {
                for (Scooter scooter : Scooter.scooterlist)
                {
                    System.out.println(scooter);
                }
            }
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }
    }

    /**
     * Uses toString method from Scooter to deliver information about non-working Scooters
     */
    public void printScootersReportedAsDamaged()
    {
        try
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
        catch (Exception ex)
        {
            System.out.println(ex);
        }
    }

    /**
     * @return Returns the first damaged Scooter from the scooterlist
     */
    public Scooter returnDamagedScooter()
    {
        try
        {
            if (getIsLoggedIn())
            {
                Scooter returnscooter = null;
                for (Scooter scooter : Scooter.scooterlist)
                {
                    if (scooter.getState().equals(Status.damaged))
                    {
                        returnscooter = scooter;
                        break;
                    }
                }
                if (returnscooter == null)
                {
                    throw new Exception("Es gibt keinen Scooter mit Status: damaged");
                }
                else
                    return returnscooter;
            }
            else
                return null;
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    /**
     * @param scooter Scooter which is damaged/defective
     * @return If Admin is logged in and MaintenanceDepartment has capacity, true should be returned
     */
     public boolean sendScooterToLocalMaintenanceDepartment(Scooter scooter)
     {
         try
         {
             if (getIsLoggedIn())
             {
                 try
                 {
                     return scooter.getRegisteredMaintenanceDepartment().receiveScooter(scooter);
                 }
                 catch (NullPointerException exception)
                 {
                     System.out.println("Kein Scooter übergeben");
                     return false;
                 }
             }
             else
                 throw new Exception("Not logged in");
         }
         catch (Exception ex)
         {
             System.out.println(ex.getMessage());
             return false;
         }
     }
}