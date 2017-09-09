
package wg.gol;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

/**
 * A class that represents a basic appearance.
 * @author Wesley Garey
 */
public class BasicAppearance implements Appearance {
  /**
   * The base color of the appearance.
   */
  private Color mBaseColor;
  /**
   * The color of the appearance.
   */
  private Color mColor;
		/**
			* The location of the appearance.
			*/
		private Point mLocation;
  /**
   * The maximum size that the cell can be.
   */
  private Dimension mMaxSize;
		/**
			* The shape of the basic appearance.
			*/
		private Shape mShape;
		/**
			* The size of the appearance.
			*/
		private Dimension mSize;
  /**
   * The flag that indicates if this appearance is visible.
   */
  private boolean mVisible;
  /**
   * Gets the base color.
   * @return The base color.
   */
  public Color getBaseColor() {
    return this.mBaseColor;
  }
  /**
   * Gets the color of the appearance.
   * @return The color.
   */
  protected Color getColor() {
    return this.mColor;
  }
		/**
			* Gets the location of the appearance.
			* @return The location.
			*/
		protected Point getLocation() {
				return this.mLocation;
		}
  /**
   * Gets the maximum size of the cell.
   * @return The maximum size.
   */
  public Dimension getMaxSize() {
    return this.mMaxSize;
  }
		/**
			* Gets the shape of the appearance.
			* @return The shape.
			*/
		public Shape getShape() {
				return this.mShape;
		}
		/**
			* Gets the size of the appearance.
			* @return The size.
			*/
		protected Dimension getSize() {
				return this.mSize;
		}
  /**
   * Gets the flag that indicates if this appearance is visible.
   * @return The flag.
   */
  public boolean getVisible() {
    return this.mVisible;
  }
  /**
   * Sets the base color.
   * @param baseColor The base color.
   */
  public void setBaseColor(Color baseColor) {
    this.mBaseColor = baseColor;
  }
  /**
   * Sets the color.
   * @param color The color.
   */
  protected void setColor(Color color) {
    this.mColor = color;
  }
		/**
			* Sets the location of the appearance.
			* @param location The location.
			*/
		protected void setLocation(Point location) {
				this.mLocation = location;
		}
  /**
   * Sets the maximum size.
   * @param maxSize The maximum size.
   */
  public void setMaxSize(Dimension maxSize) {
    this.mMaxSize = maxSize;
  }
  /**
   * Sets the shape.
   * @param shape The shape.
   */
  public void setShape(Shape shape) {
    this.mShape = shape;
  }
		/**
			* Sets the size of the appearance.
			* @param size The size.
			*/
		protected void setSize(Dimension size) {
				this.mSize = size;
		}
  /**
   * Sets the flag that indicates if this appearance is visible.
   * @param visible The flag.
   */
  @Override
  public void setVisible(boolean visible) {
    this.mVisible = visible;
  }
  /**
   * Creates an instance of the BasicAppearance class.
   */
  public BasicAppearance(){
    this.mBaseColor = Color.BLUE;
    this.mColor = Color.BLUE;
				this.mLocation = new Point();
    this.mMaxSize = new Dimension();
				this.mShape = new OvalShape();
				this.mSize = new Dimension();
    this.mVisible = true;
  }
  /**
   * Creates a clone of this instance.
   * @return The clone.
   */
  @Override
  public BasicAppearance copy() {
    BasicAppearance clone = new BasicAppearance();
				clone.copy(this);
    return clone;
  }
		/**
			* Copies the attributes of another basic appearance.
			* @param appearance The basic appearance.
			*/
		protected void copy(BasicAppearance appearance) {
    Color theirBaseColor = appearance.getBaseColor();
    Color theirColor = appearance.getColor();
				Point theirLocation = appearance.getLocation();
    Dimension theirMaxSize = appearance.getMaxSize();
				Shape theirShape = appearance.getShape();
				Dimension theirSize = appearance.getSize();
    Color myColor = new Color(theirColor.getRed(),
            theirColor.getGreen(),
            theirColor.getBlue(),
            theirColor.getAlpha());
    boolean myVisible = appearance.getVisible();
    Color myBaseColor = new Color(theirBaseColor.getRed(),
            theirBaseColor.getGreen(),
            theirBaseColor.getBlue(),
            theirBaseColor.getAlpha());
				Point myLocation = new Point(theirLocation);
    Dimension myMaxSize = new Dimension(theirMaxSize);
				Shape myShape = theirShape.copy();
				Dimension mySize = new Dimension(theirSize);
    this.setBaseColor(myBaseColor);
    this.setColor(myColor);
				this.setLocation(myLocation);
    this.setMaxSize(myMaxSize);
				this.setShape(myShape);
				this.setSize(mySize);
    this.setVisible(myVisible);
		}
  /**
   * Draws the appearance.
   * @param g The graphics to draw with.
   * @param startingPoint The starting point.
   */
  @Override
  public void draw(Graphics g, Point startingPoint) {
    if (this.isVisible()) {
						Shape shape = this.getShape();
      Color color = this.getColor();
      Dimension size = this.getSize();
      Point location = this.getLocation();
      Dimension maxSize = this.getMaxSize();
      int x = (startingPoint.x + (location.x * maxSize.width));
      int y = (startingPoint.y + (location.y * maxSize.height));
						x += ((maxSize.width - size.width) / 2);
						y += ((maxSize.height - size.height) / 2);
      int width = size.width;
      int height = size.height;
						shape.setLocation(new Point(x, y));
						shape.setSize(new Dimension(width, height));
      g.setColor(color);
						shape.draw(g, new Point(0, 0));
    }
  }
  /**
   * Indicates whether or not this appearance is visible.
   * @return True, if this appearance is visible.
   */
  public boolean isVisible() {
    boolean isVisible = this.getVisible();
    return isVisible;
  }
  /**
   * Updates the appearance based on the cell.
   * @param cell The appearance.
   */
  @Override
  public void update(BasicCell cell) {
    Color baseColor = this.getBaseColor();
    Dimension maxSize = this.getMaxSize();
    int alpha = (cell.isAlive() ? 255 : 0);
    Dimension size = new Dimension(maxSize);
    Color color = new Color(baseColor.getRed(),
            baseColor.getGreen(),
            baseColor.getBlue(),
            alpha);
    Point location = new Point(cell.getLocation());
    this.setLocation(location);
    this.setColor(color);
    this.setSize(size);
  }
}
