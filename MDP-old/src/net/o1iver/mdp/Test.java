package net.o1iver.mdp;

import net.o1iver.mdp.MDP;
import com.ost.mdp.gui.MDPVisualizer;
/**
 *
 * @author ost
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static MDP exampleMDP1() {
        MDP mdp1 = new MDP(3, 2, testTP1(), MDP.Matrix.TP);
        return mdp1;        
    }
    
    private static double[][][] testTP1() {
        double[][][] tp = new double[3][2][3];
        tp[0][0][0] = 0.5;
        tp[0][0][1] = 0;
        tp[0][0][2] = 0.5;
        
        tp[0][1][0] = 0;
        tp[0][1][1] = 1;
        tp[0][1][2] = 0;

        tp[1][0][0] = 0.2;
        tp[1][0][1] = 0.6;
        tp[1][0][2] = 0.2;
        
        tp[1][1][0] = 0.7;
        tp[1][1][1] = 0.2;
        tp[1][1][2] = 0.1;

        tp[2][0][0] = 0.9;
        tp[2][0][1] = 0;
        tp[2][0][2] = 0.1;
        
        tp[2][1][0] = 0.33;
        tp[2][1][1] = 0.33;
        tp[2][1][2] = 0.34;

        return tp;
        
        
    }
}
