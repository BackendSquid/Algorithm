

## 유효한 팰린드롬

- https://leetcode.com/problems/valid-palindrome/submissions/

- 문제의 조건인 **alphanumeric characters**으로 변경하려고 했는데, 정규표현식을 잘 다룰 줄 몰라서 검색을 통해 해답을 확인했다.



#### 정규표현식`[^a-zA-Z0-9]` 

- `[]` : 문자열을 의미
- `^` : 문자열 안에 들어가면 `not`을 의미한다.
- `a-z` : 소문자 전체를 의미
- `A-Z` : 대문자 전체를 의미
- `0-9` : 숫자 전체를 의미

대소문자와 숫자를 포함하지 않는 문자열 전체를 의미한다.



한글은 `가-힣` 이다.

`^`는 두가지 의미

1. `^`, `\A` : (위치) 문자열의 시작
2. `[^문자열]` : 문자열의 문자를 제외한 문자에 매핑



#### replaceAll()

- 특정 Character를 변경하는 replace()와 다르게 정규표현식을 통해 문자열의 내용을 수정할 수 있다.



참고블로그 : https://sowon-dev.github.io/2021/01/09/210110replacevsreplaceall/





#### 코드

```java
import java.util.*;


public class Solution {

    public static void main(String[] args) {
        new Solution().isPalindrome("A man, a plan, a canal: Panama");
    }

    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]","").toUpperCase();
        
        int forward = 0;
        int backward = s.length()-1;
        
        while(forward<backward){
            if(s.charAt(forward) != s.charAt((backward))){
                return false;
            }
            forward++;
            backward--;
        }
            return true;
    }
}

```



#### 다른 풀이를 보니 아래와 같이 반으로 나눈뒤 한번만 검사하는 풀이도 있다.



```java
 for(int i=0; i<s1.length()/2; i++){
      if(s1.charAt(i) != s1.charAt(s1.length()-i-1)){
        return false;
      }
  }
```

