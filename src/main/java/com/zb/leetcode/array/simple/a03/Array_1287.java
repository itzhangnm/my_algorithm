package com.zb.leetcode.array.simple.a03;

/**
 * @author Zhang Bo
 * @date 2019/12/16 15:47
 */
public class Array_1287 {
    /**
     * 给你一个非递减的 有序 整数数组，已知这个数组中恰好有一个整数，它的出现次数超过数组元素总数的 25%。

     请你找到并返回这个整数

      

     示例：

     输入：arr = [1,2,2,6,6,6,6,7,10]
     输出：6
      

     提示：

     1 <= arr.length <= 10^4
     0 <= arr[i] <= 10^5

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/element-appearing-more-than-25-in-sorted-array
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public int findSpecialInteger(int[] arr) {
        int count = 1;
        int tmp = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == tmp) {
                count ++;
            }else{
                count = 1;
                tmp = arr[i];
            }
            if (count * 4 > arr.length) {
                return arr[i];
            }
        }
        return arr[0];
    }
}
