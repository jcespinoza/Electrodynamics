
package tests;

import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.opensourcephysics.controls.AbstractSimulation;
import org.opensourcephysics.controls.Control;
import org.opensourcephysics.controls.MainFrame;
import org.opensourcephysics.controls.SimControl;
import org.opensourcephysics.controls.SimulationControl;
import org.opensourcephysics.display.InteractiveMouseHandler;
import org.opensourcephysics.display.InteractivePanel;
import org.opensourcephysics.display.OSPFrame;
import org.opensourcephysics.frames.Vector2DFrame;
import sun.awt.WindowClosingListener;

/**
 * @author Juan Carlos Espinoza
 *
 */
public class EFApp2 extends AbstractSimulation implements InteractiveMouseHandler{
    int n = 100;
    int a = 50;
    int maxX = a/2;
    int maxY = a/2;
    int minX = -(a/2);
    int minY = -(a/2);
    boolean boundariesEnabled = true;
    boolean bounce = true;
    boolean closeActionFixed  = false;
    double eField[][][] = new double[2][n][n];
    Vector2DFrame frame = new Vector2DFrame("X", "Y", "Electrid Field");
    TestCharge tCharge;
    
    
    public EFApp2(){
        frame.setPreferredMinMax(-a/2, a/2, -a/2, a/2);
        frame.setZRange(false, 0, 2);
        frame.setAll(eField); // sets the vector field
        frame.setInteractiveMouseHandler(this);
        frame.setDefaultCloseOperation(OSPFrame.DISPOSE_ON_CLOSE);       
    }
    
    public static void main(String[] args) {
        SimulationControl.createApp(new EFApp2());
    }

    @Override
    public void run() {
        super.run();
        System.out.println("Ran!");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
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
                if(bounce)
                    tCharge.invertVx();
                tCharge.setX(minX);
                return;
            }
            if(cy < minY){
                if(bounce)
                    tCharge.invertVy();
                tCharge.setY(minY);              
                return;
            }
            if(cx > maxX){
                if(bounce)
                    tCharge.invertVx();
                tCharge.setX(maxX);
                return;
            }
            if(cy > maxY){
                if(bounce)
                    tCharge.invertVy();
                tCharge.setY(maxY);
            }
        }
    }


    @Override
    public void start() {
        calculateField();
        frame.setVisible(true);
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
        double x3 = control.getDouble("x3");
        double y3 = control.getDouble("y3");
        double q3 = control.getDouble("q3");
        Charge charge3 = new Charge(x3, y3, q3);
        frame.addDrawable(charge3);
        double px = control.getDouble("px");
        double py = control.getDouble("py");
        double pq = control.getDouble("pq");
        double pm = control.getDouble("pm");
        tCharge = new TestCharge(px, py, pq, pm);
        frame.addDrawable(tCharge);
        boundariesEnabled = control.getBoolean("Jaula");
        bounce = control.getBoolean("Rebote");
        calculateField();
        frame.setVisible(true);
    }

    @Override
    public void reset() {
        if(!closeActionFixed)
            fixCloseAction(control);
        control.println("Creates charges");
        control.println("You can drag charges.");
        control.setValue("x1", 16);
        control.setValue("y1", 10);
        control.setValue("q1", 3);
        control.setValue("x2", -5);
        control.setValue("y2", 20);
        control.setValue("q2", 3);
        control.setValue("x3", -20);
        control.setValue("y3", 2);
        control.setValue("q3", -3);
        control.setValue("px", 0);
        control.setValue("py", 0);
        control.setValue("pq", -3);
        control.setValue("pm", 0.1);
        control.setValue("Jaula", false);
        control.setValue("Rebote", false);
        frame.clearDrawables();

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

    private void fixCloseAction(SimControl control) {
        if(control instanceof MainFrame){
            MainFrame mf = (MainFrame)(control);
            mf.getMainFrame().setDefaultCloseOperation(OSPFrame.DISPOSE_ON_CLOSE);
        }
    }

    /*********************************************/
}
