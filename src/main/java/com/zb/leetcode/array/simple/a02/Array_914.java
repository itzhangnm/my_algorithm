package com.zb.leetcode.array.simple.a02;

import java.util.HashMap;

/**
 * 卡牌分组
 * @author Zhang Bo
 * @date 2019/12/31 17:36
 */
public class Array_914 {
    /**
     * 给定一副牌，每张牌上都写着一个整数。

     此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：

     每组都有 X 张牌。
     组内所有的牌上都写着相同的整数。
     仅当你可选的 X >= 2 时返回 true。

      

     示例 1：

     输入：[1,2,3,4,4,3,2,1]
     输出：true
     解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
     示例 2：

     输入：[1,1,1,2,2,2,3,3]
     输出：false
     解释：没有满足要求的分组。
     示例 3：

     输入：[1]
     输出：false
     解释：没有满足要求的分组。
     示例 4：

     输入：[1,1]
     输出：true
     解释：可行的分组是 [1,1]
     示例 5：

     输入：[1,1,2,2,2,2]
     输出：true
     解释：可行的分组是 [1,1]，[2,2]，[2,2]

     提示：

     1 <= deck.length <= 10000
     0 <= deck[i] < 10000

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/x-of-a-kind-in-a-deck-of-cards
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        Array_914 array_914 = new Array_914();
        System.out.println(array_914.hasGroupsSizeX(new int[]{1, 2, 3, 4, 4, 3, 2, 1}));
        System.out.println(array_914.hasGroupsSizeX(new int[]{1, 1, 1, 2, 2, 2, 3, 3}));
        System.out.println(array_914.hasGroupsSizeX(new int[]{1}));
        System.out.println(array_914.hasGroupsSizeX(new int[]{1, 1}));
        System.out.println(array_914.hasGroupsSizeX(new int[]{1, 1, 2, 2, 2, 2}));
        System.out.println(array_914.hasGroupsSizeX(new int[]{1, 1, 1, 1, 2, 2, 2, 2, 2, 2}));
    }

    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer, Integer> map = new HashMap<>(deck.length);
        for (int i = 0; i < deck.length; i++) {
            if (map.get(deck[i]) != null) {
                map.put(deck[i], map.get(deck[i]) + 1);
            }else{
                map.put(deck[i], 1);
            }
        }
        int minGroup = Integer.MAX_VALUE;
        for (Integer i : map.values()) {
            if (minGroup > i) {
                minGroup = i;
            }
        }
        if (minGroup < 2) {
            return false;
        }
        int i = 2;
        while (i <= minGroup) {
            boolean flag = true;
            for (Integer val : map.values()) {
                if (val % i != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
            i++;
        }
        //优化可以用最大公约数求解
        return false;
    }

    private int group(int x, int y) {
        return x == 0 ? y : group(y % x, x);
    }
}
