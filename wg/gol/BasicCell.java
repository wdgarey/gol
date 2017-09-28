
package wg.gol;

import java.awt.Graphics;
import java.awt.Point;

/**
 * A basic cell.
 * @author Wesley Garey
 */
public class BasicCell implements Cell {
  /**
   * The age.
   */
  private int mAge;
  /**
   * The current state of the cell.
   */
  private CellState mCurrState;
  /**
   * The grid location.
   */
  private Point mLocation;
  /**
   * The look of the cell.
   */
  private CellAppearance mLook;
  /**
   * The next state of the cell.
   */
  private CellState mNextState;
  /**
   * The maximum age of the cell.
   */
  private int mMaxAge;
  /**
   * The grid that the cell belongs to.
   */
  private CellGrid mParent;
  /**
   * The rules used by the cell.
   */
  private CellRules mRules;
  /**
   * Gets the age.
   * @return The age.
   */
  public int getAge() {
    return this.mAge;
  }
  /**
   * Gets the look of the cell.
   * @return The look of the cell.
   */
  public CellAppearance getAppearance() {
    return this.mLook;
  }
  /**
   * Gets the current state of the cell.
   * @return The current state.
   */
  @Override
  public CellState getCurrState() {
    return this.mCurrState;
  }
  /**
   * Gets the grid location.
   * @return The grid location.
   */
  @Override
  public Point getLocation() {
    return this.mLocation;
  }
  /**
   * Gets the next state of the cell.
   * @return The next state.
   */
  @Override
  public CellState getNextState() {
    return this.mNextState;
  }
  /**
   * Gets the maximum age of the cell.
   * @return The maximum age.
   */
  public int getMaxAge() {
    return this.mMaxAge;
  }
  /**
   * Gets the grid that the cell belongs to.
   * @return The grid that the cell belongs to.
   */
  @Override
  public CellGrid getParent() {
    return this.mParent;
  }
  /**
   * Gets the rules that the cell should use.
   * @return The rules.
   */
  @Override
  public CellRules getRules() {
    return this.mRules;
  }
  /**
   * Sets the age.
   * @param age The age.
   */
  public void setAge(int age) {
    this.mAge = age;
  }
  /**
   * Sets the look of the cell.
   * @param look The look.
   */
  @Override
  public void setAppearance(CellAppearance look) {
    this.mLook = look;
  }
  /**
   * Sets the current state of the cell.
   * @param state The current state.
   */
  @Override
  public void setCurrState(CellState state) {
    this.mCurrState = state;
  }
  /**
   * Sets the grid location.
   * @param loc The grid location.
   */
  @Override
  public void setLocation(Point loc) {
    this.mLocation = loc;
  }
  /**
   * Sets the maximum age.
   * @param maxAge The maximum age.
   */
  public void setMaxAge(int maxAge) {
    this.mMaxAge = maxAge;
  }
  /**
   * Sets the next state of the cell.
   * @param state The state.
   */
  @Override
  public void setNextState(CellState state) {
    this.mNextState = state;
  }
  /**
   * Sets the grid that the cell belongs to.
   * @param parent The grid that the cell belongs to.
   */
  @Override
  public void setParent(CellGrid parent) {
    this.mParent = parent;
  }
  /**
   * Sets the rules that a cell should use.
   * @param rules The rules.
   */
  public void setRules(CellRules rules) {
    this.mRules = rules;
  }
  /**
   * Creates an instance of the BasicCell class.
   */
  public BasicCell() {
    this.mAge = 0;
    this.mCurrState = CellStateAlive.getInstance();
    this.mLocation = null;
    this.mLook = null;
    this.mMaxAge = 0;
    this.mNextState = CellStateAlive.getInstance();
    this.mParent = null;
    this.mRules = null;
  }
  /**
   * Determines the next state of the cell.
   */
  @Override
  public void determineNextState() {
    CellState currState = this.getCurrState();
    currState.determineNextState(this);
  }
  /**
   * Draws the cell.
   * @param g The graphics to use to draw the cell.
   */
  @Override
  public void draw(Graphics g) {
    this.updateAppearance();
    CellAppearance look = this.getAppearance();
    look.draw(g);
  }
  /**
   * Gets the age of the cell as a percentage.
   * @return The age as a percentage.
   */
  @Override
  public double getAgeAsPercentage() {
    int age = this.getAge();
    int maxAge = this.getMaxAge();
    double percentage = ((double)age / (double)maxAge);
    return percentage;
  }
  /**
   * Increases the cells age.
   */
  @Override
  public void increaseAge() {
    int age = this.getAge();
    int maxAge = this.getMaxAge();
    if (age < maxAge) {
      age += 1;
    }
    this.setAge(age);
  }
  /**
   * Indicates if the cell is alive.
   * @return True, if the cell is alive.
   */
  @Override
  public boolean isAlive() {
    CellState currState = this.getCurrState();
    boolean isAlive = currState.isAlive(this);
    return isAlive;
  }
  /**
   * Moves this cell to the next state.
   */
  @Override
  public void moveToNextState() {
    CellState nextState = this.getNextState();
    nextState.selected(this);
    this.setCurrState(nextState);
  }
  /**
   * Resets the cell age.
   */
  @Override
  public void resetAge() {
    this.setAge(0);
  }
  /**
   * Updates the cells appearance.
   */
  protected void updateAppearance() {
    CellAppearance look = this.getAppearance();
    look.update(this);
  }
}
