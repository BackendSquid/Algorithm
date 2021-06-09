# 자신을 제외한 배열의 곱

- https://leetcode.com/problems/product-of-array-except-self/

- 파이썬 알고리즘 인터뷰 - 193p



> 배열을 입력받아 output[i] 가 자신을 제외한 나머지 모든 요소의 곱셈 결과가 되도록 출력하라.

```text
Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
```

- <조건> 나눗셈 연산자 없이 풀어야함.



## 첫번째 시도

- 이중  반복문
- 시간초과

```java
class Solution {
    public int[] productExceptSelf(int[] nums) {
        
    
        int[] result = new int[nums.length];
        
        Arrays.fill(result,1);

  
        for(int index = 0 ; index< nums.length; index++){
         
            for(int j=0; j<nums.length;j++){
                
                if(index != j){
                    
                    result[index] *= nums[j];
                }
                
            }
            
        }
        return result;
     
    }
}
```



| Time Submitted   | Status                                                       | Runtime | Memory | Language |
| :--------------- | :----------------------------------------------------------- | :------ | :----- | :------- |
| 06/09/2021 19:00 | [Time Limit Exceeded](https://leetcode.com/submissions/detail/505364686/) | N/A     | N/A    | java     |



## 교재 참고

- 자기 자신을 제외한 왼쪽의 곱셈 결과와 오른쪽 곱셈의 결과를 곱해야한다.

```
INPUT: [4, 5, 1, 8, 2]

왼쪽 곱셈결과 : [1, 4, 20, 20, 160]

오른쪽 곰셈결과: [80, 16, 16, 2, 1]

```

## K의 혁신적인 풀이법🖐🖐

![image](https://user-images.githubusercontent.com/73760074/121348414-4ca8ac80-c963-11eb-94e4-bf2239423c05.png)


```java
class Solution {
    public int[] productExceptSelf(int[] nums) {
    
        int N = nums.length;
        
        int[] left_products = new int[N];
        int[] right_products = new int[N];
        
        int[] output_arr = new int[N];
        
        left_products[0] = 1;
        right_products[N-1] = 1;
        
        for (int i=1; i<N; i++){
            left_products[i] = nums[i-1] * left_products[i-1];
        }
        
        for (int j=N-2; j>=0; j--){
            right_products[j] = nums[j+1] * right_products[j+1];
        }
        
        for (int i=0; i<N; i++){
            
            output_arr[i] = left_products[i] * right_products[i];
        }
        
        return output_arr;
        
    }
}
```

