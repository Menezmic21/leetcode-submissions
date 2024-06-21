// https://leetcode.com/problems/ransom-note

class Solution:
    def makeDict(self, string):
        rDict = {}
        for letter in string:
            rDict[letter] = rDict.get(letter, 0) + 1
        return rDict

    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        rDict = self.makeDict(ransomNote)
        mDict = self.makeDict(magazine)
        for key in rDict:
            if(mDict.get(key, 0) < rDict[key]):
                return False
        return True
        