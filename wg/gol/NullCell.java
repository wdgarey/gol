
package wg.gol;

import java.awt.Graphics;
import java.awt.Point;

/**
 * A null cell.
 * @author Wesley Garey
 */
public class NullCell implements Cell {
  /**
   * The static instance of the NullCell class.
   */
  static NullCell sInstance = null;
  /**
   * Gets the static instance of the NullCell class.
   * @return 
   */
  public static NullCell getInstance() {
    if (NullCell.sInstance == null) {
      NullCell.sInstance = new NullCell();
    }
    return NullCell.sInstance;
  }
  /**
   * Creates an instance of the NullCell class.
   */
  protected NullCell(){
  }
  /**
   * Applies the settings to this instance.
   * @param settings The settings to apply.
   */
  @Override
  public void accept(CellSettings settings) {
    //Do nothing.
  }
  /**
   * Tells the cell to be born.
   */
  @Override
  public void beBorn() {
    //Do nothing.
  }
  /**
   * Tells the cell to die.
   */
  @Override
  public void die() {
    //Do nothing.
  }
  /**
   * Draws the cell.
   * @param g The graphics to use.
   * @param startingPoint The starting point.
   */
  @Override
  public void draw(Graphics g, Point startingPoint) {
    //Do nothing.
  }
  /**
   * Tells the cell to grow.
   */
  @Override
  public void grow() {
    //Do nothing.
  }
  /**
   * Indicates if this cell is alive.
   * @return True, if this cell is alive.
   */
  @Override
  public boolean isAlive() {
    return false;
  }
  /**
   * Perdures the cell through time.
   * @return The future cell.
   */
  @Override
  public Cell perdure() {
    return NullCell.getInstance();
  }
  /**
   * Sets the location of the cell.
   * @param loc The location.
   */
  @Override
  public void setLocation(Point loc) {
    //Do nothing.
  }
  /**
   * Sets the parent of the cell.
   * @param parent The parent.
   */
  @Override
  public void setParent(CellGrid parent) {
    //Do nothing.
  }
}
