
package wg.gol;

/**
 * A class used to compute statics for a CellGrid.
 * @author Wesley Garey
 */
public class CellGridStatistics {
  /**
   * The grid.
   */
  private CellGrid mGrid;
  /**
   * Gets the grid.
   * @return The grid.
   */
  public CellGrid getGrid() {
    return this.mGrid;
  }
  /**
   * Sets the grid.
   * @param grid The grid.
   */
  public void setGrid(CellGrid grid) {
    this.mGrid = grid;
  }
  /**
   * Creates an instance of the CellGridStatistics class.
   */
  public CellGridStatistics() {
    this.mGrid = null;
  }
  /**
   * Creates an instance of the CellGridStatistics class.
   * @param grid The grid.
   */
  public CellGridStatistics(CellGrid grid) {
    this.mGrid = grid;
  }
  /**
   * Gets the number of dead cells.
   * @return The count.
   */
  public int getDead() {
    int count = 0;
    CellGrid grid = this.getGrid();
    Iterable<Cell> cells = grid.getAllCells();
    for (Cell cell : cells) {
      if (!cell.isAlive()) {
        count += 1;
      }
    }
    return count;
  }
  /**
   * Gets the number of infected cells.
   * @return The count.
   */
  public int getInfected() {
    int count = 0;
    CellGrid grid = this.getGrid();
    Iterable<Cell> cells = grid.getAllCells();
    for (Cell cell : cells) {
      if (cell.getCurrState() == CellStateVirusInfected.getInstance()) {
        count += 1;
      }
    }
    return count;
  }
  /**
   * Gets the number of living cells.
   * @return The count.
   */
  public int getLiving() {
    int count = 0;
    CellGrid grid = this.getGrid();
    Iterable<Cell> cells = grid.getAllCells();
    for (Cell cell : cells) {
      if (cell.isAlive()) {
        count += 1;
      }
    }
    return count;
  }
  /**
   * Gets the total number of cells.
   * @return The count.
   */
  public int getTotal() {
    int count = 0;
    CellGrid grid = this.getGrid();
    Iterable<Cell> cells = grid.getAllCells();
    for (Cell cell : cells) {
      count += 1;
    }
    return count;
  }
}
