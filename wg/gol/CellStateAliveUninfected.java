
package wg.gol;

import java.awt.Point;

/**
 * A class used to represent the state of an alive, uninfected cell.
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
						CellStateAliveUninfected.sInstance.setDeadState(CellStateDead.getInstance());
						CellStateAliveUninfected.sInstance.setInfectedState(CellStateAliveInfected.getInstance());
						CellStateAliveUninfected.sInstance.setLook(new BasicAppearanceSizeDecorator(new BasicAppearanceLegendDecorator(new BasicCellAppearance())));
    }
    return CellStateAliveUninfected.sInstance;
  }
		/**
			* The state to use for an infected cell.
			*/
		private CellState mInfectedState;
		/**
			* Gets the state to use for an infected cell.
			* @return The state.
			*/
		public CellState getInfectedState() {
				return this.mInfectedState;
		}
		/**
			* Sets the state to use for an infected cell.
			* @param infectedState The state.
			*/
		public void setInfectedState(CellState infectedState) {
				this.mInfectedState = infectedState;
		}
		/**
			* Creates an instance of the CellStateAliveUninfected class.
			*/
		public CellStateAliveUninfected() {
				super();
				this.mInfectedState = null;
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
				CellState infectedCellState = this.getInfectedState();
				Iterable<Cell> cellNeighbors = cellParent.getNeighbors(cellLoc);
				if (cellState == this) {
						for (Cell cellNeighbor : cellNeighbors) {
								if (cellNeighbor.getCurrState() == infectedCellState) {
										isNeighborInfected = true;
								}
						}
						if (isNeighborInfected == true) {
								cell.setNextState(infectedCellState);
						}
				}
		}
}
