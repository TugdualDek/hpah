package com.example.test_javafx.wizarding;


import lombok.Getter;

/**
 * This enum represents the different cores that can be used in a wand.
 */
public enum Core {

    /**
     * The core made of phoenix feathers.
     */
    PHOENIX_FEATHER("pheonix feather"),

    /**
     * The core made of dragon heartstrings.
     */
    DRAGON_HEARTSTRING("dragon heartstring");

    //
    // Fields
    //

    /**
     * The name of the core.
     */
    private @Getter String name;

    //
    // Constructors
    //

    /**
     * Creates a new Core with the given name.
     *
     * @param name the name of the core
     */
    Core(String name) {
        this.name = name;
    }

    ;

    //
    // Methods
    //

    //
    // Accessor methods
    //

    //
    // Other methods
    //

}
