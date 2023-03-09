package kerdrel.tugdual;

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
  private ArrayList<Spell> knownSpells;
  private ArrayList<Potion> potions;
  
  //
  // Constructors
  //
  public Wizard () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of pet
   * @param newVar the new value of pet
   */
  public void setPet (Pet newVar) {
    pet = newVar;
  }

  /**
   * Get the value of pet
   * @return the value of pet
   */
  public Pet getPet () {
    return pet;
  }

  /**
   * Set the value of wand
   * @param newVar the new value of wand
   */
  public void setWand (Wand newVar) {
    wand = newVar;
  }

  /**
   * Get the value of wand
   * @return the value of wand
   */
  public Wand getWand () {
    return wand;
  }

  /**
   * Set the value of house
   * @param newVar the new value of house
   */
  public void setHouse (House newVar) {
    house = newVar;
  }

  /**
   * Get the value of house
   * @return the value of house
   */
  public House getHouse () {
    return house;
  }

  public void setKnownSpells () {

  }

  /**
   * Get the value of knownSpells
   * @return the value of knownSpells
   */
  public ArrayList<Spell> getKnownSpells () {
    return knownSpells;
  }


  public void setPotions () {

  }

  /**
   * Get the value of potions
   * @return the value of potions
   */
  public ArrayList<Potion> getPotions () {
    return potions;
  }

  //
  // Other methods
  //

}
