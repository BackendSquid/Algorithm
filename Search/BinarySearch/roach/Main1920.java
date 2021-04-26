import java.util.*;
import java.io.*;

public class Main1920 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] arrayM = new int[M];
        for (int i = 0; i < M; i++) {
            arrayM[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);
        for (int i = 0; i < M; i++) {
            System.out.println(binarySearch(array, arrayM[i], 0, array.length - 1));
        }
    }

    public static int binarySearch(int[] array, int findValue, int low, int high) {
        while (low <= high) {
            int midIdx = (low + high) / 2;
            int midValue = array[midIdx];
            if (midValue == findValue) {
                return 1;
            } else if (midValue > findValue) {
                high = midIdx - 1;
            } else if (midValue < findValue) {
                low = midIdx + 1;
            }
        }
        return 0;
    }
}