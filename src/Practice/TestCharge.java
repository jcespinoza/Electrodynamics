/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Practice;

import org.opensourcephysics.numerics.Adams4;
import org.opensourcephysics.numerics.Euler;
import org.opensourcephysics.numerics.ODE;
import org.opensourcephysics.numerics.ODESolver;
import org.opensourcephysics.numerics.RK45;
import org.opensourcephysics.numerics.Verlet;

/**
 * @author Juan Carlos Espinoza
 *
 */
public class TestCharge extends Charge implements ODE{
    double m = 0;
    double vx = 0;
    double vy = 0;
    double Ex, Ey = 0;
    double[] state = new double[7];
    ODESolver odeSolver = new RK45(this);

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
        return state;
    }

    @Override
    public void getRate(double[] state, double[] rate) {
        rate[0] = state[1]; // dx/dt = vx
        rate[1] = state[3]; // dy/dt = vy
        rate[2] = (q*Ex)/m; // dvx/dt = ax = qEx/m
        rate[3] = (q*Ey)/m; // dvy/dt = ay = qEy/m
        rate[4] = 0.0000001; // dt/dt = 1
    }
    
   /**
   * Steps the time using an ode solver.
   */
  public void doStep(double _Ex, double _Ey) {
    System.out.println("X,Y: " + getX() + " , " + getY() + "- Ex,Ey: " + _Ex + " , " + _Ey);
    Ex = _Ex;
    Ey = _Ey;
    odeSolver.step();
    setX(state[0]);
    setY(state[2]);
  }
}
