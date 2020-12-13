package com.zb.leetcode.simple._000;

import java.util.Arrays;

/**
 * 66 加一
 * @author Zhang Bo
 * @date 2019/11/19 13:58
 */
public class LeetCode_066 {
    /**
     * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
     * <p>
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     * <p>
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [1,2,3]
     * 输出: [1,2,4]
     * 解释: 输入数组表示数字 123。
     * 示例 2:
     * <p>
     * 输入: [4,3,2,1]
     * 输出: [4,3,2,2]
     * 解释: 输入数组表示数字 4321。
     * <p>
     * 来源：力扣（LeetCode_148）
     * 链接：https://leetcode-cn.com/problems/plus-one
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        LeetCode_066 leetCode066 = new LeetCode_066();
        System.out.println(Arrays.toString(leetCode066.plusOne(new int[]{9})));

    }

    public int[] plusOne(int[] digits) {
        //繁琐
//        int add = 1;
//        for (int i = digits.length - 1; i >= 0; i--) {
//            //存在进位
//            if (add == 1) {
//                if (digits[i] == 9) {
//                    //进位
//                    digits[i] = 0;
//                } else {
//                    //加一即可,进位消除
//                    digits[i] = digits[i] + 1;
//                    add = 0;
//                }
//            } else {
//                break;
//            }
//        }
//        //首位进位,需要扩容
//        if (add == 1) {
//            int[] newDigits = new int[digits.length + 1];
//            newDigits[0] = 1;
//            for (int i = 0; i < digits.length; i++) {
//                newDigits[i + 1] = digits[i];
//            }
//            return newDigits;
//        }

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            }else {
                digits[i] += 1;
                return digits;
            }
        }
        //int[]数组默认值就是0,如果存在首位扩容问题,那么后面所有值都为0
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
