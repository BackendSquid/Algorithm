import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer A = new StringTokenizer(br.readLine(), " ");
        
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

    private static int[] solve(StringTokenizer Ai, int N) {
        int[] result = new int[N];
        
        int stackPointer = -1;
        int[] stack = new int[N];
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            int currentValue = Integer.parseInt(Ai.nextToken());
            A[i] = currentValue;
            
            while (stackPointer != -1 && A[stack[stackPointer]] < currentValue) {
                result[stack[stackPointer--]] = currentValue;
            }
            stackPointer++;
            stack[stackPointer] = i;
        }
        
        while(stackPointer != -1) {
            result[stack[stackPointer--]] = -1;
        }
        
        return result;
    }
}