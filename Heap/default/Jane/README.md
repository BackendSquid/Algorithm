# 학습 목표

- Heap 자료구조에 대해 이해한다.
- 힙 정렬 알고리즘에 대해 이해한다.
- 파이썬 및 자바에서 제공하는 힙 자료구조를 자유롭게 활용할 수 있다.



# 힙 (Heap)

- 최대값과 최소값을 빠르게 찾기 위해(O(1)) 고안된 완전 이진 트리

- max heap: 각 노드의 값은 해당 노드의 자식 노드보다 항상 크거나 같다.
- min heap: 각 노드의 값은 해당 노드의 자식 노드가 가진 값보다 항상 크거나 작다.



## 배열로 힙 표현하기

- 부모 노드 인덱스 번호: (자식 노드 인덱스 번호-1) // 2
- 왼쪽 자식 노드 인덱스 번호: 부모 노드 인덱스 번호 * 2 + 1
- 오른쪽 자식 노드 인덱스 번호:부모 노드 인덱스 번호 * 2 + 2

| 0    | 1    | 2    | 3    | 4    | 5    | 6    | 7    | 8    |
| ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- |
| 7    | 6    | 5    | 8    | 3    | 5    | 9    | 1    | 6    |


![image](https://user-images.githubusercontent.com/68000537/117963024-d82a2000-b35a-11eb-9c7d-3d37f929bded.png)



## 힙 vs 이진 탐색 트리

- 힙은 모든 `자식노드 < 부모노드`
- 이진 탐색 트리는 `왼쪽 자식 노드 < 부모노드 < 오른쪽 자식 노드`



![](https://www.fun-coding.org/00_Images/completebinarytree_bst.png)



## Heapify (힙 생성 알고리즘)

- 특정한 노드의 두 자식 중에서 더 큰 자식과 자신의 위치를 바꾸는 알고리즘 
- 하나의 노드에 대한 heapify의 시간복잡도는 트리의 높이인 O(log n)이다.
  - root 노드에서 leaf 노드까지 모두 비교
- 모든 노드에 대해 heapify를 수행하여 전체 트리를 힙 구조로 만드는 시간 복잡도는 O(n*log n)이다.   



## 데이터 삽입

1. 노드를 왼쪽에서부터 추가한 뒤,
2. 부모 노드랑 비교하고,
3. Heap property violation이 없을 때까지 교환한다.
   - max heap의 경우 자식 노드가 부모 노드보다 값이 클 경우 교환

![img](https://www.fun-coding.org/00_Images/heap_insert.png)



## 데이터 삭제

1. 최상단(최대값 또는 최솟값) 데이터를 삭제한다.
2. 가장 최하단에 위치한 노드를 root 노드로 이동한다.
3. heap property violation이 없을 때까지 heapify를 실행한다.



![img](https://www.fun-coding.org/00_Images/heap_remove.png)



## 힙 정렬



![swapping maximum element with last and removing it](https://www.codesdope.com/staticroot/images/algorithm/heapsort2.png)

![heapify animation](https://www.codesdope.com/staticroot/images/algorithm/heapsort1.gif)



- 정렬 방법

  1. 주어진 원소들로 최대 힙을 구성 (build heap)

  2. 최대 힙의 root 노드와 leaf 노드를 교환, 마지막 노드(원래의 루트 노드) 제거

  3. 새 루트노드에 대해 최대 힙 구성 

  4. 원소의 개수만큼 2번과 3번 반복 수행

- [시간 복잡도](https://rninche01.tistory.com/entry/%EC%A0%95%EB%A0%AC-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-04-%ED%9E%99-%EC%A0%95%EB%A0%AC)

  - Build-Max-Heap : O(n) 소요

  - 루트 노드 제거 및 마지막 노드와 교환: O(1) 소요

  - Max-Heapify: O(log n) 소요

  - T(n)=O(n)+n⋅(O(1)+O(log n))T(n)=O(n)+n⋅(O(1)+O(log⁡ n)) = O(n)+O(n)+O(nlog n) = O(n log n)

    ![img](https://blog.kakaocdn.net/dn/k4yYF/btq2ZnFV5Ed/5BLS74pL3DrYMOc9KZOBWk/img.png)출처: https://st-lab.tistory.com/225

- In-place 

  - 추가적인 메모리 공간을 전혀 또는 거의 필요로하지 않는 알고리즘

- Not stable

  - 안정 정렬: 동일한 정렬 기준을 가진 원소는 정렬 전, 후 순서가 동일하다.
  - 불안정 정렬: 동일한 정렬 기준을 가진 원소의 정렬 전, 후 순서가 다를 수 있다.



## 구현

```java
class Heap {
  public static int heapSize = 10;

  public static int getRightChild(int A[], int index) {
    if((((2*index)+1) < A.length && (index >= 1)))
      return (2*index)+1;
    return -1;
  }

  public static int getLeftChild(int A[], int index) {
      if(((2*index) < A.length && (index >= 1)))
          return 2*index;
      return -1;
  }

  public static int getParent(int A[], int index) {
    if ((index > 1) && (index < A.length)) {
      return index/2;
    }
    return -1;
  }

  public static void maxHeapify(int A[], int index) {
    int leftChildIndex = getLeftChild(A, index);
    int rightChildIndex = getRightChild(A, index);

    // finding largest among index, left child and right child
    int largest = index;

    if ((leftChildIndex <= heapSize) && (leftChildIndex > 0)) {
      if (A[leftChildIndex] > A[largest]) {
        largest = leftChildIndex;
      }
    }

    if ((rightChildIndex <= heapSize && (rightChildIndex > 0))) {
      if (A[rightChildIndex] > A[largest]) {
        largest = rightChildIndex;
      }
    }

    // largest is not the node, node is not a heap
    if (largest != index) {
      int temp;
      // swapping
      temp = A[largest];
      A[largest] = A[index];
      A[index] = temp;
      maxHeapify(A, largest);
    }
  }

  public static void buildMaxHeap(int A[]) {
    int i;
    for(i=heapSize/2; i>=1; i--) {
      maxHeapify(A, i);
    }
  }

  public static void heapSort(int a[]) {
    while (heapSize > 0) {
      int temp;
      temp = a[1];
      a[1] = a[heapSize];
      a[heapSize] = temp;
      heapSize--;
      maxHeapify(a, 1);
    }
  }

  public static void main(String[] args) {
    int A[] = {0, 15, 20, 7, 9, 5, 8, 6, 10, 2, 1}; // 트리는 인덱스 1에서 시작
    buildMaxHeap(A);
    heapSort(A);
    for(int i=1; i<=10; i++) {
      System.out.println(A[i]);
    }
  }
}
```



## 라이브러리

###  Python

> 최소 힙
>
> 1. 모든 원소를 차례대로 heap에 삽입한다.
> 2. 힙에 삽입된 모든 원소를 차례대로 result에 담는다.

```py
import heapq

def heapsort(iterable):
    heap = []
    result = []
    for value in iterable:
        heapq.heappush(heap, value)
    for i in range(len(heap)):
        result.append(heapq.heappop(heap))
    return result

result = heapsort([1,9,0,7,8,6,3,5])
print(result)
```

```py
[0, 1, 3, 5, 6, 7, 8, 9]
```

> 최대 힙
>
> 1. 모든 원소에 -를 붙인 값을 heap에 삽입한다.
> 2. heap의 원소를 꺼낸 뒤 다시 -를 붙여 result에 담는다.

```py
def heapsort(iterable):
    heap = []
    result = []
    for value in iterable:
        heapq.heappush(heap, -value)
    # print(heap)
    # [-9, -8, -6, -5, -7, 0, -3, -1]
    for i in range(len(heap)):
        result.append(-heapq.heappop(heap))
    return result

result = heapsort([1,9,0,7,8,6,3,5])
print(result)
```

```python
[9, 8, 7, 6, 5, 3, 1, 0]
```



### Java

> 최소힙

```java
import java.util.Arrays;
import java.util.PriorityQueue;

public class HeapPractice {
    public static void main(String[] args) {
        int[] arr = {1,9,0,7,8,6,3,5};
        System.out.println("Before heap sort: " + Arrays.toString(arr));
        heapSort(arr);
        System.out.print("After heap sort: " + Arrays.toString(arr));
    }

    private static void heapSort(int[] arr) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int element : arr) {
            heap.add(element);
        }

        for(int i = 0; i < arr.length; i++) {
            arr[i] = heap.poll();
        }
    }
}
```

```java
Before heap sort: [1, 9, 0, 7, 8, 6, 3, 5]
After heap sort: [0, 1, 3, 5, 6, 7, 8, 9]
```

> 최대힙

```java
PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
```

```java
Before heap sort: [1, 9, 0, 7, 8, 6, 3, 5]
After heap sort: [9, 8, 7, 6, 5, 3, 1, 0]
```





## 실전 문제

- [프로그래머스 디스크 컨트롤러](https://programmers.co.kr/learn/courses/30/lessons/42627?language=java)

```java
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[][] jobs) {
        int totalTime = 0;
        int currentTime = 0;
        int processedRequestNumber = 0;

        Arrays.sort(jobs, Comparator.comparingInt(job -> job[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(job -> job[1]));

        int index = 0;
        while (processedRequestNumber < jobs.length) {
            while (index < jobs.length && jobs[index][0] <= currentTime) {
                pq.add(jobs[index++]);
            }

            if (pq.isEmpty()) {
                currentTime = jobs[index][0];
            } else {
                int[] job = pq.poll();
                totalTime += job[1] + currentTime - job[0];
                currentTime += job[1];
                processedRequestNumber++;
            }
        }
        return totalTime / jobs.length;
    }
}
```





## 추가 학습

- 프로그래머스 더 맵게 https://programmers.co.kr/learn/courses/30/lessons/42626
- 백준 N번째 큰 수 https://www.acmicpc.net/problem/2075
- 백준 중앙값 구하기 https://www.acmicpc.net/problem/2696



---

***Source***

- https://www.codesdope.com/course/algorithms-heapsort/
- https://rninche01.tistory.com/entry/%EC%A0%95%EB%A0%AC-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-04-%ED%9E%99-%EC%A0%95%EB%A0%AC
- https://zeddios.tistory.com/56
- https://codevang.tistory.com/316
- https://ratsgo.github.io/data%20structure&algorithm/2017/09/27/heapsort/
- https://www.fun-coding.org/Chapter11-heap.html
- https://blog.naver.com/ndb796/221228342808
- https://www.geeksforgeeks.org/insertion-and-deletion-in-heaps/
- https://www.geeksforgeeks.org/in-place-algorithm/

