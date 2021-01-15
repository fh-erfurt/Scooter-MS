package de.teamshrug.scooterms;

/**
 * Can do what a Customer can do, but is able to see Scooters with low battery and recharge them to top up the account balance
 */
public class ScooterHunter extends Customer
{
    public ScooterHunter(String username, String password)
    {
        super(username, password);
    }

    /**
     * Lets the ScooterHunter see which Scooters urgently need to be recharged
     */
    public void returnScootersLowOnBattery()
    {
        if (getIsLoggedIn())
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
                    System.out.println("ScooterId:"+" "+ scooterid +" "+ "Distance:"+" "+ roundkmdistance + "km"+" "+"Battery is:"+" "+ batterylvl + "%");
                }
            }
        }
        else
            System.out.println("Login failed");
    }
}

