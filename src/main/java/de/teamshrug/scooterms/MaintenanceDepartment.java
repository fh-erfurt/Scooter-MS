package de.teamshrug.scooterms;

import java.util.LinkedList;

/**
 * The class MaintenanceDepartment stores damaged scooters and repair them
 */
public class MaintenanceDepartment
{
    /**
     * The scootercapacity can be set in the cunstructor
     */
    public MaintenanceDepartment(String departmentname, Coordinate location, int scootercapacity) {
        this.location = location;
        this.scootercapacity = scootercapacity;
        this.departmentname = departmentname;
    }

    /**
     * If not scootercapacity is set, the default is 8
     */
    public MaintenanceDepartment(String _departmentname, Coordinate _location) {
        this.location = _location;
        this.departmentname = _departmentname;
    }

    /**
     * repairs a damaged scooter
     * @param _scooter - damaged scooter from a list
     */
    void repairScooter(Scooter _scooter)
    {

    }

    /**
     * Sends the scooter back to the admin
     * @param _scooter - repaired scooter
     */
    void checkOutScooter(Scooter _scooter)
    {

    }

    /**
     * @param scooter Scooter which is sent by the Admin
     * @return Returns true or false, depending on the capacity utilization whether the Scooter can be repaired at the moment or not
     */
    boolean receiveScooter(Scooter scooter)
    {
        if (MaintenanceDepartmentScooterList.size() < scootercapacity)
        {
            MaintenanceDepartmentScooterList.add(scooter);
            scooter.setState(Status.maintenance);
            return true;
        }
        else
            return false;
    }

    public Coordinate getLocation()
    {
        return location;
    }

    public int getScootercapacity()
    {
        return scootercapacity;
    }


    private final String departmentname;
    private final Coordinate location;
    private int scootercapacity = 8;
    private LinkedList<Scooter> MaintenanceDepartmentScooterList = new LinkedList<Scooter>();

}
