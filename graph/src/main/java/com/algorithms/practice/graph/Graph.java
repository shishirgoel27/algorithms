package com.algorithms.practice.graph;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

public class Graph {

    String name;
    Map<Integer, List<WeightedEdge>> adjacencyList;

    Graph(String name) {
        this.name = String.copyValueOf(name.toCharArray());
        adjacencyList = new HashMap<>();
    }

    void addEdge(int u, int v) {
        addWeightedEdge(u, v , 0);
    }

    void addWeightedEdge(int u, int v, int weight) {
        adjacencyList.computeIfAbsent(u,
                k-> new ArrayList<WeightedEdge>()).add(new WeightedEdge(v, weight)
        );
    }

    List<Integer> getNeighbors(int u) {
        return getWeightedNeighbors(u)
                .stream()
                .map(WeightedEdge::end)
                .toList();
    }

    List<WeightedEdge> getWeightedNeighbors(int u) {
        return adjacencyList.getOrDefault(u, new ArrayList<>());
    }

    void printGraph() {
        System.out.println("Printing "+name+" graph");
        adjacencyList.forEach((k, v) -> {
            System.out.println("" + k + "-->" + v.stream().map(String::valueOf).collect(Collectors.joining(",")));
        });
    }
}
