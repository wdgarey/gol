
package wg.gol;

import java.util.Random;

/**
 * A class used to create BasicCells.
 * @author Wesley Garey
 */
public class BasicCellFactory implements CellFactory {
  /**
   * The maximum age that a cell can have.
   */
  private int mMaxAge;
  /**
   * A random number generator.
   */
  private Random mRnd;
  /**
   * Gets the maximum age that a cell can have.
   * @return The maximum age.
   */
  public int getMaxAge() {
    return this.mMaxAge;
  }
  /**
   * Gets the random number generator.
   * @return The random number generator.
   */
  public Random getRnd() {
    return this.mRnd;
  }
  /**
   * Sets the maximum age of a cell.
   * @param maxAge The maximum age.
   */
  public void setMaxAge(int maxAge) {
    this.mMaxAge = maxAge;
  }
  /**
   * Sets the random number generator.
   * @param rnd The random number generator.
   */
  public void setRnd(Random rnd) {
    this.mRnd = rnd;
  }
  /**
   * Creates an instance of the 
   */
  public BasicCellFactory() {
    this.mMaxAge = 0;
    this.mRnd = new Random();
  }
  /**
   * Creates a basic cell.
   * @return The newly created cell.
   */
  @Override
  public BasicCell createCell() {
    Random rnd = this.getRnd();
    BasicCell cell = new BasicCell();
    CellAppearance appearance = new BasicAppearanceLegendDecorator(new BasicCellAppearance());
    CellRules rules = new CellRules();
    int maxAge = this.getMaxAge();
    cell.setMaxAge(maxAge);
    cell.setAppearance(appearance);
    cell.setRules(rules);
    if (rnd.nextBoolean()) {
      cell.setCurrState(CellStateAlive.getInstance());
    } else {
      cell.setCurrState(CellStateDead.getInstance());
    }
    return cell;
  }
}
