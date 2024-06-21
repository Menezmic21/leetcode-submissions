// https://leetcode.com/problems/string-compression

class Solution {
    public int compress(char[] chars) {
        char prev = chars[0];
        int pi = 0;
        int end = 0;
        char c = 'a';
        for (int i = 1; i <= chars.length; i++) {
            // print_arr(chars);
            if (i == chars.length || prev != (c = chars[i])) {
                // number of chars left in group
                // while (i - pi > 0) {
                //     chars[end]
                // }
                int n = i - pi;
                chars[end] = prev;
                prev = c;
                pi = i;
                end++;
                if (n == 1) {
                    continue;
                }
                // String s = "" + n;
                // for (int j = 0; j < s.length(); j++) {
                //     chars[end] = s.charAt(j);
                //     end++;
                // }

                if (n >= 1000) {
                    chars[end] = ("" + (n / 1000)).charAt(0);
                    end++;
                }
                if (n >= 100) {
                    chars[end] = ("" + ((n % 1000) / 100)).charAt(0);
                    end++;
                }
                if (n >= 10) {
                    chars[end] = ("" + ((n % 100) / 10)).charAt(0);
                    end++;
                }
                if (n >= 1) {
                    chars[end] = ("" + (n % 10)).charAt(0);
                    end++;
                }
            }
        }
        // System.out.println(end);
        // print_arr(chars);
        return end;
    }
    // private void print_arr(char[] chars) {
    //     System.out.print("[");
    //     for (char c : chars) {
    //         System.out.print("" + c + ", ");
    //     }
    //     System.out.println("]");
    // }
}