package m6k1;

import java.util.*;

public class Task {
    private final List<List<Integer>> adjacencyList;

    public Task(int numVertices) {
        adjacencyList = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination) {
        adjacencyList.get(source).add(destination);
    }

    public List<Integer> DFSTraversal(int start) {
        List<Integer> traversalOrder = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        DFS(start, visited, traversalOrder);
        return traversalOrder;
    }

    private void DFS(int vertex, Set<Integer> visited, List<Integer> traversalOrder) {
        visited.add(vertex);
        traversalOrder.add(vertex);

        for (int neighbor : adjacencyList.get(vertex)) {
            if (!visited.contains(neighbor)) {
                DFS(neighbor, visited, traversalOrder);
            }
        }
    }

    public List<Integer> BFSTraversal(int start) {
        List<Integer> traversalOrder = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(start);
        queue.offer(start);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            traversalOrder.add(vertex);

            for (int neighbor : adjacencyList.get(vertex)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }

        return traversalOrder;
    }

    public static void main(String[] args) {
        Task graph = new Task(12);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 1);
        graph.addEdge(2, 5);
        graph.addEdge(4, 6);
        graph.addEdge(5, 2);
        graph.addEdge(5, 3);
        graph.addEdge(5, 7);
        graph.addEdge(5, 9);
        graph.addEdge(6, 7);
        graph.addEdge(7, 6);
        graph.addEdge(7, 11);
        graph.addEdge(8, 9);
        graph.addEdge(8, 11);
        graph.addEdge(9, 5);
        graph.addEdge(9, 8);
        graph.addEdge(11, 10);
        graph.addEdge(11, 7);

        List<Integer> dfsOrder = graph.DFSTraversal(1);
        List<Integer> bfsOrder = graph.BFSTraversal(1);

        System.out.println("DFS Traversal Order: " + dfsOrder);
        System.out.println("BFS Traversal Order: " + bfsOrder);
    }
}
