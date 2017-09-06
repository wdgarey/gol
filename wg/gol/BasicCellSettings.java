
package wg.gol;

/**
 *
 * @author Wesley Garey
 */
public class BasicCellSettings implements CellSettings {
  /**
   * The look of a cell.
   */
  private Appearance mLook;
  /**
   * The maximum age that a cell can have.
   */
  private int mMaxAge;
  /**
   * The cell rules.
   */
  private CellRules mRules;
  /**
   * Gets the look of a cell.
   * @return The look of a cell.
   */
  public Appearance getLook() {
    return this.mLook;
  }
  /**
   * Gets the maximum age that a cell can have.
   * @return The maximum age.
   */
  public int getMaxAge() {
    return this.mMaxAge;
  }
  /**
   * Gets the cell rules.
   * @return The cell rules.
   */
  public CellRules getRules() {
    return this.mRules;
  }
  /**
   * Sets the look of a cell.
   * @param look The look of the cell.
   */
  public void setLook(Appearance look) {
    this.mLook = look;
  }
  /**
   * Sets the maximum age of a cell.
   * @param maxAge The maximum age.
   */
  public void setMaxAge(int maxAge) {
    this.mMaxAge = maxAge;
  }
  /**
   * Sets the cell rules.
   * @param rules The cell rules.
   */
  public void setRules(CellRules rules) {
    this.mRules = rules;
  }
  /**
   * Creates an instance of the BasicCellSettings class.
   */
  public BasicCellSettings() {
    this.mLook = null;
    this.mMaxAge = 0;
    this.mRules = new CellRules();
  }
  /**
   * Applies the settings to a basic cell.
   * @param cell The basic cell.
   */
  @Override
  public void applyTo(BasicCell cell) {
    Appearance myLook = this.getLook();
    CellRules myRules = this.getRules();
    int theirMaxAge = this.getMaxAge();
    Appearance theirLook = myLook.copy();
    CellRules theirRules = myRules.copy();
    cell.setMaxAge(theirMaxAge);
    cell.setLook(theirLook);
    cell.setRules(theirRules);
  }
}
