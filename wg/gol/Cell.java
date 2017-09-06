
package wg.gol;

import java.awt.Point;

/**
 * An interface that represents a cell object.
 * @author Wesley Garey
 */
public interface Cell extends Drawable {
  /**
   * Accepts the settings.
   * @param settings The cell settings.
   */
  public void accept(CellSettings settings);
  /**
   * Tells the cell to be born.
   */
  public void beBorn();
  /**
   * Tells the cell to die.
   */
  public void die();
  /**
   * Tells the cell to grow.
   */
  public void grow();
  /**
   * Indicates if this cell is alive.
   * @return True, if this cell is alive.
   */
  public boolean isAlive();
  /**
   * Perdures the cell by one time step.
   * @return The new cell.
   */
  public Cell perdure();
  /**
   * Sets the location of the cell.
   * @param loc The location.
   */
  public void setLocation(Point loc);
  /**
   * Sets the parent of the cell.
   * @param parent The parent.
   */
  public void setParent(CellGrid parent);
}
