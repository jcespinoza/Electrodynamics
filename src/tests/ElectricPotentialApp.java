package tests;

import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.List;
import org.opensourcephysics.controls.AbstractCalculation;
import org.opensourcephysics.controls.CalculationControl;
import org.opensourcephysics.controls.Control;
import org.opensourcephysics.controls.MainFrame;
import org.opensourcephysics.display.InteractiveMouseHandler;
import org.opensourcephysics.display.InteractivePanel;
import org.opensourcephysics.display.OSPFrame;
import org.opensourcephysics.frames.Scalar2DFrame;

/**
 * @author Juan Carlos Espinoza
 *
 */
public class ElectricPotentialApp extends AbstractCalculation implements InteractiveMouseHandler{
    int n = 40;                                // grid points on a side
    double a = 10;                             // viewing side length
    double[][] eField = new double[n][n]; // stores electric field
    boolean closeActionFixed  = false;
    Scalar2DFrame frame = new Scalar2DFrame("x", "y", "Potential Electrico");
    
    public ElectricPotentialApp(){
        frame.setPreferredMinMax(-a, a, -a, a);
        frame.setZRange(false, 0, 2);
        frame.setAll(eField); // sets the vector field
        frame.setDefaultCloseOperation(OSPFrame.DISPOSE_ON_CLOSE);
        frame.setInteractiveMouseHandler(this);
    }
    
    @Override
    public void calculate() {
        double x = control.getDouble("x");
        double y = control.getDouble("y");
        double q = control.getDouble("q");
        Charge charge = new Charge(x, y, q);
        frame.addDrawable(charge);
        calculatePotential();
    }
    
  /**
   * Removes charges and recalculates the field.
   */
  public void reset() {
    if(!closeActionFixed)
        fixCloseAction(control);
    control.println("Calcular crea a una nueva carga y actualiza el campo.");
    control.println("Las cargas pueden arrastrarse.");
    frame.clearDrawables(); // removes all charges
    control.setValue("x", 0);
    control.setValue("y", 0);
    control.setValue("q", 1);
    calculatePotential();
  }

    @Override
    public void handleMouseAction(InteractivePanel panel, MouseEvent evt) {
        panel.handleMouseAction(panel, evt);
        if(panel.getMouseAction()==InteractivePanel.MOUSE_DRAGGED) {
          calculatePotential();
          panel.repaint();
        }
    }

    public static void main(String[] args) {
        CalculationControl.createApp(new ElectricPotentialApp());
    }

    private void calculatePotential() {
        for(int ix = 0; ix < n; ix++) {
          for(int iy = 0; iy < n; iy++)
            eField[ix][iy] = eField[ix][iy] = 0;
        }
        
        List chargeList = frame.getDrawables(Charge.class);
        Iterator it = chargeList.iterator();
        while(it.hasNext()){
            Charge charge = (Charge)it.next();
            double xs = charge.getX(), ys = charge.getY();
            for(int ix = 0; ix < n; ix++){
                double x = frame.indexToX(ix);
                double dx = (xs - x);
                for(int iy = 0; iy < n; iy++){
                    double y = frame.indexToY(iy);
                    double dy = (ys - y);
                    double r2 = dx*dx + dy*dy;
                    double r = Math.sqrt(r2);
                    if(r > 0)
                        eField[ix][iy] += charge.getQ()/r;
                }
            }
        }
        frame.setAll(eField);
    }
    
    private void fixCloseAction(Control control) {
        if(control instanceof MainFrame){
            MainFrame mf = (MainFrame)(control);
            mf.getMainFrame().setDefaultCloseOperation(OSPFrame.DISPOSE_ON_CLOSE);
        }
    }
}
