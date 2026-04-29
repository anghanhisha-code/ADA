import java.util.*;

class KruskalAlgorithm {

    // Edge class
    static class Edge implements Comparable<Edge> {
        int src, dest, weight;

        // Compare edges based on weight
        public int compareTo(Edge other) {
            return this.weight - other.weight;
        }
    }

    // Subset for Union-Find
    static class Subset {
        int parent, rank;
    }

    int V, E;
    Edge edges[];

    // Constructor
    KruskalAlgorithm(int v, int e) {
        V = v;
        E = e;
        edges = new Edge[E];
        for (int i = 0; i < e; i++) {
            edges[i] = new Edge();
        }
    }

    // Find function (with path compression)
    int find(Subset subsets[], int i) {
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);
        return subsets[i].parent;
    }

    // Union function (by rank)
    void union(Subset subsets[], int x, int y) {
        int rootX = find(subsets, x);
        int rootY = find(subsets, y);

        if (subsets[rootX].rank < subsets[rootY].rank)
            subsets[rootX].parent = rootY;
        else if (subsets[rootX].rank > subsets[rootY].rank)
            subsets[rootY].parent = rootX;
        else {
            subsets[rootY].parent = rootX;
            subsets[rootX].rank++;
        }
    }

    // Kruskal’s MST function
    void kruskalMST() {
        Edge result[] = new Edge[V]; // store MST
        for (int i = 0; i < V; i++)
            result[i] = new Edge();

        // Step 1: Sort edges
        Arrays.sort(edges);

        Subset subsets[] = new Subset[V];
        for (int i = 0; i < V; i++) {
            subsets[i] = new Subset();
            subsets[i].parent = i;
            subsets[i].rank = 0;
        }

        int e = 0; // result index
        int i = 0; // sorted edges index

        // Step 2: Pick edges one by one
        while (e < V - 1 && i < E) {
            Edge nextEdge = edges[i++];

            int x = find(subsets, nextEdge.src);
            int y = find(subsets, nextEdge.dest);

            // If including this edge doesn't form cycle
            if (x != y) {
                result[e++] = nextEdge;
                union(subsets, x, y);
            }
        }

        // Print MST
        System.out.println("Edge \tWeight");
        for (i = 0; i < e; i++) {
            System.out.println(result[i].src + " - " +
                               result[i].dest + "\t" +
                               result[i].weight);
        }
    }

    public static void main(String[] args) {

        int V = 4; // vertices
        int E = 5; // edges

        KruskalAlgorithm graph = new KruskalAlgorithm(V, E);

        // Define edges
        graph.edges[0].src = 0;
        graph.edges[0].dest = 1;
        graph.edges[0].weight = 10;

        graph.edges[1].src = 0;
        graph.edges[1].dest = 2;
        graph.edges[1].weight = 6;

        graph.edges[2].src = 0;
        graph.edges[2].dest = 3;
        graph.edges[2].weight = 5;

        graph.edges[3].src = 1;
        graph.edges[3].dest = 3;
        graph.edges[3].weight = 15;

        graph.edges[4].src = 2;
        graph.edges[4].dest = 3;
        graph.edges[4].weight = 4;

        graph.kruskalMST();
    }
}
