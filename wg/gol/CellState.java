
package wg.gol;

/**
 * Represents the state of a cell.
 * @author Wesley Garey
 */
public interface CellState {
  /**
   * Indicates if this cell is alive.
   * @param cell The cell.
   * @return True, if this cell is alive.
   */
  public boolean isAlive(Cell cell);
  /**
   * Determines the next state of the cell.
   * @param cell The cell.
   */
  public void determineNextState(Cell cell);
  /**
   * Selects this state for the given cell.
   * @param cell The cell.
   */
  public void selected(Cell cell);
}
