package com.zb.leetcode.medium._100;

/**
 * 146. LRU 缓存机制
 * @author Zhang Bo
 * @date 2020/12/14 16:42
 */
public class LeetCode_146 {
}

class LRUCache {

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.get(1);
        lruCache.put(3,3);
        lruCache.get(2);
    }

    int[] cache;
    int[] hash = new int[3001];
    int[] hashVal = new int[3001];
    int curr = 0;
    boolean flag = false;

    public LRUCache(int capacity) {
        cache = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            cache[i] = -1;
        }
        for (int i = 0; i < hash.length; i++) {
            hash[i] = -1;
        }
    }

    public int get(int key) {
        if (hash[key] == -1) {
            return -1;
        }
        int lastCurr = hash[key];
        move(key, lastCurr);
        return hashVal[key];
    }

    private void move(int key, int lastCurr) {
        for (int i = lastCurr + 1; i < curr; i++) {
            hash[cache[i]]--;
            cache[i - 1] = cache[i];
        }
        hash[key] = curr - 1;
        cache[curr - 1] = key;
    }

    public void put(int key, int value) {
        if (hash[key] != -1) {
            int lastCurr = hash[key];
            move(key, lastCurr);
            hashVal[key] = value;
        } else {
            if (flag) {
                int delKey = cache[0];
                hash[delKey] = -1;
                move(key,0);
                hashVal[key] = value;
            } else {
                hash[key] = curr;
                cache[curr++] = key;
                hashVal[key] = value;
                flag = curr == cache.length;
            }
        }
    }
}
