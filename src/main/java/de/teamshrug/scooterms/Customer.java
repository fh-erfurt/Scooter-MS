package de.teamshrug.scooterms;

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
     * @return true for the matching password, false for the wrong one
     */
    boolean logIn(String password)
    {
        if (this.password.equals(password))
        {
            try
            {
                this.isloggedin = true;
                return true;
            }
            catch (Exception ex)
            {
                System.out.println(ex);
                return false;
            }
        }
        else
        {
            return false;
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
        try
        {
            if (this.getIsLoggedIn())
            {
                this.password = newpassword;
            }
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }
    }

    /**
     * An attentive Customer is able to report a non-working/damaged Scooter to the system
     * @param scooter The Scooter as param which is damaged/defective
     */
    public void reportScooterDamaged(Scooter scooter)
    {
        scooter.setState(Status.damaged);
    }

    /**
     * Uses Haverine formula for calculating the distance. Distance is not yet used, but is ready to be used
     * @return When logged in, the method returns the scooter, which is geographically closest
     */
    public Scooter returnNearestScooter()
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
            return returnscooter;
        }
        else
            return null;
    }

    /**
     * Customer can use the scooter (drive) if his balance is sufficient
     * @param scooter Scooter which is returned by returnNearestScooter
     */
    public void useScooter(Scooter scooter)
    {
        if (creditedeuros > 0 && isloggedin)
        {
            scooter.drive(this);
            usingScooter = scooter;
        }
    }

    /**
     * Customer can end his journey and park the scooter
     */
    public void endDrive()
    {
        usingScooter.park();
        usingScooter = null;
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


    private Scooter usingScooter;
    private float creditedeuros;
    private Coordinate position;
    private String password;
    private boolean isloggedin;
}
