package com.zb.leetcode.array.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Zhang Bo
 * @date 2019/12/20 17:40
 */
public class Array_697 {
    /**
     * 给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。

     你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。

     示例 1:

     输入: [1, 2, 2, 3, 1]
     输出: 2
     解释:
     输入数组的度是2，因为元素1和2的出现频数最大，均为2.
     连续子数组里面拥有相同度的有如下所示:
     [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
     最短连续子数组[2, 2]的长度为2，所以返回2.
     示例 2:

     输入: [1,2,2,3,1,4,2]
     输出: 6
     注意:

     nums.length 在1到50,000区间范围内。
     nums[i] 是一个在0到49,999范围内的整数。

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/degree-of-an-array
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        Array_697 array_697 = new Array_697();
        System.out.println(array_697.findShortestSubArray(new int[]{1, 2, 2, 3, 1}));
        System.out.println(array_697.findShortestSubArray(new int[]{1,2,2,3,1,4,2}));
        System.out.println(array_697.findShortestSubArray(new int[]{2,1}));
    }

    public int findShortestSubArray(int[] nums) {
        int maxCount = 0;
        int shortLength = 1;
        Map<Integer, Integer> indexMap = new HashMap<>();
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer index = indexMap.get(nums[i]);
            if (index == null) {
                indexMap.put(nums[i], i);
                countMap.put(i, 1);
            }else{
                Integer count = countMap.get(index);
                countMap.put(index, ++count);
                if (count >= maxCount) {
                    int length = i - index + 1;
                    if (count > maxCount) {
                        maxCount = count;
                        shortLength = length;
                    }else{
                        shortLength = length < shortLength ? length : shortLength;
                    }
                }
            }
        }
        return shortLength;

    }
}
