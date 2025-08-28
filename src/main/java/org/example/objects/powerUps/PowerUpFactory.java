package org.example.objects.powerUps;

import java.util.HashMap;

public class PowerUpFactory {
    /**
     * Purpose: Should be a simple factory responsible for creating instances
     * of specific power-up classes based on an input key.
     */

    // TODO: implement DESIGN PATTERN: Factory Method Pattern It centralizes the object creation logic.

    private static HashMap<Integer, PowerUp> powerUpsMap = new HashMap<Integer, PowerUp>();

    public static PowerUp createPowerUp(int index) {
        powerUpsMap.put(1, new Armor());
        powerUpsMap.put(2, new HealthKit());
        powerUpsMap.put(3, new NoPowerUp());

        PowerUp currentPower = powerUpsMap.get(index);

        if (currentPower != null) {
            return currentPower;
        } else {
            return null;
        }
    }
}
