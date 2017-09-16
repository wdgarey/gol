
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
						CellStateDead.sInstance.setAliveState(CellStateAlive.getInstance());
						CellStateDead.sInstance.setLook(NullAppearance.getInstance());
    }
    return CellStateDead.sInstance;
  }
		/**
			* The alive state to use.
			*/
		private CellState mAliveState;
  /**
   * The appearance to assign to live cells.
   */
  private CellAppearance mLook;
		/**
			* Gets the alive state to use.
			* @return The alive state.
			*/
		public CellState getAliveState() {
				return this.mAliveState;
		}
  /**
   * Gets the appearance of live cells.
   * @return The appearance.
   */
  public CellAppearance getLook() {
    return this.mLook;
  }
		/**
			* Sets the alive state to use.
			* @param aliveState The alive state.
			*/
		public void setAliveState(CellState aliveState) {
				this.mAliveState = aliveState;
		}
  /**
   * Sets the appearance of live cells.
   * @param look The appearance.
   */
  public void setLook(CellAppearance look) {
    this.mLook = look;
  }
  /**
   * Creates an instance of the CellStateDead class.
   */
  protected CellStateDead() {
    this.mLook = null;
				this.mAliveState = null;
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
				CellState aliveCellState = this.getAliveState();
    int livingNeighbors = cellParent.countLivingNeighbors(cellLoc);
    boolean shouldLive = cellRules.shouldDeadCellLive(livingNeighbors);
    if (shouldLive == true) {
      cell.setNextState(aliveCellState);
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
    CellAppearance cellLook = this.getLook();
    cell.setAppearance(cellLook);
    cell.resetAge();
  }
}
