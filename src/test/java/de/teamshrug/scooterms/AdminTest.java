package de.teamshrug.scooterms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedList;

public class AdminTest {

    @Test
    public void printAllScootersTest()
    {

        Area TestArea = new Area("TestArea",50.95f,51.01f, 11.00f,11.06f);

        LinkedList<Scooter> ScooterList = new LinkedList<Scooter>();

        for (int _i = 1 ; _i <= 100 ; _i++ )
        {
            Scooter _scooter = new Scooter(TestArea);
            ScooterList.add(_scooter);
        }



        ScooterList.get(5).setState(Status.damaged);
        ScooterList.get(19).setState(Status.maintenance);
        ScooterList.get(56).setState(Status.lowonbattery);
        ScooterList.get(87).setState(Status.charging);

        assertEquals(1,ScooterList.get(0).getId());


        ScooterList.forEach(Scooter -> {
            System.out.println(Scooter.getId() +
                    ": " + "Status: " + Scooter.getState() + " - "
                    + "Batterie: " + Scooter.getBattery() + " - "
                    + "in seiner registrierten Area: " + Scooter.getRegisteredArea().isInArea(Scooter.getPosition())
                    + " - " + "Kennzeichen: " + Scooter.getLicensePlate()
            );
        });
    }
}