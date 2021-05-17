# BFS

### 유기농 배추

- 백준 1012 번

- 배추흰 지렁이를 1이 인접해있는 구역에 놓으면 되는 문제다.
- 결국 인접해 있는 1의 영역이 몇개인지 구하는 문제
- BFS 로 푸는 아주쉬운 문제!

### 풀이방법

- dx + dy 를 더하면 {1,0} {0,1} ... 등등 상하좌우로 움직이는 하나의 방향점이 된다.
  그래서 주위 상하좌우로 탐색하면서 같은 스코프일때만 더해주는 방식으로 풀이한다.

```java
import java.util.*;
import java.io.*;

public class Main {

    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };
    static int[][] map;
    static boolean[][] visited;
    static int M;
    static int N;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            map = new int[M][N];
            visited = new boolean[M][N];

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                map[X][Y] = 1;
            }

            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    if (map[j][k] == 1 && !visited[j][k]) {
                        bfs(j, k);
                    }
                }
            }
            System.out.println(answer);
            answer = 0;
        }

    }

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.offer(new int[] { x, y });
        while (!queue.isEmpty()) {

            int[] dir = queue.poll();

            for (int i = 0; i < 4; i++) {

                int pX = dx[i] + dir[0];
                int pY = dy[i] + dir[1];

                if (pX >= 0 && pY >= 0 && pX < M && pY < N && map[pX][pY] == 1) {
                    if (!visited[pX][pY]) {
                        queue.offer(new int[] { pX, pY });
                        visited[pX][pY] = true;
                    }
                }
            }
        }
        answer++;
    }

}
```
