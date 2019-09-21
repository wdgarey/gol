/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wg.gol;

/**
 * Represents the dead state for a cell that can be infected.
 * 
 * @author Wesley Garey
 */
public class CellStateVirusDead implements CellState {
  /**
   * The static instance of this state.
   */
  private static CellStateVirusDead sInstance;
  
  /**
   * Gets the static instance of this state.
   * 
   * @return The static instance.
   */
  public static CellStateVirusDead getInstance() {
    if (sInstance == null) {
      sInstance = new CellStateVirusDead();
    }
    return sInstance;
  }
  
  /**
   * Creates an instance of the CellStateDeadUninfected class.
   */
  public CellStateVirusDead() {
    
  }
  
  /**
   * Indicates if the given cell is alive.
   * 
   * @param cell The given cell.
   * @return True, if the cell is alive; otherwise, false.
   */
  @Override
  public boolean isAlive(Cell cell) {
    return CellStateDead.getInstance().isAlive(cell);
  }

  /**
   * Determines the next state of the given cell.
   * 
   * @param cell The given cell.
   */
  @Override
  public void determineNextState(Cell cell) {
    CellStateDead.getInstance().determineNextState(cell);
    if (cell.getNextState() == CellStateDead.getInstance()) {
      cell.setNextState(CellStateVirusDead.getInstance());
    } else {
      cell.setNextState(CellStateVirusAlive.getInstance());
    }
  }
  
  /**
   * Indicates that this state has been selected for the given cell.
   * 
   * @param cell The given cell.
   */
  @Override
  public void selected(Cell cell) {
    CellStateDead.getInstance().selected(cell);
  }
  
}
