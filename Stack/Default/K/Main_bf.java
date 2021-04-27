import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer Ai = new StringTokenizer(br.readLine(), " ");
        
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(Ai.nextToken());
        }
        
        int[] result = solve(A, N);
        
        printResult(result);
        br.close();
    }
    
    private static void printResult(int[] result) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int num : result) {
            bw.write(num + " ");
        }
        bw.close();
    }

    private static int[] solve(int[] A, int N) {
        int[] result = new int[N];
        
        outer:
        for (int i = 0; i < N; i++) {
            int A_i = A[i];
            for (int j = i + 1; j < N; j++) {
                if (A_i < A[j]) {
                    result[i] = A[j];
                    continue outer;
                }
            }
            result[i] = -1;
        }
        
        return result;
    }
}