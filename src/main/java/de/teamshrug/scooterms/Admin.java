package de.teamshrug.scooterms;

import de.teamshrug.scooterms.enums.Status;
import de.teamshrug.scooterms.exceptions.NotLoggedInException;

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
            else
                throw new NotLoggedInException();
        }
        catch (NotLoggedInException ex)
        {
            logger.warning(ex.getMessage());
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
            else
                throw new NotLoggedInException();
        }
        catch (NotLoggedInException ex)
        {
            logger.warning(ex.getMessage());
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

                try
                {
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
                        throw new Exception("There's no Scooter with Status: damaged");
                    }
                    return returnscooter;
                }
                catch(Exception ex)
                {
                    logger.info(ex.getMessage());
                    return null;
                }
            }
            else
                throw new NotLoggedInException();
        }
        catch (NotLoggedInException ex)
        {
            logger.warning(ex.getMessage());
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
                     logger.warning("No Scooter was passed");
                     return false;
                 }
             }
             else
                 throw new NotLoggedInException();
         }
         catch (NotLoggedInException ex)
         {
             logger.warning(ex.getMessage());
             return false;
         }
     }
}