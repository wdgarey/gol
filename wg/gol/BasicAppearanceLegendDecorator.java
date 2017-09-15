
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
  public BasicAppearanceLegendDecorator(BasicCellAppearance subj) {
    super();
    this.mSubj = subj;
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
