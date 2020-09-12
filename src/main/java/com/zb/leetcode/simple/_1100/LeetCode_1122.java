package com.zb.leetcode.simple._1100;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

public class LeetCode_1122 {
    /**
     * 给你两个数组，arr1 和 arr2，
     *
     *     arr2 中的元素各不相同
     *     arr2 中的每个元素都出现在 arr1 中
     *
     * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
     *
     *
     *
     * 示例：
     *
     * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
     * 输出：[2,2,2,1,4,3,3,9,6,7,19]
     *
     *
     *
     * 提示：
     *
     *     arr1.length, arr2.length <= 1000
     *     0 <= arr1[i], arr2[i] <= 1000
     *     arr2 中的元素 arr2[i] 各不相同
     *     arr2 中的每个元素 arr2[i] 都出现在 arr1 中
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/relative-sort-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        LeetCode_1122 leetCode_1122 = new LeetCode_1122();
        System.out.println(JSON.toJSONString(leetCode_1122.relativeSortArray(new int[]{2,3,1,3,2,4,6,7,9,2,19},new int[]{2,1,4,3,9,6})));
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        //先升序,保证未出现的顺序ok
        Arrays.sort(arr1);
        int[] a = new int[1001];
        //记录每个数出现的次数
        for (int i = 0; i < arr1.length; i++) {
            a[arr1[i]]++;
        }
        int index = 0;
        //根据arr2的排序顺序排序
        for (int i = 0; i < arr2.length; i++) {
            int num = arr2[i];
            int count = a[num];
            while (count > 0) {
                arr1[index++] = num;
                count--;
            }
            a[num] = 0;
        }
        //未出现的升序
        for (int i = 0; i < a.length; i++) {
            if (a[i] > 0) {
                int count = a[i];
                while (count > 0) {
                    arr1[index++] = i;
                    count--;
                }
            }
        }
        return arr1;
    }
}
