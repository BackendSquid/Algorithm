# Dynamic Programming

## RGB 거리

- RGB 거리에는 **집이 N 개** 있다. **1 번 부터 ... N 번째 까지**
- 집은 무조건 **빨강(R)**, **초록(G)**,**블루(B)** 로 색칠해야 한다
  - 조건
    - N 번집의 색깔은 N-1 번째 집의 색과 같지 않아야 한다.
    - i 번 집의 색깔은 N-1 , N+1 번째 집의 색과 같지 않아야 한다.
    - 그냥 한마디로 위 아래 색깔과 달라야 한다 이다.

## 입력 예제

```
3
26 40 83
49 60 57
13 89 99
```

## 접근 방식

**알 수 있는것**

- 집별로 색깔에 대한 COST 가 주어진다.

**최소를 어떻게 알 수 있을까?**

- 만약 N 번째 집부터 시작한다면, 전의 `DP[N-1][index]` 을 알아야 한다.
- **그렇담 풀이 하는 방식은 아래와 같다.**

```java
dp[0][0] = array[0][0];
dp[0][1] = array[0][1];
dp[0][2] = array[0][2];

for(int i = 1; i < N; i++) {
  dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + array[i][0];
  dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + array[i][1];
  dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + array[i][2];
}

int answer = Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2]));
```

## 실제 풀이

```java
import java.util.*;
import java.io.*;

public class Main {

	static int[][] dp;
	static int[][] array;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		dp = new int[N][3];
		array = new int[N][3];

		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			array[i][0] = Integer.parseInt(st.nextToken());
			array[i][1] = Integer.parseInt(st.nextToken());
			array[i][2] = Integer.parseInt(st.nextToken());
		}

		dp[0][0] = array[0][0];
		dp[0][1] = array[0][1];
		dp[0][2] = array[0][2];

		for(int i = 1; i < N; i++) {
		  dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + array[i][0];
		  dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + array[i][1];
		  dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + array[i][2];
		}

		int answer = Math.min(dp[N-1][0], Math.min(dp[N-1][1], dp[N-1][2]));

		System.out.println(answer);
	}

}
```
