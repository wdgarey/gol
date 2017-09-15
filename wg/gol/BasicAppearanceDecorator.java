
package wg.gol;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

/**
 * A class used to decorate the BasicCellAppearance class.
 * @author Wesley Garey
 */
public abstract class BasicAppearanceDecorator extends BasicCellAppearance {
  /**
   * Gets the subject being decorated.
   * @return The subject.
   */
  public abstract BasicCellAppearance getSubj();
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
    * Gets the shape of the appearance.
    * @return The shape.
    */
  @Override
  public Shape getShape() {
      return this.getSubj().getShape();
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
    * Sets the shape of the appearance.
    * @param shape The shape.
    */
  @Override
  public void setShape(Shape shape) {
      this.getSubj().setShape(shape); //To change body of generated methods, choose Tools | Templates.
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
   * Updates the appearance based on the cell.
   * @param cell The appearance.
   */
  @Override
  public void update(BasicCell cell) {
    this.getSubj().update(cell);
  }
}
