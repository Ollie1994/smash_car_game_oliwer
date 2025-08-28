package org.example.core;

import org.example.entities.Player;

/**
 * Purpose:
 * A data holder class that represents the current state of
 * the game at a high level. It primarily holds a reference to
 * the Player object and a gameRunning flag.
 *
 * Design Principle:
 * Encapsulation: It cleanly groups related state variables together.
 * While simple here, this pattern makes it easy to save, load,
 * or reset the game state in the future.
 */
public class GameState {
    private boolean gameRunning;
    private Player player;

    public boolean isGameRunning() { return gameRunning; }
    public void setGameRunning(boolean running) { gameRunning = running; }
    public Player getPlayer() { return player; }
    public void setPlayer(Player player) { this.player = player; }
}