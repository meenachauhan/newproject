import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Graph {
	private int V; // Number of vertices
	private List<Map<Integer, Integer>> adjList; // Adjacency list to store edges and weights


	public Graph(int V) {
		this.V = V;
		adjList = new ArrayList<>(V);
		for (int i = 0; i < V; i++) {
			adjList.add(new HashMap<>());
		}
	}

	// Add an edge to the graph with a given weight
	public void addEdge(int source, int destination, int weight) {
		adjList.get(source).put(destination, weight);
	}

	// Dijkstra's algorithm to find the shortest path from a source vertex
	public void dijkstra(int source) {
		int[] distance = new int[V];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[source] = 0;

		PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.distance));
		minHeap.add(new Node(source, 0));

		while (!minHeap.isEmpty()) {
			Node currentNode = minHeap.poll();
			int u = currentNode.vertex;

			for (Map.Entry<Integer, Integer> neighborEntry : adjList.get(u).entrySet()) {
				int v = neighborEntry.getKey();
				int weight = neighborEntry.getValue();

				if (distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v]) {
					distance[v] = distance[u] + weight;
					minHeap.add(new Node(v, distance[v]));
				}
			}
		}

		// Print the shortest distances from the source vertex to all other vertices
		System.out.println("Shortest distances from vertex " + source + " to all other vertices:");
		for (int i = 0; i < V; i++) {
			System.out.println("Vertex " + i + ": " + distance[i]);
		}
	}

	private static class Node {
		int vertex;
		int distance;

		Node(int vertex, int distance) {
			this.vertex = vertex;
			this.distance = distance;
		}
	}
}

public class DijkstraAlgorithmExample {
	public static void main(String[] args) {
		int V = 6; // Number of vertices
		Graph graph = new Graph(V);

		graph.addEdge(0, 1, 2);
		graph.addEdge(0, 2, 4);
		graph.addEdge(1, 2, 1);
		graph.addEdge(1, 3, 7);
		graph.addEdge(2, 3, 3);
		graph.addEdge(3, 4, 1);
		graph.addEdge(3, 5, 5);
		graph.addEdge(4, 5, 2);

		int source = 0; // Source vertex

		graph.dijkstra(source);
	}
}


