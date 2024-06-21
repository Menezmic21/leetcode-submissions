// https://leetcode.com/problems/minimum-cost-to-make-array-equal

class Solution:
    def getAvg(self, a, b):
        return (int) ((a + b) / 2)

    def getCost(self, target, nums, cost):
        expense = 0
        cnt = 0
        for num in nums:
            expense += abs(target - num) * cost[cnt]
            cnt += 1
        return expense

    def minCost(self, nums: List[int], cost: List[int]) -> int:
        top = max(nums)
        bottom = min(nums)
        middle = self.getAvg(top, bottom)
        newTop = top
        newBottom = bottom
        dp = {}
        dp[newTop] = self.getCost(newTop, nums, cost)
        dp[newBottom] = self.getCost(newBottom, nums, cost)
        dp[middle] = self.getCost(middle, nums, cost)
        while abs(newTop - newBottom) > 2:
            newTop = self.getAvg(top, middle)
            newBottom = self.getAvg(bottom, middle)
            # print(top, newTop, middle, newBottom, bottom)

            dp[newTop] = self.getCost(newTop, nums, cost)
            dp[newBottom] = self.getCost(newBottom, nums, cost)
            dp[middle] = self.getCost(middle, nums, cost)

            # print(dp[newTop], dp[newBottom])

            if dp[newTop] < dp[newBottom] and dp[newTop] < dp[middle]:
                bottom = newBottom
            elif dp[newBottom] < dp[newTop] and dp[newBottom] < dp[middle]:
                top = newTop
            else:
                right = middle + 1
                dp[right] = self.getCost(right, nums, cost)
                if dp[right] < dp[middle]:
                    bottom = newBottom
                else:
                    top = newTop
            middle = self.getAvg(top, bottom)
        # print(top, newTop, middle, newBottom, bottom)
        # print(dp)
        return min(dp.get(top, 0), dp.get(newTop, 0), dp.get(middle, 0), dp.get(newBottom, 0), dp.get(bottom, 0))
