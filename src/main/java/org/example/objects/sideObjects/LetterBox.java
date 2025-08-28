package org.example.objects.sideObjects;

import org.example.entities.GameObject;
import org.example.entities.Player;

public class LetterBox extends SideObject{
    /**
     *Purpose: A concrete side object that represents a mailbox.
     * It is functionally identical to FireHydrant but exists
     * to provide variety in the game world.
     *
     * Key Behavior: Its OnCollision method has the same logic
     * as FireHydrant (damage application and cash multiplication)
     * but uses different text.
     */

    public LetterBox(int damage, int cash) {
        super(damage, cash);
        setName("LetterBox") ;
    }

    @Override
    public void onCollision(GameObject other) {
        if(other.getTag().equals("Player")){
            Player player = (Player)other;
            if(count == 0){
                System.out.println("#### COLLISION ->[Letterbox] Letters falling");
                player.applyDamage(getDamage(), getCash());
            }else{
                System.out.println("#### COLLISION ->[Letterbox] Collided again");
                player.applyDamage(getDamage(), getCash() * count);
            }
        }
    }
}
