
package wg.gol;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 * The GOL frame.
 * @author Wesley Garey
 */
public class BasicGolFrame extends JFrame implements ActionListener, MouseListener, MouseMotionListener {
  /**
   * The alive cell count label.
   */
  private JLabel mAliveLbl;
  /**
   * The drawing canvas.
   */
  private DrawPanel mCanvas;
  /**
   * The collection of cells.
   */
  private CellGrid mCells;
  /**
   * The dead cell count label.
   */
  private JLabel mDeadLbl;
  /**
   * The infected cell count label.
   */
  private JLabel mInfectedLbl;
  /**
   * The start/stop button.
   */
  private JButton mStartStopBtn;
  /**
   * The total cell count label.
   */
  private JLabel mTotalLbl;
  /**
   * The timer used to update.
   */
  private Timer mUpdateTmr;
  /**
   * Gets the alive cell count label.
   * @return The label.
   */
  protected JLabel getAliveLbl() {
    return this.mAliveLbl;
  }
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
   * Gets the dead cell count label.
   * @return The label.
   */
  protected JLabel getDeadLbl() {
    return this.mDeadLbl;
  }
  /**
   * Gets the infected cell count label.
   * @return The label.
   */
  protected JLabel getInfectedLbl() {
    return this.mInfectedLbl;
  }
  /**
   * Gets the start/stop button.
   * @return The start/stop button.
   */
  protected JButton getStartStopBtn() {
    return this.mStartStopBtn;
  }
  /**
   * Gets the total cell count label.
   * @return The label.
   */
  protected JLabel getTotalLbl() {
    return this.mTotalLbl;
  }
  /**
   * Gets the timer used to update.
   * @return The timer.
   */
  protected Timer getUpdateTmr() {
    return this.mUpdateTmr;
  }
  /**
   * Sets the alive cell count label.
   * @param aliveLbl The label.
   */
  protected void setAliveLbl(JLabel aliveLbl) {
    this.mAliveLbl = aliveLbl;
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
   * Sets the dead cell count label.
   * @param deadLbl The label.
   */
  protected void setDeadLbl(JLabel deadLbl) {
    this.mDeadLbl = deadLbl;
  }
  /**
   * Sets the infected cell count label.
   * @param infectedLbl The label.
   */
  protected void setInfectedLbl(JLabel infectedLbl) {
    this.mInfectedLbl = infectedLbl;
  }
  /**
   * Sets the start/stop button.
   * @param startStopBtn The start/stop button.
   */
  protected void setStartStopBtn(JButton startStopBtn) {
    this.mStartStopBtn = startStopBtn;
  }
  /**
   * Sets the total cell count label.
   * @param totalLbl The label.
   */
  protected void setTotalLbl(JLabel totalLbl) {
    this.mTotalLbl = totalLbl;
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
    this.mAliveLbl = null;
    this.mCanvas = null;
    this.mCells = null;
    this.mDeadLbl = null;
    this.mInfectedLbl = null;
    this.mStartStopBtn = null;
    this.mTotalLbl = null;
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
    JLabel totalLbl = new JLabel("Total:");
    JLabel aliveLbl = new JLabel("Alive:");
    JLabel deadLbl = new JLabel("Dead:");
    JLabel infectedLbl = new JLabel("Infected:");
    Timer updateTmr = new Timer(100, this);
    JButton startStopBtn = new JButton("Start/Stop");
    GridBagConstraints layoutConstraints = new GridBagConstraints();
    pane.setLayout(new GridBagLayout());
    //Canvas
    canvas.addMouseListener(this);
    canvas.addMouseMotionListener(this);
    canvas.setBgColor(Color.BLACK);
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
    //Labels
    layoutConstraints.gridx = 0;
    pane.add(totalLbl, layoutConstraints);
    this.setTotalLbl(totalLbl);
    layoutConstraints.gridx += 1;
    pane.add(aliveLbl, layoutConstraints);
    this.setAliveLbl(aliveLbl);
    layoutConstraints.gridx += 1;
    pane.add(deadLbl, layoutConstraints);
    this.setDeadLbl(deadLbl);
    layoutConstraints.gridx += 1;
    pane.add(infectedLbl, layoutConstraints);
    this.setInfectedLbl(infectedLbl);
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
    cellLookShape.setFill(true);
    BasicCellAppearance cellLook = new BasicCellAppearance();
				cellLook = new BasicAppearanceLegendDecorator(cellLook); //Make cells change color.
				cellLook = new BasicAppearanceSizeDecorator(cellLook); //Make cells change size.
    cellLook.setBaseColor(Color.RED); //Set the base color of a cell.
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
    cellFac.setMaxAge(12); //The maximum age before a cell stops growing.
				//Infected cell settings.
				cellFac.setInfectionRate(1.0); //Sets the rate of infection for the initial cells.
				CellStateDead.getInstance().setAliveState(CellStateAliveUninfected.getInstance()); //Make it possible for uninfected living cells to become infected.
				CellStateAliveInfected.getInstance().setSurvivalRate(1.0); //Sets the rate at which cells survive per-time-step
    //Cells
    BasicCellGrid cells = new BasicCellGrid();
    cells.setCellFac(cellFac);
    cells.setCellSize(new Dimension(5, 5));
    cells.setRows(160);
    cells.setCols(288);
    cells.initialize();
				//Link drawing and updates
    canvas.addDrawable(cells);
    this.setCells(cells);
				//Set form values.
    this.setTitle("Game of Life");
    this.setSize(1440, 900);
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
    CellGridStatistics stats = new CellGridStatistics();
    cells.advance();
    canvas.repaint();
    stats.setGrid(cells);
    this.getTotalLbl().setText("Total: " + stats.getTotal() + " ");
    this.getAliveLbl().setText("Alive: " + stats.getLiving() + " ");
    this.getDeadLbl().setText("Dead: " + stats.getDead() + " ");
    this.getInfectedLbl().setText("Infected: " + stats.getInfected() + " ");
  }
  /**
   * Mouse clicked event.
   * @param e The event information.
   */
  @Override
  public void mouseClicked(MouseEvent e) {
      Point cellPt = new Point();
      Point clickPt = e.getPoint();
      DrawPanel canvas = this.getCanvas();
      CellGrid cellGrid = this.getCells();
      Dimension cellSize = cellGrid.getCellSize();
      cellPt.x = clickPt.x / cellSize.width;
      cellPt.y = clickPt.y / cellSize.height;
      Cell cell = cellGrid.getCell(cellPt);
      if (e.getButton() == MouseEvent.BUTTON1
              || e.getButton() == MouseEvent.NOBUTTON) {
        if (!cell.isAlive()) {
          cell.setNextState(CellStateAliveUninfected.getInstance());
        } else if (cell.getCurrState() == CellStateAliveInfected.getInstance()) {
          cell.setNextState(CellStateDead.getInstance());
        } else if (cell.isAlive()) {
          cell.setNextState(CellStateAliveInfected.getInstance());
        }
        cell.moveToNextState();
        canvas.repaint();
      }
  }
  /**
   * Mouse pressed event.
   * @param e The event information.
   */
  @Override
  public void mousePressed(MouseEvent e) {
  }
  /**
   * Mouse released event.
   * @param e The event information.
   */
  @Override
  public void mouseReleased(MouseEvent e) {
    //Do nothing.
  }
  /**
   * Mouse entered event.
   * @param e The event information.
   */
  @Override
  public void mouseEntered(MouseEvent e) {
    //Do nothing.
  }
  /**
   * Mouse exited event.
   * @param e The event information.
   */
  @Override
  public void mouseExited(MouseEvent e) {
    //Do nothing.
  }
  /**
   * The mouse dragged event.
   * @param e The event information.
   */
  @Override
  public void mouseDragged(MouseEvent e) {
    this.mouseClicked(e);
  }
  /**
   * The mouse moved event.
   * @param e The event information.
   */
  @Override
  public void mouseMoved(MouseEvent e) {
    //Do nothing.
  }
}
