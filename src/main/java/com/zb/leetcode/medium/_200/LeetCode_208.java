package com.zb.leetcode.medium._200;

/***
 * 208. 实现 Trie (前缀树)
 * @author once
 * @date 2020/12/13 10:53
 *
 */
public class LeetCode_208 {

    Node[] trie = new Node[26];

    public static void main(String[] args) {
//        ["Trie","insert","insert","insert","insert","insert","insert","search","search","search","search","search","search","search","search","search","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith"]
//[[],["app"],["apple"],["beer"],["add"],["jam"],["rental"],["apps"],["app"],["ad"],["applepie"],["rest"],["jan"],["rent"],["beer"],["jam"],["apps"],["app"],["ad"],["applepie"],["rest"],["jan"],["rent"],["beer"],["jam"]]
        LeetCode_208 leetCode_208 = new LeetCode_208();
        leetCode_208.insert("app");
        leetCode_208.insert("apple");
        leetCode_208.insert("beer");
        leetCode_208.insert("add");
        leetCode_208.insert("jam");
        System.out.println(leetCode_208.search("apps"));
        System.out.println(leetCode_208.search("app"));

    }
    class Node{
        int val;
        Node[] next = new Node[26];
    }


    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Node[] temp = trie;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (temp[index] == null) {
                temp[index] = new Node();
            }
            if (temp[index].val == 0) {
                temp[index].val = 1;
            }
            if (i == word.length() - 1) {
                temp[index].val = 2;
            }
            temp = temp[index].next;
        }
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Node[] temp = trie;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (temp == null || temp[index] == null || temp[index].val == 0) {
                return false;
            }
            if (i == word.length() - 1) {
                return temp[index].val == 2;
            }
            temp = temp[index].next;
        }
        return false;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Node[] temp = trie;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (temp == null || temp[index] == null || temp[index].val == 0) {
                return false;
            }
            temp = temp[index].next;
        }
        return true;
    }
}
