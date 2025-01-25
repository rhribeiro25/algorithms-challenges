import java.util.*;

/**
 * Represents a graph using an adjacency list and supports BFS traversal.
 */
public class Graph {
    private final int vertices;
    private final LinkedList<Integer>[] adjacencyList;

    @SuppressWarnings("unchecked")
    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    /**
     * Adds an edge to the graph (unidirectional).
     *
     * @param source the source vertex
     * @param destination the destination vertex
     */
    public void addEdge(int source, int destination) {
        adjacencyList[source].add(destination);
    }

    /**
     * Performs a Breadth-First Search (BFS) on the graph starting from a given vertex.
     *
     * @param startVertex the starting vertex
     */
    public void breadthFirstSearch(int startVertex) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();
        visited[startVertex] = true;
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");
            for (int adjacent : adjacencyList[vertex]) {
                if (!visited[adjacent]) {
                    visited[adjacent] = true;
                    queue.add(adjacent);
                }
            }
        }
    }

    public static void main(String[] args) {
        // Graph Example
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        System.out.println("\n\nBreadth-First Search starting from vertex 0:");
        graph.breadthFirstSearch(0);
    }
}

/*
 * Problem: Graph Representation Using Adjacency List and BFS Traversal
 *
 * **Objective**:
 * The objective of this problem is to represent an undirected graph using an adjacency list
 * and implement a Breadth-First Search (BFS) traversal for the graph.
 * The graph consists of nodes (vertices) and edges. BFS is an algorithm used to traverse
 * or search through a graph in a level-wise manner, starting from a selected node
 * and visiting all its neighbors before moving to their neighbors.
 *
 * **Graph Representation**:
 * A graph can be represented in different ways, but here we use an **adjacency list**.
 * In an adjacency list:
 * - Each node in the graph has a list of all the nodes it is directly connected to (its neighbors).
 * - We use a HashMap (or similar structure) to store each node and its corresponding list of adjacent nodes.
 *
 * **Breadth-First Search (BFS)**:
 * BFS is a traversal technique used to explore all the nodes at the present depth level
 * before moving on to nodes at the next depth level. The algorithm uses a queue to
 * ensure nodes are visited level by level.
 *
 * **Steps**:
 * 1. Create a graph using an adjacency list. Each node is represented as a key,
 *    and its value is a list of adjacent nodes.
 * 2. Implement the BFS algorithm:
 *    - Initialize a queue to keep track of nodes to be visited.
 *    - Use a `visited` set to track nodes that have already been explored.
 *    - Start from a selected node, mark it as visited, and explore its neighbors.
 *    - For each neighbor, mark it as visited and add it to the queue.
 *    - Repeat until all reachable nodes have been visited.
 *
 * **Time Complexity**:
 * - O(V + E), where V is the number of vertices (nodes) and E is the number of edges in the graph.
 *   - O(V) for visiting each node.
 *   - O(E) for exploring all the edges.
 *
 * **Space Complexity**:
 * - O(V) for storing the graph in the adjacency list and the visited set.
 *
 * **Example**:
 * Given a graph:
 *   0 -- 1
 *   |    |
 *   3 -- 2
 *
 * The adjacency list representation will be:
 *   0 -> [1, 3]
 *   1 -> [0, 2]
 *   2 -> [1, 3]
 *   3 -> [0, 2]
 *
 * BFS starting from node 0 will visit the nodes in the order: 0 -> 1 -> 3 -> 2
 */
