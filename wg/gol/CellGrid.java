
package wg.gol;

import java.awt.Point;

/**
 * An interface used to represent a cell grid.
 * @author Wesley Garey
 */
public interface CellGrid extends Drawable {
  /**
   * Counts the number of living cells around the given location.
   * @param loc The given location.
   * @return The number of living cells.
   */
  public int countLivingNeighbors(Point loc);
  /**
   * Gets the cell located a particular location.
   * @param loc The location.
   * @return The cell.
   */
  public Cell getCell(Point loc);
  /**
   * Initializes the grid of cells.
   */
  public void initialize();
  /**
   * Perdures the grid of cells by one time step.
   */
  public void perdure();
  /**
   * Sets the cell at a particular location.
   * @param loc The location.
   * @param cell The cell.
   */
  public void setCell(Point loc, Cell cell);
  /**
   * Sets the factory used to create cells.
   * @param cellFac The factory.
   */
  public void setCellFac(CellFactory cellFac);
  /**
   * Sets the cell settings.
   * @param settings The settings.
   */
  public void setCellSettings(CellSettings settings);
  /**
   * Sets the number of columns.
   * @param cols The number of columns.
   */
  public void setCols(int cols);
  /**
   * Sets the number of rows.
   * @param rows The number of rows.
   */
  public void setRows(int rows);
}