# 숫자 규칙 찾기

문제에서 요구하는 상황에 따라 숫자의 규칙을 찾는 문제

## 프로그래머스 - 예상 대진표

[프로그래머스 - 예상 대진표](https://programmers.co.kr/learn/courses/30/lessons/12985)

N = 2^k인 사람 두명 a, b가 있다.

라운드가 하나 지날 때 마다 번호는 절반으로 감소한다. 이때 1, 2번은 1번으로, 3,4번은 2번이 된다.

즉, 나머지가 있으면 n / 2 + 1, 없으면 n / 2가 된다.


```java
class Solution
{
    public int solution(int n, int a, int b)
    {
        int aGroup = a;
        int bGroup = b;
        int round = 1;
        while (n >= 2) {
            aGroup = nextGroup(aGroup);
            bGroup = nextGroup(bGroup);
            
            if (aGroup == bGroup) {
                return round;
            }
            
            round++;
            n /= 2;
        }
        

        return 0;
    }
    
    private int nextGroup(int number) {
        if (number % 2 == 0) {
            return number / 2;
        } else {
            return number / 2 + 1;
        }
    }
}

```

## 124 나라의 숫자

[프로그래머스 - 124 나라의 숫자](https://programmers.co.kr/learn/courses/30/lessons/12899)

3진법 문제이긴 하지만, 자릿수에 0이 오지 않는다.

    1, 2, 3, 4, 5, 6, 7, 8, 9

->  1, 2, 4, 11, 12, 14, 21, 22, 24

3^1 * 0 이 아니라, 3^0 * 3 으로 표현해야 한다.

-> 나눈 나머지가 0이 되면 다음 자릿수에서 1을 빼야 한다.

```java
import java.util.*;

class Solution {
    Map<Integer, Integer> digitTable;
    
    public String solution(int n) {
        digitTable = initDigitTable();
        
        StringBuilder answer = new StringBuilder();
        
        while (n > 0) {
            int remain = n % 3;
            int digit124 = digitTable.get(remain);
            answer.append(digit124);
            n /= 3;
            if (remain == 0) {
                n -= 1;
            }
            
            
        }
        
        return answer.reverse().toString();
    }
    
    private Map<Integer, Integer> initDigitTable() {
        Map<Integer, Integer> digitTable = new HashMap<>();
        
        digitTable.put(0, 4);
        digitTable.put(1, 1);
        digitTable.put(2, 2);
        
        return digitTable;
    }
}

```