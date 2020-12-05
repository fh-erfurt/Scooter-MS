package de.teamshrug.scooterms;

public class area {


    public area(String areaName, float ndegree1, float ndegree2, float edegree1, float edegree2) {
        AreaName = areaName;
        Ndegree1 = ndegree1;
        Ndegree2 = ndegree2;
        Edegree1 = edegree1;
        Edegree2 = edegree2;
    }


    public boolean isInArea(coordinate _position)
    {
        if (((Ndegree1 < _position.Ndegree) && (_position.Ndegree < Ndegree2)) || ((Ndegree1 > _position.Ndegree) && (_position.Ndegree > Ndegree2)))
        {
            if (((Edegree1 < _position.Edegree) && (_position.Edegree < Edegree2)) || ((Edegree1 > _position.Edegree) && (_position.Edegree > Edegree2)))
            {
                return true;
            }
            else
                return false;
        }
        else
            return false;
    }


    private final String AreaName;
    private final float Ndegree1;
    private final float Ndegree2;
    private final float Edegree1;
    private final float Edegree2;
}
