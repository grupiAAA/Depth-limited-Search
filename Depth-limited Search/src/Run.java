import java.util.Scanner;

public class Run {

    public static void main(String[] args) {
        Problem problem = new NavigationProblem();
        Search search;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you want to run in graph mode(0) or tree mode(1): ");
        int graphChoice = scanner.nextInt();
        boolean isGraph = true;
        if (graphChoice == 1)
            isGraph = false;
                System.out.print("please enter the depth: ");
                int depth = scanner.nextInt();
                search = new SearchDLS(isGraph, depth);
        search.setProblem(problem);
        search.execute();
        showResultOfSearch(search);
    }

    public static void showResultOfSearch(Search search) {
        System.out.println("Result of the " + search.getClass().getSimpleName());
        System.out.print("path: 0 ");
        for (int i = search.getPath().size() - 2; i >= 0; i--) {
            System.out.print(search.getPath().get(i) + " ");
        }
        System.out.println();
        System.out.println("path cost: " + search.answer.pathCost);
        System.out.println("Depth of the result: " + (search.getPath().size() - 1));
        System.out.println("Number of node that has been seen: " + search.getNodeSeen());
        System.out.println("Number of node that has been expanded: " + search.getNodeExpand());
        System.out.println("Maximum number of nodes kept in memory: " + search.getMaxNodeKeptInMemory());
    }
}
