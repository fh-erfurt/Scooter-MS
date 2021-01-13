package de.teamshrug.scooterms;

public class Customer {

    public Customer(String username, String password) {
        this.username = username;
        this.password = password;
        this.creditedeuros = 0;
        this.position = new Coordinate(0,0);
        this.isloggedin = false;
    }

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

    public Coordinate getPosition()
    {
        return position;
    }

    public void setPosition(Coordinate position)
    {
        this.position = position;

    }

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

    public boolean getIsLoggedIn()
    {
        return isloggedin;
    }

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
