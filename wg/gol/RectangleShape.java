
package wg.gol;

import java.awt.Graphics;

/**
 * A class used to represent the rectangle shape.
 * @author Wesley Garey
 */
public class RectangleShape extends BasicShape {
		/**
			* Creates an instance of the rectangle shape.
			*/
		public RectangleShape() {
		}
		/**
			* Draws the filled-in rectangle.
			* @param g The graphics to draw with.
			* @param x The x-coordinate.
			* @param y The y-coordinate.
			* @param width The width.
			* @param height The height.
			*/
		@Override
		public void fill(Graphics g, int x, int y, int width, int height) {
				g.fillRect(x, y, width, height);
		}
		/**
			* Draws the outlined rectangle.
			* @param g The graphics to draw with.
			* @param x The x-coordinate.
			* @param y The y-coordinate.
			* @param width The width.
			* @param height The height.
			*/
		@Override
		public void outline(Graphics g, int x, int y, int width, int height) {
				g.drawRect(x, y, width, height);
		}
}
