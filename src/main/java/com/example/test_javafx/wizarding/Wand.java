package com.example.test_javafx.wizarding;


/**
 * Class Wand
 * This class represents a wand object used by wizards and witches in the wizarding world.
 * A wand has a size and a core, which determines its magical properties.
 */
public class Wand {

    //
    // Fields
    //

    private int size;
    private Core core;

    //
    // Constructors
    //

    /**
     * Creates a new Wand object with the given core and size.
     *
     * @param core the core of the wand
     * @param size the size of the wand
     */
    public Wand(Core core, int size) {
        this.core = core;
        this.size = size;
    }

    ;

    //
    // Methods
    //


    //
    // Accessor methods
  //

  /**
   * Set the value of size
   * @param size the new value of size
   */
  public void setSize (int size) {
    this.size = size;
  }

  /**
   * Get the value of size
   * @return the value of size
   */
  public int getSize () {
    return size;
  }

  /**
   * Set the value of core
   * @param core the new value of core
   */
  public void setCore (Core core) {
    this.core = core;
  }

  /**
   * Get the value of core
   * @return the value of core
   */
  public Core getCore () {
    return core;
  }

  //
  // Other methods
  //

}
