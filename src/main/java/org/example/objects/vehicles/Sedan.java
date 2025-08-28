package org.example.objects.vehicles;

import org.example.entities.GameObject;
import org.example.entities.Player;

public class Sedan extends Vehicle{
    /**
     * Purpose: Concrete implementations of traffic vehicles.
     * They represent different types of cars the player encounters on the road.
     *
     * Key Behavior: They override the OnCollision method to provide
     * unique text while performing the same core logic: applying damage and cash to the player.
     */
    public Sedan(int damage, int cash) {
        super(damage, cash);
        setName("Sedan");
    }

    @Override
    public void onCollision(GameObject other) {
        if(other.getTag().equals("Player")){
            Player player = (Player)other;
            System.out.println("#### COLLISION ->[Sedan] Sparks flying");
            player.applyDamage(getDamage(), getCash());

        }
    }

}

