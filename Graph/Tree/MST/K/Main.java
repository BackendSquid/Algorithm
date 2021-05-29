import java.io.*;
import java.util.*;

public class Main {

    public static int[] parent;
    public static PriorityQueue<int[]> edges;
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static final int WEIGHT = 2;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(reader.readLine());
        int M = Integer.parseInt(reader.readLine());

        initParent(N);
        initEdges(M);
        int result = 0;
        int count = 0;
        while(!edges.isEmpty()) {
            int[] edge = edges.poll();

            if (findParent(edge[0]) == findParent(edge[1])) {
                continue;
            }
            
            union(edge[0], edge[1]);
            result += edge[WEIGHT];
            count++;
            if (count == N - 1) {
                break;
            }
        }

        System.out.println(result);
    }

    public static void initParent(int N) {
        parent = new int[N + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }

    public static void initEdges(int M) throws IOException {
        edges = new PriorityQueue<>(Comparator.comparingInt(edge -> edge[WEIGHT]));
        for (int i = 0; i < M; i++) {
            edges.add(getEdge(new StringTokenizer(reader.readLine())));
        }
    }

    public static int[] getEdge(StringTokenizer edgeToken) {
        int[] edge = new int[3];
        for (int i = 0; i < edge.length; i++) {
            edge[i] = Integer.parseInt(edgeToken.nextToken());
        }
        return edge;
    }

    public static int findParent(int node) {
        int p = parent[node];
        if (p == node) {
            return p;
        }
        return parent[node] = findParent(p);
    }

    public static void union(int node1, int node2) {
        int p1 = findParent(node1);
        int p2 = findParent(node2);
        if (p1 < p2) {
            parent[p2] = p1;
        } else {
            parent[p1] = p2;
        }
    }
}
