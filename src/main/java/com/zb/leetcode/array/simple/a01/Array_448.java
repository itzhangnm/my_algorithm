package com.zb.leetcode.array.simple.a01;

import java.util.ArrayList;
import java.util.List;

/***
 *
 * @author once
 * @date 2019/12/8 12:11
 *
 */
public class Array_448 {
    /**
     * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
     * <p>
     * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
     * <p>
     * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
     * <p>
     * 示例:
     * <p>
     * 输入:
     * [4,3,2,7,8,2,3,1]
     * <p>
     * 输出:
     * [5,6]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        Array_448 array_448 = new Array_448();
        System.out.println(array_448.findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>(nums.length);
        int i = 0;
        while (i < nums.length) {
            //循环计数,存在过的数的下标,标记为1
            int n = nums[i] - 1;
            if (n >= 0 && nums[n] > 0) {
                nums[i] = nums[n];
                nums[n] = -1;
            } else {
                i++;
            }
        }
        //未存在过,下面位置值一定大于0
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] > 0) {
                list.add(j + 1);
            }
        }
        return list;
    }
}
