# Trie

[위키피디아 트라이](https://ko.wikipedia.org/wiki/%ED%8A%B8%EB%9D%BC%EC%9D%B4_(%EC%BB%B4%ED%93%A8%ED%8C%85)

트라이는 검색 트리의 일종으로 일반적으로 키가 문자열인, 동적 배열 또는 연관 배열을 저장하는데 사용되는 트리 자료 구조

```java
import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        Node root = new Node();
        
        for (String phone : phone_book) {
            if (hasPrefix(phone, root)) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean hasPrefix(String phone, Node root) {
        Node n = root;
        boolean isExist = false;
        for (Character number : phone.toCharArray()) {
            Node next = n.children.get(number);
            if (next == null) {
                isExist = false;
                next = new Node();
            } else {
                isExist = true;
            }
            if (next.end) {
                return true;
            }
            n.children.put(number, next);
            n = next;
        }
        if(isExist) {
            return true;
        }
        n.end = true;
        
        return false;
    }
    
    
    static class Node {
        private Map<Character, Node> children = new HashMap<>();
        private boolean end = false;
    }
}

```