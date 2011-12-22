package net.o1iver.mdp;

/**
 *
 * @author ost
 */
public class MDP {
    
    private static final double defaultTPValue = 0;
    private static final double defaultRValue = 0;
    
    public enum Matrix {TP,R}
    // TODO: implement this, for MatrixToString
    public enum Pivot {SourceState,SinkState,Action}
    
    private int numStates;
    private int numActions;
    private double tp[][][];
    private double r[][][];
    
    public MDP(int NumStates, int NumActions) {
        this(NumStates, NumActions, MDP.defaultTPValue, MDP.defaultRValue);
    }
        
    public MDP(int NumStates, int NumActions, double TPVal, double RVal) {
        this.numStates = NumStates;
        this.numActions = NumActions;
        
        this.initializeTP(NumStates, NumActions, TPVal);
        this.initializeR(NumStates, NumActions, RVal);
        
    }
    
    public MDP(int NumStates, int NumActions, double Matrix[][][], Matrix WhichMatrix) {
        this.numStates = NumStates;
        this.numActions = NumActions;
        if (WhichMatrix == MDP.Matrix.TP) {
            this.tp = Matrix;
            this.initializeR(NumStates, NumActions, defaultRValue);
        } else {
            this.r = Matrix;
            this.initializeTP(NumStates, NumActions, defaultTPValue);
        }
    }
    
    public MDP(int NumStates, int NumActions, double TP[][][], double R[][][]) {
        this.numStates = NumStates;
        this.numActions = NumActions;
        this.tp = TP;
        this.r = R;
    }

    private void initializeTP(int NumStates, int NumActions, double TPVal) {
        this.tp = new double[NumStates][NumActions][NumStates];        
        for (int source = 0; source < NumStates; source++) {
            for (int action = 0; action < NumActions; action++) {
                for (int sink = 0; sink < NumStates; sink++) {
                    this.tp[source][action][sink] = TPVal;
                }
            }
        }        
    }

    private void initializeR(int NumStates, int NumActions, double RVal) {
        this.r = new double[NumStates][NumActions][NumStates];        
        for (int source = 0; source < NumStates; source++) {
            for (int action = 0; action < NumActions; action++) {
                for (int sink = 0; sink < NumStates; sink++) {
                    this.r[source][action][sink] = RVal;
                }
            }
        }
    }
    
    public int NumberOfStates() {
        return this.numStates;
    }
    
    public int NumberOfActions() {
        return this.numActions;
    }
    
    public double[][][] TP() {
        return this.tp;
    }
    public double TP(int source_state, int action, int sink_state) {
        return this.tp[source_state][action][sink_state];
    }
    public void TP(int source_state, int action, int sink_state, double value) {
        this.tp[source_state][action][sink_state] = value;
    }
    
    public double[][][] R() {
        return this.r;
    }
    public double R(int source_state, int action, int sink_state) {
        return this.r[source_state][action][sink_state];
    }
    
    public void R(int source_state, int action, int sink_state, double value) {
        this.r[source_state][action][sink_state] = value;
    }
    
    public String MatrixToString(Matrix WhichMatrix, int Action, int NumDecimalPlaces) {
        String str = "";
        String patt = "%."+Integer.toString(NumDecimalPlaces)+"f ";
        
        double val;
        for (int source = 0; source < this.numStates; source++) {
            for (int sink = 0; sink < this.numStates; sink++) {
                if (WhichMatrix == MDP.Matrix.TP) {
                    val = this.TP(source,Action,sink);
                } else {
                    val = this.R(source,Action,sink);                        
                }
                str += String.format(patt,val);
            }
            str += "\n";
        }
        return str;
    }
    
    public String InfoToString() {
        String str = "";
        str += "MDP Information:\n";
        str += String.format(" - number of states:  %d\n",this.numStates);
        str += String.format(" - number of actions: %d\n",this.numActions);
        return str;
    }
    
}