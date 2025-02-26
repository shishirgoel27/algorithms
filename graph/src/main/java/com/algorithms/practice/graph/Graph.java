package com.algorithms.practice.graph;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

public class Graph {

    String name;
    Map<Integer, List<Integer>> adjacencyList;

    Graph(String name) {
        this.name = String.copyValueOf(name.toCharArray());
        adjacencyList = new HashMap<>();
    }

    void addEdge(int u, int v) {
        adjacencyList.computeIfAbsent(u, k-> new ArrayList<>()).add(v);
    }

    List<Integer> getNeighbors(int u) {
        return adjacencyList.getOrDefault(u, new ArrayList<>());
    }

    void printGraph() {
        adjacencyList.forEach((k, v) -> {
            System.out.println("" + k + "-->" + v.stream().map(String::valueOf).collect(Collectors.joining(",")));
        });
    }
}
