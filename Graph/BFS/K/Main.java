import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static boolean[][] field;
    private static boolean[][] checked;
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(reader.readLine());

        for (int i = 0; i < T; i++) {
            solve();
        }

    }

    private static void solve() throws IOException {
        StringTokenizer infos = new StringTokenizer(reader.readLine());
        int M = Integer.parseInt(infos.nextToken());
        int N = Integer.parseInt(infos.nextToken());
        int K = Integer.parseInt(infos.nextToken());

        field = new boolean[M][N];
        checked = new boolean[M][N];

        initField(K);

        int bugCount = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (field[i][j] && !checked[i][j]) {
                    bugCount++;
                    dfs(i, j, M, N);
                }
            }
        }
        System.out.println(bugCount);
    }

    private static void dfs(int i, int j, int M, int N) {
        if (i < 0 || i >= M || j < 0 || j >= N) {
            return;
        }

        if (!field[i][j] || checked[i][j]) {
            return;
        }

        checked[i][j] = true;
        dfs(i + 1, j, M, N);
        dfs(i - 1, j, M, N);
        dfs(i, j + 1, M, N);
        dfs(i, j - 1, M, N);

    }

    private static void initField(int K) throws IOException {
        for (int i = 0; i < K; i++) {
            StringTokenizer cabbagePosition = new StringTokenizer(reader.readLine());
            int x = Integer.parseInt(cabbagePosition.nextToken());
            int y = Integer.parseInt(cabbagePosition.nextToken());
            field[x][y] = true;
        }
    }

}
