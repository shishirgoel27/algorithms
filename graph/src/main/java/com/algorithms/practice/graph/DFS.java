package com.algorithms.practice.graph;

import java.util.HashSet;
import java.util.Set;

public class DFS {

    public static void main(String[] args) {
        Graph g = new Graph("DFS");
        g.addEdge(1,2);
        g.addEdge(2,3);
        g.addEdge(2,4);
        g.addEdge(3,5);
        g.addEdge(3,8);
        g.addEdge(3,9);
        g.addEdge(5,7);
        g.addEdge(4,6);
        g.addEdge(8,10);
        g.printGraph();
        dfs(g, 1);
    }

    public static void dfs(Graph g, int source) {
        Set<Integer> visited = new HashSet<>();
        System.out.println("Traversing the graph");
        dfsRec(g, source, visited);
    }

    private static void dfsRec(Graph g, int source, Set<Integer> visited) {
        System.out.println(source);
        visited.add(source);
        g.getNeighbors(source)
                .stream()
                .forEach(n -> {
                    if(!visited.contains(n)) {
                        dfsRec(g,n,visited);
                    }
                });

    }
}
