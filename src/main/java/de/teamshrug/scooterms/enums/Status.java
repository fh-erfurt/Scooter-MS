package de.teamshrug.scooterms.enums;

/**
 * The enum Status consists of the types: ready, lowonbattery, inuse, charging, damaged, maintenance. Every Scooter can change his 'Status' to a different one.
 */
public enum Status
{
    /**
     * The scooter is ready to use
     */
    ready,

    /**
     * The scooter is low on battery, if the battery is lower or equals 20%
     */
    lowonbattery,

    /**
     * The scooter is currently in use
     */
    inuse,

    /**
     * The scooter is charging
     */
    charging,

    /**
     * The scooter was reported as damaged
     */
    damaged,

    /**
     * The scooter is being serviced
     */
    maintenance
}
