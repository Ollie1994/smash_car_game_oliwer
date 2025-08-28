package org.example.entities;

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

}