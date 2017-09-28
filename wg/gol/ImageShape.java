
package wg.gol;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

/**
 * A class used to represent an image shape.
 * @author Wesley Garey
 */
public class ImageShape implements Shape {
		/**
			* The image.
			*/
		private Image mImg;
		/**
			* The location of the shape.
			*/
		private Point mLocation;
		/**
			* The size of the shape.
			*/
		private Dimension mSize;
		/**
			* Gets the image.
			* @return The image.
			*/
		public Image getImg() {
				return this.mImg;
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
			* Sets the image.
			* @param img The image.
			*/
		public void setImg(Image img) {
				this.mImg = img;
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
		public ImageShape() {
				this.mImg = null;
				this.mLocation = new Point();
				this.mSize = new Dimension();
		}
		/**
			* Draws the image shape.
			* @param g The graphics to use.
			*/
		@Override
		public void draw(Graphics g) {
				Image img = this.getImg();
				Point location = this.getLocation();
				Dimension size = this.getSize();
				int x = location.x;
				int y = location.y;
				int width = size.width;
				int height = size.height;
				g.drawImage(img, x, y, width, height, null);
		}
}
