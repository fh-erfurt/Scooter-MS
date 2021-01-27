package de.teamshrug.scooterms;

/**
 *  The class coordinate consists of two attributes, ndegrees and edegrees. together they built a position on a map.
 */
public class Coordinate
{
    public Coordinate(float ndegree, float edegree) {
        this.ndegree = ndegree;
        this.edegree = edegree;
    }


    public float ndegree;
    public float edegree;
}
