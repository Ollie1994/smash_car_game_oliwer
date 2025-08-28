package org.example.objects.vehicles;

import org.example.entities.GameObject;

public class Vehicle extends GameObject {
    /**
     * Purpose: The base class for traffic vehicles (NPCs)
     * that the player can collide with. It is separate from
     * PlayerVehicle as it has different properties—it's an obstacle, not a controllable entity.
     *
     * Key Properties: damage (how much damage it does on collision)
     * and cash (how much money the player gets for hitting it).
     *
     * Design Principle:
     * Inheritance: Serves as the parent for specific traffic vehicles like Sedan and Van.
     */
    private int damage ;
    private int cash ;

    public Vehicle(int damage, int cash) {
        this.damage = damage;
        this.cash = cash;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }
}
