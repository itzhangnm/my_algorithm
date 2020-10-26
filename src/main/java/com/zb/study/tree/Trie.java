package com.zb.study.tree;

/**
 * 24字母字典树
 *
 * @author Zhang Bo
 * @date 2020/10/26 14:26
 */
public class Trie {
    private char c = ' ';
    private Trie[] childTries;
    private boolean isEnding;

    public Trie() {
        childTries = new Trie[26];
    }

    private Trie(char c) {
        this.c = c;
        this.childTries = new Trie[26];
    }

    public void add(String s) {
        char[] chars = getChars(s);
        Trie trie = this;
        for (char c : chars) {
            int i = checkLetterChar(c);
            if (trie.childTries[i] == null) {
                trie.childTries[i] = new Trie(c);
            }
            trie = trie.childTries[i];
        }
        trie.isEnding = true;
    }

    public boolean contains(String s) {
        char[] chars = getChars(s);
        Trie trie = this;
        for (char c : chars) {
            int i = checkLetterChar(c);
            if (trie.childTries[i] == null) {
                return false;
            }
            trie = trie.childTries[i];
        }
        return trie.isEnding;
    }



    private int checkLetterChar(char c) {
        if (c < 'a' || c > 'z') {
            throw new RuntimeException("c is not in [a-z]");
        }
        return c - 'a';
    }

    private char[] getChars(String s) {
        s = s.toLowerCase();
        return s.toCharArray();
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.add("trie");
        trie.add("tries");
        trie.add("tree");
        trie.add("boy");
        trie.add("biz");
        trie.add("apple");
        System.out.println(trie.contains("tries"));
        System.out.println(trie.contains("trie"));
        System.out.println(trie.contains("tri"));
    }
}
