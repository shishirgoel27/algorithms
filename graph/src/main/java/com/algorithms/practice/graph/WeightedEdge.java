package com.algorithms.practice.graph;

public record WeightedEdge(int end, int weight){
    WeightedEdge(int end){
        this(end, 0);
    }
}
