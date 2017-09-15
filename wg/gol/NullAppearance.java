
package wg.gol;

import java.awt.Graphics;
import java.awt.Point;

/**
 * A null appearance.
 * @author Wesley Garey
 */
public class NullAppearance implements CellAppearance {
  /**
   * The static instance of the NullAppearance class.
   */
  private static NullAppearance sInstance;
  /**
   * Gets the static instance of the NullAppearance class.
   * @return The static instance.
   */
  public static NullAppearance getInstance() {
    if (NullAppearance.sInstance == null) {
      NullAppearance.sInstance = new NullAppearance();
    }
    return NullAppearance.sInstance;
  }
  /**
   * Creates an instance of the NullAppearance class.
   */
  protected NullAppearance() {
  }
  /**
   * Updates the appearance based on the cell.
   * @param cell The cell to base the appearance off of.
   */
  @Override
  public void update(BasicCell cell) {
    //Do nothing.
  }
  /**
   * Draws the appearance.
   * @param g The graphics to draw with.
   * @param startingPoint The starting point.
   */
  @Override
  public void draw(Graphics g, Point startingPoint) {
    //Do nothing.
  }
}
