package de.teamshrug.scooterms;

/**
 * Customer is allowed to check the account balance and drive a scotter if account balance is sufficient
 */
public class Customer {

    public Customer(String username, String password) {
        this.username = username;
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
            this.isloggedin = true;
            return true;
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

    public float getCreditedeuros()
    {
        return creditedeuros;
    }

    public void setCreditedeuros(float creditedeuros)
    {
        this.creditedeuros = creditedeuros;
    }

    /**
     * @return gives back the private positon as Coordinate class
     */
    public Coordinate getPosition()
    {
        return position;
    }

    /**
     * @param position applies the position parameter to the private attribute position
     */
    public void setPosition(Coordinate position)
    {
        this.position = position;
    }

    /**
     * Uses Haverine formula for calculating the distance. Distance is not yet used, but is ready to be used
     * @return When logged in, the method returns the scooter, which is geographically closest
     */
    public Scooter returnNearestScooter()
    {
        if (isloggedin)
        {
            double kmdistance = 0;
            int scooterid = 0;

            for (int _i = 0 ; _i < Scooter.scooterlist.size() ; _i++)
            {
                double newdistance;

                if (kmdistance == 0)
                {
                    kmdistance = Haversine.distance(this.position.ndegree, this.position.edegree,
                            Scooter.scooterlist.get(_i).getPosition().ndegree, Scooter.scooterlist.get(_i).getPosition().edegree);
                }

                newdistance = Haversine.distance(this.position.ndegree, this.position.edegree,
                        Scooter.scooterlist.get(_i).getPosition().ndegree, Scooter.scooterlist.get(_i).getPosition().edegree);

                if (newdistance < kmdistance)
                {
                    kmdistance = newdistance;
                    scooterid = Scooter.scooterlist.get(_i).getId();
                }
            }


            return Scooter.scooterlist.get(scooterid);
        }
        else
            return null;
    }

    /**
     * @return Returns boolean value, whether the private isloggedin is set true or false
     */
    public boolean getIsLoggedIn()
    {
        return isloggedin;
    }

    /**
     * Customer can use the scooter (drive) if his balance is sufficient
     * @param _scooter Scooter which is returned by returnNearestScooter
     */
    public void useScooter(Scooter _scooter)
    {
        if (creditedeuros != 0 && isloggedin)
        {
            creditedeuros--;
            _scooter.drive();
        }
    }

    private float creditedeuros;
    private Coordinate position;
    private String username;
    private String password;
    private boolean isloggedin;
}
