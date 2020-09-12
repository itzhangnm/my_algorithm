package com.zb.leetcode.simple._800;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;

/**
 * 公平的糖果交换
 *
 * @author Zhang Bo
 * @date 2019/12/31 14:27
 */
public class LeetCode_888 {

    /**
     * 爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 块糖的大小，B[j] 是鲍勃拥有的第 j 块糖的大小。
     * <p>
     * 因为他们是朋友，所以他们想交换一个糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）
     * <p>
     * 返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。
     * <p>
     * 如果有多个答案，你可以返回其中任何一个。保证答案存在。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：A = [1,1], B = [2,2]
     * 输出：[1,2]
     * 示例 2：
     * <p>
     * 输入：A = [1,2], B = [2,3]
     * 输出：[1,2]
     * 示例 3：
     * <p>
     * 输入：A = [2], B = [1,3]
     * 输出：[2,3]
     * 示例 4：
     * <p>
     * 输入：A = [1,2,5], B = [2,4]
     * 输出：[5,4]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/fair-candy-swap
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        LeetCode_888 leetCode_888 = new LeetCode_888();
        System.out.println(JSON.toJSONString(leetCode_888.fairCandySwap(new int[]{1, 1}, new int[]{2, 2})));
        System.out.println(JSON.toJSONString(leetCode_888.fairCandySwap(new int[]{1, 2}, new int[]{2, 3})));
        System.out.println(JSON.toJSONString(leetCode_888.fairCandySwap(new int[]{2}, new int[]{1, 3})));
        System.out.println(JSON.toJSONString(leetCode_888.fairCandySwap(new int[]{1, 2, 5}, new int[]{2, 4})));

    }

    public int[] fairCandySwap(int[] A, int[] B) {
        HashMap<Integer, Object> map = new HashMap<>(B.length);
        Object o = new Object();
        int sum = 0;
        int i = 0;
        while (i < A.length) {
            if (i < B.length) {
                sum = sum + A[i] - B[i];
                map.put(B[i],o);
            } else {
                sum += A[i];
            }
            i++;
        }
        while (i < B.length) {
            sum -= B[i];
            map.put(B[i],o);
            i++;
        }
        for (int j = 0; j < A.length; j++) {
            //交换目标公式
            //sumA - A + B = sumB - B + A  sumA -sumB = n
            //B = (2A - n) / 2
            int targetB = (2 * A[j] - sum) / 2;
            if (map.get(targetB) != null) {
                return new int[]{A[j],targetB};
            }
        }
        return new int[]{};
    }
}
