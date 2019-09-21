package wg.gol;

import java.awt.Point;

/**
 * The state of a living cell.
 *
 * @author Wesley Garey
 */
public class CellStateAlive implements CellState {

  /**
   * The static instance.
   */
  private static CellStateAlive sInstance;

  /**
   * Gets the static instance.
   *
   * @return The static instance.
   */
  public static CellStateAlive getInstance() {
    if (CellStateAlive.sInstance == null) {
      CellStateAlive.sInstance = new CellStateAlive();
    }
    return CellStateAlive.sInstance;
  }
  /**
   * The appearance to assign to live cells.
   */
  private CellAppearance mLook;
  /**
   * Gets the appearance of live cells.
   *
   * @return The appearance.
   */
  public CellAppearance getLook() {
    return this.mLook;
  }

  /**
   * Sets the appearance of live cells.
   *
   * @param look The appearance.
   */
  public void setLook(CellAppearance look) {
    this.mLook = look;
  }

  /**
   * Creates an instance of the CellStateAlive class.
   */
  protected CellStateAlive() {
    this.mLook = new BasicAppearanceSizeDecorator(new BasicAppearanceLegendDecorator(new BasicCellAppearance()));
  }

  /**
   * Indicates if the cell of this state is alive.
   *
   * @param cell The cell of this state.
   * @return True, if the cell is alive.
   */
  @Override
  public boolean isAlive(Cell cell) {
    return true;
  }

  /**
   * Determines the next state of a cell.
   *
   * @param cell The cell.
   */
  @Override
  public void determineNextState(Cell cell) {
    Point cellLoc = cell.getLocation();
    CellRules cellRules = cell.getRules();
    CellGrid cellParent = cell.getParent();
    int livingNeighbors = cellParent.countLivingNeighbors(cellLoc);
    boolean shouldDie = cellRules.shouldLiveCellDie(livingNeighbors);
    if (shouldDie == true) {
      cell.setNextState(CellStateDead.getInstance());
    } else {
      cell.setNextState(this);
    }
  }

  /**
   * Selects this state.
   *
   * @param cell The cell.
   */
  @Override
  public void selected(Cell cell) {
    CellAppearance cellLook = this.getLook();
    cell.setAppearance(cellLook);
    cell.increaseAge();
  }
}
