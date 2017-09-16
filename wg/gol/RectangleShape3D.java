
package wg.gol;

import java.awt.Graphics;

/**
 * A 3D rectangle shape.
 * @author Wesley Garey
 */
public class RectangleShape3D extends BasicShape {
		/**
			* The flag that indicates if the rectangle is raised (true) or sunk (false).
			*/
		private boolean mRaised;
		/**
			* Gets the flag that indicates if the rectangle is raised (true) or sunk (false).
			* @return The flag.
			*/
		public boolean getRaised() {
				return this.mRaised;
		}
		/**
			* Sets the flag that indicates if the rectangle is raised (true) or sunk (false).
			* @param raised The flag.
			*/
		public void setRaised(boolean raised) {
				this.mRaised = raised;
		}
		/**
			* Creates an instance of the 3D rectangle shape.
			*/
		public RectangleShape3D() {
				this.mRaised = true;
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
				boolean raised = this.getRaised();
				g.fill3DRect(x, y, width, height, raised);
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
				boolean raised = this.getRaised();
				g.draw3DRect(x, y, width, height, raised);
		}
}
