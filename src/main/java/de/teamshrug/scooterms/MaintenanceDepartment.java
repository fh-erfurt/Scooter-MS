package de.teamshrug.scooterms;

import org.sonatype.guice.bean.containers.Main;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * The class MaintenanceDepartment stores damaged scooters and repairs them
 */
public class MaintenanceDepartment
{
    /**
     * The scootercapacity can be set in the constructor
     */
    public MaintenanceDepartment(String departmentname, Coordinate location, int scootercapacity) {
        this.location = location;
        this.scootercapacity = scootercapacity;
        this.departmentname = departmentname;
    }

    /**
     * If no scootercapacity is set, the default is 8
     */
    public MaintenanceDepartment(String _departmentname, Coordinate _location) {
        this.location = _location;
        this.departmentname = _departmentname;
    }

    /**
     * Uses toString method from Scooter to print Scooters in the MD
     */
    public void printAllScootersInMd()
    {
        try
        {
            for (Scooter scooter : maintenancedepartmentscooterlist)
            {
                System.out.println(scooter);
            }
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }
    }

    /**
     * Repairs the first Scooter in the queue
     */
    void repairScooter()
    {
        try
        {
            Scooter scooter = maintenancedepartmentscooterlist.getFirst();
            scooter.setBattery(100);
            System.out.println("Repaired Scooter will be checked out now...");
            checkOutScooter(scooter);
        }
        catch (NoSuchElementException ex)
        {
            System.out.println("Es gibt keinen Scooter der repariert werden muss.");
        }

    }

    /**
     * Sends the scooter back to the admin
     * @param scooter - repaired scooter
     */
    void checkOutScooter(Scooter scooter)
    {
        scooter.setState(Status.ready);
        maintenancedepartmentscooterlist.remove(scooter);
        System.out.println("...checked out Scooter");
    }

    /**
     * @param scooter Scooter which is sent by the Admin
     * @return Returns true or false, depending on the capacity utilization whether the Scooter can be repaired at the moment or not
     */
    boolean receiveScooter(Scooter scooter)
    {
        if (maintenancedepartmentscooterlist.size() < scootercapacity)
        {
            maintenancedepartmentscooterlist.add(scooter);
            scooter.setState(Status.maintenance);
            scooter.setPosition(this.location);
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
    private LinkedList<Scooter> maintenancedepartmentscooterlist = new LinkedList<Scooter>();

}
