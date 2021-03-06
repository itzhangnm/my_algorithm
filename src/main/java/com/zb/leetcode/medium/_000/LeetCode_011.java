package com.zb.leetcode.medium._000;

/**
 * 11. 盛最多水的容器
 *
 * @author Zhang Bo
 * @date 2020/2/23 12:45
 */
public class LeetCode_011 {
    /**
     * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     * <p>
     * 说明：你不能倾斜容器，且 n 的值至少为 2。
     * <p>
     * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
     * <p>
     * <p>
     * <p>
     * 示例:
     * <p>
     * 输入: [1,8,6,2,5,4,8,3,7]
     * 输出: 49
     * <p>
     * 来源：力扣（LeetCode_148）
     * 链接：https://leetcode-cn.com/problems/container-with-most-water
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {
        LeetCode_011 leetCode011 = new LeetCode_011();
        System.out.println(leetCode011.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    public int maxArea(int[] height) {
        int head = 0;
        int tail = height.length - 1;
        int maxVal = 0;
        while (head < tail) {
            int wide = tail - head;
            int hig = height[head];
            if (height[head] > height[tail]) {
                hig = height[tail];
                tail--;
            }else{
                head++;
            }
            if (wide * hig > maxVal) {
                maxVal = wide * hig;
            }
        }
        return maxVal;
    }
}
