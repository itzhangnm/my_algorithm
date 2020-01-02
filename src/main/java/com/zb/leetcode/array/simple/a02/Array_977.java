package com.zb.leetcode.array.simple.a02;

import com.alibaba.fastjson.JSON;

/**
 *  有序数组的平方
 * @author Zhang Bo
 * @date 2020/1/2 14:36
 */
public class Array_977 {
    /**
     * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。

      

     示例 1：

     输入：[-4,-1,0,3,10]
     输出：[0,1,9,16,100]
     示例 2：

     输入：[-7,-3,2,3,11]
     输出：[4,9,9,49,121]
      

     提示：

     1 <= A.length <= 10000
     -10000 <= A[i] <= 10000
     A 已按非递减顺序排序。

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        Array_977 array_977 = new Array_977();
        System.out.println(JSON.toJSONString(array_977.sortedSquares(new int[]{-4,-1,0,3,10})));
        System.out.println(JSON.toJSONString(array_977.sortedSquares(new int[]{-7,-3,2,3,11})));
    }

    public int[] sortedSquares(int[] A) {
        int[] result = new int[A.length];
        int i = 0;
        while (i < A.length && A[i] < 0) {
            A[i] = A[i] * A[i];
            i++;
        }
        int j = i - 1;
        for (int k = 0; k < result.length; k++) {
            if (j < 0) {
                result[k] = A[i] * A[i++];
            } else if (i >= A.length) {
                result[k] = A[j--];
            }else{
                if (A[j] <= A[i] * A[i]) {
                    result[k] = A[j--];
                }else{
                    result[k] = A[i] * A[i++];;
                }
            }
        }
        return result;
    }
}
