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
    double m = 0;
    double vx = 0;
    double vy = 0;

    public double getM() {
        return m;
    }

    public void setM(double m) {
        this.m = m;
    }

    public double getVx() {
        return vx;
    }

    public void setVx(double vx) {
        this.vx = vx;
    }

    public double getVy() {
        return vy;
    }

    public void setVy(double vy) {
        this.vy = vy;
    }
    
    public TestCharge(double x, double y, double q, double m){
        super(x, y, q);
        this.m = m;
    }
        
    @Override
    public double[] getState() {
        return null;
    }

    @Override
    public void getRate(double[] state, double[] rate) {
        
    }
}
