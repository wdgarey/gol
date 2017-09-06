
package wg.gol;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

/**
 * A class used to decorate the BasicAppearance class.
 * @author Wesley Garey
 */
public abstract class BasicAppearanceDecorator extends BasicAppearance {
  /**
   * Gets the subject being decorated.
   * @return The subject.
   */
  public abstract BasicAppearance getSubj();
  /**
   * Creates an instance of the BasicAppearanceDecorator class.
   */
  public BasicAppearanceDecorator() {
  }
  /**
   * Gets the base color.
   * @return The base color.
   */
  @Override
  public Color getBaseColor() {
    return this.getSubj().getBaseColor();
  }
  /**
   * Gets the color of the appearance.
   * @return The color.
   */
  @Override
  protected Color getColor() {
    return this.getSubj().getColor();
  }
  /**
   * Gets the location of the appearance.
   * @return The location.
   */
  @Override
  public Point getLocation() {
    return this.getSubj().getLocation();
  }
  /**
   * Gets the maximum size of the cell.
   * @return The maximum size.
   */
  @Override
  public Dimension getMaxSize() {
    return this.getSubj().getMaxSize();
  }
  /**
   * Gest the size of the appearance.
   * @return The size.
   */
  @Override
  protected Dimension getSize() {
    return this.getSubj().getSize();
  }
  /**
   * Gets the flag that indicates if this appearance is visible.
   * @return The flag.
   */
  @Override
  public boolean getVisible() {
    return this.getSubj().getVisible();
  }
  /**
   * Sets the base color.
   * @param baseColor The base color.
   */
  @Override
  public void setBaseColor(Color baseColor) {
    this.getSubj().setBaseColor(baseColor);
  }
  /**
   * Sets the color.
   * @param color The color.
   */
  @Override
  protected void setColor(Color color) {
    this.getSubj().setColor(color);
  }
  /**
   * Sets the location of the appearance.
   * @param location The location.
   */
  @Override
  public void setLocation(Point location) {
    this.getSubj().setLocation(location);
  }
  /**
   * Sets the maximum size.
   * @param maxSize The maximum size.
   */
  @Override
  public void setMaxSize(Dimension maxSize) {
    this.getSubj().setMaxSize(maxSize);
  }
  /**
   * Sets the size.
   * @param size The size.
   */
  @Override
  protected void setSize(Dimension size) {
    this.getSubj().setSize(size);
  }
  /**
   * Sets the flag that indicates if this appearance is visible.
   * @param visible The flag.
   */
  @Override
  public void setVisible(boolean visible) {
    this.getSubj().setVisible(visible);
  }
  /**
   * Creates a clone of this instance.
   * @return The clone.
   */
  @Override
  public BasicAppearance copy() {
    return this.getSubj().copy();
  }
  /**
   * Draws the appearance.
   * @param g The graphics to draw with.
   * @param startingPoint The starting point.
   */
  @Override
  public void draw(Graphics g, Point startingPoint) {
    this.getSubj().draw(g, startingPoint);
  }
  /**
   * Indicates whether or not this appearance is visible.
   * @return True, if this appearance is visible.
   */
  @Override
  public boolean isVisible() {
    return this.getSubj().isVisible();
  }
  /**
   * Updates the appearance based on the cell.
   * @param cell The appearance.
   */
  @Override
  public void update(BasicCell cell) {
    this.getSubj().update(cell);
  }
}
