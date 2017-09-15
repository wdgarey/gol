
package wg.gol;

import java.util.Random;

/**
 * A class used to create basic cells that can be infected.
 * @author Wesley Garey
 */
public class BasicCellInfectedFactory extends BasicCellFactory {
		/**
			* Creates an instance of the BasicCellInfectedFactory class.
			*/
		public BasicCellInfectedFactory() {
				super();
		}
		/**
			* Creates basic cells that can be infected.
			* @return The newly create cell.
			*/
		@Override
		public BasicCell createCell() {
				Random rnd = this.getRnd();
				BasicCell cell = super.createCell();
				int x = rnd.nextInt(3);
				if (x == 0) {
						cell.setCurrState(CellStateAliveUninfected.getInstance());
				} else if (x == 1) {
						cell.setCurrState(CellStateDeadUninfected.getInstance());
				} else {
						cell.setCurrState(CellStateAliveInfected.getInstance());
				}
				return cell;
		}
}
