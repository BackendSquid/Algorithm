import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final int R = 0;
    private static final int G = 1;
    private static final int B = 2;

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static int[][] table;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(reader.readLine());
        table = new int[N][3];

        StringTokenizer costs = new StringTokenizer(reader.readLine());
        table[0][R] = Integer.parseInt(costs.nextToken());
        table[0][G] = Integer.parseInt(costs.nextToken());
        table[0][B] = Integer.parseInt(costs.nextToken());

        for (int i = 1; i < N; i++) {
            costs = new StringTokenizer(reader.readLine());
            int r = Integer.parseInt(costs.nextToken());
            int g = Integer.parseInt(costs.nextToken());
            int b = Integer.parseInt(costs.nextToken());

            table[i][R] = r + Integer.min(table[i - 1][G], table[i - 1][B]);
            table[i][G] = g + Integer.min(table[i - 1][R], table[i - 1][B]);
            table[i][B] = b + Integer.min(table[i - 1][R], table[i - 1][G]);
        }

        int minCost = table[N - 1][R];
        for (int i = 1; i <= 2; i++) {
            if (minCost > table[N - 1][i]) {
                minCost = table[N - 1][i];
            }
        }
        System.out.println(minCost);
    }
}
