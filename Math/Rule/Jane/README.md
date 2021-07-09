---
title: Programmers 예상 대진표
date: 2021-07-09 15:07:10
category: algorithms
---

- https://programmers.co.kr/learn/courses/30/lessons/12985

## Solution

```py
def solution(n, a, b):
    answer = 0
    while a != b:
        answer += 1
        a = (a + 1) // 2
        b = (b + 1) // 2
    return answer
```

- 다른 사람 풀이

```py
def solution(n,a,b):
    return ((a-1)^(b-1)).bit_length()
```
