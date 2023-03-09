package kerdrel.tugdual;

/**
 * Class Wand
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
  public Wand () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of size
   * @param newVar the new value of size
   */
  public void setSize (int newVar) {
    size = newVar;
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
   * @param newVar the new value of core
   */
  public void setCore (Core newVar) {
    core = newVar;
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
