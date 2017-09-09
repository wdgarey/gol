
package wg.gol;

import java.awt.Graphics;

/**
 * A class that represents the circle shape.
 * @author Wesley Garey
 */
public class OvalShape extends BasicShape {
		/**
			* Creates an instance of the oval shape.
			*/
		public OvalShape() {
		}
		/**
			* Creates a copy of the oval.
			* @return The copy.
			*/
		@Override
		public OvalShape copy() {
				OvalShape clone = new OvalShape();
				clone.copy(this);
				return clone;
		}
		/**
			* Draws the filled-in oval.
			* @param g The graphics to draw with.
			* @param x The x-coordinate.
			* @param y The y-coordinate.
			* @param width The width.
			* @param height The height.
			*/
		@Override
		public void fill(Graphics g, int x, int y, int width, int height) {
				g.fillOval(x, y, width, height);
		}
		/**
			* Draws the outlined oval.
			* @param g The graphics to draw with.
			* @param x The x-coordinate.
			* @param y The y-coordinate.
			* @param width The width.
			* @param height The height.
			*/
		@Override
		public void outline(Graphics g, int x, int y, int width, int height) {
				g.drawOval(x, y, width, height);
		}
}
