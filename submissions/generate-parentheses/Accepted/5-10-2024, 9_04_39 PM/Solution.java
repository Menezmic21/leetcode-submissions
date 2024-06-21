// https://leetcode.com/problems/generate-parentheses

class Solution {
    public List<String> generateParenthesis(int n) {
        List<ArrayList<String>> workspace = new ArrayList<ArrayList<String>>();
        ArrayList<String> zrthLst = new ArrayList<>(1);
        zrthLst.add("");
        workspace.add(zrthLst);
        for (int i = 1; i <= n; i++) {
            workspace.add(new ArrayList<String>((int) Math.pow(2, 2 * i)));
        }
        buildStrings(workspace, 1, n);
        List<String> res = workspace.get(n);
        for (int i = 0; i < res.size(); i++) {
            if (!isValid(res.get(i))) {
                // System.out.println("not valid");
                res.remove(i);
                i--;
            } 
            // else {
                // System.out.println("valid");
            // }
        }
        return res;
    }
    private void buildStrings(List<ArrayList<String>> workspace, int i, int m) {
        if (i == m+1) {
            return;
        }
        for (String s : workspace.get(i-1)) {
            workspace.get(i).add(s + "((");
            workspace.get(i).add(s + "()");
            workspace.get(i).add(s + ")(");
            workspace.get(i).add(s + "))");
        }
        // System.out.println(workspace.get(i));
        buildStrings(workspace, i+1, m);
    }
    private boolean isValid(String s) {
        System.out.println(s);
        int depth = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                depth++;
            } else {
                depth--;
            }
            if (depth < 0) {
                return false;
            }
        }
        return depth == 0;
    }
}