// https://leetcode.com/problems/fizz-buzz

class Solution {
    public String toStr(int n) {
        if(n % 3 == 0) {
            if(n % 5 == 0) return "FizzBuzz";
            return "Fizz";
        }
        if (n % 5 == 0) return "Buzz";
        return String.valueOf(n);
    }
    public List<String> fizzBuzz(int n) {
        List<String> rLst = new ArrayList<String>();
        for(int i = 1; i <= n; i++) {
            rLst.add(toStr(i));
        }
        return rLst;
    }
}