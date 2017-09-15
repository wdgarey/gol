
package wg.gol;

/**
 * The state of an live cell that is infected.
 * @author Wesley Garey
 */
public class CellStateAliveInfected extends CellStateAlive {
  /**
   * The static instance.
   */
  private static CellStateAliveInfected sInstance;
  /**
   * Gets the static instance.
   * @return The static instance.
   */
  public static CellStateAliveInfected getInstance() {
    if (CellStateAliveInfected.sInstance == null) {
      CellStateAliveInfected.sInstance = new CellStateAliveInfected();
    }
    return CellStateAliveInfected.sInstance;
  }
		/**
			* Creates an instance of the CellStateAliveInfected class.
			*/
		public CellStateAliveInfected() {
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
						cell.setNextState(this);
				} else if (cellState == CellStateDead.getInstance()) {
						cell.setNextState(CellStateDeadUninfected.getInstance());
				}
		}
}
