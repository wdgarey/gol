
package wg.gol;

import java.awt.Dimension;
import java.awt.Point;

/**
 * A class used to represent a shape.
 * @author Wesley Garey
 */
public interface Shape extends Drawable {
		/**
			* Copies the shape.
			* @return The copy.
			*/
		public Shape copy();
		/**
			* The flag that Indicates if the shape should be filled in or not.
			* @param fill The flag that indicates if the shape should be filled in or not. 
			*/
		public void setFill(boolean fill);
		/**
			* Sets the location of the shape.
			* @param location The location.
			*/
		public void setLocation(Point location);
		/**
			* Sets the size of the shape.
			* @param size 
			*/
		public void setSize(Dimension size);
}
