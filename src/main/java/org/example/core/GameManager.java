package org.example.core;

import org.example.entities.Player;
import org.example.entities.PlayerVehicle;

/**
 * BAD EXAMPLE - God Object Anti-Pattern!
 * This GameManager does too much and knows about too many things.
 * It violates Single Responsibility Principle.
 */

//TODO: Refactor this class into multiple classes!
public class GameManager {
    // Singleton Pattern - this part is actually good...
    private static GameManager instance = new GameManager();
    private int cash;

    private GameManager() {
        // private constructor for singleton
    }

    public static GameManager getInstance() {
        return instance;
    }

    public int getCash() {
        return cash;
    }

    public void addCash(int amount) {
        cash += amount;
    }

    public void newGame() {
        System.out.println("🎮 NEW GAME STARTED 🎮");

        // creating player and vehicle
        PlayerVehicle vehicle = new PlayerVehicle("Sedan", 5, 70, 4);
        Player player = new Player(100, vehicle);
        player.setTag("Player");

        // creating and managing scene
        Scene scene = new Scene();
        scene.start(player);

        // managing game loop
        int turnCount = 0;
        final int MAX_TURNS = 20;

        while (player.isAlive() && turnCount < MAX_TURNS) {
            turnCount++;
            System.out.println("\n=== TURN " + turnCount + "/" + MAX_TURNS + " ===");

            // 4. executing scene logic
            scene.execute();

            // making player drive
            player.drive();

            // managing game state display
            System.out.printf("📊 Health=%d, Cash=%d, PowerUp=%s%n",
                    player.getPlayerHealth().getHealthUnits(),
                    cash,
                    player.getPowerUp().toString());

            try { Thread.sleep(800); } catch (InterruptedException e) {}
        }

        // handling game end
        endGame();
    }

    public void endGame() {
        System.out.println("\n💀 GAME OVER 💀");
        System.out.printf("Total cash accumulated: %d%n", cash);
    }
}