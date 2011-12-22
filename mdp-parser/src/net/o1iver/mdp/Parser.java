/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.o1iver.mdp;

import net.o1iver.mdp.lib.MDP;

import java.util.List;
import java.util.ArrayList;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.text.ParseException;


/**
 *
 * @author ost
 */
public class Parser {
    
    public Parser() {
    }
    
    public void parse(String filePath) throws FileNotFoundException, IOException, ParseException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;

        int numStates = -1;
        int numActions = -1;
        
        while ((line = reader.readLine()) != null) {
            if (line.trim().length() == 0) continue;
            if (line.startsWith("#")) continue;
            
            if (line.startsWith("states")) {
                line = line.substring(8);
                numStates = Integer.parseInt(line);
                System.out.println("Found num states: "+Integer.toString(numStates));
            } else if (line.startsWith("actions")) {
                line = line.substring(9);
                numActions = Integer.parseInt(line);
                System.out.println("Found num actions: "+Integer.toString(numActions));
            }
        }
        
        // Check if valid number of states found
        if (numStates == -1) {
            throw new ParseException("Invalid number of states: " + Integer.toString(numStates),0);
        }

        if (numActions == -1) {
            throw new ParseException("Invalid number of actions: " + Integer.toString(numActions),0);
        }
        
        System.out.println("Num states: " + Integer.toString(numStates));        
        System.out.println("Num actions: " + Integer.toString(numActions));
        
        
        reader = new BufferedReader(new FileReader(filePath));
        
        
        // Initialize matrices
        double[][][] tp = new double[numStates][numActions][numStates];
        double[][][] r  = new double[numStates][numActions][numStates];
        
        while ((line = reader.readLine()) != null) {
            if (line.trim().length() == 0) continue;
            if (line.startsWith("#")) continue;
            
            if (line.startsWith("T")) {
                tp = parseLine(tp, line);
            } else if (line.startsWith("R")) {
                r = parseLine(r, line);
            } else {
                continue;
            }
        }
    }
    
    private double[][][] parseLine(double[][][] matrix, String line) {
        // remove first three identifier chars
        line = line.substring(3);
        String[] parts = line.split(" ");

        String sourceStateStr = parts[0];
        String sinkStateStr   = parts[2];
        String actionStr      = parts[4];
        String valueStr       = parts[5];
        
        System.out.print("source: "+sourceStateStr);
        System.out.print(", sink: "+sinkStateStr);
        System.out.print(", action: "+actionStr);
        System.out.println(", value: "+valueStr);
        
        
        return matrix;   
    }
    
}
