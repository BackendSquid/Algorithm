



이진탐색전에 sort 하는걸 까먹어서 좀 삽질했다.

이진탐색

- sort
- 작으면 left ++
- 크면 right --



```java
import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] firstInput = br.readLine().split(" ");

        int M = Integer.parseInt(br.readLine());
        String[] secondInput = br.readLine().split(" ");


        Integer[] inputNumbers = new Integer[N];
        for (int i = 0; i < N; i++) {
            inputNumbers[i] = Integer.parseInt(firstInput[i]);
        }

        Arrays.sort(inputNumbers);

        Integer[] findNumbers = new Integer[M];
        int low = 0;
        int high = inputNumbers.length - 1;

        for (int i = 0; i < M; i++) {
            findNumbers[i] = Integer.parseInt(secondInput[i]);
            bw.write(binarySearch(inputNumbers, findNumbers[i], low, high));
            bw.newLine();
        }


        bw.flush();
    }

    private static char binarySearch(Integer[] array, int findValue, int low, int high) {

        while (low <= high) {

            int midIdx = (low + high) / 2;
            int midValue = array[midIdx];

            if (midValue == findValue) {
                return '1';
            }
            if (midValue > findValue) {
                high = midIdx - 1;
            }
            if (midValue < findValue) {
                low = midIdx + 1;
            }
        }

        return '0';
    }

}

```

