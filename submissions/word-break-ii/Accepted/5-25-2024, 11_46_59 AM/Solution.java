// https://leetcode.com/problems/word-break-ii

class TreeNode {
    HashMap<Character, TreeNode> children;
    Character c = null;
    boolean isValid = false;
    public TreeNode(HashMap<Character, TreeNode> children, Character c, boolean isValid) {
        this.children = children;
        this.c = c;
        this.isValid = isValid;
    }
}

class Solution {
    TreeNode root;
    public List<String> wordBreak(String s, List<String> wordDict) {
        // Make Trie
        root = new TreeNode(new HashMap<Character, TreeNode>(), ' ', false);
        for (String word : wordDict) {
            TreeNode node = root;
            for (char c : word.toCharArray()) {
                if (!node.children.keySet().contains(c)) {
                    TreeNode child = new TreeNode(new HashMap<Character, TreeNode>(), c, false);
                    node.children.put(c, child);
                }
                node = node.children.get(c);
            }
            node.isValid = true;
        }
        // System.out.println(trieContains(root, "pine"));

        List<String> sentences = new ArrayList<String>();
        backtrace(sentences, "", s, root, 0);
        return sentences;
    }

    private void backtrace(List<String> sentences, String sentence, String s, TreeNode node, int idx) {
        if (idx == s.length()) {
            if (node.isValid) {
                sentences.add(sentence);
            }
            return;
        }
        Character c = s.charAt(idx);
        // if (!node.children.keySet().contains(c)) { // c missing
        //     return;
        // }
        TreeNode nextNode = node.children.get(c);
        if (nextNode == null) { // c missing
            return;
        } else if (nextNode.isValid && idx < s.length()-1) {
            backtrace(sentences, sentence+c+" ", s, root, idx+1);
        }
        backtrace(sentences, sentence+c, s, nextNode, idx+1);
    }

    private boolean trieContains(TreeNode root, String s) {
        if (s.length() == 0) {
            // System.out.println("root: " + root.c);
            return root.isValid;
        }
        Character c = s.charAt(0);
        if (!root.children.keySet().contains(c)) {
            // System.out.println("trie missing: " + c);
            return false;
        }
        // System.out.println("trie has: " + c);
        return trieContains(root.children.get(c), s.substring(1));
    }
}