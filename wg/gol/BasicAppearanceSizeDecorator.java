
package wg.gol;

import java.awt.Dimension;

/**
 * A class used to add size animation to the BasicCellAppearance.
 * @author Wesley Garey
 */
public class BasicAppearanceSizeDecorator extends BasicAppearanceDecorator {
  /**
    * The subject being decorated.
    */
  private BasicCellAppearance mSubj;
  /**
    * Gets the subject being decorated.
    * @return The subject.
    */
  @Override
  public BasicCellAppearance getSubj() {
    return this.mSubj;
  }
  /**
    * Sets the subject being decorated.
    * @param subj The subject.
    */
  public void setSubj(BasicCellAppearance subj) {
    this.mSubj = subj;
  }
  /**
    * Creates an instance of the BasicAppearanceSizeDecorator class.
    */
  public BasicAppearanceSizeDecorator() {
    this.mSubj = null;
  }
  /**
    * Creates an instance of the BasicAppearanceSizeDecorator class.
    * @param subj The subject to decorate.
    */
  public BasicAppearanceSizeDecorator(BasicCellAppearance subj) {
    this.mSubj = subj;
  }
  /**
    * Updates the appearance.
    * @param cell The cell to base the appearance off of.
    */
  @Override
  public void update(BasicCell cell) {
    double percent = cell.getAgeAsPercentage();
    Dimension maxSize = this.getMaxSize();
    int width = (int)(maxSize.width * percent);
    int height = (int)(maxSize.height * percent);
    Dimension size = new Dimension(width, height);
    super.update(cell);
    this.setSize(size);
  }
}
