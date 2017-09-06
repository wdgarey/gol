
package wg.gol;

/**
 * A class used to create BasicCells.
 * @author Wesley Garey
 */
public class BasicCellFactory implements CellFactory {
  /**
   * Creates an instance of the 
   */
  public BasicCellFactory() {
  }
  /**
   * Creates a basic cell.
   * @return The newly created cell.
   */
  @Override
  public Cell createCell() {
    return new BasicCell();
  }
}
