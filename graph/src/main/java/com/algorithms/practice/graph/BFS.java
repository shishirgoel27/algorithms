package com.algorithms.practice.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class BFS {

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
        bfs(g, 1);
    }

    public static void bfs(Graph g, int source) {
        Set<Integer> visited = new HashSet<>();
        System.out.println("Traversing the graph");
        var queue = new LinkedList<Integer>();
        queue.add(source);
        while(!queue.isEmpty()) {
            var vertex = queue.pollFirst();
            visited.add(vertex);
            System.out.println(vertex);
            g.getNeighbors(vertex).stream().forEach(n-> {
                if(!visited.contains(n)) {
                    queue.offerLast(n);
                }
            });
        }
    }
}
