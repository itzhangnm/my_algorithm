package com.zb.leetcode.array.simple.a01;

/**
 * @author Zhang Bo
 * @date 2019/11/19 16:16
 */
public class Array_121 {
    /**
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

     如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。

     注意你不能在买入股票前卖出股票。

     示例 1:

     输入: [7,1,5,3,6,4]
     输出: 5
     解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
     示例 2:

     输入: [7,6,4,3,1]
     输出: 0
     解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        Array_121 array_121 = new Array_121();
        System.out.println(array_121.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(array_121.maxProfit(new int[]{7,6,4,3,1}));
    }

    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        //初始化利润
        int result = 0;
        //倒序比较
        int maxValue = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
            //买入价格出现
            if (prices[i] < maxValue) {
                //计算利润
                int tmp = maxValue - prices[i];
                //更新利润,取最大利润
                result = tmp > result ? tmp : result;
            }else {
                //更新最大卖出价格
                maxValue = prices[i];
            }
        }
        return result;
    }
}
