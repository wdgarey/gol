
package wg.gol;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

/**
 * A class that represents a basic shape.
 * @author Wesley Garey
 */
public abstract class BasicShape implements Shape {
		/**
			* The flag that indicates if the shape should be filled in or not.
			*/
		private boolean mFill;
		/**
			* The location of the shape.
			*/
		private Point mLocation;
		/**
			* The size of the shape.
			*/
		private Dimension mSize;
		/**
			* Gets the flag that indicates if the shape should be filled in or not.
			* @return The flag.
			*/
		public boolean getFill() {
				return this.mFill;
		}
		/**
			* Gets the location of the shape.
			* @return The location.
			*/
		public Point getLocation() {
				return this.mLocation;
		}
		/**
			* Gets the size of the shape.
			* @return The size.
			*/
		public Dimension getSize() {
				return this.mSize;
		}
		/**
			* Sets the flag that indicates if the shape should be filled in or not.
			* @param fill The flag.
			*/
		public void setFill(boolean fill) {
				this.mFill = fill;
		}
		/**
			* Sets the location of the shape.
			* @param location The location.
			*/
		@Override
		public void setLocation(Point location) {
				this.mLocation = location;
		}
		/**
			* Sets the size of the shape.
			* @param size The size.
			*/
		@Override
		public void setSize(Dimension size) {
				this.mSize = size;
		}
		/**
			* Creates an instance of the oval shape.
			*/
		public BasicShape() {
				this.mFill = false;
				this.mLocation = new Point();
				this.mSize = new Dimension();
		}
		/**
			* Draws the shape.
			* @param g The graphics to draw with.
			*/
		@Override
		public void draw(Graphics g) {
				Point location = this.getLocation();
				Dimension size = this.getSize();
				int x = location.x;
				int y = location.y;
				int width = size.width;
				int height = size.height;
				if (this.isFilled()) {
						this.fill(g, x, y, width, height);
				}
				this.outline(g, x, y, width, height);
		}
		/**
			* Draws the filled-in shape.
			* @param g The graphics to draw with.
			* @param x The x-coordinate.
			* @param y The y-coordinate.
			* @param width The width.
			* @param height The height.
			*/
		public abstract void fill(Graphics g, int x, int y, int width, int height);
		/**
			* Indicates whether or not the shape should be filled in when drawn.
			* @return True, if the shape should be filled in.
			*/
		public boolean isFilled() {
				boolean isFilled = this.getFill();
				return isFilled;
		}
		/**
			* Draws the outlined shape.
			* @param g The graphics to draw with.
			* @param x The x-coordinate.
			* @param y The y-coordinate.
			* @param width The width.
			* @param height The height.
			*/
		public abstract void outline(Graphics g, int x, int y, int width, int height);
}
