
package wg.gol;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 * The GOL frame.
 * @author Wesley Garey
 */
public class BasicGolFrame extends JFrame implements ActionListener {
  /**
   * The drawing canvas.
   */
  private DrawPanel mCanvas;
  /**
   * The collection of cells.
   */
  private CellGrid mCells;
  /**
   * The start/stop button.
   */
  private JButton mStartStopBtn;
  /**
   * The timer used to update.
   */
  private Timer mUpdateTmr;
  /**
   * Gets the drawing canvas.
   * @return The drawing canvas.
   */
  protected DrawPanel getCanvas() {
    return this.mCanvas;
  }
  /**
   * Gets the collection of cells.
   * @return The collection of cells.
   */
  protected CellGrid getCells() {
    return this.mCells;
  }
  /**
   * Gets the start/stop button.
   * @return The start/stop button.
   */
  protected JButton getStartStopBtn() {
    return this.mStartStopBtn;
  }
  /**
   * Gets the timer used to update.
   * @return The timer.
   */
  protected Timer getUpdateTmr() {
    return this.mUpdateTmr;
  }
  /**
   * Sets the drawing canvas.
   * @param canvas The drawing canvas.
   */
  protected void setCanvas(DrawPanel canvas) {
    this.mCanvas = canvas;
  }
  /**
   * Sets the collection of cells.
   * @param cells The collection of cells.
   */
  protected void setCells(CellGrid cells) {
    this.mCells = cells;
  }
  /**
   * Sets the start/stop button.
   * @param startStopBtn The start/stop button.
   */
  protected void setStartStopBtn(JButton startStopBtn) {
    this.mStartStopBtn = startStopBtn;
  }
  /**
   * Sets the timer used to update.
   * @param updateTmr The timer.
   */
  protected void setUpdateTmr(Timer updateTmr) {
    this.mUpdateTmr = updateTmr;
  }
  /**
   * Creates an instance of the BasicGolFrame class.
   */
  public BasicGolFrame() {
    super();
    this.mCanvas = null;
    this.mStartStopBtn = null;
    this.mUpdateTmr = null;
  }
  /**
   * Notifies the frame that an action was performed.
   * @param e The action event.
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    Object src = e.getSource();
    if (src == this.getUpdateTmr()) {
      this.updateCb();
    } else if (src == this.getStartStopBtn()) {
      this.startStopCb();
    }
  }
  /**
   * Initializes the frame.
   */
  public void initialize() {
    this.setTitle("Game of Life");
    this.setSize(1024, 768);
				Shape cellLookShape = new OvalShape();
				//Shape cellLookShape = new RectangleShape();
				//RectangleShape3D cellLookShape = new RectangleShape3D();
    BasicAppearance cellLook = new BasicAppearanceSizeDecorator(new BasicAppearanceLegendDecorator(new BasicAppearance()));
    BasicCellGrid cells = new BasicCellGrid();
    BasicCellSettings cellSettings = new BasicCellSettings();
    Container pane = this.getContentPane();
    DrawPanel canvas = new DrawPanel();
    Timer updateTmr = new Timer(100, this);
    JButton startStopBtn = new JButton("Start/Stop");
    GridBagConstraints layoutConstraints = new GridBagConstraints();
    pane.setLayout(new GridBagLayout());
    //Canvas
    canvas.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    layoutConstraints.fill = GridBagConstraints.BOTH;
    layoutConstraints.weightx = 1.0;
    layoutConstraints.weighty = 1.0;
    layoutConstraints.gridx = 0;
    layoutConstraints.gridy = 0;
    layoutConstraints.gridwidth = 64;
    layoutConstraints.gridheight = 63;
    pane.add(canvas, layoutConstraints);
    canvas.repaint();
    this.setCanvas(canvas);
    //Start/Stop button
    startStopBtn.addActionListener(this);
    layoutConstraints.weightx = 0.0;
    layoutConstraints.weighty = 0.0;
    layoutConstraints.fill = GridBagConstraints.NONE;
    layoutConstraints.anchor = GridBagConstraints.LAST_LINE_END;
    layoutConstraints.gridx = 63;
    layoutConstraints.gridy = 63;
    layoutConstraints.gridwidth = 1;
    layoutConstraints.gridheight = 1;
    pane.add(startStopBtn, layoutConstraints);
    this.setStartStopBtn(startStopBtn);
    //Update timer
    updateTmr.setInitialDelay(500);
    updateTmr.setRepeats(true);
    this.setUpdateTmr(updateTmr);
    //Cell appearance
				cellLookShape.setFill(true);
				//cellLookShape.setRaised(true);
    cellLook.setBaseColor(Color.BLUE);
    cellLook.setLocation(new Point(0, 0));
    cellLook.setMaxSize(new Dimension(10, 10));
				cellLook.setShape(cellLookShape);
    cellLook.setVisible(true);
    //Cell settings
    cellSettings.setLook(cellLook);
    cellSettings.setMaxAge(20);
    cellSettings.setRules(new CellRules());
    //Cells
    cells.setCellFac(new BasicCellFactory());
    cells.setCellSettings(cellSettings);
    cells.setRows(70);
    cells.setCols(100);
    cells.initialize();
    this.setCells(cells);
    canvas.addDrawable(cells);
  }
  /**
   * Indicates if the frame is running.
   * @return True, if the frame is running.
   */
  protected boolean isRunning() {
    Timer updateTmr = this.getUpdateTmr();
    boolean isRunning = updateTmr.isRunning();    
    return isRunning;
  }
  /**
   * Starts the frame.
   */
  protected void start() {
    Timer updateTmr = this.getUpdateTmr();
    updateTmr.start();
  }
  /**
   * The start/stop callback.
   */
  protected void startStopCb() {
    if (this.isRunning()) {
      this.stop();
    } else {
      this.start();
    }
  }
  /**
   * Stops the frame.
   */
  protected void stop() {
    Timer updateTmr = this.getUpdateTmr();
    updateTmr.stop();
  }
  /**
   * The update callback.
   */
  protected void updateCb() {
    CellGrid cells = this.getCells();
    DrawPanel canvas = this.getCanvas();
    cells.perdure();
    canvas.repaint();
  }
}
