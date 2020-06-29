package com.zb.study.tree;

/**
 * @author Zhang Bo
 * @date 2020/6/10 15:57
 */
public class HeapTree {
    private int[] data;
    private int count;
    private int total;

    public HeapTree() {
        data = new int[16];
        total = data.length - 1;
        count = 0;
    }

    public static void main(String[] args) {
        HeapTree heapTree = new HeapTree();
        heapTree.insert(9);
        heapTree.insert(6);
        heapTree.insert(3);
        heapTree.insert(1);
        heapTree.insert(5);

        heapTree.sort();
    }

    public void insert(int i) {
        if (count == total) {
            throw new RuntimeException();
        }
        data[++count] = i;
        int index = count;
        while (index / 2 > 0 && data[index] > data[index / 2]) {
            swap(data, index, index / 2);
            index /= 2;
        }
    }

    public void delete() {
        if (count == 0) {
            throw new RuntimeException();
        }
        data[1] = data[count];
        count--;
        heaplfy(data,count,1);

    }

    public void sort() {
        if (count == 0) {
            return;
        }

        for (int i = count / 2; i >= 1 ; i--) {
            heaplfy(data, count, i);
        }
        int k = count;
        while (k > 1) {
            swap(data,k,1);
            k--;
            heaplfy(data,k,1);
        }

    }

    private void heaplfy(int[] data, int n, int i) {
        while (true) {
            int max = i;
            if (i * 2 <= n && data[i * 2] > data[i]) {
                max = i * 2;
            }
            if (i * 2 + 1 <= n && data[i * 2 + 1] > data[max]) {
                max = i * 2 + 1;
            }
            if (i == max) {
                break;
            }
            swap(data, i, max);
            i = max;
        }
    }

    private void swap(int[] data, int i, int j) {
        data[i] ^= data[j];
        data[j] ^= data[i];
        data[i] ^= data[j];
    }
}
