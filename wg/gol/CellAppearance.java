
package wg.gol;

/**
 * An interface that represents an appearance.
 * @author Wesley Garey
 */
public interface CellAppearance extends Drawable {
  /**
   * Updates appearance based on the cell.
   * @param cell The cell to base the appearance off of.
   */
  public void update(BasicCell cell);
}
