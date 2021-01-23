package de.teamshrug.scooterms;

import java.util.Random;
import java.util.LinkedList;


public class Scooter
{

    public Scooter(Area _registeredArea, MaintenanceDepartment _registeredmaintenancedepartment)
    {
        this.registeredmaintenancedepartment = _registeredmaintenancedepartment;
        this.state = Status.ready;
        this.registeredarea = _registeredArea;
        this.battery = genRandomNumber(1,100);
        this.id = ++numberofscooters;
        scooterlist.add(this);

        requestLicensePlate();

        float nmin = registeredarea.getNdegree1();
        float nmax = registeredarea.getNdegree2();
        float emin = registeredarea.getEdegree1();
        float emax = registeredarea.getEdegree2();

        float rndegree = (float)Math.random() * (nmax - nmin ) + nmin;
        float redegree = (float)Math.random() * (emax - emin ) + emin;

        this.setPosition(new Coordinate(rndegree,redegree));
    }


    protected void finalize()
    {
        --numberofscooters;
        scooterlist.remove(this);
    }



    // creates licenseplate with pattern like '263ZDE'
    void requestLicensePlate()
    {
        if (this.licenseplate == null)
        {
            this.licenseplate = genRandomNumber(100,999) + genChars();
        }
    }

    private int genRandomNumber(int min, int max)
    {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public String genChars()
    {
        char one   = (char)(Math.random()*26 + 'A');
        char two   = (char)(Math.random()*26 + 'A');
        char three = (char)(Math.random()*26 + 'A');
        return String.valueOf(one) + String.valueOf(two) + String.valueOf(three);
    }


    public Area getRegisteredArea()
    {
        return registeredarea;
    }

    public void setRegisteredArea(Area _registeredArea)
    {
        this.registeredarea = _registeredArea;
    }

    public void drive(Customer driver)
    {
        setState(Status.inuse);
        inUseByDriver = driver;
    }

    /**
     * Calculates the driven distance and deducts the costs from the user and reduces the battery charge (each KM started 1€)
     * If the battery drops under 20% when the scooter is parked, it state changes to lowonbattery and a scooterhunter is able to pick it up for recharging
     */
    public void park()
    {
        float ndestination = inUseByDriver.getPosition().ndegree;
        float edestination = inUseByDriver.getPosition().edegree;
        float startBalance = inUseByDriver.getBalance();

        float kmdriven = (float)Haversine.distance(position.ndegree,position.edegree,ndestination,edestination);

        float roundkmdistance = (float)(Math.round(kmdriven * 100.0) / 100.0);      // like this 4.11  rounds kmdriven to 2 decimal places
        int meterdistance = (int)(kmdriven*1000);                                   // like this 4109

        if (battery >= 20)
        {
            setState(Status.ready);
        }
        else
        {
            setState(Status.lowonbattery);
        }

        this.position = inUseByDriver.getPosition();                    // applies Customers position when scooter is parked
        this.battery = this.battery - (int)(meterdistance*0.002);
        inUseByDriver.setBalance(startBalance - roundkmdistance);
        inUseByDriver = null;
    }

    public int getId()
    {
        return id;
    }

    public Status getState()
    {
        return state;
    }

    public void setState(Status _state)
    {
        this.state = _state;
    }

    public int getBattery()
    {
        return battery;
    }

    public void setBattery(int battery)
    {
        this.battery = battery;
    }

    public Coordinate getPosition()
    {
        return position;
    }

    public void setPosition(Coordinate position)
    {
        this.position = position;
    }

    public static int getNumberofscooters()
    {
        return numberofscooters;
    }

    public String getLicensePlate()
    {
        return licenseplate;
    }

    public void setLicensePlate(String licenseplate)
    {
        this.licenseplate = licenseplate;
    }

    /**
     * @return Gets the private lowbattery attribute
     */
    public static int getLowbattery()
    {
        return lowbattery;
    }

    /**
     * @param lowbattery Sets lowbattery attribute
     */
    public static void setLowbattery(int newlowbattery)
    {
        lowbattery = newlowbattery;
    }

    /**
     * @return toString method to show important information about the Scooters instead of the internal IDs
     */
    @Override
    public String toString()
    {
        StringBuilder strBuilder = new StringBuilder("Scooter ");
        strBuilder.append(this.id);
        strBuilder.append(" with Licenseplate ");
        strBuilder.append(this.licenseplate);
        strBuilder.append(" is ");
        strBuilder.append(this.state);
        strBuilder.append(" and has ");
        strBuilder.append(this.battery);
        strBuilder.append("% Battery and ");

        if (isInRegisteredArea())
        {
            strBuilder.append("is in his registered Area ");
        }
        else
        {
            strBuilder.append("is NOT in his registered Area ");
        }

        strBuilder.append(this.registeredarea);

        return strBuilder.toString();
    }

    public MaintenanceDepartment getRegisteredMaintenanceDepartment() {
        return registeredmaintenancedepartment;
    }

    public void setRegisteredMaintenanceDepartment(MaintenanceDepartment _registeredmaintenancedepartment) {
        this.registeredmaintenancedepartment = _registeredmaintenancedepartment;
    }


    public boolean isInRegisteredArea()
    {
        return registeredarea.isInArea(this.position);
    }

    private Customer inUseByDriver;
    private Area registeredarea;
    private Coordinate position;
    private final int id;
    private Status state;
    private int battery;
    private String licenseplate;
    public static LinkedList<Scooter> scooterlist = new LinkedList<Scooter>();
    private static int numberofscooters;
    private MaintenanceDepartment registeredmaintenancedepartment;
    /**
     * Defines what a low scooter percentage is
     */
    static private int lowbattery = 20;
}
