package de.teamshrug.scooterms;

public class MaintenanceDepartment
{
    public MaintenanceDepartment(String _departmentname, Coordinate _location, int _scootercapacity) {
        this.location = _location;
        this.scootercapacity = _scootercapacity;
        this.departmentname = _departmentname;
    }

    public MaintenanceDepartment(String _departmentname, Coordinate _location) {
        this.location = _location;
        this.departmentname = _departmentname;
    }



    public Coordinate getLocation() {
        return location;
    }

    public int getScootercapacity() {
        return scootercapacity;
    }

    public Scooter[] getScooterarray() {
        return scooterarray;
    }

    void repairScooter(Scooter _scooter)
    {

    }

    void checkOutScooter(Scooter _scooter)
    {

    }

    private final String departmentname;
    private final Coordinate location;
    private int scootercapacity = 8;
    private Scooter scooterarray [] = new Scooter[scootercapacity];

}
