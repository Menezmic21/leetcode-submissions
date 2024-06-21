// https://leetcode.com/problems/find-numbers-with-even-number-of-digits

def func(num):
        return len(str(num)) % 2 == 0
    
class Solution:
    
    def findNumbers(self, nums: List[int]) -> int:
        return len(list(filter(func, nums)))