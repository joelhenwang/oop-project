package graph;

import java.util.ArrayList;
import java.util.Random;

public class WeightedGraph extends AbstractGraph{


    public WeightedGraph(int n_nodes) {
        super(n_nodes);
    }

    @Override
    public void addEdgeToList(int n1, int n2, double weight) {
        this.adjList[n1].addEdgeToNode(n2, weight);
        this.adjList[n2].addEdgeToNode(n1, weight);
    }
    @Override
    public void addEdgeToList(int n1, int n2){
        throw new RuntimeException("Error addEdgeToList(int n1, int n2): Cannot add a Unweighted Edge to an Weighted Graph.\n");
    }

    @Override
    public void createRandomGraph(int max_weight){

        Random rand = new Random();

        int num_edges = rand.nextInt(max_edges - n_nodes) + n_nodes;
        ArrayList<Integer> hamiltonean_path = generateRandomHamiltoneanPath();

        for (int j = 0; j < hamiltonean_path.size(); j++) {
            if( j + 1 == hamiltonean_path.size()) break;
            int node1 = hamiltonean_path.get(j);
            int node2 = hamiltonean_path.get(j + 1);

            double weight = rand.nextInt(max_weight - 1) + 1;

            addEdgeToList( node1, node2 , weight);
        }

        int i = n_nodes;
        while (i <= num_edges) {
            int node1 = rand.nextInt(n_nodes);
            int node2 = rand.nextInt(n_nodes);

            if( node1 == node2 ) continue;
            if( adjList[node1].getLinked().contains(node2) ) continue;

            double weight = rand.nextInt(max_weight - 1) + 1;

            addEdgeToList( node1, node2 , weight);

            i++;
        }
    }

    @Override
    public void createRandomGraph(){
        throw new RuntimeException("Error createRandomGraph(): Cannot create a Random Weighted Graph without weights.\n");
    }

}
