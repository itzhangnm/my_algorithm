package com.zb.leetcode.simple._1000;

import com.alibaba.fastjson.JSON;

import java.util.ArrayDeque;
import java.util.Queue;

public class LeetCode_1089 {
    /**
     * 给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
     * <p>
     * 注意：请不要在超过该数组长度的位置写入元素。
     * <p>
     * 要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：[1,0,2,3,0,4,5,0]
     * 输出：null
     * 解释：调用函数后，输入的数组将被修改为：[1,0,0,2,3,0,0,4]
     * <p>
     * 示例 2：
     * <p>
     * 输入：[1,2,3]
     * 输出：null
     * 解释：调用函数后，输入的数组将被修改为：[1,2,3]
     * <p>
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= arr.length <= 10000
     * 0 <= arr[i] <= 9
     * <p>
     * 来源：力扣（LeetCode_148）
     * 链接：https://leetcode-cn.com/problems/duplicate-zeros
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        LeetCode_1089 leetCode_1089 = new LeetCode_1089();
        int[] a = {1, 0, 2, 3, 0, 4, 5, 0};
        leetCode_1089.duplicateZeros(a);
        System.out.println(JSON.toJSONString(a));
        a = new int[]{1, 2, 3};
        leetCode_1089.duplicateZeros(a);
        System.out.println(JSON.toJSONString(a));
    }

    public void duplicateZeros(int[] arr) {
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            int tmp = arr[i];
            queue.add(tmp);
            if (tmp == 0) {
                queue.add(tmp);
            }
            arr[i] = queue.poll();
        }
    }
}
