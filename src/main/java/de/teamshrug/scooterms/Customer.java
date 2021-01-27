package de.teamshrug.scooterms;

import de.teamshrug.scooterms.enums.Status;
import de.teamshrug.scooterms.exceptions.NotEnoughCreditsException;
import de.teamshrug.scooterms.exceptions.NotLoggedInException;

import java.util.logging.Logger;

/**
 * The class Customer is allowed to check the account balance and drive a scotter if account balance is sufficient
 */
public class Customer {

    public Customer(String password) {
        this.password = password;
        this.creditedeuros = 0;
        this.position = new Coordinate(0,0);
        this.isloggedin = false;
    }

    /**
     * if param password quals the password registered in the customer instance, private attribute loggedin is being set to true
     * @param password plain text password
     */
    void logIn(String password)
    {
        try
        {
            if (this.password.equals(password))
            {
                this.isloggedin = true;
            }
            else
                throw new Exception("Wrong password");
        }
        catch (Exception ex)
        {
            logger.info(ex.getMessage());
        }
    }

    /**
     * If logged in, the private attribute is set to false
     */
    void logOut()
    {
        this.isloggedin = false;
    }

    /**
     * replaces the current password with a new one
     * @param newpassword - new password
     */
    void changePassword(String newpassword)
    {
        Logger logger = Logger.getLogger("Scooter-MS Logger");
        try
        {
            if (getIsLoggedIn())
            {
                this.password = newpassword;
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
     * An attentive Customer is able to report a non-working/damaged Scooter to the system
     * @param scooter The Scooter as param which is damaged/defective
     */
    public void reportScooterDamaged(Scooter scooter)
    {
        Logger logger = Logger.getLogger("Scooter-MS Logger");
        try
        {
            if (getIsLoggedIn())
            {
                scooter.setState(Status.damaged);
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
     * Uses Haverine formula for calculating the distance. Distance is not yet used, but is ready to be used
     * @return When logged in, the method returns the scooter, which is geographically closest
     */
    public Scooter returnNearestScooter()
    {
        Logger logger = Logger.getLogger("Scooter-MS Logger");
        try
        {
            if (getIsLoggedIn())
            {
                double kmdistance = -1;
                Scooter returnscooter = null;


                for (Scooter scooter : Scooter.scooterlist)
                {
                    double newdistance;

                    if (kmdistance == -1)
                    {
                        kmdistance = Haversine.distance(this.getPosition().ndegree, this.getPosition().edegree,
                                scooter.getPosition().ndegree, scooter.getPosition().edegree);
                    }

                    if (returnscooter == null)
                    {
                        returnscooter = scooter;
                    }

                    newdistance = Haversine.distance(this.getPosition().ndegree, this.getPosition().edegree,
                            scooter.getPosition().ndegree, scooter.getPosition().edegree);

                    if (newdistance < kmdistance)
                    {
                        returnscooter = scooter;
                        kmdistance = newdistance;
                    }
                }
                logger.finest("Nearest Scooter is " + kmdistance + " km away");
                return returnscooter;
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
     * Customer can use the scooter (drive) if his balance is sufficient
     * @param scooter Scooter which is returned by returnNearestScooter
     */
    public void useScooter(Scooter scooter)
    {
        Logger logger = Logger.getLogger("Scooter-MS Logger");
        try
        {
            if (isloggedin)
            {
                try
                {
                    if (creditedeuros > 0)
                    {
                        scooter.drive(this);
                        usingScooter = scooter;
                    }
                    else
                        throw new NotEnoughCreditsException();
                }
                catch (NotEnoughCreditsException ex)
                {
                    System.out.println(ex.getMessage());
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
     * Customer can end his journey and park the Scooter
     */
    public void endDrive()
    {
        Logger logger = Logger.getLogger("Scooter-MS Logger");
        try
        {
            usingScooter.park();
            usingScooter = null;
        }
        catch (Exception ex)
        {
            logger.info("Can not park because no Scooter was used to park");
        }
    }

    public float getBalance()
    {
        return creditedeuros;
    }

    public void setBalance(float creditedeuros)
    {
        this.creditedeuros = creditedeuros;
    }

    public Coordinate getPosition()
    {
        return position;
    }

    public void setPosition(Coordinate position)
    {
        this.position = position;
    }

    public boolean getIsLoggedIn()
    {
        return isloggedin;
    }


    protected final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private Scooter usingScooter;
    private float creditedeuros;
    private Coordinate position;
    private String password;
    private boolean isloggedin;
}
