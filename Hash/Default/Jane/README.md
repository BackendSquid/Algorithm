---
title: Programmers 위장
date: 2021-07-08 18:07:79
category: hash
---

- https://programmers.co.kr/learn/courses/30/lessons/42578

## Solution

1. 의상 종류를 key로 옷을 저장하고
2. 선택 안함까지 포함하여 종류별 옷의 개수를 곱한 뒤 아무것도 안 입는 경우를 빼면 된다.

```py
def solution(clothes):
    answer = 1
    _list = dict()

    for cloth in clothes:
        if cloth[1] in _list.keys():
            _list[cloth[1]].append(cloth[0])
        else:
            _list[cloth[1]] = [cloth[0]]

    for key in _list:
        answer *= len(_list[key]) + 1

    return answer - 1
```

- 다른 사람 풀이

```py
def solution(clothes):
    from collections import Counter
    from functools import reduce
    cnt = Counter([kind for name, kind in clothes])
    answer = reduce(lambda x, y: x * (y + 1), cnt.values(), 1) - 1
    return answer
```

- 더 줄인 코드

```py
import collections
from functools import reduce

def solution(c):
    return reduce(lambda x, y: x * y,
    [a + 1 for a in collections.Counter([x[1] for x in c]).values()]) - 1
```
