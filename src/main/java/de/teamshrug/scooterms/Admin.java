package de.teamshrug.scooterms;

import java.util.LinkedList;

public class Admin extends Customer
{
    public Admin(String username, String password)
    {
        super(username, password);
    }


     void printAllScooters()
     {
         if (isloggedin)
         {
             Scooter.scooterlist.forEach(System.out::println);
         }
     }

     public MaintenanceDepartment returnLocalMaintenanceDepartmentFromScooter(Scooter _scooter)
     {
         if (isloggedin)
         {
             return _scooter.getRegisteredMaintenanceDepartment();
         }
         else
             return null;
     }

     boolean sendScooterToMaintenance(Scooter _scooter, MaintenanceDepartment _maintenancedepartment)
     {
         if (isloggedin)
         {
             return _maintenancedepartment.receiveScooter(_scooter);
         }
         else
             return false;
     }
}