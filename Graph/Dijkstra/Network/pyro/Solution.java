// https://leetcode.com/problems/network-delay-time/

import java.util.*;

class Solution {
    class Edge implements Comparable<Edge> {
        private final int time;
        private final int node;

        public Edge(int time, int node) {
            this.time = time;
            this.node = node;
        }

        @Override
        public int compareTo(Edge o) {
            return this.time - o.time;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<Edge>> graph = new HashMap<>();
        for (int[] arr : times) {
            int u = arr[0];
            int v = arr[1];
            int w = arr[2];
            if (!graph.containsKey(u)) {
                graph.put(u, new ArrayList<>());
            }
            graph.get(u).add(new Edge(w, v));
        }

        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.add(new Edge(0, k));
        Map<Integer, Integer> dist = new HashMap<>();

        while (!queue.isEmpty()) {
            Edge e = queue.poll();
            int time = e.time;
            int node = e.node;
            if (!dist.containsKey(node)) {
                dist.put(node, time);
                if (!graph.containsKey(node)) {
                    continue;
                }
                for (Edge edge : graph.get(node)) {
                    int alt = time + edge.time;
                    queue.add(new Edge(alt, edge.node));
                }
            }
        }

        System.out.println(dist);
        if (dist.size() == n) {
            return dist.values().stream().mapToInt(d -> d)
                    .max().orElse(-1);
        }
        return -1;
    }

    public static void main(String[] args) {
        // given
        int[][] times = new int[][]{
                new int[]{1, 2, 1},
                new int[]{2, 3, 2},
                new int[]{1, 3, 4}
        };
        int n = 3;
        int k = 1;

        // when
        int actual = new Solution().networkDelayTime(times, n, k);

        // then expect 3
        System.out.println(actual);
    }
}
