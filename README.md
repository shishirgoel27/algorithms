# Algorithms

A collection of algorithm implementations in Java, organized into modular Maven projects. This repository covers common data structures and algorithmic problems including arrays, graphs, linked lists, and binary trees.

## Project Structure

This is a multi-module Maven project built with **Java 21**.

```
Algorithms/
├── pom.xml           # Parent POM
├── arrays/           # Array-based algorithm problems
├── graph/            # Graph data structures and traversal algorithms
├── list/             # Linked list operations
└── tree/             # Binary tree utilities
```

## Modules

### 1. Arrays Module

Contains solutions for common array manipulation problems.

| Class | Description |
|-------|-------------|
| `ContainsDuplicate` | Checks if an array contains any duplicate values. Provides two implementations: using HashMap and HashSet. |
| `MatchingSumInArray` | Given a list of numbers and a target `k`, determines if any two numbers add up to `k` (Two Sum problem). |
| `MissingNumber` | Finds the missing minimum positive number in an array containing positive, negative, and duplicate numbers in O(n) time and O(1) space. |
| `MultiplyExceptSelf` | Returns a new array where each element is the product of all elements except itself, without using division. |
| `CountOccurrenceInSortedArray` | Uses binary search to count occurrences of a given number in a sorted array. |

### 2. Graph Module

Implements graph data structures and common traversal algorithms.

| Class | Description |
|-------|-------------|
| `Graph` | Adjacency list representation of a graph supporting both weighted and unweighted edges. |
| `WeightedEdge` | Record representing an edge with a destination vertex and weight. |
| `BFS` | Breadth-First Search traversal implementation using a queue. |
| `DFS` | Depth-First Search traversal implementation using recursion. |
| `Path` | Finds a path between two vertices using BFS. |
| `ShortestPath` | Dijkstra's algorithm implementation to find the shortest path in a weighted graph using a priority queue. |

### 3. List Module

Contains linked list operations.

| Class | Description |
|-------|-------------|
| `ReverseList` | Reverses a singly linked list with both recursive and iterative approaches. Includes utility methods to build and print a linked list. |

### 4. Tree Module

Binary tree utilities and operations.

| Class | Description |
|-------|-------------|
| `BinaryTreeUtility` | Provides binary tree operations including calculating tree height/depth and checking if two trees are symmetric. |

## Requirements

- **Java 21** or higher
- **Maven 3.x**

## Building the Project

```bash
# Build all modules
mvn clean install

# Build a specific module
mvn clean install -pl arrays
```

## Running Examples

Each class contains a `main` method with example usage. You can run them directly:

```bash
# Compile and run a specific class
cd arrays
mvn compile exec:java -Dexec.mainClass="com.leetcode.duplicate.ContainsDuplicate"

# Or run graph algorithms
cd graph
mvn compile exec:java -Dexec.mainClass="com.algorithms.practice.graph.BFS"
```

## Algorithm Complexity

### Arrays
| Algorithm | Time Complexity | Space Complexity |
|-----------|-----------------|------------------|
| Contains Duplicate (Set) | O(n) | O(n) |
| Two Sum | O(n) | O(n) |
| Missing Number | O(n) | O(1) |
| Product Except Self | O(n) | O(n) |
| Count Occurrence | O(log n) | O(log n) |

### Graph
| Algorithm | Time Complexity | Space Complexity |
|-----------|-----------------|------------------|
| BFS | O(V + E) | O(V) |
| DFS | O(V + E) | O(V) |
| Dijkstra's Shortest Path | O((V + E) log V) | O(V) |

### List
| Algorithm | Time Complexity | Space Complexity |
|-----------|-----------------|------------------|
| Reverse List (Iterative) | O(n) | O(1) |
| Reverse List (Recursive) | O(n) | O(n) |

### Tree
| Algorithm | Time Complexity | Space Complexity |
|-----------|-----------------|------------------|
| Tree Height | O(n) | O(h) |
| Is Symmetric | O(n) | O(h) |

*Where V = vertices, E = edges, n = number of elements, h = height of tree*

## License

This project is for educational and practice purposes.
