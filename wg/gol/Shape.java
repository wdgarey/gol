
package wg.gol;

import java.awt.Dimension;
import java.awt.Point;

/**
 * A class used to represent a shape.
 * @author Wesley Garey
 */
public interface Shape extends Drawable {
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
