package org.example.entities;

public class PlayerHealth {
    /**
     * Purpose: Should manage the player's health and state.
     * It should encapsulate the health value and automatically
     * update the player's state (HEALTHY, INJURED, etc.) when the health changes.
     */

    // TODO: implement DESIGN PRINCIPLE: Single Responsibility Principle

    int health;

    public PlayerHealth(int health) {
        this.health = health;
    }

    public int getHealthUnits() {
        return health;
    }

    public void setHealthUnits(int health) {
        this.health = health;
    }

    /*  HEALTHY, //>70
    INJURED, // >=25 && <=70
    CRITICAL,// >=1 && < 25
    DEAD	//0*/
    public PlayerState getPlayerState() {
        if(health <= 0) {
            return PlayerState.DEAD;
        } else if (1 >= health && health < 25) {
            return PlayerState.CRITICAL;
        } else if (25 >= health && health <= 70) {
            return PlayerState.INJURED;
        } else {
            return PlayerState.HEALTHY;
        }
    }
}
