// https://leetcode.com/problems/two-sum

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        right = 0
        left = len(nums) - 1

        orderedLst = sorted(enumerate(nums), key=lambda x:x[1])
        while(orderedLst[right][1] + orderedLst[left][1] != target and right < left):
            if orderedLst[right][1] + orderedLst[left][1] > target:
                left -= 1
            else:
                right += 1

        return [orderedLst[right][0], orderedLst[left][0]]