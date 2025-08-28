package org.example.cash;

/**
 * Purpose: a simple, dedicated class to manage the player's in-game currency.
 * DESIGN PRINCIPLE:
 * Single Responsibility Principle (SRP):
 * This class has one reason to change:
 * if the rules for managing cash change. It's not mixed with health logic,
 * scene logic, or anything else.
 */

public class CashManager {
    private int cash;

    public int getCash() { return cash; }
    public void addCash(int amount) { cash += amount; }
    public void deductCash(int amount) { cash = Math.max(0, cash - amount); }
}
