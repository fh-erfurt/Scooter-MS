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
         if (getIsLoggedIn())
         {
             Scooter.scooterlist.forEach(System.out::println);
         }
     }

     public MaintenanceDepartment returnLocalMaintenanceDepartmentFromScooter(Scooter _scooter)
     {
         if (getIsLoggedIn())
         {
             return _scooter.getRegisteredMaintenanceDepartment();
         }
         else
             return null;
     }

     boolean sendScooterToMaintenance(Scooter _scooter, MaintenanceDepartment _maintenancedepartment)
     {
         if (getIsLoggedIn())
         {
             return _maintenancedepartment.receiveScooter(_scooter);
         }
         else
             return false;
     }
}