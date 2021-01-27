package de.teamshrug.scooterms.exceptions;

/**
 * When a Customer has not enough credits to rent a Scooter, this exception is thrown
 */
public class NotEnoughCreditsException extends Exception
{
    public NotEnoughCreditsException()
    {
        super("Not enough credits");
    }
}
