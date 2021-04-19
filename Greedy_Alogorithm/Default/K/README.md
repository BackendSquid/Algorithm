## 소개

- Greedy 알고리즘은 Dynamic Programming과 마찬가지로 최적의 경우를 구하는 문제에 적용할 수 있는 방법 중에 하나이다. 하지만 Dynamic Programming과는 다르게 매 순간에 최적이라고 생각되는 경우의 수를 선택하여 풀이하는 것이다.

## 접근 방식

- Greedy 알고리즘으로 풀 수 있는 문제는 다음의 두가지 특성을 가진다.

1. Greedy-choice property

전체 최적의 해답은 Greedy하게 지역적으로 최적의 선택을 하는 것으로 만들 수 있다.

2. Optimal substructure

전체 문제의 최적의 해답은 작은 문제의 최적의 해를 포함한다.

## 예제

- fractional knapsack problem

담을 것을 나눌 수 있는 경우, 단위 무게당 가격이 제일 높은 것부터 순서대로 담는 것이 해답이 된다.

- 돈을 동전으로 교환하는 문제

20, 10, 5, 1원이 있을 때, 36원을 가장 적은 갯수의 동전으로 교환하는 법은 20 + 10 + 5 + 1 이 된다.

## 문제

- [백준 1715 카드 정렬하기](https://www.acmicpc.net/problem/1715)

10, 20, 30, 40 의 카드 묶음을 비교하는 경우

(10, 20)을 묶으면, 30번의 비교와 30, 30, 40 의 카드 묶음을 비교하는 경우가 된다.

여기서 (30, 30)을 묶으면 30 + 60번의 비교와 40, 60의 카드 묶음을 비교하는 경우가 된다.

마지막으로 (40 + 60)으로 묶으면 30 + 60 + 100 = 190이 최소 비교 횟수가 된다.

전형적으로 Greedy-choice property와 Optimal substructure가 되는 Greedy Algorithms으로 풀 수 있는 문제이다.

```java
import java.util.*;
public class Main{

    public static int result;

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n;
        result = 0;
        n = sc.nextInt();
        int[] cards = new int[n];
        for (int i = 0; i < n; i++) {
            cards[i] = sc.nextInt();
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int card : cards) {
            priorityQueue.add(card);
        }

        while (!priorityQueue.isEmpty()) {
            Integer card1 = priorityQueue.poll();
            Integer card2 = priorityQueue.poll();
            Integer sum = card1;
            if (card2 != null) {
                sum += card2;
            }
            if (!priorityQueue.isEmpty()) {
                priorityQueue.add(sum);
            }
            result += sum;
        }
        
        if (n == 1) {
            System.out.println(0);    
        } else {
            System.out.println(result);    
        }
    }
}

```

## 기타 문제

[LeetCode 122. Best Time to Buy and Sell Stock II](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/)

[LeetCode 406. Queue Reconstruction by Height](https://leetcode.com/problems/queue-reconstruction-by-height/)

[LeetCode 621. Task Scheduler](https://leetcode.com/problems/task-scheduler/)
