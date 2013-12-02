/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Practice;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import org.opensourcephysics.controls.CalculationControl;
import org.opensourcephysics.display.InteractivePanel;

/**
 * @author Juan Carlos Espinoza
 *
 */
public class FieldLineApp2 extends FieldLineApp{
    
    
    public FieldLineApp2(){
        super();
    }

    @Override
    public void reset() {
        control.println("Calculate creates a new charge and clears the field lines.");
        control.println("You can drag charges.");
        control.println("Double click in display to compute a field line.");
        
        /****set them done**/
        ArrayList<FieldLine> lines = frame.getDrawables(FieldLine.class);
        for(FieldLine fl:lines){
            fl.setDone(false);
        }
        /*******/
        
        frame.clearDrawables(); // remove charges and field lines
        control.setValue("x", 0);
        control.setValue("y", 0);
        control.setValue("q", 1);
    }
    
    

    @Override
    public void handleMouseAction(InteractivePanel panel, MouseEvent evt) {
        panel.handleMouseAction(panel, evt); // panel handles dragging
        switch(panel.getMouseAction()) {
            case InteractivePanel.MOUSE_DRAGGED :
                if(panel.getInteractive()==null) {
                    return;
                }
                frame.removeObjectsOfClass(FieldLine.class); // field is invalid
                frame.repaint();                             // repaint to keep the screen up to date
                break;
            case InteractivePanel.MOUSE_CLICKED :
                if(evt.getClickCount()>1) {                  // check for double click
                    double x = panel.getMouseX(), y = panel.getMouseY();
                    FieldLine fieldLine = new FieldLine(frame, x, y, +1);
                    panel.addDrawable(fieldLine);
                    fieldLine = new FieldLine(frame, x, y, -1);
                    panel.addDrawable(fieldLine);
                }
                break;
        }
    }
    
    public static void main(String[] args) {
        CalculationControl.createApp(new FieldLineApp2());
    }
}
