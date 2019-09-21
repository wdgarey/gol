
package wg.gol;

import java.awt.Dimension;
import java.awt.Point;

/**
 * An interface used to represent a cell grid.
 * @author Wesley Garey
 */
public interface CellGrid extends Drawable {
  /**
   * Perdures the grid of cells by one time step.
   */
  public void advance();
  /**
   * Counts the number of living cells around the given location.
   * @param loc The given location.
   * @return The number of living cells.
   */
  public int countLivingNeighbors(Point loc);
  /**
   * Gets all the cells in the grid.
   * @return The collection of cells.
   */
  public Iterable<Cell> getAllCells();
  /**
   * Gets the cell located a particular location.
   * @param loc The location.
   * @return The cell.
   */
  public Cell getCell(Point loc);
  /**
   * Gets the factory used to create cells.
   * @return The factory.
   */
  public CellFactory getCellFac();
  /**
   * Gets the size of one grid in the cell.
   * @return The size.
   */
  public Dimension getCellSize();
  /**
   * Gets the number of columns in the grid.
   * @return The number of columns.
   */
  public int getCols();
		/**
			* Gets the neighbors of a cell.
			* @param loc The location of the cell.
			* @return The collection of neighbors.
			*/
		public Iterable<Cell> getNeighbors(Point loc);
  /**
   * Gets the number of rows in the grid.
   * @return The number of rows.
   */
  public int getRows();
  /**
   * Initializes the grid of cells.
   */
  public void initialize();
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
   * Sets the size of one cell location.
   * @param cellSize The size.
   */
  public void setCellSize(Dimension cellSize);
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
