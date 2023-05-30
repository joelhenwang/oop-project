package graph;
import java.util.Stack;

public class HamiltoneanCycle {
    private final Node start;
    private final int n_nodes;
    private boolean[] visited;
    private final Node[] nodeList;
    Stack<Node> cycle = new Stack<Node>();
    boolean hasCycle = false;

    public HamiltoneanCycle(Node start, int n_nodes, Node[] nodeList){
        this.start = start;
        this.n_nodes = n_nodes;
        this.visited = new boolean[n_nodes];
        for (int i = 0; i < n_nodes; i++) this.visited[i] = false;
        this.nodeList = nodeList;
    }

    public void findCycle(){
        //add starting vertex to the list
        cycle.push(start);

        //start searching the path
        solve(start);
    }

    public void solve(Node node){
        if( node == start && cycle.size() == n_nodes + 1 ){
            hasCycle = true;

            //output the cycle
            System.out.println(cycle);

            //return to explore more hamiltonian cycles
            return;
        }

        for(Edge nbr: node.edges){
            int neighb = nbr.getDestination();
            if(!visited[neighb]){
                //visit and add vertex to the cycle
                visited[neighb] = true;
                cycle.push(nodeList[neighb]);

                //Go to the neighbor vertex to find the cycle
                solve(nodeList[neighb]);

                //Backtrack
                visited[neighb] = false;
                cycle.pop();
            }
        }
    }
}
