## 백준 오큰수

## 2 depth For-loop

```java
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] array = new int[N];
        int[] answer = new int[N];

        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            int curNum = array[i];
            answer[i] = -1;
            for (int j = i + 1; j < N; j++) {
                if (curNum < array[j]) {
                    answer[i] = array[j];
                    break;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(answer[i] + " ");
        }
    }

}
```

- 이렇게 풀었더니 시간 초과가 난다. 그럼 다르게 풀 생각을 해보자! (사실 최대 크기가 100만개인가? 인거보고 안될거 같아서 다른 방식의 구조를 채용해야만 했다.)

- 어떻게 해야 시간을 줄일 수 있을까?
  - 노을이 Stack 구조로 풀었던 것이 기억이 났다. 나도 Stack 구조를 채용해보자.

## Stack 을 이용한 풀이

1. Stack 을 pop 한다. 그중, array[i] 보다 클때 멈춘다.

2. 멈추지 않고 전부 pop 됬다면, -1 처리가 된다.

3. 다시 넣어준다.

4. 이과정을 array.length-1 ~ 0 까지 반복한다.

```java
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] array = new int[N];
        int[] answer = new int[N];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = N - 1; i >= 0; i--) {
            while (!stack.isEmpty() && array[i] >= stack.peek()) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                answer[i] = -1;
            } else {
                answer[i] = stack.peek();
            }
            stack.push(array[i]);
        }

        for (int i = 0; i < N; i++) {
            bw.write(answer[i] + " ");
        }

        bw.flush();
    }

}
```

- 으음 근데.. 왜 되는걸까? 이것도 O(n^2) 아닌가? 내가 직접 쓰고도 실행하는데 의문이간다..
