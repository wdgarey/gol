
package wg.gol;

import java.util.Random;

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
						RectangleShape3D shp = new RectangleShape3D();
						BasicCellAppearance appr = new BasicCellAppearance();
						shp.setFill(true);
						shp.setRaised(true);
						appr.setShape(shp);
      CellStateAliveInfected.sInstance = new CellStateAliveInfected();
						CellStateAliveInfected.sInstance.setDeadState(CellStateDead.getInstance());
						CellStateAliveInfected.sInstance.setLook(new BasicAppearanceSizeDecorator(new BasicAppearanceLegendDecorator(appr)));
						CellStateAliveInfected.sInstance.setRnd(new Random());
						CellStateAliveInfected.sInstance.setSurvivalRate(0.98);
    }
    return CellStateAliveInfected.sInstance;
  }
		/**
			* The random generator to use.
			*/
		private Random mRnd;
		/**
			* Gets the survival rate.
			*/
		private double mSurvivalRate;
		/**
			* Gets the random generator.
			* @return The random generator.
			*/
		public Random getRnd() {
				return this.mRnd;
		}
		/**
			* Gets the survival rate.
			* @return The survival rate.
			*/
		public double getSurvivalRate() {
				return this.mSurvivalRate;
		}
		/**
			* Sets the random generator.
			* @param rnd 
			*/
		public void setRnd(Random rnd) {
				this.mRnd = rnd;
		}
		/**
			* Sets the survival rate.
			* @param survivalRate The survival rate.
			*/
		public void setSurvivalRate(double survivalRate) {
				this.mSurvivalRate = survivalRate;
		}
		/**
			* Creates an instance of the CellStateAliveInfected class.
			*/
		public CellStateAliveInfected() {
				super();
		}
		/**
			* Determines the next state of a cell.
			* @param cell The cell.
			*/
		@Override
		public void determineNextState(Cell cell) {
				Random rnd = this.getRnd();
				CellState deadState = this.getDeadState();
				double survivalRate = this.getSurvivalRate();
				super.determineNextState(cell);
				if (cell.getNextState() == this) {
						if (rnd.nextDouble() > survivalRate) {
								cell.setNextState(deadState);
						}
				}
		}
}
