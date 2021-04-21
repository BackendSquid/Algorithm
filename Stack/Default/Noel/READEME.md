

## 소개

- 자료구조를 리마인드 하기위해 스택을 활용한 알고리즘 문제풀이를 해보았다.
- 문제의 유형은 아래와 같다.
  - [오큰수 - 백준 17298번](https://www.acmicpc.net/problem/17298)
- 수열 배열중 자신 오른쪽에 있는 큰 요소중 가장 왼쪽에 있는 요소를 고르는 문제이다. 
- 처음 문제풀이때 `가장 작은 요소` 를 고르는 것으로 착각해 삽질을 했다.

## 접근 방식

> 1. 요소의 개수만큼 반복문을 순회한다.
> 2. 현재 커서에 위치한 요소를 선택한다.(push)
> 3. 다른 요소들을 순회한다.
> 4. 커서된 요소보다 큰 요소 중 가장 먼저 발견한 값을 오큰수 배열에 넣는다.(pop)

| index  | 0    | 1    | 2    | 3    |
| ------ | ---- | ---- | ---- | ---- |
| 원소   | 3    | 5    | 2    | 7    |
| 오큰수 |      |      |      |      |



| Stack |
| ----- |
|       |
|       |
| 3     |



| index  | 0    | 1    | 2    | 3    |
| ------ | ---- | ---- | ---- | ---- |
| 원소   | 3    | 5    | 2    | 7    |
| 오큰수 | 5    |      |      |      |



| Stack |
| ----- |
|       |
| 2     |
| 5     |



| index  | 0    | 1    | 2    | 3    |
| ------ | ---- | ---- | ---- | ---- |
| 원소   | 3    | 5    | 2    | 7    |
| 오큰수 | 5    |      | 7    |      |



| Stack |
| ----- |
|       |
|       |
| 5     |





| index  | 0    | 1    | 2    | 3    |
| ------ | ---- | ---- | ---- | ---- |
| 원소   | 3    | 5    | 2    | 7    |
| 오큰수 | 5    | 7    | 7    |      |



| Stack |
| ----- |
|       |
|       |
|       |



| index  | 0    | 1    | 2    | 3    |
| ------ | ---- | ---- | ---- | ---- |
| 원소   | 3    | 5    | 2    | 7    |
| 오큰수 | 5    | 7    | 7    |      |



| Stack |
| ----- |
|       |
|       |
| 7     |



오큰수는 오른쪽에 있으면서 Ai보다 큰 수 중에서 가장 왼쪽에 있는 수를 의미한다. 

## 그러한 수가 없는 경우에 오큰수는  -1

| index  | 0    | 1    | 2    | 3    |
| ------ | ---- | ---- | ---- | ---- |
| 원소   | 3    | 5    | 2    | 7    |
| 오큰수 | 5    | 7    | 7    | -1   |



## 코드 작성

```
import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCaseCount = Integer.parseInt(br.readLine());
        String[] inputSequence = br.readLine().split(" ");
        int[] nge = new int[inputSequence.length];

        Stack<Integer> stack = new Stack<>();


        for (int index = 0; index < testCaseCount; index++) {
            int currentElement = Integer.parseInt(inputSequence[index]);

            if (stack.isEmpty()) {
                stack.push(index);
            }

            while (!stack.isEmpty() && Integer.parseInt(inputSequence[stack.peek()]) < currentElement){
                nge[stack.pop()] = currentElement;
            }
            stack.push(index);
        }


        while (!stack.isEmpty()) {
            nge[stack.pop()] = -1;
        }

        for (int n : nge) {
            bw.write(n + " ");
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
```



## 관련 문제

[오등큰수 - 백준 17299번](https://www.acmicpc.net/problem/17299)



