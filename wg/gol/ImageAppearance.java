
package wg.gol;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

/**
 * The appearance of an image.
 * @author Wesley Garey
 */
public class ImageAppearance implements CellAppearance {
		/**
			* The basic appearance.
			*/
		private BasicCellAppearance mAppr;
		/**
			* The shape.
			*/
		private ImageShape mShp;
		/**
			* Gets the basic appearance.
			* @return The basic appearance.
			*/
		public BasicCellAppearance getAppr() {
				return this.mAppr;
		}
		/**
			* Gets the shape.
			* @return The shape.
			*/
		public ImageShape getShp() {
				return this.mShp;
		}
		/**
			* Sets the appearance.
			* @param appr The appearance.
			*/
		public void setAppr(BasicCellAppearance appr) {
				this.mAppr = appr;
		}
		/**
			* Sets the shape.
			* @param shp The shape.
			*/
		public void setShp(ImageShape shp) {
				this.mShp = shp;
		}
		/**
			* Creates an instance of the ImageAppearance.
			*/
		public ImageAppearance() {
				this.mAppr = new BasicCellAppearance();
				this.mShp = new ImageShape();
		}
		/**
			* Creates an instance of the ImageAppearance.
			* @param shp The image.
			*/
		public ImageAppearance(ImageShape shp) {
				this.mAppr = new BasicCellAppearance();
				this.mShp = shp;
		}
		/**
			* Updates the appearance.
			* @param cell The cell to base the appearance off of.
			*/
		@Override
		public void update(BasicCell cell) {
				ImageShape shp = this.getShp();
				BasicCellAppearance appr = this.getAppr();
				appr.setShape(shp);
				appr.update(cell);
		}
		/**
			* Draws the appearance.
			* @param g The graphics to use.
			* @param startingPoint The offset.
			*/
		@Override
		public void draw(Graphics g, Point startingPoint) {
				this.getAppr().draw(g, startingPoint);
		}
}
