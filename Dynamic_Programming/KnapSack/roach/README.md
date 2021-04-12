## 소개

- 알고리즘에서 가장 많이 나오는 유형 중 하나로, 풀이 방법을 보니 상당히 재미있다는 생각이 들었다. 이제 풀이 Concept 에 관해 알아보자.
- 문제의 유형은 아래와 같다.

  - **백준 12865 (평범한 배낭)**

  [12865번: 평범한 배낭](https://www.acmicpc.net/problem/12865)

- 아주 평범한 배낭에 대한 문제로, 담을 수 있는 무게 한도(K) 가 있으며, 지정된 물품의 개수(N) 개 중 가치를 최대로 담을 수 있는 수를 구하는 것이다.

## 접근 방식

- Greedy ⇒ 제일 최소의 무게로 접근한다 ? ⇒ 답이 확정이란 것을 보장해 줄 수 없다. 많이 담는다는 것은 최선의 시나리오는 맞으나, 무게가 무거움에도 가치가 상당히 높은 물건이 존재할 수 있다. 따라서 우리는 모든 경우의 수를 알아야 한다.
- 여기서 KeyPoint 는 모든 무게의 경우의 수라면, 해당 무게가 가질 수 있는 최대의 경우를 알면 되는것이다. 그럼 **Dynamic Programming** 을 이용해서 풀어보자
- 우리가 구해야 할 총 경우의 수는 곧 **지정된 물품의 개수 \* 무게 한도** 가 된다. 따라서 DP 의 크기는 다음과 같다.

  - **DP = new DP[N][k]**

- DP 를 하면서 선택할 수 있는 수는 아래와 같다.

  - 해당 순서의 물건을 배낭에 담는다.
    - (Math.max(TABLE[i-1][j], TABLE[i][j-weight] + value) if i - weight >= 0)
  - 해당 순서의 물건을 배낭에 담지 않는다. (TABLE[i-1][j])

- 그렇담 표가 아래와 같은 방식으로 나올 것이다. (아래는 예제 입력)

```
4 7
6 13
4 8
3 6
5 12
```

| N\K |  0  |  1  |  2  |  3  |  4  |  5  |  6  |      7 |
| --- | :-: | :-: | :-: | :-: | :-: | :-: | :-: | -----: |
| 6   |  0  |  0  |  0  |  0  |  0  |  0  | 13  |     13 |
| 4   |  0  |  0  |  0  |  0  |  8  |  8  | 13  |     13 |
| 3   |  0  |  0  |  0  |  6  |  8  |  8  | 13  |     14 |
| 5   |  0  |  0  |  0  |  6  |  8  | 12  | 13  | **14** |

그럼 우리가 구해야할 INDEX 는 **TABLE[N][k]** 번째이다.

## 코드 작성

```java
import java.util.*;
import java.io.*;

public class Main {

	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] firstLine = br.readLine().split(" ");

		int N = Integer.parseInt(firstLine[0]);
		int K = Integer.parseInt(firstLine[1]);

		dp = new int[N+1][K+1];

		for(int i = 1; i <= N; i++) {
			String[] line = br.readLine().split(" ");
			int weight = Integer.parseInt(line[0]);
			int value = Integer.parseInt(line[1]);
			for(int j = 1; j <= K; j++) {
				dp[i][j] = dp[i-1][j];
				if(j - weight >= 0) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight] + value);
				}
			}
		}

		for(int[] a : dp) {
			System.out.println(Arrays.toString(a));
		}

		System.out.println(dp[N][K]);


	}

}
```
