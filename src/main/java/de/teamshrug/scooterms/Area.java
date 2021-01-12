package de.teamshrug.scooterms;

public class Area {

    public Area(String _areaname, float _ndegree1, float _ndegree2, float _edegree1, float _edegree2) {
        this.areaname = _areaname;
        this.ndegree1 = _ndegree1;
        this.ndegree2 = _ndegree2;
        this.edegree1 = _edegree1;
        this.edegree2 = _edegree2;
    }

    public boolean isInArea(Coordinate _position)
    {
        if (((ndegree1 < _position.ndegree) && (_position.ndegree < ndegree2)) || ((ndegree1 > _position.ndegree) && (_position.ndegree > ndegree2)))
        {
            if (((edegree1 < _position.edegree) && (_position.edegree < edegree2)) || ((edegree1 > _position.edegree) && (_position.edegree > edegree2)))
            {
                return true;
            }
            else
                return false;
        }
        else
            return false;
    }

    public float getNdegree1() {
        return ndegree1;
    }

    public float getNdegree2() {
        return ndegree2;
    }

    public float getEdegree1() {
        return edegree1;
    }

    public float getEdegree2() {
        return edegree2;
    }

    public String getAreaInfo()
    {
        return areaname + ": N" + ndegree1 + "° - N" + ndegree2 + "°  &  E" + edegree1 + "° - E" + edegree2 + "°";
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