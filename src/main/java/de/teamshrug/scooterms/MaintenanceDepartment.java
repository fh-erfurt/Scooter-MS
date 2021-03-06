package de.teamshrug.scooterms;

import de.teamshrug.scooterms.enums.Status;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.logging.Logger;

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
    public MaintenanceDepartment(String departmentname, Coordinate location) {
        this.location = location;
        this.departmentname = departmentname;
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
            logger.warning(ex.getMessage());
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
            System.out.println("There's no Scooter which has to be repaired.");
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

    private final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private final String departmentname;
    private final Coordinate location;
    private int scootercapacity = 8;
    private LinkedList<Scooter> maintenancedepartmentscooterlist = new LinkedList<Scooter>();
}
