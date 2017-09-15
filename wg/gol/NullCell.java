
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
   * Gets the age as a percentage.
   * @return The percentage.
   */
  @Override
  public double getAgeAsPercentage() {
    return 0;
  }
  /**
   * Gets the current state.
   * @return The current state.
   */
  @Override
  public CellState getCurrState() {
    return null;
  }
  /**
   * Gets the location.
   * @return The location.
   */
  @Override
  public Point getLocation() {
    return null;
  }
  /**
   * Gets the next state.
   * @return The next state.
   */
  @Override
  public CellState getNextState() {
    return null;
  }
  /**
   * Gets the parent.
   * @return The parent.
   */
  @Override
  public CellGrid getParent() {
    return null;
  }
  /**
   * Gets the rules.
   * @return The rules.
   */
  @Override
  public CellRules getRules() {
    return null;
  }
  /**
   * Increases the age.
   */
  @Override
  public void increaseAge() {
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
   * Determines the next state.
   */
  @Override
  public void determineNextState() {
    //Do nothing.
  }
  /**
   * Moves to the next state.
   */
  @Override
  public void moveToNextState() {
    //Do nothing.
  }
  /**
   * Resets the current age.
   */
  @Override
  public void resetAge() {
    //Do nothing.
  }
  /**
   * Sets the appearance.
   * @param appearance The appearance.
   */
  @Override
  public void setAppearance(CellAppearance appearance) {
    //Do nothing.
  }
  /**
   * Sets the current state.
   * @param state The current state.
   */
  @Override
  public void setCurrState(CellState state) {
    //Do nothing.
  }
  /**
   * Sets the location.
   * @param loc The location.
   */
  @Override
  public void setLocation(Point loc) {
    //Do nothing.
  }
  /**
   * Sets the next state.
   * @param state The next state.
   */
  @Override
  public void setNextState(CellState state) {
    //Do nothing.
  }
  /**
   * Sets the parent.
   * @param parent The parent.
   */
  @Override
  public void setParent(CellGrid parent) {
    //Do nothing.
  }
  /**
   * Draws the cell.
   * @param g The graphics to use.
   * @param startingPoint The starting point at which to draw.
   */
  @Override
  public void draw(Graphics g, Point startingPoint) {
    //Do nothing.
  }
}
