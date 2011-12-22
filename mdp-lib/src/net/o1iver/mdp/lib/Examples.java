/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.o1iver.mdp.lib;

/**
 *
 * @author ost
 */
public class Examples {
    
    public static MDP exampleMDP1() {
        MDP mdp1 = new MDP(3, 2, testTP1(), MDP.Matrix.TP);
        return mdp1;        
    }
    
    private static double[][][] testTP1() {
        double[][][] tp = new double[3][4][3];
        tp[0][0][0] = 0.3;
        tp[0][0][1] = 0.3;
        tp[0][0][2] = 0.3;
        
        tp[0][1][0] = 0;
        tp[0][1][1] = 1;
        tp[0][1][2] = 0;
        
        tp[0][2][0] = 0.25;
        tp[0][2][1] = 0.25;
        tp[0][2][2] = 0.5;

        tp[0][3][0] = 0.9;
        tp[0][3][1] = 0.05;
        tp[0][3][2] = 0.05;
        
        
        tp[1][0][0] = 0.2;
        tp[1][0][1] = 0.6;
        tp[1][0][2] = 0.2;
        
        tp[1][1][0] = 0.7;
        tp[1][1][1] = 0.2;
        tp[1][1][2] = 0.1;

        tp[1][2][0] = 0.25;
        tp[1][2][1] = 0.25;
        tp[1][2][2] = 0.5;

        tp[1][3][0] = 0.9;
        tp[1][3][1] = 0.05;
        tp[1][3][2] = 0.05;

        
        tp[2][0][0] = 0.9;
        tp[2][0][1] = 0;
        tp[2][0][2] = 0.1;
        
        tp[2][1][0] = 0.33;
        tp[2][1][1] = 0.33;
        tp[2][1][2] = 0.34;

        tp[2][2][0] = 0.2;
        tp[2][2][1] = 0.2;
        tp[2][2][2] = 0.6;

        tp[2][3][0] = 0.75;
        tp[2][3][1] = 0.05;
        tp[2][3][2] = 0.2;

        return tp;
        
        
    }

}
