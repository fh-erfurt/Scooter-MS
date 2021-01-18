package de.teamshrug.scooterms;

/**
 * Can do what a Customer can do, but is able to see Scooters with low battery and recharge them to top up the account balance
 */
public class ScooterHunter extends Customer
{
    public ScooterHunter(String password)
    {
        super(password);
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
                    kmdistance = Haversine.distance(getPosition().ndegree, getPosition().edegree,
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

    /**
     * @param battery Gets the percentage of battery of the scooter which is going to be charged
     * @return Returns the earned credits for charging
     */
    public float calcBalanceForCharging(int battery)
    {
        int maxBattery = 100;
        float chargingCredits = 0.05f;

        int usedPowerForCharging = maxBattery - battery;

        return usedPowerForCharging * chargingCredits;
    }

    /**
     * Uses the return of calcBalanceForCharging to add the credits to the balance and fully recharges the scooter
     * @param scooter Scooter from a list of scooters which are going to be charged by the ScooterHunter
     */
    public void chargeScooter(Scooter scooter)
    {
        scooter.setState(Status.charging);
        float actualBalance = getBalance();
        float balanceForCharging = calcBalanceForCharging(scooter.getBattery());
        setBalance(actualBalance+balanceForCharging);
        scooter.setBattery(100);
    }
}


