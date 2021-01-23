package de.teamshrug.scooterms;

/**
 * Can do what a Customer can do, but is able to see Scooters with low battery and recharge them to top up the account balance
 */
public class ScooterHunter extends Customer
{
    public ScooterHunter(String password, Area area)
    {
        super(password);
        this.activeinarea = area;
    }

    /**
     * @return Returns most-empty ScooterHotspot in the area where the ScooterHunter is
     */
    public ScooterHotspot returnMostEmptyScooterHotspot()
    {
        ScooterHotspot returnscooterhotspot = null;
        int returnscooterhotspotusage = -1;

        if (getIsLoggedIn())
        {

            for (ScooterHotspot hotspot : ScooterHotspot.scooterhotspotlist)
            {
                if (hotspot.getRegisteredArea() == getActiveInArea())
                {
                    if (hotspot.getScootercount() < hotspot.getMaxscootercount())
                    {
                        if (returnscooterhotspot == null)
                        {
                            returnscooterhotspot = hotspot;
                            returnscooterhotspotusage = hotspot.getScootercount();
                        }

                        if (hotspot.getScootercount() < returnscooterhotspotusage)
                        {
                            returnscooterhotspot = hotspot;
                            returnscooterhotspotusage = hotspot.getScootercount();
                        }
                    }
                }
            }
            return returnscooterhotspot;
        }
        else
            return null;
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
                if (scooter.getBattery() <= Scooter.getLowbattery())
                {
                    System.out.println(scooter);
                }
            }
        }
    }

    /**
     * @return Returns nearest Scooter with a Battery percentage (or below) the "lowbattery" attribute.
     */
    public Scooter returnNearestScooterLowOnBattery()
    {
        if (getIsLoggedIn())
        {
            double kmdistance = -1;
            Scooter returnscooter = null;

            for (Scooter scooter : Scooter.scooterlist)
            {
                if (scooter.getBattery() <= Scooter.getLowbattery())
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
        if (scooter != null)
        {
            scooter.setState(Status.charging);
            float actualBalance = getBalance();
            float balanceForCharging = calcBalanceForCharging(scooter.getBattery());
            setBalance(actualBalance+balanceForCharging);
            scooter.setBattery(100);
        }
    }

    /**
     * Returns a charged Scooter to a ScooterHotspot
     * @param scooter Scooter from a list of scooters which are charged by the ScooterHunter and will be returned to a ScooterHotspot
     */
    public void bringBackScooterToHotspot(Scooter scooter, ScooterHotspot scooterHotspot)
    {
        int actualScooter = scooterHotspot.getScootercount();
        int newHotspotcount = (scooterHotspot.getScootercount() + 1);

        if (actualScooter < scooterHotspot.getMaxscootercount())
        {
            scooter.setState(Status.ready);
            scooterHotspot.setScootercount(newHotspotcount);
            scooter.setPosition(scooterHotspot.getLocation());
        }
        else {
            System.out.println("The Hotspot is already full, please go to another one");
        }
    }


    public Area getActiveInArea()
    {
        return activeinarea;
    }

    public void setActiveInArea(Area activeinarea)
    {
        this.activeinarea = activeinarea;
    }

    /*
        public static int getLowbattery()
        {
            return lowbattery;
        }


        public static void setLowbattery(int lowbattery)
        {
            ScooterHunter.lowbattery = lowbattery;
        }


        static private int lowbattery = 0;

     */
    private Area activeinarea;
}