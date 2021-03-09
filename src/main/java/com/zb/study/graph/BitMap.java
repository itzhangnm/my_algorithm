package com.zb.study.graph;

/**
 * @author Zhang Bo
 * @date 2021/3/9 18:09
 */
public class BitMap {
    private int[] bytes;
    private int size;

    public BitMap(int size) {
        this.size = size;
        bytes = new int[size / 32 + 1];
    }

    public void set(int key) {
        int byteIndex = key / 32;
        int bitIndex = key % 32;
        bytes[byteIndex] |= (1 << bitIndex);
    }

    public boolean get(int key) {
        if (key > size) {
            return false;
        }
        int byteIndex = key / 32;
        int bitIndex = key % 32;
        return (bytes[byteIndex] & (1 << bitIndex)) != 0;
    }

    public static void main(String[] args) {
        BitMap bitMap = new BitMap(10000);
        bitMap.set(5);
        bitMap.set(100);
        bitMap.set(500);
        System.out.println(bitMap.get(5));
        System.out.println(bitMap.get(100));
        System.out.println(bitMap.get(500));
        System.out.println(bitMap.get(555));
        System.out.println(bitMap.get(10000));
        System.out.println(bitMap.get(10000000));
    }
}
