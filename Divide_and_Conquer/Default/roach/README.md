# 풀이

```java
package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * 1. 연산자 중심으로 나눈다.
 * 2. 연산자 중심으로 왼쪽, 오른쪽으로 연산한다.
 * 3. 연산자가 없다면 종료한다.
 */
public class Leet241 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.diffWaysToCompute("23*3-4*5").toString());
    }

    public static class Solution {

        Pattern pattern = Pattern.compile("[0-9]*");

        public List<Integer> diffWaysToCompute(String expression) {

            Matcher matcher = pattern.matcher(expression);
            ArrayList<Integer> list = new ArrayList<>();

            // 넘어온 표현식이 문자열 일때
            if(matcher.matches()) {
                return Arrays.asList(Integer.parseInt(expression));
            }

            for(int i = 0; i < expression.length(); i++) {
                if(!isOperator(expression.charAt(i))) {
                    continue;
                }

                String left = expression.substring(0, i);
                String right = expression.substring(i+1);

                list.addAll(calcualte(diffWaysToCompute(left), diffWaysToCompute(right), expression.charAt(i)));
            }

            return list;

        }

        public boolean isOperator(char op) {
            return op == '+' || op == '-' || op == '*' || op == '/';
        }

        public List<Integer> calcualte(List<Integer> left, List<Integer> right, char op) {
            ArrayList<Integer> list = new ArrayList<>();

            for(Integer l : left) {
                for(Integer r : right) {
                    if('+' == op) {
                        list.add(l+r);
                    }
                    if('-' == op) {
                        list.add(l-r);
                    }
                    if('/' == op) {
                        list.add(l/r);
                    }
                    if('*' == op) {
                        list.add(l*r);
                    }
                }
            }
            return list;
        }

    }





}

```

## 다른 방법으로도 나중에 풀어보기!
