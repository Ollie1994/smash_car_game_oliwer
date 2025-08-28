package org.example.objects.sideObjects;

import org.example.entities.GameObject;
import org.example.entities.Player;

public class FireHydrant extends SideObject{
    /**
     *Purpose: A concrete side object that represents a fire hydrant.
     * It defines the specific behavior and flavor text for a collision with this object.
     *
     * Key Behavior: In its OnCollision method, it applies damage and cash to the player.
     * The unique twist is that on subsequent collisions (count > 0),
     * the cash reward is multiplied by the count, making repeated collisions
     * with the same object more lucrative but risky.
     */

    public FireHydrant(int damage, int cash) {
        super(damage, cash);
        setName("FireHydrant");
    }


    @Override
    public void onCollision(GameObject other) {
        if(other.getTag().equals("Player")){
            Player player = (Player)other;
            if(count == 0){
                System.out.println("#### COLLISION ->[FireHydrant] Fountain");
                player.applyDamage(getDamage(), getCash());
            }else{
                System.out.println("#### COLLISION ->[FireHydrant] Collided again");
                player.applyDamage(getDamage(), getCash() * count);
            }
        }
    }
}
