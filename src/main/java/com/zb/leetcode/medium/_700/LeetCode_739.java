package com.zb.leetcode.medium._700;

import java.util.*;

/***
 * 739. 每日温度
 * @author once
 * @date 2020/12/27 16:35
 *
 */
public class LeetCode_739 {

    /**
     * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
     * <p>
     * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
     * <p>
     * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/daily-temperatures
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public int[] dailyTemperatures(int[] T) {
        int[] rs = new int[T.length];
        Map<Integer, List<Integer>> maps = new HashMap<>();
        for (int i = 0; i < T.length; i++) {
            Iterator<Map.Entry<Integer, List<Integer>>> it = maps.entrySet().iterator();
            while (it.hasNext()) {
                Integer key = it.next().getKey();
                if (key < T[i]) {
                    List<Integer> list = maps.get(key);
                    for (Integer index : list) {
                        rs[index] = i - index;
                    }
                    it.remove();
                }
            }
            List<Integer> list = maps.getOrDefault(T[i], new ArrayList<>());
            list.add(i);
            maps.put(T[i], list);
        }
        return rs;
    }
}
