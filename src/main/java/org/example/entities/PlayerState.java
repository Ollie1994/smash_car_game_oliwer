package org.example.entities;

public enum PlayerState {
    /**
     * Purpose: An enumeration (enum) that defines the
     * possible states of the player (HEALTHY, INJURED, CRITICAL, DEAD).
     */
    HEALTHY, //>70
    INJURED, // >=25 && <=70
    CRITICAL,// >=1 && < 25
    DEAD	//0
}
