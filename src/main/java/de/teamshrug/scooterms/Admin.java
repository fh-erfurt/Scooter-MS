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
         //Scooter.scooterlist.forEach(Scooter -> {
         //    System.out.println(Scooter.getId() + ": "
         //            + "Status: " + Scooter.getState() + " - "
         //            + "Batterie: " + Scooter.getBattery() + " - "
         //            + "in seiner registrierten Area: " + Scooter.getRegisteredArea().isInArea(Scooter.getPosition()) + " - "
         //            + "Kennzeichen: " + Scooter.getLicensePlate());
         //});

         Scooter.scooterlist.forEach(System.out::println);
     }

     MaintenanceDepartment returnLocalMaintenanceDepartmentFromScooter(Scooter _scooter)
     {
        return _scooter.getRegisteredMaintenanceDepartment();
     }

     boolean sendScooterToMaintenance(Scooter _scooter, MaintenanceDepartment _maintenancedepartment)
     {
         return _maintenancedepartment.receiveScooter(_scooter);
     }
}