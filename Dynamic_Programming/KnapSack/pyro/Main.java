// https://www.acmicpc.net/problem/12865

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] firstLine = br.readLine().split(" ");
		int N = Integer.parseInt(firstLine[0]);
		int K = Integer.parseInt(firstLine[1]); // capacity

        int[][] cargo = new int[N][2];
        for (int i = 0; i < N; i++) {
			String[] line = br.readLine().split(" ");
            cargo[i][0] = Integer.parseInt(line[0]);
            cargo[i][1] = Integer.parseInt(line[1]);
        }

		System.out.println(zeroOneKnapsack(cargo, K));
	}

    public static int zeroOneKnapsack(int[][] cargo, int capacity) {
        int N = cargo.length;
        int K = capacity;
        int[][] dp = new int[N+1][K+1];
		for(int i = 1; i <= N; i++) {
			int weight = cargo[i - 1][0];
			int value = cargo[i - 1][1];
			for(int j = 1; j <= K; j++) {
				if(j - weight >= 0) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight] + value);
				} else {
                    dp[i][j] = dp[i-1][j];
                }
			}
		}
        return dp[N][K];
    }
}
