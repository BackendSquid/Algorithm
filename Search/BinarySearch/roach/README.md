# Binary Search ?

- **이진 탐색 이란 ?** 배열의 중간 **임의의 값을 선택하여 찾고자 하는 Value 와 비교**한다. **Value 가 중간 값보다 작으면, 좌측의 데이터들을 대상으로 Value 가 중간값보다 크면 우측을 대상으로 다시 탐색**한다. 동일한 방법으로 다시 중간 값을 임의로 선택하고 비교한다. 따라서 이진 탐색에는 아래와 같은 조건이 붙는다.

## Condition

1. **원소가 정렬이 되어 있을 것(오름차순이든 내림차순이든)**
2. 원소의 Random Access 가 가능해야 한다.
   - **Random Access ?** : O(1) 의 시간복잡도로 해당 Value 에 접근할 수 있냐는 것이다. 배열로 치면 `array[1]` 을 입력하면 해당 array 내의 1번째 Index Value 에
     O(1) 의 시간 복잡도로 접근 할 수 있으므로 해당 조건을 만족한다.

## PseudoCode

- 간단한 수도 코드로 적어보면 로직은 아래와 같을 것이다.

```
if(value == middleValue) {
    return value;
}

if(Value < middleValue) {
    findleftArray();
}

if(Value > middleValue) {
    findRightArray();
}
```

예를 들어 **오름차순으로 정렬된 아래와 같은 배열**이 있다고 해보자

우리가 **찾고싶은 Value 는 92** 이다.

```
[10, 27, 40, 55, 70, 88, 92]
```

위 배열에서 중간값(array[array.length/2])을 선택해보자

```
middle value : 55
Value : 92
```

그런데 우리가 왼쪽 배열, 오른쪽 배열로 가기 위해서는 배열을 분리해내야 한다. 따라서
**0 ~ middle Index 전까지를 leftArray**
**middelIndex ~ endPoint 까지를 rightArray 로 잡는 방식**으로 진행해보겠다.

## Step By Step

0. low = 0, high = array.length - 1;

1. [10, 27, 40, **55**, 70, 88, 92]

   1-1. if(middleValue < findValue) low = mid + 1;

2. [10, 27, 40, **55**, 70, **88**, 92]

   2-1. if(middleValue < findValue) low = mid + 1;

3. [10, 27, 40, **55**, 70, **88**, **92**]

4. **findAnswer!!**

```java
public class BinarySearch {

    public static void main(String[] args) {
        int[] array = { 10, 27, 40, 55, 70, 88, 92 };
        int findValue = 92;
        int low = 0;
        int high = array.length - 1;
        System.out.println(binarySearch(array, findValue, low, high));
    }

    public static int binarySearch(int[] array, int findValue, int low, int high) {
        while (low <= high) {
            int midIdx = (low + high) / 2;
            int midValue = array[midIdx];
            if (midValue == findValue) {
                return midIdx;
            } else if (midValue > findValue) {
                high = midIdx - 1;
            } else if (midValue < findValue) {
                low = midIdx + 1;
            }
        }
        return -1;
    }
}
```

# BackJun 1920 수 찾기

- 전형적인 이분 탐색문제로 위의 방법을 정확히 학습했다면, 그냥 대입만으로 풀 수 있다.

[Link](https://www.acmicpc.net/problem/1920)

```java
import java.util.*;
import java.io.*;

public class Main1920 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] arrayM = new int[M];
        for (int i = 0; i < M; i++) {
            arrayM[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);
        for (int i = 0; i < M; i++) {
            System.out.println(binarySearch(array, arrayM[i], 0, array.length - 1));
        }
    }

    public static int binarySearch(int[] array, int findValue, int low, int high) {
        while (low <= high) {
            int midIdx = (low + high) / 2;
            int midValue = array[midIdx];
            if (midValue == findValue) {
                return 1;
            } else if (midValue > findValue) {
                high = midIdx - 1;
            } else if (midValue < findValue) {
                low = midIdx + 1;
            }
        }
        return 0;
    }
}
```
