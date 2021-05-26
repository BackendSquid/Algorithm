# 프로그래머스 다단계 칫솔 판매

[다단계 칫솔 판매](https://programmers.co.kr/learn/courses/30/lessons/77486)

트리 구조로 구성된 다단계 칫솔 판매의 이익을 계산하는 문제

child -> parant로 가는 역방향 그래프를 구성한 후, 각 판매에 대해 이익 분배를 계산한다.

```java
import java.util.*;

class Solution {
    
    private static Map<String, Integer> profits = new LinkedHashMap<>();
    private static Map<String, String> reversedTree = new LinkedHashMap<>();
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        
        initMaps(enroll, referral);
        
        for (int i = 0; i < seller.length; i++) {
            String s = seller[i];
            int profit = amount[i] * 100;

            while (!"-".equals(s)) {
                Integer currentProfit = profits.get(s);

                int addedProfit = profit;
                if (profit >= 10) {
                    addedProfit -= profit / 10;    
                } 

                profits.put(s, currentProfit + addedProfit);
                
                if (profit < 10) {
                    break;
                }
                
                s = reversedTree.get(s);
                profit = profit / 10;
            }
        }
        
        int[] result = new int[enroll.length];
        
        for (int i = 0; i < enroll.length; i++) {
            result[i] = profits.get(enroll[i]);
        }
        
        return result;
    }
    
    public static void initMaps(String[] enroll, String[] referral) {        
        for (int i = 0; i < enroll.length; i++) {
            reversedTree.put(enroll[i], referral[i]);
            profits.put(enroll[i], 0);
        }
    }
}

```