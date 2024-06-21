// https://leetcode.com/problems/palindrome-partitioning

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> partitions = new ArrayList<List<String>>();
        backtrace(partitions, new ArrayList<String>(), 0, s);
        return partitions;
    }
    private void backtrace(List<List<String>> partitions, List<String> partition, int idx, String s) {
        if (idx == s.length()) {
            partitions.add(new ArrayList<String>(partition));
            return;
        }
        partition.add("");
        for (int i = idx; i < s.length(); i++) {
            String new_partition = partition.get(partition.size()-1) + s.charAt(i);
            partition.set(partition.size()-1, new_partition);
            if (!is_palindrome(new_partition)) {
                continue;
            }
            backtrace(partitions, partition, i+1, s);
        }
        partition.remove(partition.size()-1);
    }
    private boolean is_palindrome(String s) {
        for (int left = 0, right = s.length()-1; left < right; left++, right--) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
        }
        return true;
    }
}