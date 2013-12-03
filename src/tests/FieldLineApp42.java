/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tests;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import org.opensourcephysics.controls.CalculationControl;
import org.opensourcephysics.display.InteractivePanel;

/**
 * @author Juan Carlos Espinoza
 *
 */
public class FieldLineApp42 extends FieldLineApp31{
    
    public static void main(String[] args) {
        CalculationControl.createApp(new FieldLineApp42());
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
                ArrayList<FieldLine4> lines = frame.getDrawables(FieldLine4.class);
                for(FieldLine4 fl:lines){
                    fl.setDone(false);
                }
                frame.removeObjectsOfClass(FieldLine4.class); // field is invalid
                frame.repaint();                             // repaint to keep the screen up to date
                break;
            case InteractivePanel.MOUSE_RELEASED:
            showLines();
            break;
        }     
    }
    
    @Override
    public void reset() {
        if(!closeActionFixed)
            fixCloseAction(control);
        control.println("Calculate creates a new charge and clears the field lines.");
        control.println("You can drag charges.");
        ArrayList<FieldLine4> lines = frame.getDrawables(FieldLine4.class);
        for(FieldLine4 fl:lines){
            fl.setDone(false);
        }
        frame.clearDrawables(); // remove charges and field lines
        control.setValue("x", 0);
        control.setValue("y", 0);
        control.setValue("q", 1);
    }
    
    @Override
    public void showLines() {
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
                    FieldLine4 fLine = new FieldLine4(frame, px, py, 0.1);
                    iPanel.addDrawable(fLine);
                    fLine = new FieldLine4(frame, px, py, -0.1);
                    iPanel.addDrawable(fLine);
                }
            }
        }
    }
}
