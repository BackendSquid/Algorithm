# 다익스트라 알고리즘

BFS + Greedy 알고리즘

모든 edge의 weight 값이 음수가 아닌 경우 한 점에서 다른 점으로 가는 최단 경로를 구할 수 있는 알고리즘

집합 S = 최단 거리가 결정된 점들의 집합
Q = 최단 거리 dist를 key로 하는 min-priority queue

```
initialize dist and prev
S = ∅
Q = G.V
while Q != ∅
    u = EXTRACT-MIN(Q)
    S = S ∪ {u}
    forEach v ∈ G.Adjecant[u]
        RELAX (u, v, w)

```

# 증명

1. S = ∅ 일 때는 자명하다.
2. 시작점 s에서 다른 점으로 가는 경우의 edge 값이 가장 작은 점은 S에 포함할 수 있다. (init)
3. Q에서 u를 찾아 S에 포함시킬 경우를 생각해보자.

u로 가는 최단 경로가 되는 s -> x -> y -> u 라는 길이 있다고 가정한다. x는 S에 포함되는 마지막 노드이며, y는 길에서 S에 포함되지 않은 최초의 점이다.
s-> x -> y는 s -> x -> y -> u가 최단경로라고 했으므로, 수렴에 의해서 s -> y로 가는 최단 거리가 된다. 그렇다면, dist.y <= dist.u가 되므로, y = u가 된다. 즉, 그리디하게 u를 Q에서 꺼낸다면, 그 때의 s -> u는 최단거리가 된다.

# 시간 복잡도

Queue 만드는데 V, Queue를 배열로 구현했다면, O(V * V + E) = O(V * V)

E = o(V * V / log V)라서, 충분히 sparse한 그래프라면, Priority Queue로 구현하여 O(VlogV + ElogV) = O(ElogV) 의 시간 복잡도를 가진다.

피보나치 힙을 이용하면 O(VlogV + E)의 시간 복잡도를 가진다. (심화)

# 문제

[백준 1753 최단경로](https://www.acmicpc.net/problem/1753)

```java
package backjun;

import java.io.*;
import java.util.*;

public class Main1753 {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer tokenizer;

    private static final int VERTEX = 0;
    private static final int WEIGHT = 1;

    private static List<int[]>[] graph;
    private static int[] dist;
    private static int[] prev;
    private static boolean[] visited;

    private static final PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(edge -> edge[WEIGHT]));

    public static void main(String[] args) throws IOException {
        tokenizer = new StringTokenizer(reader.readLine());
        int V = Integer.parseInt(tokenizer.nextToken());
        int E = Integer.parseInt(tokenizer.nextToken());

        int source = Integer.parseInt(reader.readLine());

        initGraph(V, E);

        dist[source] = 0;
        queueAdd(source);

        while (!queue.isEmpty()) {
            int[] vertex = queue.poll();
            int u = vertex[0];
            if (visited[u]) continue;
            visited[u] = true;
            for (int[] edge : graph[u]) {
                int v = edge[VERTEX];
                int alt = dist[u] + edge[WEIGHT];
                if (alt < dist[v]) {
                    dist[v] = alt;
                    prev[v] = u;
                    queueAdd(v);
                }
            }
        }

        printDist();

    }

    private static void initGraph(int V, int E) throws IOException {
        dist = new int[V + 1];
        prev = new int[V + 1];
        visited = new boolean[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        graph = new List[V + 1];

        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int u = Integer.parseInt(tokenizer.nextToken());
            int v = Integer.parseInt(tokenizer.nextToken());
            int w = Integer.parseInt(tokenizer.nextToken());

            graph[u].add(new int[]{v, w});
        }
    }

    private static void queueAdd(int source) {
        queue.add(new int[]{source, dist[source]});
    }

    private static void printDist() throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i < dist.length; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                writer.write("INF\n");
            } else {
                writer.write(dist[i] + "\n");
            }
        }

        writer.flush();
        writer.close();
    }
}

```
