package wg.gol;

/**
 * A class used to represent the state of an alive, uninfected cell.
 * @author Wesley Garey
 */
public class CellStateVirusAlive implements CellState {
  /**
   * The static instance.
   */
  private static CellStateVirusAlive sInstance;
  /**
   * Gets the static instance.
   * @return The static instance.
   */
  public static CellStateVirusAlive getInstance() {
    if (CellStateVirusAlive.sInstance == null) {
      CellStateVirusAlive.sInstance = new CellStateVirusAlive();
    }
    return CellStateVirusAlive.sInstance;
  }
  /**
   * The appearance of a cell in this state.
   */
  private CellAppearance mLook;
  /**
   * Gets the appearance that a cell will have in this state.
   * @return The appearance.
   */
  public CellAppearance getLook() {
    return mLook;
  }
  /**
   * Sets the appearance that a cell will have in this state.
   * @param look The appearance.
   */
  public void setLook(CellAppearance look) {
    mLook = look;
  }
  /**
   * Creates an instance of the CellStateAliveUninfected class.
   */
  public CellStateVirusAlive() {
    mLook = CellStateAlive.getInstance().getLook();
  }
  /**
   * Determines the next state of the cell.
   * @param cell The next state.
   */
  @Override
  public void determineNextState(Cell cell) {
    CellStateAlive.getInstance().determineNextState(cell);
    boolean isNeighborInfected = false;
    Iterable<Cell> cellNeighbors = cell.getParent().getNeighbors(cell.getLocation());
    if (cell.getNextState() == CellStateAlive.getInstance()) {
      for (Cell cellNeighbor : cellNeighbors) {
        if (cellNeighbor.getCurrState() == CellStateVirusInfected.getInstance()) {
          isNeighborInfected = true;
        }
      }
      if (isNeighborInfected == true) {
        cell.setNextState(CellStateVirusInfected.getInstance());
      } else {
        cell.setNextState(CellStateVirusAlive.getInstance());
      }
    } else {
      cell.setNextState(CellStateVirusDead.getInstance());
    }
  }
  /**
   * Indicates if a cell is alive.
   * @param cell The cell.
   * @return True, if the cell is alive; otherwise, false.
   */
  @Override
  public boolean isAlive(Cell cell) {
    return CellStateAlive.getInstance().isAlive(cell);
  }
  /**
   * Indicates that this state has been selected for the given cell.
   * @param cell The given cell.
   */
  @Override
  public void selected(Cell cell) {
    CellStateAlive.getInstance().selected(cell);
    cell.setAppearance(mLook);
  }
}
