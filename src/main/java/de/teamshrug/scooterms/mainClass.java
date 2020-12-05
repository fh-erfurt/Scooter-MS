package de.teamshrug.scooterms;

public class mainClass {
    public static void main(String[] args)
    {
        System.out.println("Scooter-MS Start...");


        area Erfurt = new area("Erfurt",50.95f,51.01f, 11.00f,11.06f);

        coordinate PosInArea = new coordinate(50.978966f,11.029587f);
        coordinate PosNotInArea = new coordinate(50.992366f,11.079712f);



        if (Erfurt.isInArea(PosNotInArea))
        {
            System.out.println("In der Area");
        }
        else System.out.println("Nicht in Area");


    }
}
