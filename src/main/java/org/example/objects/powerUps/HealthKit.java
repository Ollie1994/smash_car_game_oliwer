package org.example.objects.powerUps;

import org.example.entities.GameObject;
import org.example.entities.Player;

public class HealthKit extends PowerUp{
    /**
     * Purpose: A concrete power-up that immediately restores
     * health upon collision (OnCollision). Its ApplyPowerup
     * method is empty because it provides a one-time benefit,
     * not ongoing damage modification.
     */
    @Override
    public void applyPowerup(Player player, int damage, int cash) {

    }

    @Override
    public void onCollision(GameObject other) {
        if(other.getTag().equalsIgnoreCase("Player")) {
            System.out.println("********************************************");
            System.out.println("*************** HEALTHKIT  *****************");
            System.out.println("********************************************");
            Player p = (Player)other ;
            int newHealth = p.getPlayerHealth().getHealthUnits() + 25 ;
            p.getPlayerHealth().setHealthUnits(newHealth);
        }
    }

}


