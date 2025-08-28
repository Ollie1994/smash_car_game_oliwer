package org.example.objects.sideObjects;

import org.example.entities.GameObject;

public class SideObject extends GameObject {
    /**
     * Purpose: The abstract base class for all objects on the side
     * of the road that the player can collide with (e.g., fire hydrants, mailboxes).
     * It encapsulates the common properties of these objects:
     * the damage they inflict, the cash they award, and a count
     * of how many times they've been hit.
     *
     * Key Properties:
     * damage: The amount of health points subtracted on collision.
     *
     * cash: The amount of currency awarded on collision.
     *
     * count: A protected counter tracking the number of collisions.
     *
     * Design Principle:
     * Inheritance: Serves as the parent class for specific side
     * objects like FireHydrant and LetterBox, allowing for code reuse and polymorphic treatment.
     */

    private int damage ;
    private int cash ;
    protected int count ;

    public SideObject(int damage, int cash) {
        super();
        this.damage = damage;
        this.cash = cash;
        count = 0;
    }


    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }
}
