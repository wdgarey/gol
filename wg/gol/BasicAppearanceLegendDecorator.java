
package wg.gol;

import java.awt.Color;

/**
 * A class used to decorate the appearance with a legend.
 * @author Wesley Garey
 */
public class BasicAppearanceLegendDecorator extends BasicAppearanceDecorator {
  /**
   * The legend.
   */
  private static Color[] sLegend;
  /**
   * Gets the static instance of the legend.
   * @return The legend.
   */
  public static Color[] getLegend() {
    if (BasicAppearanceLegendDecorator.sLegend == null) {
      int idx = 0;
      BasicAppearanceLegendDecorator.sLegend = new Color[6];
      BasicAppearanceLegendDecorator.sLegend[idx++] = Color.WHITE;
      BasicAppearanceLegendDecorator.sLegend[idx++] = Color.YELLOW;
      BasicAppearanceLegendDecorator.sLegend[idx++] = Color.ORANGE;
      BasicAppearanceLegendDecorator.sLegend[idx++] = Color.RED;
      BasicAppearanceLegendDecorator.sLegend[idx++] = Color.MAGENTA;
      BasicAppearanceLegendDecorator.sLegend[idx++] = Color.BLUE;
    }
    return BasicAppearanceLegendDecorator.sLegend;
  }
  /**
   * Sets the static instance of the legend.
   * @param legend The legend.
   */
  public static void setLegend(Color[] legend) {
    BasicAppearanceLegendDecorator.sLegend = legend;
  }
  /**
   * The subject being decorated.
   */
  private BasicAppearance mSubj;
  /**
   * Gets the subject being decorated.
   * @return The subject.
   */
  @Override
  public BasicAppearance getSubj() {
    return this.mSubj;
  }
  /**
   * Sets the subject being decorated.
   * @param subj The subject.
   */
  public void setSubj(BasicAppearance subj) {
    this.mSubj = subj;
  }
  /**
   * Creates an instance of the BasicAppearanceLegendDecorator class.
   */
  public BasicAppearanceLegendDecorator() {
    super();
    this.mSubj = null;
  }
  /**
   * Creates an instance of the BasicAppearanceLegendDecorator class.
   * @param subj The subject being decorated.
   */
  public BasicAppearanceLegendDecorator(BasicAppearance subj) {
    super();
    this.mSubj = subj;
  }
  /**
   * Copies the decorator.
   * @return The copy.
   */
  @Override
  public BasicAppearanceLegendDecorator copy() {
    BasicAppearanceLegendDecorator clone = new BasicAppearanceLegendDecorator();
				clone.copy(this);
    return clone;
  }
		/**
			* Copies the attributes of the given decorator.
			* @param decorator The decorator to copy.
			*/
		protected void copy(BasicAppearanceLegendDecorator decorator) {
				BasicAppearance theirSubj = decorator.getSubj();
				BasicAppearance mySubj = theirSubj.copy();
				this.setSubj(mySubj);
		}
  /**
   * Updates the appearance based on the cell.
   * @param cell The cell to base the appearance off of.
   */
  @Override
  public void update(BasicCell cell) {
    double percent = cell.getAgeAsPercentage();
    Color[] legend = BasicAppearanceLegendDecorator.getLegend();
    int idx = (int)((legend.length - 1) * percent);
    Color color = legend[idx];
    this.setBaseColor(color);
				super.update(cell);
  }
}
