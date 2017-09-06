
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
  public Point getLocation() {
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
   * Gest the size of the appearance.
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
  public void setLocation(Point location) {
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
   * Sets the size.
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
    this.mLocation = null;
    this.mMaxSize = null;
    this.mSize = new Dimension(0, 0);
    this.mVisible = true;
  }
  /**
   * Creates a clone of this instance.
   * @return The clone.
   */
  @Override
  public BasicAppearance copy() {
    Point myLocation = this.getLocation();
    Color myBaseColor = this.getBaseColor();
    Color myColor = this.getColor();
    Dimension mySize = this.getSize();
    Dimension myMaxSize = this.getMaxSize();
    Color theirColor = new Color(myColor.getRed(),
            myColor.getGreen(),
            myColor.getBlue(),
            myColor.getAlpha());
    boolean theirVisible = this.getVisible();
    Point theirLocation = new Point(myLocation);
    Color theirBaseColor = new Color(myBaseColor.getRed(),
            myBaseColor.getGreen(),
            myBaseColor.getBlue(),
            myBaseColor.getAlpha());
    Dimension theirSize = new Dimension(mySize);
    Dimension theirMaxSize = new Dimension(myMaxSize);
    BasicAppearance clone = new BasicAppearance();
    clone.setBaseColor(theirBaseColor);
    clone.setColor(theirColor);
    clone.setLocation(theirLocation);
    clone.setMaxSize(theirMaxSize);
    clone.setSize(theirSize);
    clone.setVisible(theirVisible);
    return clone;
  }
  /**
   * Draws the appearance.
   * @param g The graphics to draw with.
   * @param startingPoint The starting point.
   */
  @Override
  public void draw(Graphics g, Point startingPoint) {
    if (this.isVisible()) {
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
      g.setColor(color);
      g.drawOval(x, y, width, height);
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
