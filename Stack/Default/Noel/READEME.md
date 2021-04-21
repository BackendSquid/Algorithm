> remote: Permission to AlgorithmSqaud/Algorithm.git denied to sanhee. <BR>
> [GitHub 문제](https://recoveryman.tistory.com/392)를 오늘(04/21(수)) 해결해서 과제제출이 늦어졌습니다.

## 소개

- 자료구조를 리마인드 하기위해 스택을 활용한 알고리즘 문제풀이입니다.
- 문제의 유형은 아래와 같습니다.
  - [오큰수 - 백준 17298번](https://www.acmicpc.net/problem/17298)
- 크키가 N인 수열 A이 존재하고, 각 원소 A_i의 오큰수를 구하는 문제입니다.
  - NGE(오큰수) : 원소 A_i의 오른쪽에 있으면서 A_i보다 큰 수 중에서 `가장 왼쪽`에 있는 수
  - 자신보다 큰 수가 없을 경우 오큰수는 -1
  - 처음 문제풀이때 `가장 작은 요소` 를 고르는 것으로 착각해 삽질을 했습니다.

## 접근 방식

> 1. 입력된 수열 배열의 수만큼 반복문을 순회한다.
> 2. 반복문 안에서 원소 선택하고
> 3. 다른 요소들을 순회한다.
> 4. 커서된 요소보다 큰 요소 중 가장 먼저 발견한 값을 오큰수 배열에 넣는다.(pop)

| index  | 0    | 1    | 2    | 3    |
| ------ | ---- | ---- | ---- | ---- |
| 원소   | 3    | 5    | 2    | 7    |
| 오큰수 |      |      |      |      |



| IndexStack |
| ----- |
| 0     |



| IndexStack  | 0    | 1    | 2    | 3    |
| ------ | ---- | ---- | ---- | ---- |
| 원소   | 3    | 5    | 2    | 7    |
| 오큰수 | 5    |      |      |      |



| IndexStack |
| ----- |
| X     |



| IndexStack  | 0    | 1    | 2    | 3    |
| ------ | ---- | ---- | ---- | ---- |
| 원소   | 3    | 5    | 2    | 7    |
| 오큰수 | 5    |      |      |      |



| IndexStack |
| ----- |
| 2     |
| 1     |



| index  | 0    | 1    | 2    | 3    |
| ------ | ---- | ---- | ---- | ---- |
| 원소   | 3    | 5    | 2    | 7    |
| 오큰수 | 5    |      | 7    |      |



| IndexStack |
| ----- |
|       |
|       |
| 1     |





| index  | 0    | 1    | 2    | 3    |
| ------ | ---- | ---- | ---- | ---- |
| 원소   | 3    | 5    | 2    | 7    |
| 오큰수 | 5    | 7    | 7    |      |



| IndexStack |
| ----- |
|       |
|       |
|       |



| index  | 0    | 1    | 2    | 3    |
| ------ | ---- | ---- | ---- | ---- |
| 원소   | 3    | 5    | 2    | 7    |
| 오큰수 | 5    | 7    | 7    |      |



| IndexStack |
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

```java
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



