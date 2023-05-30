package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Graph {
    private final int n_nodes;
    private final int max_edges;
    private final Node[] adjList;

    public Graph(int n_nodes){
        this.n_nodes = n_nodes;
        this.max_edges = (n_nodes * (n_nodes - 1)) / 2;
        this.adjList = new Node[n_nodes];
        for(int l = 0; l < n_nodes; l++){
            this.adjList[l] = new Node(l+1);
        }
    }

    public void addEdgeToList(int n1, int n2, int weight){
        this.adjList[ n1 ].addEdgeToNode( n2 , weight);
        this.adjList[ n2 ].addEdgeToNode( n1 , weight);

    }

    public Node getNode(int id){
        return this.adjList[ id ];
    }

    public Node[] getNodeList(){
        return this.adjList;
    }

    public void createRandomGraph(int max_weight){

        Random rand = new Random();

        int num_edges = rand.nextInt(max_edges - n_nodes) + n_nodes;
        ArrayList<Integer> hamiltonean_path = generateRandomHamiltoneanPath();

        for (int j = 0; j < hamiltonean_path.size(); j++) {
            if( j + 1 == hamiltonean_path.size()) break;
            int node1 = hamiltonean_path.get(j);
            int node2 = hamiltonean_path.get(j + 1);

            int weight = rand.nextInt(max_weight - 1) + 1;

            addEdgeToList( node1, node2 ,weight);
        }

        int i = n_nodes;
        while (i <= num_edges) {
            int node1 = rand.nextInt(n_nodes);
            int node2 = rand.nextInt(n_nodes);

            if( node1 == node2 ) continue;
            if( adjList[node1].linked.contains(node2) ) continue;

            int weight = rand.nextInt(max_weight - 1) + 1;

            addEdgeToList( node1, node2 ,weight);

            i++;
        }



    }

    private ArrayList<Integer> generateRandomHamiltoneanPath()
    {
        ArrayList<Integer> hamiltonean_path = new ArrayList<>(n_nodes);

        for (int i = 0; i < n_nodes; i++)
            hamiltonean_path.add(i);

        Collections.shuffle(hamiltonean_path);

        return hamiltonean_path;
    }


}
