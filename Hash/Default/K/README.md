# Hash Table

- 동작을 잘한다는 가정 하에 Insert / Search / Delete 연산에 O(1) 의 시간 복잡도를 가지는 자료구조
- key 와 그 것에 연결되는 value를 가진다.

# Hash Function

- 값을 key에 연결하기 위한 함수
- mod 등으로 구현한다.
- key가 균일하게 분포하도록 적절한 함수를 선택해야 한다.

# 충돌 해결 방법

다른 값이 같은 key에 매핑될 수 있다. 이를 충돌이라고 하고, 이를 해결하기 위해서 다음 두가지 방법을 사용한다.

- chaining
  - 이후에 Linked-List처럼 구현
- open-address
  - 충돌이 일어나면, 다른 키에 저장
  - ex) 바로 다음 키


# 프로그래머스 - 위장

[위장](https://programmers.co.kr/learn/courses/30/lessons/42578)

```java
import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (String[] cloth : clothes) {
            List<String> clothList = map.getOrDefault(cloth[1], new ArrayList<>());
            
            clothList.add(cloth[0]);
            
            map.put(cloth[1], clothList);
        }
        
        int answer = 1;
        
        for(String clothKey:map.keySet()) {
            answer *= map.get(clothKey).size() + 1;
        }
    
        return answer - 1;
    }
}

```