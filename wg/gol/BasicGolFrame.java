
package wg.gol;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
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
				// Load the image to be used for infected cells.
				Image infectedCellImg = null;
				URL infectedCellImgUrl = BasicGolFrame.class.getResource("/wg/gol/images/virus.gif" );
				try {
						infectedCellImg = ImageIO.read(infectedCellImgUrl);
				} catch(IOException e) {
						e.printStackTrace();
						System.exit(0);
				}
				//Set up the form
    Container pane = this.getContentPane();
    DrawPanel canvas = new DrawPanel(); //Create the custom canvas for drawing cells.
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
				updateTmr.setDelay(100); //Set repeat delay.
    updateTmr.setInitialDelay(500); //Set initital delay.
    updateTmr.setRepeats(true); //Make the timer restart on expiration.
    this.setUpdateTmr(updateTmr);
    //Cell appearance
    OvalShape cellLookShape = new OvalShape();
    //Shape cellLookShape = new RectangleShape();
    //RectangleShape3D cellLookShape = new RectangleShape3D();
    //cellLookShape.setRaised(true);
    cellLookShape.setFill(false);
    BasicCellAppearance cellLook = new BasicCellAppearance();
				cellLook = new BasicAppearanceLegendDecorator(cellLook); //Make cells change color.
				cellLook = new BasicAppearanceSizeDecorator(cellLook); //Make cells change size.
    cellLook.setBaseColor(Color.BLUE); //Set the base color of a cell.
    cellLook.setShape(cellLookShape); // Set the shape of a cell.
    CellStateAlive.getInstance().setLook(cellLook); // Give living cells the above look.
				CellStateAliveUninfected.getInstance().setLook(cellLook); //Give uninfected cells the above look.
				ImageShape infecedCellShape = new ImageShape(); //The image shape.
				infecedCellShape.setImg(infectedCellImg); //Set the image of the shape to the image of an infected cell.
				ImageAppearance infectedCellLook = new ImageAppearance(infecedCellShape); // Create the look for an infected cell.
				infectedCellLook.setAppr(new BasicAppearanceSizeDecorator(infectedCellLook.getAppr())); //Make the infected look change size.
				CellStateAliveInfected.getInstance().setLook(infectedCellLook); //Give infected cells the above look.
    //Initial cell creation
    //BasicCellFactory cellFac = new BasicCellFactory(); //Initially add only non-infected cells.
				BasicCellInfectedFactory cellFac = new BasicCellInfectedFactory(); //Add some already infected cells.
    cellFac.setMaxAge(20); //The maximum age before a cell stops growing.
				//Infected cell settings.
				cellFac.setInfectionRate(0.02); //Sets the rate of infection for the initial cells.
				CellStateDead.getInstance().setAliveState(CellStateAliveUninfected.getInstance()); //Make it possible for uninfected living cells to become infected.
				CellStateAliveInfected.getInstance().setSurvivalRate(0.99); //Sets the rate at which cells survive per-time-step
    //Cells
    BasicCellGrid cells = new BasicCellGrid();
    cells.setCellFac(cellFac);
    cells.setCellSize(new Dimension(10, 10));
    cells.setRows(70);
    cells.setCols(100);
    cells.initialize();
				//Link drawing and updates
    canvas.addDrawable(cells);
    this.setCells(cells);
				//Set form values.
    this.setTitle("Game of Life");
    this.setSize(1024, 768);
				//Do one initial draw so that the canvas is not blank.
    this.updateCb();
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
    cells.advance();
    canvas.repaint();
  }
}
