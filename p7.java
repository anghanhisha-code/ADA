public class PrimsAlgorithm {

    static final int V = 5; // number of vertices

    // Function to find the vertex with minimum key value
    int minKey(int key[], boolean mstSet[]) {
        int min = Integer.MAX_VALUE, minIndex = -1;

        for (int v = 0; v < V; v++) {
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    // Function to print MST
    void printMST(int parent[], int graph[][]) {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
        }
    }

    // Prim's Algorithm function
    void primMST(int graph[][]) {
        int parent[] = new int[V]; // stores MST
        int key[] = new int[V];    // minimum weight
        boolean mstSet[] = new boolean[V]; // included in MST

        // Initialize all keys as infinite
        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        // Start from vertex 0
        key[0] = 0;
        parent[0] = -1; // root node

        for (int count = 0; count < V - 1; count++) {

            int u = minKey(key, mstSet); // pick minimum key vertex
            mstSet[u] = true;

            // Update key values
            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        // Print the MST
        printMST(parent, graph);
    }

    public static void main(String[] args) {

        PrimsAlgorithm obj = new PrimsAlgorithm();

        int graph[][] = {
            {0, 2, 0, 6, 0},
            {2, 0, 3, 8, 5},
            {0, 3, 0, 0, 7},
            {6, 8, 0, 0, 9},
            {0, 5, 7, 9, 0}
        };

        obj.primMST(graph);
    }
}
