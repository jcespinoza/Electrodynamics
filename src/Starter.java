
import Practice.ElectricFieldApp;
import Practice.FieldLineApp;
import Practice.LaplaceApp;
import Practice.MaxwellApp;
import Practice.RadiatingEFieldApp;
import Practice.VectorPlotApp;
import java.util.Scanner;
import org.opensourcephysics.controls.CalculationControl;
import org.opensourcephysics.controls.SimulationControl;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jay C Espinoza
 */
public class Starter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.println("This is the starter app");
        boolean bored = false;
        do{
            System.out.println("Choose an app to launch:");
            System.out.println("1. Electric Field\n2. Field Line\n3. "
                    + "Laplace\n4. Maxwell\n5. Radiating E Field\n6. Vector Plot\n7. SALIR");
            
            //Lectura
            int seleccion = -1;
            try{
                seleccion = read.nextInt();
            }catch(Exception ex){
                seleccion = -1;
                read = new Scanner(System.in);
            }
            
            switch(seleccion){
                case 1:
                    CalculationControl.createApp(new ElectricFieldApp());
                    break;
                case 2:
                    CalculationControl.createApp(new FieldLineApp());
                    break;
                case 3:
                    SimulationControl.createApp(new LaplaceApp());
                    break;
                case 4:
                    SimulationControl.createApp(new MaxwellApp());
                    break;
                case 5:
                    SimulationControl.createApp(new RadiatingEFieldApp());
                    break;
                case 6:
                    CalculationControl.createApp(new VectorPlotApp());
                    break;
                case 7:
                    bored = true;
                    break;
                case -1:
                    System.out.println("\nSOLO NUMEROS GENIO!!!!\n");
                    break;
                default:
                    System.out.println("Err... Ese numero no lo dije");
            }
        }while(!bored);
    }
}
