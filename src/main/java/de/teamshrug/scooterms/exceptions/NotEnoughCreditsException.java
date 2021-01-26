package de.teamshrug.scooterms.exceptions;

public class NotEnoughCreditsException extends Exception
{
    public NotEnoughCreditsException()
    {
        super("Not enough credits");
    }
}
