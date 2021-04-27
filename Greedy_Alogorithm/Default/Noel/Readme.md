





# 카드 정렬하기

https://www.acmicpc.net/problem/1715



### 알게 된 것



#### Priority Queue

- FIFO 형식인 일반적인 큐와 달리 우선순위에 따라 방출되는 방식

  ```java
  // 우선순위가 낮은 숫자 순
  PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
  
  // 우선순위가 높은 숫자 순
  PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
  
  // String도 가능
  ```

  - 출처: https://coding-factory.tistory.com/603



```java
package com.example.BOJ.카드정렬하기_1715;

import java.io.*;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> queue = new PriorityQueue<>(); // 정렬된 숫자 카드 묶음 , 작은 것끼리 더해야 효율적임

        final int testcaseNum = Integer.parseInt(br.readLine());
        int N = testcaseNum;
        int result = 0;

        while (N-- > 0) {
            queue.add(Integer.parseInt(br.readLine()));
        }

        while (!queue.isEmpty() && queue.size()>1) {
            Integer card1 = queue.poll();
            Integer card2 = queue.poll();
            Integer sum = card1 + card2;
            queue.add(sum);

            result += sum;
        }

        if (testcaseNum == 1) {
            bw.write("0");
        } else {
            bw.write(result + "");
        }


        bw.flush();
    }
}

```

