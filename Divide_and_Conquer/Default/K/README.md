## 분할정복

- Merge sort
- Maximum Subarray

- **분할** : 문제를 원래 문제와 비슷하면서도 작은 여러개의 문제로 나눈다.
- **정복** : 작은 문제들을 해결한다. (보통 재귀적으로 푼다.)
- **조합** : 해결한 작은 문제들을 원래 문제의 해답을 만들기 위해 조합한다.

## 문제 소개

[LeetCode #84 괄호를 삽입하는 여러가지 방법](https://leetcode.com/problems/different-ways-to-add-parentheses/)

2 * 3 - 4 * 5 라는 식이 있으면,

```
(2*(3-(4*5))) = -34 
((2*3)-(4*5)) = -14 
((2*(3-4))*5) = -10 
(2*((3-4)*5)) = -10 
(((2*3)-4)*5) = 10
```

와 같이 괄호를 묶을 수 있다. 이 모든 경우 수를 탐색하며 결과를 합쳐야 한다.

- 분할 : 연산자를 기준으로 나눈다.
- 정복 : 연산자가 포함이 되어있지 않다면, 그 수 하나를 포함하는 리스트를 리턴한다.
- 조합 : 연산자를 기준으로 나눴을 때, 좌측의 결과 리스트와 우측의 결과 리스트를 해당 연산자로 계산한다.

```java
import java.util.regex.Pattern;
import java.util.regex.Matcher;

class Solution {
    
    private Pattern num = Pattern.compile("\\d*");
    
    public List<Integer> diffWaysToCompute(String expression) {
        Matcher m = num.matcher(expression);
        
        if (m.matches()) {
            return Arrays.asList(Integer.parseInt(expression));
        }
        
        List<Integer> results = new ArrayList<>();
        
        for (int i = 0; i < expression.length(); i++) {
            char operator = expression.charAt(i);
            if (!isOperator(operator)) {
                continue;
            }
            
            String left = expression.substring(0, i);
            String right = expression.substring(i + 1);
            
            results.addAll(mergeResults(diffWaysToCompute(left), diffWaysToCompute(right), operator));
        }
        
        return results;
    }
    
    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*';
    }
    
    private List<Integer> mergeResults(List<Integer> left, List<Integer> right, char operator) {
        List<Integer> results = new ArrayList<>();
        
        for (Integer l : left) {
            for (Integer r: right) {
                if (operator == '+') {
                    results.add(l + r);
                } else if (operator == '-') {
                    results.add(l - r);
                } else if (operator == '*') {
                    results.add(l * r);
                }
            }
        }
        
        return results;
    }
}
```


## 참고
- master theorem : 분할 정복 문제의 분석을 위한 이론

- T(n) = a T(n / b) + f(n)
- ex) Merge Sort : T(n) = 2 T(n / 2) + n >> Θ(n log n)

## 그 외

[LeetCode 169](https://leetcode.com/problems/majority-element/)
