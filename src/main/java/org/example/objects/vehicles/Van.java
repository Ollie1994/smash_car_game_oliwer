package org.example.objects.vehicles;

import org.example.entities.GameObject;
import org.example.entities.Player;

/**
 * Same as Sedan class
 */
public class Van extends Vehicle {
    public Van(int damage, int cash) {
        super(damage, cash);
        setName("Van");
    }

    @Override
    public void onCollision(GameObject other) {
        if (other.getTag().equals("Player")) {
            Player player = (Player) other;
            System.out.println("#### COLLISION ->[Van] Milk bottles falling");
            player.applyDamage(getDamage(), getCash());

        }
    }
}

