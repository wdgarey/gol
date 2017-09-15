
package wg.gol;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

/**
 * A class that represents a basic appearance.
 * @author Wesley Garey
 */
public class BasicCellAppearance implements CellAppearance {
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
   * Creates an instance of the BasicAppearance class.
   */
  public BasicCellAppearance(){
    this.mBaseColor = Color.BLUE;
    this.mColor = Color.BLUE;
    this.mLocation = new Point();
    this.mMaxSize = new Dimension();
		this.mShape = new OvalShape();
		this.mSize = new Dimension();
  }
  /**
   * Draws the appearance.
   * @param g The graphics to draw with.
   * @param startingPoint The starting point.
   */
  @Override
  public void draw(Graphics g, Point startingPoint) {
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
  /**
   * Updates the appearance based on the cell.
   * @param cell The appearance.
   */
  @Override
  public void update(BasicCell cell) {
    Color baseColor = this.getBaseColor();
    CellGrid cellParent = cell.getParent();
    Dimension maxSize = cellParent.getCellSize();
    Dimension size = new Dimension(maxSize);
    Color color = new Color(baseColor.getRed(),
            baseColor.getGreen(),
            baseColor.getBlue());
    Point location = new Point(cell.getLocation());
    this.setColor(color);
    this.setLocation(location);
    this.setMaxSize(maxSize);
    this.setSize(size);
  }
}
