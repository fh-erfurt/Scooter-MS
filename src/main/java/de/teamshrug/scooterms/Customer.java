package de.teamshrug.scooterms;

public class Customer {

    public Customer(String username, String password) {
        this.username = username;
        this.password = password;
        this.creditedeuros = 0;
        this.position = new Coordinate(0,0);
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

    public /*Scooter*/ void returnNearestScooter()
    {

    }

    public void useScooter(Scooter _scooter)
    {
        if (creditedeuros != 0)
        {
            creditedeuros--;
            _scooter.drive();
        }
    }

    private float creditedeuros;
    private Coordinate position;
    private String username;
    private String password;
}
