package de.teamshrug.scooterms;

public class ScooterHunter extends Customer
{
    public ScooterHunter(String username, String password)
    {
        super(username, password);
    }

    public void returnAllScooterLowonbattery()
    {
        if (isloggedin)
        {

            for (int _i = 0 ; _i < Scooter.scooterlist.size() ; _i++)
            {
                int batterylvl = Scooter.scooterlist.get(_i).getBattery();
                double kmdistance = 0;
                int scooterid = 0;
                if (batterylvl <= 20)
                {
                    kmdistance = Haversine.distance(this.getPosition().ndegree, this.getPosition().edegree,
                            Scooter.scooterlist.get(_i).getPosition().ndegree, Scooter.scooterlist.get(_i).getPosition().edegree);
                    scooterid = Scooter.scooterlist.get(_i).getId();
                    double roundkmdistance = Math.round(kmdistance * 100.0) / 100.0; // round kmdistance to 2 decimal places
                    System.out.println("ScooterId:"+" "+ scooterid +" "+ "Distance:"+" "+ roundkmdistance + "km"+" "+"Battery is on:"+" "+ batterylvl + "%");

                }
            }

        }
        else
            System.out.println("Login faild");
    }
}

