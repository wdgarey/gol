
package wg.gol;

/**
 * An interface that represents an appearance.
 * @author Wesley Garey
 */
public interface Appearance extends Drawable {
  /**
   * Clones the appearance.
   * @return The appearance to clone.
   */
  public Appearance copy();
  /**
   * Sets the flag that indicates if the appearance should be visible.
   * @param visible The flag.
   */
  public void setVisible(boolean visible);
  /**
   * Updates appearance based on the cell.
   * @param cell The cell to base the appearance off of.
   */
  public void update(BasicCell cell);
}
