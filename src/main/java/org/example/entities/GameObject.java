package org.example.entities;

public class GameObject {

    /**
     * Purpose: The base class for all entities in the game.
     * It provides common properties and methods that all game objects share.
     *
     * Key Properties: enabled, name, tag.
     *
     * Key Method: OnCollision(GameObject other) -
     * Provides a common interface for collision handling.
     *
     * DESIGN PRINCIPLES:
     * Inheritance & Polymorphism:
     * This is the root of an inheritance hierarchy. All other entities (Player, Vehicle, PowerUp)
     * inherit from it, allowing them to be treated uniformly (e.g., stored in a list of GameObject
     * for collision detection). The empty OnCollision method defines a polymorphic
     * interface that subclasses override.
     */

    private boolean enabled;

    private String name;

    private String tag;

    public GameObject() {
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void onCollision(GameObject other) {

    }
}
