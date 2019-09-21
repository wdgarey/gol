package wg.gol;

import java.util.Random;

/**
 * The state of an live cell that is infected.
 * @author Wesley Garey
 */
public class CellStateVirusInfected implements CellState {
  /**
   * The static instance.
   */
  private static CellStateVirusInfected sInstance;
  /**
   * Gets the static instance.
   * @return The static instance.
   */
  public static CellStateVirusInfected getInstance() {
    if (CellStateVirusInfected.sInstance == null) {
      CellStateVirusInfected.sInstance = new CellStateVirusInfected();
    }
    return CellStateVirusInfected.sInstance;
  }
  /**
   * The appearance of the cell.
   */
  private CellAppearance mLook;
  /**
   * The random generator to use.
   */
  private Random mRnd;
  /**
   * Gets the survival rate.
   */
  private double mSurvivalRate;
  /**
   * Gets the look of a cell in this state.
   * @return The appearance.
   */
  private CellAppearance getLook() {
    return mLook;
  }
  /**
   * Gets the random generator.
   * @return The random generator.
   */
  public Random getRnd() {
    return mRnd;
  }
  /**
   * Gets the survival rate.
   * @return The survival rate.
   */
  public double getSurvivalRate() {
    return mSurvivalRate;
  }
  /**
   * Sets the look of a cell in this state.
   * @param look The appearance.
   */
  public void setLook(CellAppearance look) {
    mLook = look;
  }
  /**
   * Sets the random generator.
   * @param rnd
   */
  public void setRnd(Random rnd) {
    mRnd = rnd;
  }
  /**
   * Sets the survival rate.
   * @param survivalRate The survival rate.
   */
  public void setSurvivalRate(double survivalRate) {
    mSurvivalRate = survivalRate;
  }
  /**
   * Creates an instance of the CellStateAliveInfected class.
   */
  public CellStateVirusInfected() {
    RectangleShape3D shp = new RectangleShape3D();
    BasicCellAppearance appr = new BasicCellAppearance();
    shp.setFill(true);
    shp.setRaised(true);
    appr.setShape(shp);
    
    mLook = appr;
    mRnd = new Random();
    mSurvivalRate = 0.98;
  }
  /**
   * Determines the next state of a cell.
   * @param cell The cell.
   */
  @Override
  public void determineNextState(Cell cell) {
    CellStateAlive.getInstance().determineNextState(cell);
    if (cell.getNextState() == CellStateAlive.getInstance()) {
      if (getRnd().nextDouble() > getSurvivalRate()) {
        cell.setNextState(CellStateVirusDead.getInstance());
      } else {
        cell.setNextState(CellStateVirusInfected.getInstance());
      }
    } else {
      cell.setNextState(CellStateVirusDead.getInstance());
    }
  }
  /**
   * Indicates if the cell is alive.
   * @param cell The cell.
   * @return True, if the cell is alive; otherwise, false.
   */
  @Override
  public boolean isAlive(Cell cell) {
    return CellStateAlive.getInstance().isAlive(cell);
  }
  /**
   * Indicates that this state has been selected for the given cell.
   * 
   * @param cell The given cell.
   */
  @Override
  public void selected(Cell cell) {
    CellStateAlive.getInstance().selected(cell);
    cell.setAppearance(mLook);
  }
}
