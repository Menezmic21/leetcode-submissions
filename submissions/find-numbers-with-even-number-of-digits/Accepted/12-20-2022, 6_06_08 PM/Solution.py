// https://leetcode.com/problems/find-numbers-with-even-number-of-digits

class Solution:
    def findNumbers(self, nums: List[int]) -> int:
        return len(list(filter(lambda num:len(str(num)) % 2 == 0, nums)))