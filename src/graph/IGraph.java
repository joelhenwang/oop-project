package graph;

import java.util.ArrayList;

public interface IGraph {

    public Node getNode(int id);
    public Node[] getNodeList();
    public void addEdgeToList(int n1, int n2 );
    public void addEdgeToList(int n1, int n2 , double weight);
    public void createRandomGraph();
    public void createRandomGraph(int max_weight);

    ArrayList<Integer> generateRandomHamiltoneanPath();

}
