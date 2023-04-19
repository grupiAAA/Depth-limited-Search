
public class SearchDLS extends Search {
    private int limit;

    public SearchDLS(boolean isGraph, int limit) {
        super(isGraph);
        if (limit < 0)
            System.out.println("invalid limit");
        else
            this.limit = limit;
    }

    @Override
    public void execute() {
        search();
    }

    @Override
    public void search() {
        search(problem.getInitialState(), limit);
    }

    public int search(State node, int limit) {
        if (problem.goalTest(node)) {
            answer = node;
            createSolutionPath(node);
            return 1;
        } else if (limit == 0) {
            return 0;
        } else {
            nodeExpand++;
            boolean cutoffOccurred = false;
            for (Integer action : problem.actions(node)) {
                State child = problem.nextState(node, action);
                nodeSeen++;
                if (isGraph) {
                    if (!e.contains(child)) {
                        e.add(node);
                        int result = search(child, limit - 1);
                        if (result == 0) {
                            cutoffOccurred = true;
                        } else if (result != -1) {
                            return result;
                        }
                    }
                } else {
                    int result = search(child, limit - 1);
                    if (result == 0)
                        cutoffOccurred = true;
                    else if (result != -1)
                        return result;
                }

                maxNodeKeptInMemory = Integer.max(maxNodeKeptInMemory, e.size());

            }

            //memory optimization because it's not part of the solution
            if (isGraph)
                e.remove(node);

            if (cutoffOccurred)
                return 0;
            else
                return -1;
        }

    }
}
