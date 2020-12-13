package com.zb.leetcode.simple._100;

import java.util.ArrayList;
import java.util.List;

/**
 * 118.杨辉三角
 * @author Zhang Bo
 * @date 2019/11/19 15:02
 */
public class LeetCode_118 {

    /**
     * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
     * <p>
     * <p>
     * <p>
     * 在杨辉三角中，每个数是它左上方和右上方的数的和。
     * <p>
     * 示例:
     * <p>
     * 输入: 5
     * 输出:
     * [
     * [1],
     * [1,1],
     * [1,2,1],
     * [1,3,3,1],
     * [1,4,6,4,1]
     * ]
     * <p>
     * 来源：力扣（LeetCode_148）
     * 链接：https://leetcode-cn.com/problems/pascals-triangle
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        LeetCode_118 leetCode_118 = new LeetCode_118();
        System.out.println(leetCode_118.generate(5));
        System.out.println(leetCode_118.generate(6));
        System.out.println(leetCode_118.generate(7));
        System.out.println(leetCode_118.generate(8));

    }


    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);
        for (int i = 1; i <= numRows; i++) {
            List<Integer> list = new ArrayList<>(i);
            //头部始终为1
            list.add(1);
            if (i > 1) {
                //取上一层
                List<Integer> lastList = result.get(i - 2);
                //上一层当前下标与前一下标和为当前层值
                for (int j = 1; j < lastList.size(); j++) {
                    list.add(lastList.get(j) + lastList.get(j - 1));
                }
                //尾部始终为1
                list.add(1);
            }
            result.add(list);
        }
        return result;
    }
}
