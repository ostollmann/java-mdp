/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.o1iver.mdp.lib.random;

import net.o1iver.mdp.lib.random.Distribution;

import java.util.Random;
/**
 *
 * @author ost
 */
public class DistributionGenerator {

    private double stepperStartStep;
    private double stepperEndStep;
    private double stepperStepSize;
    
    private Distribution distribution;
    
    private Random rndGen;
    
    public DistributionGenerator(
            Distribution distribution,
            double stepperStartStep,
            double stepperEndStep,
            double stepperStepSize) {
        
        this.distribution = distribution;
        this.stepperStartStep = stepperStartStep;
        this.stepperEndStep = stepperEndStep;
        this.stepperStepSize = stepperStepSize;
        
        rndGen = new Random();
    }
    
    public double sample() {
        double s0 = stepperStartStep;
        double r = rndGen.nextDouble();
        for (double s=stepperStartStep; s < stepperEndStep; s += stepperStepSize) {
            if (distribution.CDF(s) >= r) {
                return (s0+s)/2.0;
            }
            s0 = s;
        }
        return stepperEndStep;
    }
}
