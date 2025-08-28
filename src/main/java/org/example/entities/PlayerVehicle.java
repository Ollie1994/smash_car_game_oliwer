package org.example.entities;

package org.example.entities;

public class PlayerVehicle {
    /**
     * Purpose: A data container for the vehicle's properties
     * (name, handling, speed, strength). The steering methods are placeholders.
     * Design Principle:
     * Encapsulation: It bundles all the vehicle's attributes together in one logical unit.
     */

    private String name;
    private int handling;
    private int topSpeed;
    private int strength;

    public PlayerVehicle(String name, int handling, int topSpeed, int strength) {
        super();
        this.name = name;
        this.handling = handling;
        this.topSpeed = topSpeed;
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public int getHandling() {
        return handling;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public int getStrength() {
        return strength;
    }

    public void up(){

    }
    public void down(){

    }
    public void left(){

    }
    public void right(){

    }
}
