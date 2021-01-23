package de.teamshrug.scooterms;

import java.util.LinkedList;

public class ScooterHotspot {

    public ScooterHotspot(String hotspotname, Coordinate location, int maxscootercount) {
        this.hotspotname = hotspotname;
        this.location = location;
        this.maxscootercount = maxscootercount;
        this.scootercount = 0;
        scooterhotspotlist.add(this);
    }




    public String getHotspotname()
    {
        return hotspotname;
    }

    public void setHotspotname(String hotspotname)
    {
        this.hotspotname = hotspotname;
    }

    public Coordinate getLocation()
    {
        return location;
    }

    public void setLocation(Coordinate location)
    {
        this.location = location;
    }

    public int getMaxscootercount()
    {
        return maxscootercount;
    }

    public void setMaxscootercount(int maxscootercount)
    {
        this.maxscootercount = maxscootercount;
    }

    public int getScootercount()
    {
        return scootercount;
    }

    public void setScootercount(int scootercount)
    {
        this.scootercount = scootercount;
    }


    private String hotspotname;
    private Coordinate location;
    private int maxscootercount;
    private int scootercount;
    public static LinkedList<ScooterHotspot> scooterhotspotlist = new LinkedList<ScooterHotspot>();
}
