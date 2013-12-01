
package Practice;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import org.opensourcephysics.controls.CalculationControl;
import org.opensourcephysics.display.InteractivePanel;

/**
 * @author Juan Carlos Espinoza
 *
 */
public class FieldLineApp31 extends FieldLineApp{
    double distance = 1.5; //distancia desde donde las lineas deben comenzar a dibujarse.
    InteractivePanel iPanel = null;
    public FieldLineApp31(){
        super();
    }
    /*/*Overrode Methods*///
    /*********************************/
    @Override
    public void calculate() {
        super.calculate();
        showLines();
    }
    
    

    @Override
    public void handleMouseAction(InteractivePanel panel, MouseEvent evt) {
        panel.handleMouseAction(panel, evt); // panel handles dragging
        switch(panel.getMouseAction()) {
            case InteractivePanel.MOUSE_MOVED:
                iPanel = panel;
                break;
            case InteractivePanel.MOUSE_CLICKED:
                showLines();
                break;
            case InteractivePanel.MOUSE_DRAGGED :
                if(panel.getInteractive()==null) {
                    return;
                }
                frame.removeObjectsOfClass(FieldLine.class); // field is invalid
                frame.repaint();                             // repaint to keep the screen up to date
                break;
            case InteractivePanel.MOUSE_RELEASED:
            showLines();
            break;
        }     
    }

    @Override
    public void reset() {
        control.println("Calculate creates a new charge and clears the field lines.");
        control.println("You can drag charges.");
        frame.clearDrawables(); // remove charges and field lines
        control.setValue("x", 0);
        control.setValue("y", 0);
        control.setValue("q", 1);
    }
   
    public static void main(String[] args) {
        CalculationControl.createApp(new FieldLineApp31());
    }
    /******************************************/

    /**Own Methods*/
    /************************************/
    private void showLines() {
        if(iPanel==null) return;
        ArrayList<Charge> chargeList = frame.getDrawables(Charge.class); //tomos las particulas chargadas de la lista de objetos Dibujables del panel, solo necesito cargas

        for(Charge c : chargeList){ //recorro la lista
            double q = Math.abs(c.getQ()); //tomo la carga de la particula y la guardo
            if(q != 0){ //busco solo las positivas
                double xCenter = c.getX(); //tomo las coordenadas de la particula
                double yCenter = c.getY();
                double dtheta = 2*Math.PI/10*q; //guardo el diferencial del angulo, esto es para rodear la carga.

                for(int i = 0; i < 10*q /*& (i > 0)*/ ;i++){
                    double dx = distance*Math.cos(i*dtheta); //calculo el diferencia de las coordenadas con la formula
                    double dy = distance*Math.sin(i*dtheta);
                    double px = xCenter + dx; //sumo el difeencial a la distancia total desde la particula
                    double py = yCenter + dy;
                    FieldLine fLine = new FieldLine(frame, px, py, 0.1);
                    iPanel.addDrawable(fLine);
                    fLine = new FieldLine(frame, px, py, -0.1);
                    iPanel.addDrawable(fLine);
                }
            }
        }
    }
    /************************************/
}