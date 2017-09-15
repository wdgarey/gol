
package wg.gol;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

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
   * The size of one cell.
   */
  private Dimension mCellSize;
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
   * Gets the collection of cells.
   * @return The collection of cells.
   */
  public Cell[][] getCells() {
    return this.mCells;
  }
  /**
   * Gets size of one cell location.
   * @return The size.
   */
  @Override
  public Dimension getCellSize() {
    return this.mCellSize;
  }
  /**
   * Gets the number of columns in the grid.
   * @return The number of columns.
   */
  public int getCols() {
    return this.mCols;
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
   * Sets the size of one cell location.
   * @param cellSize The size.
   */
  public void setCellSize(Dimension cellSize) {
    this.mCellSize = cellSize;
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
  }
  /**
   * Perdures the grid of cells by one time step.
   */
  @Override
  public void advance() {
    this.determineNextState();
    this.moveToNextState();
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
   * Determines the next state of the cell grid.
   */
  protected void determineNextState() {
    Cell[][] cells = this.getCells();
    for (Cell[] cellRow : cells) {
      for (Cell cell: cellRow) {
        cell.determineNextState();
      }
    }
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
    for (int rowIdx = 0; rowIdx < rows; rowIdx++) {
      cells[rowIdx] = new Cell[cols];
      for (int colIdx = 0; colIdx < cols; colIdx++) {
        Point loc = new Point(colIdx, rowIdx);
        Cell cell = cellFac.createCell();
        cell.setLocation(loc);
        cell.setParent(this);
        cells[rowIdx][colIdx] = cell;
      }
    }
    this.setCells(cells);
  }
  /**
   * Moves the cell grid to the next state.
   */
  protected void moveToNextState() {
    Cell[][] cells = this.getCells();
    for (Cell[] cellRow : cells) {
      for (Cell cell: cellRow) {
        cell.moveToNextState();
      }
    }
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
