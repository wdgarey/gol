
package wg.gol;

import java.util.Random;

/**
 * A class used to create basic cells that can be infected.
 * @author Wesley Garey
 */
public class InfectedCellFactory implements CellFactory {
  /**
   * The infection rate.
   */
   private double mInfectionRate;
  /**
   * A random number generator.
   */
  private Random mRnd;
   /**
    * The factory that produces the cells.
    */
   private CellFactory mSubj;
  /**
   * Gets the infection rate.
   * @return The infection rate.
   */
  public double getInfectionRate() {
    return mInfectionRate;
  }
  /**
   * Gets the random number generator.
   * @return The random number generator.
   */
  public Random getRnd() {
    return mRnd;
  }
  /**
   * Gets the factory that actually creates the cells.
   * 
   * @return The factory.
   */
  public CellFactory getSubj() {
    return mSubj;
  }
  /**
   * Sets the infection rate.
   * @param infectionRate The infection rate.
   */
  public void setInfectionRate(double infectionRate) {
    mInfectionRate = infectionRate;
  }
  /**
   * Sets the random number generator.
   * @param rnd The random number generator.
   */
  public void setRnd(Random rnd) {
    mRnd = rnd;
  }
  /**
   * Sets the factory that actually creates the cells.
   * @param subj The factory.
   */
  public void setSubj(CellFactory subj) {
    mSubj = subj;
  }
  /**
   * Creates an instance of the BasicCellInfectedFactory class.
   */
  public InfectedCellFactory() {
    mInfectionRate = 0.02;
    mRnd = new Random();
    mSubj = new BasicCellFactory();
  }
  /**
   * Creates an instance of the BasicCellInfectedFactory class.
   * @param cellFac The underlying cell factory to use.
   */
  public InfectedCellFactory(CellFactory cellFac) {
    mInfectionRate = 0.02;
    mRnd = new Random();
    mSubj = cellFac;
  }
  /**
   * Creates basic cells that can be infected.
   * @return The newly create cell.
   */
  @Override
  public Cell createCell() {
    Cell cell = mSubj.createCell();
    if (cell.getCurrState() == CellStateAlive.getInstance()) {
      cell.setCurrState(CellStateVirusAlive.getInstance());
      if (mRnd.nextDouble() <= mInfectionRate) {
        cell.setCurrState(CellStateVirusInfected.getInstance());
      }
    } else {
      cell.setCurrState(CellStateVirusDead.getInstance());
    }
    return cell;
   }
}
