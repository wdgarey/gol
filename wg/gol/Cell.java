
package wg.gol;

import java.awt.Point;

/**
 * An interface that represents a cell object.
 * @author Wesley Garey
 */
public interface Cell extends Drawable {
  /**
   * Gets the age of the cell as a percentage.
   * @return The age of the cell as a percentage.
   */
  public double getAgeAsPercentage();
  /**
   * Gets the current state of the cell.
   * @return The state.
   */
  public CellState getCurrState();
  /**
   * Gets the location of the cell.
   * @return The location.
   */
  public Point getLocation();
  /**
   * Gets the next state of the cell.
   * @return The next state.
   */
  public CellState getNextState();
  /**
   * Gets the grid that the cell belongs to.
   * @return The grid.
   */
  public CellGrid getParent();
  /**
   * Gets the rules for the cell to use.
   * @return The rules.
   */
  public CellRules getRules();
  /**
   * Increases the age of the cell.
   */
  public void increaseAge();
  /**
   * Indicates if this cell is alive.
   * @return True, if this cell is alive.
   */
  public boolean isAlive();
  /**
   * Determines the next state of the cell.
   */
  public void determineNextState();
  /**
   * Sets the current state to the next state.
   */
  public void moveToNextState();
  /**
   * Resets the age of the cell.
   */
  public void resetAge();
  /**
   * Sets the appearance of the cell.
   * @param appearance The appearance.
   */
  public void setAppearance(CellAppearance appearance);
  /**
   * Sets the current state of the cell.
   * @param state 
   */
  public void setCurrState(CellState state);
  /**
   * Sets the location of the cell.
   * @param loc The location.
   */
  public void setLocation(Point loc);
  /**
   * Sets the next state of the cell.
   * @param state The next state.
   */
  public void setNextState(CellState state);
  /**
   * Sets the parent of the cell.
   * @param parent The parent.
   */
  public void setParent(CellGrid parent);
}
