package com.zb.leetcode.simple._800;

/**
 * 单调数列
 *
 * @author Zhang Bo
 * @date 2019/12/31 16:47
 */
public class LeetCode_896 {

    /**
     * 如果数组是单调递增或单调递减的，那么它是单调的。
     * <p>
     * 如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。
     * <p>
     * 当给定的数组 A 是单调数组时返回 true，否则返回 false。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：[1,2,2,3]
     * 输出：true
     * 示例 2：
     * <p>
     * 输入：[6,5,4,4]
     * 输出：true
     * 示例 3：
     * <p>
     * 输入：[1,3,2]
     * 输出：false
     * 示例 4：
     * <p>
     * 输入：[1,2,4,5]
     * 输出：true
     * 示例 5：
     * <p>
     * 输入：[1,1,1]
     * 输出：true
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= A.length <= 50000
     * -100000 <= A[i] <= 100000
     * <p>
     * 来源：力扣（LeetCode_148）
     * 链接：https://leetcode-cn.com/problems/monotonic-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        LeetCode_896 leetCode_896 = new LeetCode_896();
        System.out.println(leetCode_896.isMonotonic(new int[]{1, 2, 2, 3}));
        System.out.println(leetCode_896.isMonotonic(new int[]{6, 5, 4, 4}));
        System.out.println(leetCode_896.isMonotonic(new int[]{1, 3, 2}));
        System.out.println(leetCode_896.isMonotonic(new int[]{1, 2, 4, 5}));
        System.out.println(leetCode_896.isMonotonic(new int[]{1, 1, 1}));
    }

    public boolean isMonotonic(int[] A) {
        if (A.length < 2) {
            return true;
        }
        boolean targetFlag = false;
        boolean flag = false;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] != A[i + 1]) {
                if (!flag) {
                    flag = true;
                    targetFlag = A[i] < A[i + 1];
                } else {
                    if (targetFlag != (A[i] < A[i + 1])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
