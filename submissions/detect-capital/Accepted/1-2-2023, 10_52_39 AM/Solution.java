// https://leetcode.com/problems/detect-capital

class Solution {
    public boolean detectCapitalUse(String word) {
        boolean isStartCapital = false;
        boolean isAllCapital = true;
        boolean isSomeFollowingCapital = false;
        for(int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if(i == 0) {
                isStartCapital = Character.isUpperCase(c);
                isAllCapital = isStartCapital;
            } else {
                if(Character.isUpperCase(c)) {
                    isSomeFollowingCapital = true;
                } else {
                    isAllCapital = false;
                }
                if(!isAllCapital && isSomeFollowingCapital) break;
            }
        }
        return (isStartCapital && !isSomeFollowingCapital) || (isAllCapital) || (!isStartCapital && !isSomeFollowingCapital);

    }
}