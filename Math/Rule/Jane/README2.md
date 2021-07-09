---
title: Programmers 124 나라의 숫자
date: 2021-07-09 15:07:58
category: algorithms
---

- https://programmers.co.kr/learn/courses/30/lessons/12899

## Solution

| 10진법 | 1   | 2   | 3   | 4   | 5   | 6   | 7   | 8   | 9   | 10  |
| ------ | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| 124    | 1   | 2   | 4   | 11  | 12  | 14  | 21  | 22  | 24  | 41  |

```py
def solution(n):
    answer = ''
    while (n > 0):
        remainder = n % 3
        n = n // 3
        if (remainder == 0):
            remainder = 4
            n -= 1
        answer = str(remainder) + answer
    return answer
```

- 다른 사람 풀이

```py
def change124(n):
    num = ['1','2','4']
    answer = ""

    while n > 0:
        n -= 1
        answer = num[n % 3] + answer
        n //= 3

    return answer
```
