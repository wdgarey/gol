
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
						RectangleShape3D shp = new RectangleShape3D();
						BasicCellAppearance appr = new BasicCellAppearance();
						shp.setFill(true);
						shp.setRaised(true);
						appr.setShape(shp);
      CellStateAliveInfected.sInstance = new CellStateAliveInfected();
						CellStateAliveInfected.sInstance.setDeadState(CellStateDead.getInstance());
						CellStateAliveInfected.sInstance.setLook(new BasicAppearanceSizeDecorator(new BasicAppearanceLegendDecorator(appr)));
    }
    return CellStateAliveInfected.sInstance;
  }
		/**
			* Creates an instance of the CellStateAliveInfected class.
			*/
		public CellStateAliveInfected() {
				super();
		}
}
