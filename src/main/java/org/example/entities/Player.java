package org.example.entities;

import org.example.objects.powerUps.PowerUp;
import org.example.objects.vehicles.Vehicle;

/**
 * Purpose: Should represent the player character.
 * It should be a composite object that contains the player's health,
 * vehicle, and active power-up.
 * Key Actions: drive() (simulates movement),
 * applyDamage() (delegates damage calculation to the active power-up), and steering methods.
 * Strategy Pattern (partially): The ApplyDamage method delegates
 * its behavior to the current PowerUp object. The PowerUp acts as a strategy for handling damage.
 */

//TODO: Implement the player class using DESIGN PRINCIPLE: Composition over Inheritance
// TODO: Implement DESIGN PATTERN: Strategy Pattern (partially) The applyDamage method should delegate its
// TODO: behaviour to the current PowerUp object. The PowerUp object should act as a strategy for handling damage.

public class Player extends GameObject{
    private int health;
    private PlayerVehicle vehicle;
    private PowerUp powerUp;

    public Player(int health, PlayerVehicle vehicle) {
        this.health = health;
        this.vehicle = vehicle;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public PlayerVehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(PlayerVehicle vehicle) {
        this.vehicle = vehicle;
    }

    public PowerUp getPowerUp() {
        return powerUp;
    }

    public void setPowerUp(PowerUp powerUp) {
        this.powerUp = powerUp;
    }
}