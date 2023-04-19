import java.util.ArrayList;
import java.util.List;

public abstract class Problem {
    protected State initialState;
    protected State goalState;

    public State getInitialState() {
        return initialState;
    }

    abstract public boolean goalTest(State state);

    abstract public ArrayList<Integer> actions(State state);

    abstract public State nextState(State state, int action);

    abstract public int stepCost(State firstState, int action, State secondState);

    abstract public int pathCost(List<Integer> path);

    /**
     * heuristic function, the cost to get from the node to the goal
     * you should override it based on your problem to use AStar search
     */
    public int h(State state) {
        return 0;
    }
}
