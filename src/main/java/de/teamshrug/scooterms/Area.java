package de.teamshrug.scooterms;

public class Area {

    public Area(String areaname, float ndegree1, float ndegree2, float edegree1, float edegree2)
    {
        this.areaname = areaname;
        this.ndegree1 = ndegree1;
        this.ndegree2 = ndegree2;
        this.edegree1 = edegree1;
        this.edegree2 = edegree2;
    }

    public boolean isInArea(Coordinate _position)
    {
        if (((ndegree1 < _position.ndegree) && (_position.ndegree < ndegree2)) || ((ndegree1 > _position.ndegree) && (_position.ndegree > ndegree2)))
        {
            return ((edegree1 < _position.edegree) && (_position.edegree < edegree2)) || ((edegree1 > _position.edegree) && (_position.edegree > edegree2));
        }
        else
            return false;
    }

    public float getNdegree1()
    {
        return ndegree1;
    }

    public float getNdegree2()
    {
        return ndegree2;
    }

    public float getEdegree1()
    {
        return edegree1;
    }

    public float getEdegree2()
    {
        return edegree2;
    }


    @Override
    public String toString()
    {
        return areaname;
    }

    private final String areaname;
    private final float ndegree1;
    private final float ndegree2;
    private final float edegree1;
    private final float edegree2;
}