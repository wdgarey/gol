
package wg.gol;

import java.awt.Point;

/**
 * The state of a dead cell.
 * @author Wesley Garey
 */
public class CellStateDead implements CellState {
  /**
   * The static instance.
   */
  private static CellStateDead sInstance;
  /**
   * Gets the static instance.
   * @return The static instance.
   */
  public static CellStateDead getInstance() {
    if (CellStateDead.sInstance == null) {
      CellStateDead.sInstance = new CellStateDead();
    }
    return CellStateDead.sInstance;
  }
  /**
   * The appearance to assign to live cells.
   */
  private CellAppearance mCellLook;
  /**
   * Gets the appearance of live cells.
   * @return The appearance.
   */
  public CellAppearance getCellLook() {
    return this.mCellLook;
  }
  /**
   * Sets the appearance of live cells.
   * @param cellLook The appearance.
   */
  @Override
  public void setCellLook(CellAppearance cellLook) {
    this.mCellLook = cellLook;
  }
  /**
   * Creates an instance of the CellStateDead class.
   */
  protected CellStateDead() {
    this.mCellLook = NullAppearance.getInstance();
  }
  /**
   * Indicates if the cell is alive.
   * @param cell The cell.
   * @return True, if the cell is alive.
   */
  @Override
  public boolean isAlive(Cell cell) {
    return false;
  }
  /**
   * Determines the next state of the cell.
   * @param cell The cell.
   */
  @Override
  public void determineNextState(Cell cell) {
    Point cellLoc = cell.getLocation();
    CellRules cellRules = cell.getRules();
    CellGrid cellParent = cell.getParent();
    int livingNeighbors = cellParent.countLivingNeighbors(cellLoc);
    boolean shouldLive = cellRules.shouldDeadCellLive(livingNeighbors);
    if (shouldLive == true) {
      cell.setNextState(CellStateAlive.getInstance());
    } else {
						cell.setNextState(this);
				}
  }
  /**
   * Selects this state.
   * @param cell The cell that selected it.
   */
  @Override
  public void selected(Cell cell) {
    CellAppearance cellLook = this.getCellLook();
    cell.setAppearance(cellLook);
    cell.resetAge();
  }
}
