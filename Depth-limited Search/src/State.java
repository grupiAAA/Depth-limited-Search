
public abstract class State {
    protected State parent;
    protected int act;  //action that caused to reach this state
    protected int pathCost;


    public State() {
        parent = null;
        act = -1;
        pathCost = 0;
    }

    public int getAct() {
        return act;
    }
}
