package com.example.BOJ.DFS와BFS_1260;

import java.util.*;

public class Main {

    private static int N; // 정점의 개수
    private static int M; // 간선의 개수
    private static int V; // 탐색을 시작할 정점의 번호

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Set<Integer>> graph = new HashMap<>(); // *

        N = scanner.nextInt();
        M = scanner.nextInt();
        V = scanner.nextInt();

        createGraph(graph, scanner); // *
        boolean[] visited = new boolean[N + 1];  // N번째 정점의 상태도 변경해야 하므로 +1
        dfs(graph, V, visited);
        System.out.println();

        Arrays.fill(visited, false); // dfs 연산에서 사용된 값들을 초기화
        bfs(graph, V, visited);
    }

    public static void createGraph(Map<Integer, Set<Integer>> graph, Scanner scanner) {
        for (int i = 0; i < M; i++) {
            int v1 = scanner.nextInt();
            int v2 = scanner.nextInt();

            Set<Integer> v1Edge = graph.getOrDefault(v1, new TreeSet<>());
            v1Edge.add(v2);

            graph.put(v1, v1Edge);

            // 양방향 연결이 돼있다고 했으므로,
            Set<Integer> v2Edge = graph.getOrDefault(v2, new TreeSet<>());
            v2Edge.add(v1);

            graph.put(v2, v2Edge);
        }
    }

    public static void dfs(Map<Integer, Set<Integer>> graph, int vertex, boolean[] visited) {
        if (visited[vertex]) { // 이미 방문한 정점이라면
            return;
        }
        System.out.print(vertex + " ");
        visited[vertex] = true;

        for (Integer v : graph.getOrDefault(vertex, new TreeSet<>())) {
            dfs(graph, v, visited);
        }
    }

    public static void bfs(Map<Integer, Set<Integer>> graph, int vertex, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(vertex);
        visited[vertex] = true;

        while (!queue.isEmpty()) {
            int v = queue.poll();
            System.out.print(v + " ");

            for (Integer adjacentV : graph.getOrDefault(v, new TreeSet<>())) {
                if (!visited[adjacentV]) { // 방문하지 않은 것만 추가
                    queue.add(adjacentV);
                    visited[adjacentV] = true;
                }
            }

        }

    }

}
