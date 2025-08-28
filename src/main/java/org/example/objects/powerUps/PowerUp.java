package org.example.objects.powerUps;

import org.example.entities.GameObject;
import org.example.entities.Player;

public abstract class PowerUp extends GameObject {
    /**
     * Purpose: The abstract base class for all power-ups.
     * It defines the common interface (ApplyPowerup, OnCollision)
     * that all concrete power-ups must implement.
     * DESIGN PATTERN:
     * Template Method Pattern: This abstract class defines the template for what
     * a power-up is (it has a countdown, can be Active, etc.).
     * The concrete subclasses (like Armor) provide the specific
     * implementation for the ApplyPowerup method.
     */
    private static final int DURATION=5 ;
    protected int countdown = DURATION ;

    public static final int POWERUP_COUNT = 2 ;
    public abstract void applyPowerup(Player player, int damage, int cash) ;


    public boolean isActive() {return true ;}

    @Override
    public String toString() {
        return "DEFAULT" ;
    }

}

