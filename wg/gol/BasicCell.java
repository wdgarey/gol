
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
   * The grid location.
   */
  private Point mLocation;
  /**
   * The look of the cell.
   */
  private Appearance mLook;
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
   * Gets the grid location.
   * @return The grid location.
   */
  public Point getLocation() {
    return this.mLocation;
  }
  /**
   * Gets the look of the cell.
   * @return The look of the cell.
   */
  public Appearance getLook() {
    return this.mLook;
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
  public CellGrid getParent() {
    return this.mParent;
  }
  /**
   * Gets the rules that the cell should use.
   * @return The rules.
   */
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
   * Sets the grid location.
   * @param loc The grid location.
   */
  @Override
  public void setLocation(Point loc) {
    this.mLocation = loc;
  }
  /**
   * Sets the look of the cell.
   * @param look The look.
   */
  public void setLook(Appearance look) {
    this.mLook = look;
  }
  /**
   * Sets the maximum age.
   * @param maxAge The maximum age.
   */
  public void setMaxAge(int maxAge) {
    this.mMaxAge = maxAge;
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
    this.mLocation = null;
    this.mLook = null;
    this.mMaxAge = 0;
    this.mParent = null;
    this.mRules = null;
  }
  /**
   * Applies the cell settings to the cell.
   * @param settings The cell settings to apply.
   */
  @Override
  public void accept(CellSettings settings) {
    settings.applyTo(this);
  }
  /**
   * Tells the cell to be born.
   */
  @Override
  public void beBorn() {
    this.resetAge();
    this.increaseAge();
    this.updateAppearance();
  }
  /**
   * Clones the cell.
   * @return The clone.
   */
  protected BasicCell copy() {
    Point myLocation = this.getLocation();
    Appearance myLook = this.getLook();
    CellRules myRules = this.getRules();
    int theirAge = this.getAge();
    Point theirLocation = new Point(myLocation);
    Appearance theirLook = myLook.copy();
    int theirMaxAge = this.getMaxAge();
    CellGrid theirParent = this.getParent();
    CellRules theirRules = myRules.copy();
    BasicCell clone = new BasicCell();
    clone.setAge(theirAge);
    clone.setLocation(theirLocation);
    clone.setLook(theirLook);
    clone.setMaxAge(theirMaxAge);
    clone.setParent(theirParent);
    clone.setRules(theirRules);
    return clone;
  }
  /**
   * Tells the cell to die.
   */
  @Override
  public void die() {
    this.resetAge();
    this.updateAppearance();
  }
  /**
   * Draws the cell.
   * @param g The graphics to use to draw the cell.
   * @param startingPoint The starting point.
   */
  @Override
  public void draw(Graphics g, Point startingPoint) {
    Appearance look = this.getLook();
    look.draw(g, startingPoint);
  }
  /**
   * Gets the age of the cell as a percentage.
   * @return The age as a percentage.
   */
  public double getAgeAsPercentage() {
    int age = this.getAge();
    int maxAge = this.getMaxAge();
    double percentage = ((double)age / (double)maxAge);
    return percentage;
  }
  /**
   * Tells the cell to grow.
   */
  @Override
  public void grow() {
    this.increaseAge();
    this.updateAppearance();
  }
  /**
   * Increases the cells age.
   */
  protected void increaseAge() {
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
    int age = this.getAge();
    boolean isAlive = (age > 0);
    return isAlive;
  }
  /**
   * Perdures the cell by one time step.
   * @return The future cell.
   */
  @Override
  public Cell perdure() {
    CellRules rules = this.getRules();
    BasicCell clone = this.copy();
    Point myLoc = this.getLocation();
    CellGrid parent = this.getParent();
    int livingNeighbors = parent.countLivingNeighbors(myLoc);
    if (this.isAlive()) {
      if (rules.shouldLiveCellDie(livingNeighbors)) {
        clone.die();
      } else {
        clone.grow();
      }
    } else {
      if (rules.shouldDeadCellLive(livingNeighbors)) {
        clone.beBorn();
      }
    }
    return clone;
  }
  /**
   * Resets the cell age.
   */
  protected void resetAge() {
    this.setAge(0);
  }
  /**
   * Updates the cells appearance.
   */
  protected void updateAppearance() {
    Appearance look = this.getLook();
    look.update(this);
  }
}
