package com.zb.leetcode.simple._100;

import java.util.Arrays;
import java.util.List;

/**
 * 119.杨辉三角 II
 * @author Zhang Bo
 * @date 2019/11/19 15:47
 */
public class LeetCode_119 {

    /**
     * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。



     在杨辉三角中，每个数是它左上方和右上方的数的和。

     示例:

     输入: 3
     输出: [1,3,3,1]
     进阶：

     你可以优化你的算法到 O(k) 空间复杂度吗？

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/pascals-triangle-ii
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public List<Integer> getRow(int rowIndex) {
        //复杂度O(K)
        Integer[] result = new Integer[rowIndex + 1];
        //默认第一行 1
        result[0] = 1;
        //循环 k次
        for (int i = 1; i <= rowIndex; i++) {
            //记录上一层当前j索引前一个值
            int lastNum = result[0];
            //循环获取下一层对应位置值
            for (int j = 1; j < i ; j++) {
                //临时记录当前上一层当前值
                int tmp = result[j];
                //上一层值加上一层前一个值即为当前层值
                result[j] = result[j] + lastNum;
                //更新上一层对应前一个值
                lastNum = tmp;
            }
            //当前层最后值为1
            result[i] = 1;
        }
        return Arrays.asList(result);
    }
}
