/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.o1iver.mdp.lib.random.distributions;

import net.o1iver.mdp.lib.random.Distribution;
import net.o1iver.mdp.lib.random.Util;

/**
 *
 * @author ost
 */
public class Normal implements Distribution {

    public double mean;
    public double variance;
    
    public Normal(double mean, double variance) {
        this.mean = mean;
        this.variance = variance;
    }

    @Override
    public double CDF(double x) {
        return (1.0/2.0)*(1+Util.erf((x-mean)/Math.sqrt(2*variance)));
    }

    @Override
    public double PDF(double x) {
        return (1/Math.sqrt(2*Math.PI*variance))*Math.exp(-1*Math.pow(x-mean,2)/2*variance);
    }


}
