
package wg.gol;

import java.util.Random;

/**
 * A class used to create basic cells that can be infected.
 * @author Wesley Garey
 */
public class BasicCellInfectedFactory extends BasicCellFactory {
		/**
			* The infection rate.
			*/
		private double mInfectionRate;
		/**
			* Gets the infection rate.
			* @return The infection rate.
			*/
		public double getInfectionRate() {
				return this.mInfectionRate;
		}
		/**
			* Sets the infection rate.
			* @param infectionRate The infection rate.
			*/
		public void setInfectionRate(double infectionRate) {
				this.mInfectionRate = infectionRate;
		}
		/**
			* Creates an instance of the BasicCellInfectedFactory class.
			*/
		public BasicCellInfectedFactory() {
				super();
				this.mInfectionRate = 0.02;
		}
		/**
			* Creates basic cells that can be infected.
			* @return The newly create cell.
			*/
		@Override
		public BasicCell createCell() {
				Random rnd = this.getRnd();
				double infectionRate = this.getInfectionRate();
				BasicCell cell = super.createCell();
				double x = rnd.nextDouble();
				if (cell.getCurrState() == CellStateAlive.getInstance()) {
						cell.setCurrState(CellStateAliveUninfected.getInstance());
				}
				if (x <= infectionRate) {
						cell.setCurrState(CellStateAliveInfected.getInstance());
				}
				return cell;
		}
}
