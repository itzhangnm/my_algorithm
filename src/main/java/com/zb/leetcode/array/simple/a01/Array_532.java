package com.zb.leetcode.array.simple.a01;

import java.util.HashMap;
import java.util.Map;

/***
 *
 * @author once
 * @date 2019/12/8 15:20
 *
 */
public class Array_532 {
    /**
     * 给定一个整数数组和一个整数 k, 你需要在数组里找到不同的 k-diff 数对。这里将 k-diff 数对定义为一个整数对 (i, j), 其中 i 和 j 都是数组中的数字，且两数之差的绝对值是 k.
     * <p>
     * 示例 1:
     * <p>
     * 输入: [3, 1, 4, 1, 5], k = 2
     * 输出: 2
     * 解释: 数组中有两个 2-diff 数对, (1, 3) 和 (3, 5)。
     * 尽管数组中有两个1，但我们只应返回不同的数对的数量。
     * 示例 2:
     * <p>
     * 输入:[1, 2, 3, 4, 5], k = 1
     * 输出: 4
     * 解释: 数组中有四个 1-diff 数对, (1, 2), (2, 3), (3, 4) 和 (4, 5)。
     * 示例 3:
     * <p>
     * 输入: [1, 3, 1, 5, 4], k = 0
     * 输出: 1
     * 解释: 数组中只有一个 0-diff 数对，(1, 1)。
     * 注意:
     * <p>
     * 数对 (i, j) 和数对 (j, i) 被算作同一数对。
     * 数组的长度不超过10,000。
     * 所有输入的整数的范围在 [-1e7, 1e7]。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/k-diff-pairs-in-an-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        Array_532 array_532 = new Array_532();
        System.out.println(array_532.findPairs(new int[]{3, 1, 4, 1, 5}, 2));
        System.out.println(array_532.findPairs(new int[]{1, 2, 3, 4, 5}, 1));
        System.out.println(array_532.findPairs(new int[]{1, 3, 1, 5, 4}, 0));
        System.out.println(array_532.findPairs(new int[]{1, 3, 1, 5, 4}, 0));
//        System.out.println(array_532.findPairs(new int[]{2, 9, 0, 8, 9, 6, 5, 9, 8, 1, 9, 6, 9, 2, 8, 8, 7, 5, 7, 8, 8, 3, 7, 4, 1, 1,
//                6, 2, 9, 9, 3, 9, 2, 4, 6, 5, 6, 5, 1, 5, 9, 9, 8, 1, 4, 3, 2, 8, 5, 3, 5, 4, 5,
//                7, 0, 0, 7, 6, 4, 7, 2, 4, 9, 3, 6, 6, 5, 0, 0, 0, 8, 9, 9, 6, 5, 4, 6, 2, 1, 3, 2, 5, 0, 1, 4, 2, 6, 9, 5, 4, 9, 6, 0, 8, 3, 8, 0, 0, 2, 1, 1}, 1));
    }

    public int findPairs(int[] nums, int k) {
        int count = 0;
        if (k < 0) {
            return count;
        }
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) != null) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 0);
            }
        }
        for (Integer i : map.keySet()) {
            if (k == 0) {
                if (map.get(i) > 0) {
                    count++;
                }
            } else {
                if (map.containsKey(i + k)) {
                    count++;
                }
            }
        }
        return count;
    }
}
