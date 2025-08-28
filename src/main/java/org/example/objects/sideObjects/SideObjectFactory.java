package org.example.objects.sideObjects;

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

}
