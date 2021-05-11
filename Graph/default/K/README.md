# Breadth First Search and Depth First Search

## 너비 우선 탐색

그래프를 탐색하는데, 인접한 모든 정점들을 우선적으로 탐색하는 방법이다.

일반적으로, 큐를 이용하여 구현한다.

예) edge에 가중치가 없는 경우 최단 경로, Dijkstra algorithms

## 깊이 우선 탐색

현재 정점에서 갈 수 있는 정점을 우선적으로 탐색하는 방법

일반적으로 재귀나 스택을 이용하여 구현한다.

# DFS and BFS

[백준 1260 DFS와 BFS](https://www.acmicpc.net/problem/1260)

```java

package backjun;

import java.util.*;

public class Main1260 {

    private static int N;
    private static int M;
    private static int V;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        V = scanner.nextInt();

        Map<Integer, Set<Integer>> graph = new HashMap<>();
        initGraph(graph, scanner);

        boolean[] visited = new boolean[N + 1];
        dfs(graph, V, visited);
        System.out.println();
        Arrays.fill(visited, false);
        bfs(graph, V, visited);

    }

    private static void initGraph(Map<Integer, Set<Integer>> graph, Scanner scanner) {
        for(int i = 0; i < M; i++) {
            int v1 = scanner.nextInt();
            int v2 = scanner.nextInt();

            Set<Integer> v1Edges = graph.getOrDefault(v1, new TreeSet<>());
            v1Edges.add(v2);
            graph.put(v1, v1Edges);

            Set<Integer> v2Edges = graph.getOrDefault(v2, new TreeSet<>());
            v2Edges.add(v1);
            graph.put(v2, v2Edges);
        }
    }

    private static void dfs(Map<Integer, Set<Integer>> graph, Integer vertex, boolean[] visited) {
        if (visited[vertex]) {
            return;
        }

        System.out.print(vertex + " ");
        visited[vertex] = true;

        for (Integer v : graph.getOrDefault(vertex, new TreeSet<>())) {
            dfs(graph, v, visited);
        }
    }

    private static void bfs(Map<Integer, Set<Integer>> graph, Integer vertex, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(vertex);
        visited[vertex] = true;
        while(!queue.isEmpty()) {
            Integer v0 = queue.poll();
            System.out.print(v0 + " ");

            for (Integer v : graph.getOrDefault(v0, new TreeSet<>())) {
                if (!visited[v]) {
                    queue.add(v);
                    visited[v] = true;
                }
            }
        }
    }
}


```