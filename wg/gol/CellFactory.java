
package wg.gol;

/**
 * An interface used to create cells.
 * @author Wesley Garey
 */
public interface CellFactory {
  /**
   * Creates a cell.
   * @return The newly created cell.
   */
  public Cell createCell();
}
