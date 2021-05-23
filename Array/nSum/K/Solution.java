import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    private List<List<Integer>> result;

    public List<List<Integer>> threeSum(int[] nums) {
        result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            findTwoSum(nums, i + 1, nums[i]);
        }

        return result;
    }
    private void findTwoSum(int[] nums, int left, int currentValue) {
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right] + currentValue;
            if (sum == 0) {
                result.add(Arrays.asList(currentValue, nums[left], nums[right]));
                
                while (left < right && nums[left] == nums[left + 1]) {
                    left++;
                }
                
                while (left < right && nums[right] == nums[right - 1]) {
                    right--;
                }
                left++;
                right--;
            } else if (sum < 0){
                left++;
            } else {
                right--;
            }
        }

    }
}
