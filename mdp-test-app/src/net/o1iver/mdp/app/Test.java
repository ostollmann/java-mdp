/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.o1iver.mdp.app;

import java.io.FileNotFoundException;
import java.io.IOException;
import net.o1iver.mdp.lib.MDP;
import net.o1iver.mdp.lib.Examples;

import net.o1iver.mdp.simulator.Simulator;

import net.o1iver.mdp.Parser;

import net.o1iver.mdp.lib.random.distributions.Normal;
import net.o1iver.mdp.lib.random.DistributionGenerator;

import java.lang.Integer;

import java.text.ParseException;
import java.util.Random;
import java.util.List;

/**
 *
 * @author ost
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
        
        String filePath = "D:\\code\\mdp_1";
        
        Parser parser = new Parser();
        
        parser.parse(filePath);
        
        
//        MDP mdp1 = Examples.exampleMDP1();
//        
//        int numSims = 100;
//        
//        int initState = 1;
//        int[] actions = {0,1,2,3,1,3};
//
//        Simulator sim;
//        List<Integer> simResult;
//        
//        for (int i = 0; i < numSims; i++) {
//            sim = new Simulator(mdp1, initState, actions);
//            simResult = sim.simulate();
//            System.out.println("Sim "+Integer.toString(i+1)+": "+simResult.toString());
//        }
        
    }
}
