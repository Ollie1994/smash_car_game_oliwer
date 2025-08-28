package org.example;

import org.example.core.GameManager;
import org.example.objects.sideObjects.FireHydrant;
import org.example.objects.sideObjects.LetterBox;

/**
 * Main entry point for the Driving Game application.
 * Demonstrates the application startup pattern and initialization sequence.
 */
public class Program {

    /**
     * Initializes game components and factories.
     * This method sets up the necessary callbacks for object creation.
     */
    private static void Initialize() {
        SideObjectFactory.GetInstance().RegisterCallback(0, ()-> {return new LetterBox(8, 13);});
        SideObjectFactory.GetInstance().RegisterCallback(1, ()-> {return new FireHydrant(5, 10);});

        System.out.println("Game initialized and ready to start!");
    }

    /**
     * Main method - the entry point of the Java application.
     * Demonstrates the application startup sequence pattern.
     *
     * @param args command-line arguments (not used in this game)
     */
    public static void main(String[] args) {
        System.out.println("=== Starting Driving Game ===");
        System.out.println("Initializing game components...");

        Initialize();

        System.out.println("Starting game manager...");

        GameManager.getInstance().newGame();

        System.out.println("=== Game Ended ===");
    }
}