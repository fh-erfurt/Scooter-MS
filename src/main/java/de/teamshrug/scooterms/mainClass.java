package de.teamshrug.scooterms;

import java.util.LinkedList;

public class mainClass {
    public static void main(String[] args)
    {
        System.out.println("Scooter-MS Start...");


        Area Erfurt = new Area("Erfurt",50.95f,51.01f, 11.00f,11.06f);
        MaintenanceDepartment MD_Erfurt = new MaintenanceDepartment("MD_Erfurt",new Coordinate(50.975f,11.073f),8);

        Admin Admin1 = new Admin("Admin1","1234");


        for (int _i = 1 ; _i <= 100 ; _i++ )
        {
            Scooter _scooter = new Scooter(Erfurt, MD_Erfurt);
        }


        Admin1.printAllScooters();
/*
        LinkedList<Scooter> ScooterList = new LinkedList<Scooter>();

        for (int _i = 1 ; _i <= 100 ; _i++ )
        {
            Scooter _scooter = new Scooter(Erfurt, MD_Erfurt);
            ScooterList.add(_scooter);
        }

        ScooterList.get(5).setState(Status.damaged);
        ScooterList.get(19).setState(Status.maintenance);
        ScooterList.get(56).setState(Status.lowonbattery);
        ScooterList.get(87).setState(Status.charging);


        ScooterList.forEach(Scooter -> {
            System.out.println(Scooter.getId() +
                    ": " + "Status: " + Scooter.getState() + " - "
                    + "Batterie: " + Scooter.getBattery() + " - "
                    + "in seiner registrierten Area: " + Scooter.getRegisteredArea().isInArea(Scooter.getPosition())
                    + " - " + "Kennzeichen: " + Scooter.getLicensePlate()
            );

        });



        for (Scooter scooter : ScooterList) {
            System.out.println(scooter);
        }
        */

    }
}
