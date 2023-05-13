package com.example.test_javafx.characters;

import  com.example.test_javafx.spells.Spell;
import  com.example.test_javafx.wizarding.House;
import  com.example.test_javafx.wizarding.Pet;
import  com.example.test_javafx.wizarding.Potion;
import  com.example.test_javafx.wizarding.Wand;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

/**
 * Class Wizard
 * This class represents a wizard character in the game.
 * It extends the Character class and adds fields and methods specific to wizards.
 */
public class Wizard extends Character {

    //
    // Fields
    //

    private Pet pet; // the wizard's pet
    private Wand wand; // the wizard's wand
    private House house; // the wizard's house
    private @Getter @Setter float precision; // the wizard's precision
    private ArrayList<Spell> knownSpells = new ArrayList<>(); // the spells the wizard knows
    private ArrayList<Potion> potions = new ArrayList<>(); // the potions the wizard has

    //
    // Constructors
    //

    /**
     * Constructor for Wizard class.
     * @param name the name of the wizard
     * @param health the health of the wizard
     * @param shield the shield of the wizard
     * @param attackPower the attack power of the wizard
     * @param precision the precision of the wizard
     * @param pet the wizard's pet
     * @param wand the wizard's wand
     * @param house the wizard's house
     */
    @Builder
    public Wizard(String name, float health, float shield, float attackPower, float precision, Pet pet, Wand wand, House house) {
        super(name, health, shield, attackPower);
        this.pet = pet;
        this.wand = wand;
        this.house = house;
        this.precision = precision;
    }


    @Override
    public float attack() {
        return 0;
    }

    //
    // Methods
    //

    /**
     * Method to calculate the wizard's attack power when using a spell.
     * @param spellUsed the spell used by the wizard
     * @return the wizard's attack power plus the damage of the spell
     */
    @Override
    public float attack(Spell spellUsed) {
        return attackPower + spellUsed.getDamage();
    }

    /**
     * Method to get the wizard's shield value.
     * @return the wizard's shield value
     */
    public float defend() {
        return shield;
    }


    //
    // Accessor methods
    //

    /**
     * Set the value of pet.
     * @param newVar the new value of pet
     */
    public void setPet(Pet newVar) {
        pet = newVar;
    }

    /**
     * Get the value of pet.
     * @return the value of pet
     */
    public Pet getPet() {
        return pet;
    }

    /**
     * Set the value of wand.
     * @param newVar the new value of wand
     */
    public void setWand(Wand newVar) {
        wand = newVar;
    }

    /**
     * Get the value of wand.
     * @return the value of wand
     */
    public Wand getWand() {
        return wand;
    }

    /**
     * Set the value of house.
     * @param newVar the new value of house
     */
    public void setHouse(House newVar) {
        house = newVar;
    }

    /**
     * Get the value of house.
     *
     * @return the value of house
     */
    public House getHouse() {
        return house;
    }

    /**
     * Method to add a spell to the wizard's known spells.
     *
     * @param spell the spell to add
     */
    public void setKnownSpells(Spell spell) {
        this.knownSpells.add(spell);
    }

    /**
     * Method to get the wizard's known spells.
     *
     * @return an array of the wizard's known spells
     */
    public Spell[] getKnownSpells() {
        return knownSpells.toArray(new Spell[knownSpells.size()]);
    }

    /**
     * Method to add a potion to the wizard's potions.
     *
     * @param potion the potion to add
     */
    public void setPotions(Potion potion) {
        this.potions.add(potion);
    }

    /**
     * Method to get the wizard's potions.
     *
     * @return an ArrayList of the wizard's potions
     */
    public ArrayList<Potion> getPotions() {
        return potions;
    }


    //
    // Other methods
    //

    /**
     * Method to remove a potion from the wizard's potions.
     *
     * @param potionType the type of potion to remove
     */
    public void removePotion(String potionType) {
        //get the first potion of the array with a name matching potionType
        potions.stream().filter(potion -> potion.getName().equals(potionType)).findFirst().ifPresent(potionToRemove -> potions.remove(potionToRemove));
    }

}
