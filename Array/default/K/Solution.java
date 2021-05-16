class Solution {
    public int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        
        int left = 0;
        int right = height.length - 1;
        
        int leftMax = height[left];
        int rightMax = height[right];
        
        int answer = 0;
        while (left < right) {
            if (leftMax <= rightMax) {
                left++;
                int heightLeft = height[left];
                leftMax = Integer.max(leftMax, heightLeft);
                answer += leftMax - heightLeft;
            } else {
                right--;
                int heightRight = height[right];
                rightMax = Integer.max(rightMax, heightRight);
                answer += rightMax - heightRight;
            }
        }
        return answer;
        
    }
}
