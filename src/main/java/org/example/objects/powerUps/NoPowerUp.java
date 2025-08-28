package org.example.objects.powerUps;

import org.example.entities.Player;

public class NoPowerUp extends PowerUp{
    /**
     * Purpose: Represents the default state of having no active power-up.
     * It implements the neutral behavior for handling damage.
     *
     * Design Pattern:
     * Null Object Pattern (Behavioral): This is a classic use of this pattern.
     * Instead of checking if (powerUp != null) everywhere, the player always has a
     * PowerUp object. This object, NoPowerUp, simply applies the standard damage formula.
     * It eliminates the need for null checks and prevents NullPointerExceptions.
     */

    @Override
    public void applyPowerup(Player player, int damage, int cash) {
        int newHealth = player.getPlayerHealth().getHealthUnits()-damage - player.getPlayerVehicle().getStrength() ;
        player.getPlayerHealth().setHealthUnits(newHealth);
    }

    @Override
    public boolean isActive() {
        return false ;
    }

}

