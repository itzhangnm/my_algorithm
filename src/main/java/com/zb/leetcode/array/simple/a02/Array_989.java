package com.zb.leetcode.array.simple.a02;

import java.util.ArrayList;
import java.util.List;

/**
 * 数组形式的整数加法
 *
 * @author Zhang Bo
 * @date 2020/1/2 15:33
 */
public class Array_989 {
    /**
     * 对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
     * <p>
     * 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：A = [1,2,0,0], K = 34
     * 输出：[1,2,3,4]
     * 解释：1200 + 34 = 1234
     * 示例 2：
     * <p>
     * 输入：A = [2,7,4], K = 181
     * 输出：[4,5,5]
     * 解释：274 + 181 = 455
     * 示例 3：
     * <p>
     * 输入：A = [2,1,5], K = 806
     * 输出：[1,0,2,1]
     * 解释：215 + 806 = 1021
     * 示例 4：
     * <p>
     * 输入：A = [9,9,9,9,9,9,9,9,9,9], K = 1
     * 输出：[1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
     * 解释：9999999999 + 1 = 10000000000
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= A.length <= 10000
     * 0 <= A[i] <= 9
     * 0 <= K <= 10000
     * 如果 A.length > 1，那么 A[0] != 0
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/add-to-array-form-of-integer
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        Array_989 array_989 = new Array_989();
        System.out.println(array_989.addToArrayForm(new int[]{1, 2, 0, 0}, 34));
        System.out.println(array_989.addToArrayForm(new int[]{2, 7, 4}, 181));
        System.out.println(array_989.addToArrayForm(new int[]{2, 1, 5}, 806));
        System.out.println(array_989.addToArrayForm(new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, 1));
        System.out.println(array_989.addToArrayForm(new int[]{6}, 34));
    }

    public List<Integer> addToArrayForm(int[] A, int K) {
        int[] r = new int[10002];
        for (int i = 0; i < A.length; i++) {
            r[A.length - i - 1] = A[i];
        }
        int count = 0;
        while (K > 0 || r[count] != 0) {
            int tmp = r[count] + K % 10;
            if (tmp >= 10) {
                r[count + 1] += 1;
                tmp -= 10;
            }
            r[count] = tmp;
            K /= 10;
            count++;
        }
        count = count > A.length ? count : A.length;
        List<Integer> result = new ArrayList<>(count);
        while (count > 0) {
            result.add(r[--count]);
        }
        return result;
    }
}
