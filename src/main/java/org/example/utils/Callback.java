package org.example.utils;


import org.example.objects.sideObjects.SideObject;

@FunctionalInterface
public interface Callback {
    /**
     * Purpose: A Functional Interface that defines a single
     * method Create() which returns a SideObject.
     * This is the contract that the SideObjectFactory depends on.
     *
     * Key Feature: Annotated with @FunctionalInterface,
     * which allows it to be implemented using lambda expressions
     * (e.g., ()-> {return new LetterBox(8, 13);}).
     *
     * Design Pattern:
     * Strategy Pattern (Behavioral): The Create() method represents
     * the strategy for creating an object. Each lambda expression registered
     * in the factory is a concrete strategy.
     *
     * Read more: https://www.baeldung.com/java-8-functional-interfaces
     */

    SideObject create();
}
