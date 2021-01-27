package de.teamshrug.scooterms.exceptions;

/**
 * If a user tries to do sth without being logged in, this exception is thrown
 */
public class NotLoggedInException extends Exception
{
    public NotLoggedInException()
    {
        super("Not logged in");
    }
}