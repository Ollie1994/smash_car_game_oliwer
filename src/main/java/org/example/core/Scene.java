package org.example.core;

import org.example.entities.GameObject;
import org.example.entities.Player;
import org.example.objects.powerUps.PowerUp;
import org.example.objects.powerUps.PowerUpFactory;
import org.example.objects.sideObjects.SideObject;
import org.example.objects.sideObjects.SideObjectFactory;
import org.example.objects.vehicles.Sedan;
import org.example.objects.vehicles.Van;
import org.example.objects.vehicles.Vehicle;
import org.example.utils.RandomGenerator;

import java.util.ArrayList;

/**
 * Purpose:
 * Represents the game world for a single turn or frame.
 * It contains all the objects present (traffic, side objects)
 * and handles their generation, collision, and rendering (to the console).
 *
 * Key Responsibilities:
 * GenerateSideObject(), GenerateTraffic(), GeneratePowerups():
 * Uses factories to populate the scene based on the player's health state.
 *
 * Collide(): Handles collision events between the player and other objects.
 *
 * Execute(): The main method called each turn to update the scene.
 *
 * Design Patterns:
 * Object Composition: A Scene is composed of lists of Vehicle
 * and SideObject objects. This is a fundamental OOP concept.
 *
 * Update Method Pattern:
 * The Execute() method is called
 * repeatedly (each turn) to update the state of the scene. Common in games.
 *
 * Design Principle:
 * Dependency Inversion Principle (DIP): It depends on abstractions
 * (Vehicle, SideObject) and uses factories to create concrete objects,
 * making it easy to add new types of traffic or side objects
 * without modifying the Scene class.
 */
public class Scene {
    private static final int SIDEOBJECT_COUNT = 2;
    private static final int TRAFFIC_COUNT = 2;
    private static final int NPC_TYPES = 2;

    private ArrayList<Vehicle> trafficList = new ArrayList<>();
    private ArrayList<SideObject> sideList = new ArrayList<>();
    private Player player;

    public Scene() {

    }

    /**
     * initializes the scene with the player
     */
    public void start(Player player) {
        this.player = player;
        System.out.println("Scene initialized with player");
    }

    /**
     * executes one frame of scene updates
     * demonstrates the Update method pattern
     */
    public void execute() {
        generateSideObject();
        generateTraffic();
        generatePowerups();
        collide();

        displaySideObjects();
        displayTraffic();
    }

    /**
     * generates side objects based on player state
     */
    private void generateSideObject() {
        switch(player.getPlayerHealth().getPlayerState()) {
            case HEALTHY:
                if (sideList.size() > 6) {
                    sideList.remove(0);
                }
                break;
            case INJURED:
                while (sideList.size() > 4) {
                    sideList.remove(0);
                }
                break;
            case CRITICAL:
                while (sideList.size() > 2) {
                    sideList.remove(0);
                }
                break;
            case DEAD:
                return; // No need to generate objects if player is dead
        }

        int randomKey = RandomGenerator.getInstance().nextInt(SIDEOBJECT_COUNT);
        SideObject newObject = SideObjectFactory.getInstance().createSideObject(randomKey);
        sideList.add(newObject);
    }

    /**
     * generates traffic vehicles based on player state
     */
    private void generateTraffic() {
        switch(player.getPlayerHealth().getPlayerState()) {
            case HEALTHY:
                if (trafficList.size() > 6) {
                    trafficList.remove(0);
                }
                break;
            case INJURED:
                while (trafficList.size() > 4) {
                    trafficList.remove(0);
                }
                break;
            case CRITICAL:
                while (trafficList.size() > 2) {
                    trafficList.remove(0);
                }
                break;
            case DEAD:
                return;
        }

        Vehicle vehicle = null;
        switch (RandomGenerator.getInstance().nextInt(TRAFFIC_COUNT)) {
            case 0:
                vehicle = new Sedan(15, 80);
                break;
            case 1:
                vehicle = new Van(18, 90);
                break;
        }
        trafficList.add(vehicle);
    }

    /**
     * generates powerups based on player health state
     */

    private void generatePowerups() {
        int spawnIndex = 0;
        //Mindre chans att få powerup ju mer liv du har
        switch(player.getPlayerHealth().getPlayerState()) {
            case HEALTHY:
                spawnIndex = RandomGenerator.getInstance().nextInt(10);
                break;
            case INJURED:
                spawnIndex = RandomGenerator.getInstance().nextInt(6);
                break;
            case CRITICAL:
                spawnIndex = RandomGenerator.getInstance().nextInt(3);
                break;
            case DEAD:
                spawnIndex = 100;
                break;
        }

        if (spawnIndex < PowerUp.POWERUP_COUNT) {
            if (spawnIndex != 0 && player.getPowerUp().isActive()) {
                System.out.println("💫 Powerup generation skipped - player already has active powerup");
                return;
            }

            PowerUp powerUp = PowerUpFactory.createPowerUp(spawnIndex);
            if (powerUp != null) {
                System.out.println("✨ POWERUP SPAWNED: " + powerUp.getClass().getSimpleName());
                powerUp.onCollision(player);
            }
        } else {
            System.out.println("➖ No powerup spawned this turn");
        }
    }

    /**
     * handles collision events in the scene
     */
    public void collide() {
        if (!RandomGenerator.getInstance().nextBoolean()) {
            System.out.println("➖ No collision this turn");
            return;
        }

        GameObject collidingObject = null;
        String objectType = "";

        switch (RandomGenerator.getInstance().nextInt(NPC_TYPES)) {
            case 0: // sideObjects
                if (!sideList.isEmpty()) {
                    collidingObject = RandomGenerator.getInstance().getRandomElement(sideList);
                    objectType = "Side Object";
                }
                break;
            case 1: // traffic
                if (!trafficList.isEmpty()) {
                    collidingObject = RandomGenerator.getInstance().getRandomElement(trafficList);
                    objectType = "Traffic";
                }
                break;
        }

        if (collidingObject != null) {
            System.out.println("💥 COLLISION DETECTED with " + objectType + ": " + collidingObject.getName());
            int previousHealth = player.getPlayerHealth().getHealthUnits();
            collidingObject.onCollision(player);
            int damageTaken = previousHealth - player.getPlayerHealth().getHealthUnits();
            System.out.println("💔 Damage taken: " + damageTaken + " health points");
        } else {
            System.out.println("➖ Collision chance rolled, but no objects available");
        }

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * displays current side objects for educational visibility
     */
    private void displaySideObjects() {
        System.out.println("<<<<< SIDEOBJECTS (" + sideList.size() + ") >>>>>");
        for (SideObject obj : sideList) {
            System.out.println("  - " + obj.getName());
        }
    }

    /**
     * displays current traffic for educational visibility
     */
    private void displayTraffic() {
        System.out.println("<<<<< TRAFFIC (" + trafficList.size() + ") >>>>>");
        for (Vehicle obj : trafficList) {
            System.out.println("  - " + obj.getName());
        }
        System.out.println("-----------------------------------");
    }

    /**
     * cleans up scene resources
     */
    public void cleanup() {
        trafficList.clear();
        sideList.clear();
        player = null;
    }
}

