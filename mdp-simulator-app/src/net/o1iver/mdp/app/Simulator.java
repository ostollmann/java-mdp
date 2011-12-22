/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.o1iver.mdp.app;

import net.o1iver.mdp.lib.MDP;
import net.o1iver.mdp.lib.Examples;

/**
 *
 * @author ost
 */
public class Simulator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MDP mdp1 = net.o1iver.mdp.lib.Examples.exampleMDP1();
        
        System.out.print(mdp1.InfoToString());
    }
}
