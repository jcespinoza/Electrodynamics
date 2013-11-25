/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Practice;

import org.opensourcephysics.numerics.ODE;

/**
 * @author Juan Carlos Espinoza
 *
 */
public class TestCharge extends Charge implements ODE{

    public TestCharge(double x, double y, double q){
        super(x, y, q);
    }
        
    @Override
    public double[] getState() {
        return null;
    }

    @Override
    public void getRate(double[] state, double[] rate) {
        
    }

   

}
