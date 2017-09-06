
package wg.gol;

import java.awt.Graphics;
import java.awt.Point;

/**
 * An interface for objects that can be drawn.
 * @author Wesley Garey
 */
public interface Drawable {
  /**
   * Draws the object.
   * @param g The graphics to draw with.
   * @param startingPoint The starting point.
   */
  public void draw(Graphics g, Point startingPoint);
}
