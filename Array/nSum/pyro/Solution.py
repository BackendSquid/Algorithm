class Solution:
    # 두 수의 합 알고리즘
    def twoSum(self, nums: List[int], target: int) -> List[List[int]]:
        results = []
        while self.left < self.right:
            sum = nums[self.left] + nums[self.right]
            if sum < target:
                self.left += 1
            elif sum > target:
                self.right -= 1
            else: # `sum = target`인 경우이므로 정답 처리
                results.append([-target, nums[self.left], nums[self.right]])

                # 중복된 값 건너뛰기
                while self.left < self.right and nums[self.left] == nums[self.left + 1]:
                    self.left += 1
                while self.left < self.right and nums[self.right] == nums[self.right - 1]:
                    self.right -= 1
                self.left += 1
                self.right -= 1
        return results

    # 세 수의 합 알고리즘
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        results = []
        nums.sort()

        for i in range(len(nums) - 2):
            # 중복된 값 건너뛰기
            if i > 0 and nums[i] == nums[i - 1]:
                continue

            target = -nums[i]
            self.left = i + 1
            self.right = len(nums) - 1
            results += self.twoSum(nums, target)

        return results
