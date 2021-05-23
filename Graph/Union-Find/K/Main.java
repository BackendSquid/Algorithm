import java.util.*;
import java.io.*;

public class Main {

    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static int[][] graph;
    public static int[] disjointSet;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(reader.readLine());
        int M = Integer.parseInt(reader.readLine());

        if (M == 0) {
            System.out.println("YES");
            System.exit(0);
        }

        graph = new int[N + 1][N + 1];
        disjointSet = new int[N + 1];
        for (int i = 0; i < disjointSet.length; i++) {
            disjointSet[i] = i;
        }
        initGraph();

        int[] itinerary = new int[M];
        initItinerary(itinerary);
        initDisjointSet();

        int currentSet = disjointSet[itinerary[0]];

        for (int city : itinerary) {
            if (findParent(city) != currentSet) {
                System.out.println("NO");
                System.exit(0);
            }
        }
        System.out.println("YES");
    }

    private static void initDisjointSet() {
        int N = disjointSet.length - 1;
        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                if (graph[i][j] == 1) {
                    unionParent(i, j);
                }
            }
        }
    }

    private static void unionParent(int i, int j) {
        int a = findParent(i);
        int b = findParent(j);
        if (a < b) {
            disjointSet[j] = a;
        } else if (a > b) {
            disjointSet[i] = b;
        }
    }

    private static int findParent(int node) {
        int parent = disjointSet[node];
        if (node == parent) {
            return node;
        }
        return disjointSet[node] = findParent(parent);
    }

    private static void initItinerary(int[] itinerary) throws IOException {
        int M = itinerary.length;
        StringTokenizer cities = new StringTokenizer(reader.readLine());
        for(int i = 0; i < M; i++) {
            itinerary[i] = Integer.parseInt(cities.nextToken());
        }
    }

    public static void initGraph() throws IOException {
        int N = graph.length - 1;
        for(int i = 1;  i <= N; i++) {
            StringTokenizer edges = new StringTokenizer(reader.readLine());
            for (int j = 1; j <= N; j++) {
                graph[i][j] = Integer.parseInt(edges.nextToken());
                if (graph[i][j] == 1) {
                    unionParent(i, j);
                }
            }
        }
    }
}
