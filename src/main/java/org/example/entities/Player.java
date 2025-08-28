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
    private PlayerHealth health;
    private PlayerVehicle playerVehicle;
    private PowerUp powerUp;
    private PlayerState playerState;
    private boolean isAlive = true;
    private int playerCash = 0;


    public void drive() {
        System.out.println("Player is driving the vehicle.");
    }

    // User tar skada av SideObjects
    // Tjäna cash beroende på SideObjects cash
    // SideObject.Count (antal kollisioner) ska öka för SideObjects
    //
    public void applyDamage(int damage, int cash) {
        System.out.println("Player applied damage");

        int currentHealth = getPlayerHealth().getHealthUnits();
        System.out.println("Current health: " + currentHealth);
        setPlayerHealth(new PlayerHealth(currentHealth - damage));
        System.out.println("Health set to: " + getPlayerHealth());
        setPlayerCash(playerCash + cash);
    }












    // ------------------- G S C ------------------------------

    public Player(int health, PlayerVehicle vehicle) {
        this.health.setHealthUnits(health);
        this.playerVehicle = vehicle;
    }

    public PlayerHealth getPlayerHealth() {
        return health;
    }

    public void setPlayerHealth(PlayerHealth health) {
        this.health = health;
    }

    public PlayerVehicle getPlayerVehicle() {
        return playerVehicle;
    }

    public void setPlayerVehicle(PlayerVehicle playerVehicle) {
        this.playerVehicle = playerVehicle;
    }

    public PowerUp getPowerUp() {
        return powerUp;
    }

    public void setPowerUp(PowerUp powerUp) {
        this.powerUp = powerUp;
    }

    public PlayerState getPlayerState() {
        return playerState;
    }

    public void setPlayerState(PlayerState playerState) {
        this.playerState = playerState;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public int getPlayerCash() {
        return playerCash;
    }

    public void setPlayerCash(int playerCash) {
        this.playerCash = playerCash;
    }
}