package org.example.objects.sideObjects;

import org.example.objects.powerUps.PowerUp;
import org.example.utils.Callback;

import java.util.HashMap;

public class SideObjectFactory {
    /**
     * TODO:
     * Purpose: Create a factory that produces different types of side
     * objects (like LetterBox, FireHydrant) without exposing how they're made.
     * RegisterCallback(int key, Callback callback): Used at game startup
     * (in Program.Initialize()) to populate the factory.
     *
     * Core Components:
     * Callback System: Stores recipes for creating each object type
     * Registration: Add new object types to the factory
     * Creation: Request objects by their ID number
     *
     * Key Features:
     * Singleton: Only one factory exists in the entire game
     * Extensible: Easy to add new object types later
     * Safe: Returns empty objects if requested type doesn't exist
     *
     * What You Need to Build:
     * HashMap Storage
     * Store object creation recipes using integer keys (0, 1, 2...)
     * Each key points to a function that creates a specific object
     *
     * 2. Two Main Methods:
     * RegisterCallback(): Add new object types to the factory
     * CreateSideObject(): Produce objects by their key number
     *
     * 3. Safety Feature
     * If someone requests an invalid key, return a harmless NullObject
     * This prevents crashes and errors
     */

    private static HashMap<Integer, SideObject> sideObjectMap = new HashMap<Integer, SideObject>();

    public static SideObjectFactory getInstance() {
        return new SideObjectFactory();
    }


    // Callback System: Stores recipes for creating each object type
    // Add new object types to the factory
    public void registerCallback(int key, Callback callback) {
        sideObjectMap.put(1, new FireHydrant(10, 10));
        sideObjectMap.put(2, new LetterBox(5, 5));
        sideObjectMap.put(3, new NullSideObject());
    }

    // Registration: Add new object types to the factory
    // Creation: Request objects by their ID number
    // Produce objects by their key number
    public SideObject createSideObject(int key) {

        SideObject currentObject = sideObjectMap.get(key);

        if (currentObject == null) {
            return null;
        } else {
            return currentObject;
        }
    }
}
