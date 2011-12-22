/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.o1iver.mdp.simulator;

import net.o1iver.mdp.lib.MDP;

import java.util.ArrayList;
import java.util.List;

import java.util.Random;

/**
 *
 * @author ost
 */
public class Simulator {
    
    private int initState;
    private int[] actions;
    
    private MDP mdp;
    
    private Random rndGen;
    
    public Simulator(MDP mdp, int initState, int[] actions) {
        this.initState = initState;
        this.actions = actions;
        this.mdp = mdp;
        
        rndGen = new Random();
        
    }
    
    public List<Integer> simulate() {
        
        List<Integer> states = new ArrayList<Integer>();
        states.add(initState);

        int currentState = initState;
        
        int numSteps = actions.length;
        
        for (int n = 0; n < numSteps; n++) {
            currentState = simulateStep(mdp,currentState,actions[n],rndGen);
            states.add(currentState);
        }
        return states;
    }
    
    private static int simulateStep(MDP mdp, int sourceState, int action, Random rndGen) {
        
        double r = rndGen.nextDouble();
        int sinkState = -1;
                
        double rSum = 0;
        while (r > rSum) {
            // TODO: fix this, will throw out-of-bound exception 
            // if we overflow the num of states (because the 
            // sum of probabilities is not equal to 1).
            //if (sinkState == mdp.NumberOfStates()) {
            //}
            sinkState++;
            rSum += mdp.TP(sourceState, action, sinkState);
        }
        return sinkState;        
    }
}
