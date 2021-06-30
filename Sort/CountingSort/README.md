# 계수 정렬(Counting Sort)

- 배열의 인덱스를 특정한 데이터의 값으로 여기는 정렬 방법

- 시간 복잡도 : O(n+k) 
  - n: 데이터의 개수
  - k: 최대값의 크기
  - k가 n에 비해 작다면 O(n)으로 정렬을 수행할 수 있지만, k가 n^2과 비슷하다면 비교 기반 정렬 알고리즘이 더 빠를 수도 있다.

> 모든 비교 기반 정렬 알고리즘(선택 정렬, 삽입 정렬, 퀵 정렬)은 O(nlog n)의 시간 복잡도를 갖는다. 
>
> 계수 정렬은 비교 기반 정렬 알고리즘이 아니다.

![img](https://blog.kakaocdn.net/dn/cy09N0/btqDEGcC7HP/4kdKmugXaNkWyuicqEEK3k/img.png)

- 단점
  - 데이터의 크기 범위가 제한되어 정수 형태로 표현할 수 있을 때만 사용 가능하다.
    - 모든 범위를 담을 수 있는 크기의 배열을 선언해야 하기 때문
  - 추가적인 메모리 공간이 필요하며 값의 분포에 따라 메모리 낭비가 심할 수 있다.

## 구현 

1. 정렬하고자 하는 배열의 최대값을 구한다.
2. 최대값 크기로 선언된 배열의 각 원소를 순회하며 해당 값이 몇 개인지 저장한다.
3. 저장된 데이터를 순서대로 출력한다.

```py
# 모든 원소의 값이 0보다 크거나 같다고 가정
array = [2, 5, 19, 0, 3, 1, 8, 16, 2, 9, 1, 4, 8, 0, 6, 1]

# 모든 범위를 포함하는 리스트 선언 (모든 값은 0으로 초기화)
count = [0] * (max(array) + 1)

for i in range(len(array)):
    count[array[i]] += 1  # 각 데이터에 해당하는 인덱스의 값 증가

for i in range(len(count)):  # 리스트에 기록된 정렬 정보 확인
    for j in range(count[i]):
        print(i, end=' ')  # 띄어쓰기를 구분으로 등장한 횟수만큼 인덱스 출력
```

```python
0 0 1 1 1 2 2 3 4 5 6 8 8 9 16 19 
```



## 수 정렬하기 3

- N의 범위가 `1 ≤ N ≤ 10,000,000`이므로 기본 정렬 알고리즘으로는 해결할 수 없다.
- 수의 범위가 10,000보다 작거나 같은 자연수로 제한되어 있으므로 계수 정렬을 사용하면 된다.

```python
import sys

input = sys.stdin.readline

n = int(input())
arr = [0] * 10001

for _ in range(n):
    idx = int(input())
    arr[idx] += 1

for i in range(10001):
    if arr[i] != 0:
        for _ in range(0, arr[i]):
            print(i)
```

```python
import sys

N = int(sys.stdin.readline())
A = [0] * 10001

for i in range(N):
    temp = int(sys.stdin.readline())
    A[temp] += 1

for i in range(10001):
    print("{}\n".format(i) * A[i], end='')
```



## 음수

![image](https://user-images.githubusercontent.com/68000537/123981068-00e6a180-d9fd-11eb-815d-3be280625186.png)


```python
def count_sort(arr):
    max_element = int(max(arr))
    min_element = int(min(arr))
    range_of_elements = max_element - min_element + 1

    count_arr = [0 for _ in range(range_of_elements)]
    output_arr = [0 for _ in range(len(arr))]

    # 각 데이터의 수 저장
    for i in range(0, len(arr)):
        count_arr[arr[i] - min_element] += 1

    # count_arr[i]가 output 배열에서의 실제 위치를 포함하도록 업데이트
    for i in range(1, len(count_arr)):
        count_arr[i] += count_arr[i - 1]

    # output 배열 만들기
    for i in range(len(arr) - 1, -1, -1):
        output_arr[count_arr[arr[i] - min_element] - 1] = arr[i]
        count_arr[arr[i] - min_element] -= 1

    # output 배열의 결과 복사
    for i in range(0, len(arr)):
        arr[i] = output_arr[i]

    return arr

arr = [-5, -10, 0, -3, 8, 5, -1, 10]
ans = count_sort(arr)
print("결과: " + str(ans))
```

```python
결과: [-10, -5, -3, -1, 0, 5, 8, 10]
```



---

- https://modoocode.com/274
- 이것이 취업을 위한 코딩 테스트다

- https://herong.tistory.com/entry/%EA%B3%84%EC%88%98%EC%A0%95%EB%A0%ACCounting-Sort

- https://pparksean.tistory.com/75

- https://aerocode.net/113

- https://www.geeksforgeeks.org/counting-sort/
