#  소수

> 소수란 2보다 크며, 자신외에 약수가 없어야 한다.



#### 소수 검사 접근방식

- 구하고자 하는 N을 2부터 나머지 연산으로 검사하면서 소수를 찾을 수도 있지만,

- N = A*B 이라면, N = 2* *N/2  로 표현 할 수 있다.

  - 즉, 절반만 검사해서 약수가 존재하는지 파악이 가능하다.

  - 하지만, 이 방식은 시간 복잡도 O(N/2)로, 결국은 O(N)과 동일

    

위 과정과 비슷하게 루트를 이용하면 좀 더 A와 B의 차이를 줄일 수 있다. 

- N = A*B 이므로로 아래와 같이도 표현할 수 있다.

- $$
  A <= \sqrt{N}, B >= \sqrt{N}
  $$

  

- 즉, `A<=sqrt{N}` 만 검사하면, 소수를 찾을 수 있다.

- 하지만, 실수는 컴퓨터 계산에서 근사값을 나타내기 때문에

- 양변을 제곱해서  `A^2 <= N`으로 표현해서 소수를 검사하는게 좋다.

  

### 관련문제

- https://www.acmicpc.net/problem/1978

  

#### 소스코드

```java
import java.io.*;

public class Main {

    public static boolean prime(int num){
        if(num < 2) return false;

        for(int i=2 ; i*i<=num ; i++){
            if(num%i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){

        final int testcaseMax = Integer.parseInt(br.readLine());
        String[] intputCommand = br.readLine().split(" ");
        int check = 0;
        for(int i =0; i< testcaseMax; i++){
            check = prime(Integer.parseInt(intputCommand[i])) ? ++check:check;
        }

        bw.write(String.valueOf(check));
        bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```



# 범위안의 소수 구하기



![](https://wikidocs.net/images/page/21638/DC-1707V1.png)

- 이미지 출처: https://wikidocs.net/21638



기존 소수 찾기와 같이 순회하면서  검사하는 방식도 좋지만, 에라토스테네스체라고 하는 `범위안의 소수`를  찾는데 특화된 기법이 있다.

- 에라토스테네스체는 우선 `2부터 N까지` 배열에 담는다.
- 배열중 가장 작은 요소의 배수를 제거한다. (반복)
  - 어떤 수의 제곱 이하의 요소 (`i*2 ~ i*(i-1)`) 는 제거가 보장됨.
    - ex) `4*2`, `4*3` ..  는 이미 2, 3의 배수 제거에서 제거가 됐음.

```java
int[] prime = new int[N];
int primeCount = 0;
boolean[] primeCheck = new boolean[N+1];

int n = 100;
for (int i=2; i<N; i++){
    if(primeCheck[i] == false){
        prime[primeCount++] = i;
        for(int j = i*i; j<= n; j+=i){ // 배수를 제거하는 과정 ⛔ N이 커지면 위험함.
            primeCheck[j] = true;
        }
    }
}
```



- 문제는 `i*i`인데 N이 `1_000_000(백만)`으로 주어질 경우,  1조가 되므로
  - 21억의 범위인 int로는 무리가 있음
  - N에 따라 `i+i` 또는 `i*2`와 같이 변경을 해줘야함.
    - `이전 요소의 제거 보장을 완벽하게 누리지 못하지만, 스택오버플로우는 피할 수 있음`



### 관련문제

- https://www.acmicpc.net/problem/1929



#### 소스코드

```java
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            final String[] INPUT_RANGE = br.readLine().split(" ");
            final int RANGE_START = Integer.parseInt(INPUT_RANGE[0]);
            final int RANGE_END = Integer.parseInt(INPUT_RANGE[1]);

            boolean[] chekedNotPrime = new boolean[RANGE_END+1]; // 배열조작을 위해 +1 해주어야함.

            for (int i = 2; i <= RANGE_END; i++) {
                if (chekedNotPrime[i] == false) { // 소수인 경우
                    if (i>=RANGE_START) {
                        bw.write(String.valueOf(i));
                        bw.newLine();
                    }
                    for(int j=i*2; j<=RANGE_END ; j+=i) {
                        chekedNotPrime[j] = true;  // 소수가 아닌 경우
                    }
                }
            }
            bw.flush();
        }
    }
}
```

