package com.zb.study.sort;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/***
 * 基础排序提供
 * @author once
 * @date 2019/11/10 15:40
 *
 */
public class BaseSort {

    protected static int[] generateArr(int size) {
        return IntStream.generate(() -> new Random().nextInt(100)).limit(size).boxed().mapToInt(Integer::intValue).toArray();
    }

    protected static void printArr(int[] arr) {
        Arrays.stream(arr).forEach(i -> System.out.print(i + " "));
        System.out.println();

    }

    protected boolean checkArr(int[] arr) {
        if (arr == null || arr.length < 2) {
            return true;
        }
        return false;
    }

}
