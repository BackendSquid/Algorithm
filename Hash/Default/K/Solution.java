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
