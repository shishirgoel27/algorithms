package com.algorithms.practice.graph;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ShortestPath {

    public static void main(String[] args) {
        Graph g = new Graph("DFS");
        g.addWeightedEdge(1, 2, 4);
        g.addWeightedEdge(2, 5, 2);
        g.addWeightedEdge(5, 6, 3);
        g.addWeightedEdge(6, 8, 2);
        g.addWeightedEdge(1, 3, 1);
        g.addWeightedEdge(3, 4, 3);
        g.addWeightedEdge(4, 5, 3);
        g.addWeightedEdge(5, 7, 1);
        g.addWeightedEdge(7, 8, 2);
        g.printGraph();
        int source = 1;
        int destination = 8;
        var path = findShortestPath(g, source, destination);
        switch (path.size()) {
            case 0 -> System.out.println("No path found between " + source + " and " + destination);
            default -> {
                var pathStr = path.stream().map(String::valueOf).collect(Collectors.joining("-->"));
                System.out.println(pathStr);
            }

        }
    }

    public static List<Integer> findShortestPath(Graph g, int source, int destination) {
        Node found = null;
        Node startNode = new Node(source, 0);
        var pathMap = new HashMap<Node, Node>();
        if (source == destination) {
            return List.of(source);
        }
        Set<Node> visited = new HashSet<>();
        System.out.println("Traversing the graph");
        var queue = new PriorityQueue<>(Comparator.comparingInt(Node::cost));
        queue.add(startNode);
        System.out.println("Node added to queue: "+startNode);
        while (!queue.isEmpty()) {
            var node = queue.poll();
            visited.add(node);
            if (destination == node.vertex) {
                found = node;
                break;
            }
            g.getWeightedNeighbors(node.vertex())
                    .stream()
                    .map(e -> new Node(e.end(), node.cost() + e.weight()))
                    .forEach(n -> {
                        if (!visited.contains(n)) {
                            pathMap.put(n, node);
                            queue.offer(n);
                            System.out.println("Node added to queue: "+n);
                            System.out.println("Path elements so far: "+pathMap.toString());
                        }
                    });
        }
        if (found != null) {
            return getPath(pathMap, startNode, found);
        }
        return List.of();
    }

    private static List<Integer> getPath(HashMap<Node, Node> pathMap, Node source, Node destination) {
        var parent = pathMap.get(destination);
        var path = new ArrayList<Node>();
        path.add(destination);
        while (parent != null) {
            path.add(parent);
            parent = pathMap.get(parent);
        }
        if (!path.getLast().equals(source)) {
            List.of();
        }
        return path.reversed()
                .stream()
                .map(Node::vertex)
                .collect(Collectors.toCollection(ArrayList<Integer>::new));
    }

    private static record Node(int vertex, int cost) {
        @Override
        public boolean equals(Object obj) {
            return obj == this ||
                    (
                            obj instanceof Node node && (node.vertex() == vertex() && node.cost() == cost())
                    );
        }
    }
}
