package de.teamshrug.scooterms;

import java.util.LinkedList;

public class Admin extends Customer
{
    public Admin(String username, String password) {
        super(username, password);
    }


     void printAllScooters(LinkedList<Scooter> _scooterlist)
     {
         _scooterlist.forEach(Scooter -> {
             System.out.println(Scooter.getId() + ": "
                     + "Status: " + Scooter.getState() + " - "
                     + "Batterie: " + Scooter.getBattery() + " - "
                     + "in seiner registrierten Area: " + Scooter.getRegisteredArea().isInArea(Scooter.getPosition()) + " - "
                     + "Kennzeichen: " + Scooter.getLicensePlate()
             );
         });
     }

     /*MaintenanceDepartment*/void returnLocalMaintenanceDepartment(Scooter _scooter)
     {

     }

     boolean sendScooterToMaintenance(Scooter _scooter, MaintenanceDepartment _maintenancedepartment)
     {
        return true; //!
     }


}
