package Practice;

import org.opensourcephysics.numerics.Euler;
import org.opensourcephysics.numerics.EulerRichardson;
import org.opensourcephysics.numerics.ODE;
import org.opensourcephysics.numerics.ODESolver;

/**
 * @author Juan Carlos Espinoza
 *
 */
public class TestCharge extends Charge implements ODE{
    double m = 0;
    double Ex, Ey = 0;
    double[] state = new double[5];
    ODESolver odeSolver = new EulerRichardson(this);//RK45(this);

    public double getM() {
        return m;
    }

    public void setM(double m) {
        this.m = m;
    }

    @Override
    public void setX(double x) {
        super.setX(x);
        state[0] = x;
    }

    @Override
    public void setY(double y) {
        super.setY(y);
        state[2] = y;
    }
    
    
    
    public void setVx(double vx){
        state[1] = vx;
    }
    
    public void setVy(double vy){
        state[3] = vy;
    }
   
    public TestCharge(double x, double y, double q, double m){
        super(x, y, q);
        state[0] = getX();
        state[2] = getY();
        this.m = m;
        setEnabled(false);
    }
        
    @Override
    public double[] getState() {
        return state;
    }

    @Override
    public void getRate(double[] state, double[] rate) {
        //System.out.println("dx: " + rate[0] +" , "+ "dy: " + rate[1] +" , " + "dvx: " + rate[2] +" , " + "dvy: " + rate[3] +" , " + "dt: " + rate[4]);
        rate[0] = state[1]; // dx/dt = vx
        rate[1] = (q*Ex)/m; // dvx/dt = ax = qEx/m
        rate[2] = state[3]; // dy/dt = vy
        rate[3] = (q*Ey)/m; // dvy/dt = ay = qEy/m
        rate[4] = 1; // dt/dt = 1
    }
    
   /**
   * Steps the time using an ode solver.
   */
  public void doStep(double _Ex, double _Ey) {
    //System.out.println("X,Y: " + (int)getX() + " , " + (int)getY() + "- Ex,Ey: " + _Ex + " , " + _Ey);
      //System.out.println("X: " + getX() + " , " + "Y: " + getY() + " , " + "Vx: " + state[1] + " , " + "Vy: " + state[3]);
    Ex = _Ex;
    Ey = _Ey;
    odeSolver.step();
    setX(state[0]);
    setY(state[2]);
      //System.out.println("X=" + getX() + " Y=" + getY() + " Vx=" + state[1] + " Vy=" + state[3] + " Ex=" + Ex + " Ey=" + Ey);
  }

    public void forceRest(){
        setVx(0);
        setVy(0);
    }
    
    public void invertVx(){
        state[1] *= -0.5;//-state[1]*0.5);
    }

    public void invertVy(){
        state[3] *= -0.5;

    }    
}
