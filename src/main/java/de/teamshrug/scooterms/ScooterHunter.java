package de.teamshrug.scooterms;

/**
 * Can do what a Customer can do, but is able to see Scooters with low battery and recharge them to top up the account balance
 */
public class ScooterHunter extends Customer
{
    public ScooterHunter(String password)
    {
        super(password);
        this.lowbattery = 20;
    }

    /**
     * Lets the ScooterHunter see which Scooters urgently need to be recharged
     */
    public void printScootersLowOnBattery()
    {
        if (getIsLoggedIn())
        {
            for (Scooter scooter : Scooter.scooterlist)
            {
                if (scooter.getBattery() <= lowbattery)
                {
                    System.out.println(scooter);
                }
            }
        }
    }


    public Scooter returnNearestScooterLowOnBattery()
    {
        if (getIsLoggedIn())
        {
            double kmdistance = -1;
            Scooter returnscooter = null;

            for (Scooter scooter : Scooter.scooterlist)
            {
                if (scooter.getBattery() <= lowbattery)
                {
                    double newdistance;

                    if (kmdistance == -1)
                    {
                        kmdistance = Haversine.distance(this.getPosition().ndegree, this.getPosition().edegree,
                                scooter.getPosition().ndegree, scooter.getPosition().edegree);
                    }

                    if (returnscooter == null)
                    {
                        returnscooter = scooter;
                    }

                    newdistance = Haversine.distance(this.getPosition().ndegree, this.getPosition().edegree,
                            scooter.getPosition().ndegree, scooter.getPosition().edegree);

                    if (newdistance < kmdistance)
                    {
                        returnscooter = scooter;
                        kmdistance = newdistance;
                    }
                }
            }
            return returnscooter;

        }
        else
            return null;
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

    private final int lowbattery;
}