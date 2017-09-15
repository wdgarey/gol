
package wg.gol;

import java.awt.Point;

/**
 *
 * @author Wesley Garey
 */
public class CellStateAliveUninfected extends CellStateAlive {
  /**
   * The static instance.
   */
  private static CellStateAliveUninfected sInstance;
  /**
   * Gets the static instance.
   * @return The static instance.
   */
  public static CellStateAliveUninfected getInstance() {
    if (CellStateAliveUninfected.sInstance == null) {
      CellStateAliveUninfected.sInstance = new CellStateAliveUninfected();
    }
    return CellStateAliveUninfected.sInstance;
  }
		/**
			* Creates an instance of the CellStateAliveUninfected class.
			*/
		public CellStateAliveUninfected() {
				super();
		}
		/**
			* Determines the next state of the cell.
			* @param cell The next state.
			*/
		@Override
		public void determineNextState(Cell cell) {
				super.determineNextState(cell);
				boolean isNeighborInfected = false;
				Point cellLoc = cell.getLocation();
				CellGrid cellParent = cell.getParent();
				CellState cellState = cell.getNextState();
				Iterable<Cell> cellNeighbors = cellParent.getNeighbors(cellLoc);
				if (cellState == CellStateDead.getInstance()) {
						cell.setNextState(CellStateDeadUninfected.getInstance());
				} else if (cellState == this) {
						for (Cell cellNeighbor : cellNeighbors) {
								if (cellNeighbor.getCurrState() == CellStateAliveInfected.getInstance()) {
										isNeighborInfected = true;
								}
						}
						if (isNeighborInfected == true) {
								cell.setNextState(CellStateAliveInfected.getInstance());
						} else {
								cell.setNextState(this);
						}
				}
		}
}
