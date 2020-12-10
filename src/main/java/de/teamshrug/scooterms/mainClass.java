package de.teamshrug.scooterms;

public class mainClass {
    public static void main(String[] args)
    {
        System.out.println("Scooter-MS Start...");









        Area Erfurt = new Area("Erfurt",50.95f,51.01f, 11.00f,11.06f);

        Coordinate PosInArea = new Coordinate(50.978966f,11.029587f);
        Coordinate PosNotInArea = new Coordinate(50.992366f,11.079712f);



        if (Erfurt.isInArea(PosNotInArea))
        {
            System.out.println("In der Area");
        }
        else
        {
            System.out.println("Nicht in Area");
        }



        System.out.println(Erfurt.getAreaInfo());




    }
}
