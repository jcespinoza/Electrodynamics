
package tests;

import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.List;
import org.opensourcephysics.controls.AbstractSimulation;
import org.opensourcephysics.controls.MainFrame;
import org.opensourcephysics.controls.SimControl;
import org.opensourcephysics.controls.SimulationControl;
import org.opensourcephysics.display.InteractiveMouseHandler;
import org.opensourcephysics.display.InteractivePanel;
import org.opensourcephysics.display.OSPFrame;
import org.opensourcephysics.frames.Vector2DFrame;

/**
 * @author Juan Carlos Espinoza
 *
 */
public class EFApp4 extends AbstractSimulation implements InteractiveMouseHandler{
    int n = 20;
    int a = 11;
    int maxX = a/2;
    int maxY = a/2;
    int minX = -(a/2);
    int minY = -(a/2);
    boolean boundariesEnabled = true;
    boolean closeActionFixed  = false;
    double eField[][][] = new double[2][n][n];
    Vector2DFrame frame = new Vector2DFrame("X", "Y", "Electrid Field");
    TestCharge tCharge;
    
    
    public EFApp4(){
        frame.setPreferredMinMax(-a/2, a/2, -a/2, a/2);
        frame.setZRange(false, 0, 2);
        frame.setAll(eField); // sets the vector field
        frame.setInteractiveMouseHandler(this);
        frame.setDefaultCloseOperation(OSPFrame.DISPOSE_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        SimulationControl.createApp(new EFApp4());
    }

    /*From AbstractSimulation*/
    /**************************************/
    @Override
    protected void doStep() {
        double field[] = fielOnPoint();
        double Ex = field[0];
        double Ey = field[1];
        tCharge.doStep(Ex, Ey);
        if(boundariesEnabled){
            double cx = tCharge.getX();
            double cy = tCharge.getY();
            if(cx < minX){
                tCharge.invertVx();
                tCharge.setX(minX);
                return;
            }
            if(cy < minY){
                tCharge.setY(minY);
                tCharge.invertVy();              
                return;
            }
            if(cx > maxX){
                tCharge.invertVx();
                tCharge.setX(maxX);
                return;
            }
            if(cy > maxY){
                tCharge.invertVy();
                tCharge.setY(maxY);
            }
        }
    }


    @Override
    public void start() {
        calculateField();
        frame.setVisible(true);
        System.out.println("Triggered start()");
    }


    @Override
    public void initialize() {
        double x1 = control.getDouble("x1");
        double y1 = control.getDouble("y1");
        double q1 = control.getDouble("q1");
        Charge charge1 = new Charge(x1, y1, q1);
        frame.addDrawable(charge1);
        double x2 = control.getDouble("x2");
        double y2 = control.getDouble("y2");
        double q2 = control.getDouble("q2");
        Charge charge2 = new Charge(x2, y2, q2);
        frame.addDrawable(charge2);
        double px = control.getDouble("px");
        double py = control.getDouble("py");
        double pq = control.getDouble("pq");
        double pm = control.getDouble("pm");
        tCharge = new TestCharge(px, py, pq, pm);
        frame.addDrawable(tCharge);
        boundariesEnabled = control.getBoolean("Jaula");
        calculateField();
        frame.setVisible(true);
    }

    @Override
    public void reset() {
        if(!closeActionFixed)
            fixCloseAction(control);
        control.println("Creates charges");
        control.println("You can drag charges.");
        control.setValue("x1", 2);
        control.setValue("y1", 0);
        control.setValue("q1", 1);
        control.setValue("x2", -2);
        control.setValue("y2", 0);
        control.setValue("q2", -1);
        control.setValue("px", 0.05);
        control.setValue("py", 0);
        control.setValue("pq", 1);
        control.setValue("pm", 1);
        control.setValue("Jaula", false);
        frame.clearDrawables();
        System.out.println("Triggered reset()");
    }
    /****************************************/
    
    /*Apps Methods*/
    /****************************************/
    public void calculateField(){
for(int ix = 0;ix<n;ix++) {
      for(int iy = 0;iy<n;iy++) {
        eField[0][ix][iy] = eField[1][ix][iy] = 0; // zeros field
      }
    }
    // the charges in the frame
    List<Charge> chargeList = frame.getDrawables(Charge.class);
    Iterator<Charge> it = chargeList.iterator();
    while(it.hasNext()) {      
      Charge charge = it.next();
      if(charge instanceof TestCharge)
          continue;
      double xs = charge.getX(), ys = charge.getY();
      for(int ix = 0;ix<n;ix++) {
        double x = frame.indexToX(ix);
        double dx = (x-xs);             // distance of charge to gridpoint
        for(int iy = 0;iy<n;iy++) {
          double y = frame.indexToY(iy);
          double dy = (y-ys);           // charge to gridpoint
          double r2 = dx*dx+dy*dy;      // distance squared
          double r3 = Math.sqrt(r2)*r2; // distance cubed
          if(r3>0) {
            eField[0][ix][iy] += charge.q*dx/r3;
            eField[1][ix][iy] += charge.q*dy/r3;
          }
        }
      }
    }
    frame.setAll(eField);
    }
    private double[] fielOnPoint() {
        double ret[] = {0,0};
        int xPos = frame.xToIndex(tCharge.getX());
        int yPos = frame.yToIndex(tCharge.getY());
        //System.out.println("Xindex: " + xPos + " X: " + tCharge.getX());
        //System.out.println("Yindex: " + yPos + " Y: " + tCharge.getY());
        //double ex = eField[0][(int)(xPos)][(int)(yPos)];
        //double ey = eField[1][(int)(xPos)][(int)(yPos)];
        double xComp[][] = eField[0];
        double yComp[][] = eField[1];
        double ex = xComp[xPos][yPos];
        double ey = yComp[xPos][yPos];
        ret[0] = ex;
        ret[1] = ey;
        return ret;
    }
    /*******************************************/
    private void fixCloseAction(SimControl control) {
        if(control instanceof MainFrame){
            MainFrame mf = (MainFrame)(control);
            mf.getMainFrame().setDefaultCloseOperation(OSPFrame.DISPOSE_ON_CLOSE);
        }
    }
    /**InteractiveMouseHandler Interface Methods*/
    /***********************************************/
    @Override
    public void handleMouseAction(InteractivePanel panel, MouseEvent evt) {
        panel.handleMouseAction(panel, evt); // panel moves the charge
        if(panel.getMouseAction()==InteractivePanel.MOUSE_DRAGGED) {
          calculateField(); // remove this line if user interface is slugish
          panel.repaint();
        }
    }
    /*********************************************/
}
