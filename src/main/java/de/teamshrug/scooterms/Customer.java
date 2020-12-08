package de.teamshrug.scooterms;

public class Customer {

    public Customer(String username, String password) {
        this.username = username;
        this.password = password;
        this.creditedeuros = 0;
        this.position = new Coordinate(0,0);
    }

    public float getCreditedeuros() {
        return creditedeuros;
    }

    public void setCreditedeuros(float creditedeuros) {
        this.creditedeuros = creditedeuros;
    }

    public Coordinate getPosition() {
        return position;
    }

    public void setPosition(Coordinate position) {
        this.position = position;
    }

    public void useNearestScooter()
    {
        creditedeuros--;
    }

    private float creditedeuros;
    private Coordinate position;
    private String username;
    private String password;
}
