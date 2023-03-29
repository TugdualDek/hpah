package kerdrel.tugdual.characters;

import kerdrel.tugdual.wizarding.Potion;
import kerdrel.tugdual.spells.Spell;
import kerdrel.tugdual.wizarding.House;
import kerdrel.tugdual.wizarding.Pet;
import kerdrel.tugdual.wizarding.Wand;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.*;


/**
 * Class Wizard
 */
public class Wizard extends Character {

    //
    // Fields
    //

    private Pet pet;
    private Wand wand;
    private House house;
    private @Getter
    @Setter float precision;
    private ArrayList<Spell> knownSpells = new ArrayList<>();
    private ArrayList<Potion> potions = new ArrayList<>();

    //
    // Constructors
    //

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
    @Override
    public float attack(Spell spellUsed) {
        return attackPower + spellUsed.getDamage();
    }

    public float defend() {
        return shield;
    }


    //
    // Accessor methods
    //

    /**
     * Set the value of pet
     *
     * @param newVar the new value of pet
     */
    public void setPet(Pet newVar) {
        pet = newVar;
    }

    /**
     * Get the value of pet
     *
     * @return the value of pet
     */
    public Pet getPet() {
        return pet;
    }

    /**
     * Set the value of wand
     *
     * @param newVar the new value of wand
     */
    public void setWand(Wand newVar) {
        wand = newVar;
    }

    /**
     * Get the value of wand
     *
     * @return the value of wand
     */
    public Wand getWand() {
        return wand;
    }

    /**
     * Set the value of house
     *
     * @param newVar the new value of house
     */
    public void setHouse(House newVar) {
        house = newVar;
    }

    /**
     * Get the value of house
     *
     * @return the value of house
     */
    public House getHouse() {
        return house;
    }

    public void setKnownSpells(Spell spell) {
        this.knownSpells.add(spell);
    }

    /**
     * Get the value of knownSpells
     *
     * @return the value of knownSpells
     */
    public Spell[] getKnownSpells() {
        return knownSpells.toArray(new Spell[knownSpells.size()]);
    }


    public void setPotions(Potion potion) {
        this.potions.add(potion);
    }

    /**
     * Get the value of potions
     *
     * @return the value of potions
     */
    public ArrayList<Potion> getPotions() {
        return potions;
    }


    //
    // Other methods
    //
    public void removePotion(String potionType) {
        //get the first potion of the array with a name matching potionType
        potions.stream().filter(potion -> potion.getName().equals(potionType)).findFirst().ifPresent(potionToRemove -> potions.remove(potionToRemove));
    }

}
