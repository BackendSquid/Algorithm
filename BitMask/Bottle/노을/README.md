## 물병 문제

- https://www.acmicpc.net/problem/1052

```
- N개의 물병
- 한 번에 K개의 물병을 옮길 수 있다.
- 물 분배
	- "같은 양"의 물이 들어있는 물병 두 개를 고른다. 
	- 한 개의 물병에 다른 한 쪽에 있는 물을 모두 붓는다.
	- (반복)
```

## 접근 방법
 - 물병 개수를 이진수로 변환했을 때, 1의 개수가 K 보다 작거나 같아야 한번에 옮길 수 있음.
 - 2의 거듭제곱인 수를 이진수로 변환하면 1이 한개만 존재함

```text
N	K	NEW
1	1	0	1
2	1	0	10
3	1	1	11
4	1	0	100
5	1	3	101
6	1	2	110
7	1	1	111
8	1	0	1000
9	1	7	1001
10	1	6	1010
11	1	5	1011
12	1	4	1100
13	1	3	1101
14	1	2	1110
15	1	1	1111
16	1	0	10000
```

## 내 풀이

```java
import java.io.*;

public class BOJ_1052 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        String[] inputs = br.readLine().split(" ");

        int N = Integer.parseInt(inputs[0]); // 현재 물병의 개수
        int K = Integer.parseInt(inputs[1]); // 한번에 옮길 수 있는 물병의 개수

        // 물병의 개수의 비트 개수를 구하면, 한번에 옮길 수 있는지 판단할 수 있음.
        // ex) N:3 (11), K:1
        int bitCount = Integer.bitCount(N);

        // 2의 거듭제곱인 경우에 물병을 한번에 옮길 수 있음.
        // 2의 거듭제곱의 bit는 1이 한개만 존재함. 1 2 4 8 16..
        // 필요한 물병은 현재 물병 이후, 2의 거듭제곱인 물병의 개수에서 빼면 구할 수 있음.
        int temp = N;
        while (bitCount > K) {
            temp++;
            bitCount = Integer.bitCount(temp);
        }

        bw.write(temp - N + "");
        bw.flush();
    }

}

```

## 다른사람 풀이

```java
public class BOJ_1052 {

    // Set up : I/O
    static StringBuilder output = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inputStr[] = br.readLine().split(" ");

        int n = Integer.parseInt(inputStr[0]);
        int k = Integer.parseInt(inputStr[1]);
        int need = 0;
        // Set up : Global Variables
        /* None */

        int bitCount = Integer.bitCount(n);
            // Set up : Input
            String[] inputs = br.readLine().split(" ");
            int N = Integer.parseInt(inputs[0]);
            int K = Integer.parseInt(inputs[1]);

        if(bitCount<=k) need = 0;
        else{
            for(int i=0;i<n;i++){
                int temp = (int)Math.pow(2,i); //m 2^n ...
                if(n<temp){
                    need = temp-n;
                    break;
            // Process
            int ans = 0;
            int bc = Integer.bitCount(N);
            int ofs = 1;
            while (bc > K) {
                while ((N&ofs) == 0) {
                    ofs <<= 1;
                }
                ans += ofs;
                N += ofs;
                bc = Integer.bitCount(N);
            }
        }

        System.out.println(need);
            // Control : Output
            output.append(ans);

        br.close();
    }
            bw.write(output.toString());
            bw.flush();

            // Close up : I/O
            br.close();
            bw.close();
        }

        // Helper Functions
        /* None */

}

```