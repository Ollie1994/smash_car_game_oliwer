package org.example.objects.powerUps;

import org.example.core.GameManager;
import org.example.entities.GameObject;
import org.example.entities.Player;

public class Armor extends PowerUp{

    private GameManager gameManager;
    /**
     *Purpose: A concrete power-up that reduces incoming damage.
     * Its ApplyPowerup method calculates damage differently: (vehicle strength + damage / 2).
     *
     * Key Points: It also manages its own countdown timer
     * and removes itself from the player when it expires.
     */

    @Override
    public void applyPowerup(Player player, int damage, int cash) {
        // calculate modified damage (vehicle strength + half of incoming damage)
        int totalDamage = player.getPlayerVehicle().getStrength() + (damage / 2);

        // apply reduced damage to player health
        int newHealth = player.getPlayerHealth().getHealthUnits() - totalDamage;
        player.getPlayerHealth().setHealthUnits(newHealth);

        // add cash through the proper economy system
        //GameManager.getInstance().getCash().addCash(cash);
        gameManager.getCashManager().addCash(cash);


        // decrement countdown and remove powerup if expired
        if (--countdown == 0) {
            player.setPowerUp(new NoPowerUp());
        }
    }

    @Override
    public void onCollision(GameObject other) {
        if ("Player".equals(other.getTag())) {
            System.out.println("******************************");
            System.out.println("************ ARMOR ***********");
            System.out.println("******************************");
            Player player = (Player) other;
            player.setPowerUp(this);
        }
    }

    @Override
    public String toString() {
        return "ARMOR:" + countdown;
    }


}
