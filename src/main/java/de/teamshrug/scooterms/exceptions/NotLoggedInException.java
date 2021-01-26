package de.teamshrug.scooterms.exceptions;

public class NotLoggedInException extends Exception
{
    public NotLoggedInException()
    {
        super("Not logged in");
    }
}