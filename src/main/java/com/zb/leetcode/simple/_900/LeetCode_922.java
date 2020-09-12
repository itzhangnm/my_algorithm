package com.zb.leetcode.simple._900;

import com.alibaba.fastjson.JSON;

/**
 * 按奇偶排序数组 II
 *
 * @author Zhang Bo
 * @date 2020/1/2 11:32
 */
public class LeetCode_922 {
    /**
     * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
     * <p>
     * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
     * <p>
     * 你可以返回任何满足上述条件的数组作为答案。
     * <p>
     *  
     * <p>
     * 示例：
     * <p>
     * 输入：[4,2,5,7]
     * 输出：[4,5,2,7]
     * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
     *  
     * <p>
     * 提示：
     * <p>
     * 2 <= A.length <= 20000
     * A.length % 2 == 0
     * 0 <= A[i] <= 1000
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sort-array-by-parity-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        LeetCode_922 leetCode_922 = new LeetCode_922();
        System.out.println(JSON.toJSONString(leetCode_922.sortArrayByParityII(new int[]{4, 2, 5, 7})));
        System.out.println(JSON.toJSONString(leetCode_922.sortArrayByParityII(new int[]{2,3})));
    }

    public int[] sortArrayByParityII(int[] A) {
        int i = 0;
        int j = 1;
        while (i < A.length - 1 && j < A.length) {
            while ((A[i] & 1) == 0) {
                i += 2;
                if (i >= A.length) {
                    return A;
                }
            }
            while ((A[j] & 1) == 1) {
                j += 2;
                if (j >= A.length) {
                    return A;
                }
            }
            A[i] ^= A[j];
            A[j] ^= A[i];
            A[i] ^= A[j];
            i += 2;
            j += 2;
        }
        return A;
    }
}
