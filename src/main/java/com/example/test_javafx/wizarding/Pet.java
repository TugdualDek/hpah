package com.example.test_javafx.wizarding;


/**
 * Class Pet
 * This class represents the different types of pets that can be owned by a wizard or witch.
 * Each pet has a name and an attack power.
 */
public enum Pet {

    OWL("Owl", 10), // An owl pet with an attack power of 10.
    RAT("Rat", 11), // A rat pet with an attack power of 11.
    CAT("Cat", 9), // A cat pet with an attack power of 9.
    TOAD("Toad", 10); // A toad pet with an attack power of 10.

    //
    // Fields
    //
    private String name; // The name of the pet.
    private int attackPower; // The attack power of the pet.

    //
    // Constructors
    //
    Pet(String name, int attackPower) { // Constructor for the Pet enum.
        this.name = name;
        this.attackPower = attackPower;
    }

    ;

    //
  // Methods
  //


    //
    // Accessor methods
    //
    public String getName() { // Returns the name of the pet.
        return this.name;
    }

    public int getAttackPower() { // Returns the attack power of the pet.
        return this.attackPower;
    }


  //
  // Other methods
  //

}
