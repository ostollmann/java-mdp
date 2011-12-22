/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.o1iver.mdp.lib.random;

/**
 *
 * @author ost
 */
public interface Distribution {
    
    public double PDF(double x);
    public double CDF(double x);
    
}
