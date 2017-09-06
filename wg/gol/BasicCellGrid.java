
package wg.gol;

import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

/**
 * A basic cell grid.
 * @author Wesley Garey
 */
public class BasicCellGrid implements CellGrid {
  /**
   * The factory used to create cells.
   */
  private CellFactory mCellFac;
  /**
   * The grid of cells.
   */
  private Cell[][] mCells;
  /**
   * The cell settings.
   */
  private CellSettings mCellSettings;
  /**
   * The number of columns in the grid.
   */
  private int mCols;
  /**
   * The number of rows in the grid.
   */
  private int mRows;
  /**
   * Gets the factory used to create cells.
   * @return The factory.
   */
  public CellFactory getCellFac() {
    return this.mCellFac;
  }
  /**
   * Gets the cell settings.
   * @return The cell settings.
   */
  public CellSettings getCellSettings() {
    return this.mCellSettings;
  }
  /**
   * Gets the number of columns in the grid.
   * @return The number of columns.
   */
  public int getCols() {
    return this.mCols;
  }
  /**
   * Gets the collection of cells.
   * @return The collection of cells.
   */
  public Cell[][] getCells() {
    return this.mCells;
  }
  /**
   * Gets the number of rows in the grid.
   * @return The number of rows.
   */
  public int getRows() {
    return this.mRows;
  }
  /**
   * Sets the factory used to create cells.
   * @param cellFac The factory.
   */
  @Override
  public void setCellFac(CellFactory cellFac) {
    this.mCellFac = cellFac;
  }
  /**
   * Sets the collection of cells.
   * @param cells The collection of cells.
   */
  public void setCells(Cell[][] cells) {
    this.mCells = cells;
  }
  /**
   * Sets the cell settings.
   * @param cellSettings The cell settings.
   */
  @Override
  public void setCellSettings(CellSettings cellSettings) {
    this.mCellSettings = cellSettings;
  }
  /**
   * Sets the number of columns in the grid.
   * @param cols The number of columns
   */
  @Override
  public void setCols(int cols) {
    this.mCols = cols;
  }
  /**
   * Sets the number of rows in the grid.
   * @param rows The number of rows.
   */
  @Override
  public void setRows(int rows) {
    this.mRows = rows;
  }
  /**
   * Creates an instance of the BasicCellGrid class.
   */
  public BasicCellGrid() {
    this.mCells = new Cell[0][];
    this.mCellFac = new BasicCellFactory();
    this.mCellSettings = new BasicCellSettings();
  }

  /**
   * Counts the number of living neighbors around the given location.
   * @param loc The given location.
   * @return The number of living cells.
   */
  @Override
  public int countLivingNeighbors(Point loc) {
    int count = 0;
    int startCol = loc.x - 1;
    int startRow = loc.y - 1;
    int stopCol = loc.x + 1;
    int stopRow = loc.y + 1;
    for (int row = startRow; row <= stopRow; row++) {
      for (int col = startCol; col <= stopCol; col++) {
        if (row != loc.y || col != loc.x) {
          Point tempLoc = new Point(col, row);
          Cell tempCell = this.getCell(tempLoc);
          if (tempCell.isAlive()) {
            count += 1;
          }
        }
      }
    }
    return count;
  }
  /**
   * Draws the grid of cells.
   * @param g The graphics to use.
   * @param startingPoint The starting point.
   */
  @Override
  public void draw(Graphics g, Point startingPoint) {
    Cell[][] cells = this.getCells();
    for (Cell[] cellRow : cells) {
      for (Cell cell : cellRow) {
        cell.draw(g, startingPoint);
      }
    }
  }
  /**
   * Gets the cell at the given location.
   * @param loc The given location.
   * @return The cell.
   */
  @Override
  public Cell getCell(Point loc) {
    Cell[][] cells = this.getCells();
    Cell cell = NullCell.getInstance();
    if (loc.y > -1 && loc.y < cells.length) {
      if (loc.x > -1 && loc.x < cells[loc.y].length) {
        cell = cells[loc.y][loc.x];
      }
    }
    return cell;
  }
  /**
   * Initializes the grid of cells.
   */
  @Override
  public void initialize() {
    int rows = this.getRows();
    int cols = this.getCols();
    Cell[][] cells = new Cell[rows][];
    CellFactory cellFac = this.getCellFac();
    Random rnd = new Random();
    CellSettings cellSettings = this.getCellSettings();
    for (int rowIdx = 0; rowIdx < rows; rowIdx++) {
      cells[rowIdx] = new Cell[cols];
      for (int colIdx = 0; colIdx < cols; colIdx++) {
        Point loc = new Point(colIdx, rowIdx);
        Cell cell = cellFac.createCell();
        cell.setLocation(loc);
        cell.setParent(this);
        cell.accept(cellSettings);
        cells[rowIdx][colIdx] = cell;
        if (rnd.nextBoolean()) {
          cell.beBorn();
        }
      }
    }
    this.setCells(cells);
  }
  /**
   * Perdures the grid of cells by one time step.
   */
  @Override
  public void perdure() {
    Cell[][] oldCells = this.getCells();
    Cell[][] newCells = new Cell[oldCells.length][];
    for (int rowIdx = 0; rowIdx < oldCells.length; rowIdx++) {
      Cell[] oldCellRow = oldCells[rowIdx];
      Cell[] newCellRow = new Cell[oldCellRow.length];
      for (int colIdx = 0; colIdx < newCellRow.length; colIdx++) {
        newCellRow[colIdx] = oldCellRow[colIdx].perdure();
      }
      newCells[rowIdx] = newCellRow;
    }
    this.setCells(newCells);
  }
  /**
   * Sets the cell at the given location.
   * @param loc The given location.
   * @param cell The cell.
   */
  @Override
  public void setCell(Point loc, Cell cell) {
    Cell[][] cells = this.getCells();
    if (cells.length > loc.y) {
      if (cells[loc.y].length > loc.x) {
        cells[loc.y][loc.x] = cell;
      }
    }
  }
}
