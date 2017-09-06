
package wg.gol;

/**
 * The rules used for a cell.
 * @author Wesley Garey
 */
public class CellRules {
  /**
   * Creates an instance of the CellRules class.
   */
  public CellRules() {
  }
  /**
   * Clones the cell rules.
   * @return The clone.
   */
  public CellRules copy() {
    return new CellRules();
  }
  /**
   * Indicates if a dead cell should come to life.
   * @param neighbors The number of neighbors that the cell has.
   * @return True, if the dead cell should come to life.
   */
  public boolean shouldDeadCellLive(int neighbors) {
    boolean shouldLive = false;
    if (neighbors == 3) {
      shouldLive = true;
    }
    return shouldLive;
  }
  /**
   * Indicates if a living cell should die.
   * @param neighbors The number of neighbors that the cell has.
   * @return True, if the living cell should die.
   */
  public boolean shouldLiveCellDie(int neighbors) {
    boolean shouldDie = false;
    if (neighbors < 2 || neighbors > 3) {
      shouldDie = true;
    }
    return shouldDie;
  }
}
