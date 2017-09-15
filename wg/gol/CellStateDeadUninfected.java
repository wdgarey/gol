
package wg.gol;

/**
 * A class that represents a dead uninfected cell.
 * @author Wesley Garey
 */
public class CellStateDeadUninfected extends CellStateDead {
  /**
   * The static instance.
   */
  private static CellStateDeadUninfected sInstance;
  /**
   * Gets the static instance.
   * @return The static instance.
   */
  public static CellStateDeadUninfected getInstance() {
    if (CellStateDeadUninfected.sInstance == null) {
      CellStateDeadUninfected.sInstance = new CellStateDeadUninfected();
    }
    return CellStateDeadUninfected.sInstance;
  }
		/**
			* Creates an instance of the CellStateDeadUninfected class.
			*/
		public CellStateDeadUninfected() {
				super();
		}
		/**
			* Determines the next state of the cell.
			* @param cell The next state.
			*/
		@Override
		public void determineNextState(Cell cell) {
				super.determineNextState(cell);
				CellState cellState = cell.getNextState();
				if (cellState == CellStateAlive.getInstance()) {
						cell.setNextState(CellStateAliveUninfected.getInstance());
				}
		}
}
