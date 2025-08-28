package org.example.objects.sideObjects;

import org.example.entities.GameObject;

/**
 * Null Object Pattern implementation for SideObjects.
 * Represents a non-existent or neutral side object that does nothing on collision.
 * This eliminates the need for null checks throughout the code.
 *
 * Purpose: An implementation of the Null Object Pattern specifically for SideObject.
 * It represents the absence of a real side object.
 *
 * Key Behavior: Its OnCollision method intentionally does nothing. It is also disabled.
 *
 * Design Pattern:
 * Null Object Pattern (Behavioral): This is a critical pattern used
 * to avoid null checks throughout the code. Instead of a method returning
 * null when no side object is available (e.g., in SideObjectFactory),
 * it returns NullSideObject.getInstance(). This completely eliminates
 * the risk of NullPointerExceptions and simplifies client code,
 * as you can safely call methods on it without checking for null first.
 *
 * Design Principle:
 * Singleton Pattern: The getInstance() method ensures there is only one,
 * shared instance of the NullSideObject, which is efficient since all "null" objects behave identically.
 */
public class NullSideObject extends SideObject {

    private static final NullSideObject INSTANCE = new NullSideObject();

    private NullSideObject() {
        super(0, 0); // no damage, no cash
        setName("NullSideObject");
        setEnabled(false); // not enabled since it's a null object
    }

    /**
     * Returns the singleton instance of NullSideObject
     */
    public static NullSideObject getInstance() {
        return INSTANCE;
    }

    /**
     * Overridden collision handler that does nothing
     * This is the key part of the Null Object pattern
     */
    @Override
    public void onCollision(GameObject other) {
        // intentionally do nothing - this is a null object
        // no System.out.println to avoid console spam
    }

    /**
     * Overridden to indicate this is a null object
     */
    @Override
    public String getName() {
        return "NullSideObject";
    }

    /**
     * Overridden to always return false for null objects
     */
    @Override
    public boolean isEnabled() {
        return false;
    }

    /**
     * Overridden to prevent enabling null objects
     */
    @Override
    public void setEnabled(boolean enabled) {
        // null objects cannot be enabled
        // this prevents accidental misuse
    }

    /**
     * Overridden toString for debugging
     */
    @Override
    public String toString() {
        return "NullSideObject{}";
    }
}