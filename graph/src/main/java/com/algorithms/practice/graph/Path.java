package com.algorithms.practice.graph;

import java.util.*;

public class Path {

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
        int source = 3;
        int destination = 7;
        var path = findPath(g, source, destination);
        switch (path.size()) {
            case 0 -> System.out.println("No path found between "+source+" and "+destination);
            default -> path.stream().forEach(System.out::println);

        }
    }

    public static List<Integer> findPath(Graph g, int source, int destination) {
        var found = false;
        var pathMap = new HashMap<Integer, Integer>();
        if(source == destination) {
            return List.of(source);
        }
        Set<Integer> visited = new HashSet<>();
        System.out.println("Traversing the graph");
        var queue = new LinkedList<Integer>();
        queue.add(source);
        while(!queue.isEmpty()) {
            var vertex = queue.pollFirst();
            visited.add(vertex);
            if(destination == vertex) {
                found = true;
                break;
            }
            g.getNeighbors(vertex).stream().forEach(n-> {
                if(!visited.contains(n)) {
                    pathMap.put(n, vertex);
                    queue.offerLast(n);
                }
            });
        }
        if(found) {
            return getPath(pathMap, source, destination);
        }
        return List.of();
    }

    private static List<Integer> getPath(HashMap<Integer, Integer> pathMap, int source, int destination) {
        var parent = pathMap.get(destination);
        var path = new ArrayList<Integer>();
        path.add(destination);
        while(parent != null) {
            path.add(parent);
            parent = pathMap.get(parent);
        }
        if(path.getLast() != source) {
            List.of();
        }
        return path.reversed();
    }
}
