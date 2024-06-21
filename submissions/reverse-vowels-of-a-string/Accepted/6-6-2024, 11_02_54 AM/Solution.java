// https://leetcode.com/problems/reverse-vowels-of-a-string

class Solution {
    public String reverseVowels(String s) {
        String vowels = "AEIOUaeiou";
        char[] chars = s.toCharArray();
        // System.out.println(chars[0] == 'h');
        for (int left = 0, right = chars.length-1; left < right; ) {
            while (vowels.indexOf(chars[left]) == -1) {
                left++;
                if (left >= right) {
                    // System.out.println("break");
                    break;
                }
            }

            while (vowels.indexOf(chars[right]) == -1) {
                right--;
                if (left >= right) {
                    // System.out.println("break");
                    break;
                }
            }

            // System.out.println("" + chars[left] + " vs " + chars[right]);

            if (left < right) {
                char c = chars[left];
                chars[left] = chars[right];
                chars[right] = c;
                left++;
                right--;
            }
        }
        return new String(chars);
    }
}