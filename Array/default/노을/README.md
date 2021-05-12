# Array

- 파이썬 알고리즘 인터뷰 - 180p 

  

## 빗물 트래핑

- 높이가 각기 다른 기둥 사이에 비가 내렸을 때, 얼마나 많은 물이 쌓였는지 확인하는 문제
- https://leetcode.com/problems/trapping-rain-water/

![algorithm](C:/Users/psh/Documents/Web/AlgorithmSqaud/Array/default/%EB%85%B8%EC%9D%84/img/algorithm.gif)

### 풀이1. 투 포인터 이용

- 왼쪽과 오른쪽 끝에 포인터를 두고, 좌우 어느 쪽이든 낮은 쪽은 높은 쪽을 향해서 포인터가 가운데로 점점 이동한다.

- 최대 높이의 막대는 전체 부피에 영향을 끼치지 않는다.

  - 왼쪽, 오른쪽을 가르는 장벽 역할

    

```java
class Solution {
    public int trap(int[] height) {
        
        // 투 포인터를 사용하기 위한 변수
        int left = 0;
        int right = height.length - 1;  
        
        // 포인터를 움직이면서, 과거~당시까지의 최고 높이 값 저장
        int left_max = 0;
        int right_max = 0;
        
        // 물 부피 저장변수
        int volum = 0;
        
        // left 포인터와 right 포인터가 만나면 루프 종료
        while(left < right){
            
            if(height[left] <= height[right]){
                
                if(height[left]>=left_max){
                    left_max = height[left];
                }else{
                    volum += left_max - height[left];
                }
                
                left++;
                
            }else{
                
                if(height[right]>=right_max){
                    right_max = height[right];
                }else{
                    volum += right_max -height[right];
                }
                
                right--;
            }

        }
        
        return volum;
        
    }
} 


----------------------------------------------------------------------------------------------------
    
Runtime: 1 ms, faster than 81.73% of Java online submissions for Trapping Rain Water.
Memory Usage: 38.8 MB, less than 16.67% of Java online submissions for Trapping Rain Water.
    
```



### 풀이2. 다이나믹 프로그래밍

- 왼쪽과 오른쪽 시점에서 레이저를 쏴서 사영이 지는 부분이 웅덩이
- 그림출처: leetcode.com

![Dynamic programming](https://leetcode.com/problems/trapping-rain-water/Figures/42/trapping_rain_water.png)

```java
class Solution {
    public int trap(int[] height) {
        
        if (height.length == 0) return 0;
    
        int left = 0;
        int right = height.length - 1;
        int[] left_max = new int[height.length];
        int[] right_max = new int[height.length];
        int volum = 0;
        
        
        left_max[0] = height[0];
        for(int i=1; i<height.length; i++){
            left_max[i] = Math.max(height[i], left_max[i-1]);
        }
        
        right_max[height.length-1] = height[height.length-1];
        for(int i= height.length-2; i>=0; i--){
            right_max[i] = Math.max(height[i], right_max[i+1]);
        }
        
        for(int i=1 ; i<height.length-1 ; i++){
            volum += Math.min(left_max[i], right_max[i]) - height[i];
        }
        
        return volum;
        
    }
} 

-------------------------
    
Runtime: 1 ms, faster than 81.73% of Java online submissions for Trapping Rain Water.
Memory Usage: 38.6 MB, less than 35.75% of Java online submissions for Trapping Rain Water.
```



