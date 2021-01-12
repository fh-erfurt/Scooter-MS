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

        float nmin = Erfurt.getNdegree1();
        float nmax = Erfurt.getNdegree2();
        float emin = Erfurt.getEdegree1();
        float emax = Erfurt.getEdegree2();

        for (int _i = 0 ; _i < Scooter.scooterlist.size() ; _i++)
        {
            float rndegree = (float)Math.random() * (nmax - nmin ) + nmin;
            float redegree = (float)Math.random() * (emax - emin ) + emin;

            Scooter.scooterlist.get(_i).setPosition(new Coordinate(rndegree,redegree));
        }



    }
}
