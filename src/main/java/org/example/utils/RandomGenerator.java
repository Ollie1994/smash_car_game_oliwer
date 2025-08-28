package org.example.utils;

import java.util.Random;

/**
 * Purpose: A utility class that provides centralized,
 * controlled access to random number generation for the entire game.
 *
 * Key Features:
 * Offers a wide range of helper methods (nextInt(bound),
 * nextBoolean(), getRandomElement(list), chance(probability)).
 * Can be seeded for deterministic behavior (crucial for testing and debugging).
 *
 * DESIGN PATTERN:
 * Singleton Pattern (Creational): Ensures all parts of the game use
 * the same random number generator. This is important because
 * if different parts used their own new Random(),
 * they could generate predictable sequences if created in the same millisecond.
 *
 * Utility Class: Provides static utility methods through a singleton instance.
 */
public class RandomGenerator {

    // singleton instance
    private static RandomGenerator instance;
    private Random random;

    // private constructor to prevent instantiation
    private RandomGenerator() {
        random = new Random();
        // could add seed for deterministic behavior during testing
        // random = new Random(12345L);
    }

    /**
     * Returns the singleton instance (thread-safe version)
     * Demonstrates lazy initialization
     */
    public static synchronized RandomGenerator getInstance() {
        if (instance == null) {
            instance = new RandomGenerator();
        }
        return instance;
    }

    /**
     * Returns a random integer between 0 (inclusive) and bound (exclusive)
     */
    public int nextInt(int bound) {
        return random.nextInt(bound);
    }

    /**
     * Returns a random integer between min (inclusive) and max (exclusive)
     */
    public int nextInt(int min, int max) {
        return random.nextInt(max - min) + min;
    }

    /**
     * Returns a random boolean value
     */
    public boolean nextBoolean() {
        return random.nextBoolean();
    }

    /**
     * Returns a random double between 0.0 (inclusive) and 1.0 (exclusive)
     */
    public double nextDouble() {
        return random.nextDouble();
    }

    /**
     * Returns a random double between min (inclusive) and max (exclusive)
     */
    public double nextDouble(double min, double max) {
        return min + (max - min) * random.nextDouble();
    }

    /**
     * Returns a random element from the given array
     * Demonstrates generics usage
     */
    public <T> T getRandomElement(T[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        return array[random.nextInt(array.length)];
    }

    /**
     * Returns a random element from the given list
     */
    public <T> T getRandomElement(java.util.List<T> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(random.nextInt(list.size()));
    }

    /**
     * Chance-based method - returns true with given probability (0.0 to 1.0)
     */
    public boolean chance(double probability) {
        if (probability <= 0.0) return false;
        if (probability >= 1.0) return true;
        return random.nextDouble() < probability;
    }

    /**
     * Resets the random generator with a new seed
     * Useful for testing and reproducible results
     */
    public void setSeed(long seed) {
        random.setSeed(seed);
    }

    /**
     * Returns the underlying Random instance for advanced usage
     * Use with caution - breaks encapsulation but provides flexibility
     */
    public Random getRandom() {
        return random;
    }
}
