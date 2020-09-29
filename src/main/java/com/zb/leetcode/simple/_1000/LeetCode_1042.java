package com.zb.leetcode.simple._1000;

import com.alibaba.fastjson.JSON;

/**
 * 1042. 不邻接植花
 *
 * @author Zhang Bo
 * @date 2020/9/29 16:23
 */
public class LeetCode_1042 {
    /**
     * 有 N 个花园，按从 1 到 N 标记。在每个花园中，你打算种下四种花之一。

     paths[i] = [x, y] 描述了花园 x 到花园 y 的双向路径。

     另外，没有花园有 3 条以上的路径可以进入或者离开。

     你需要为每个花园选择一种花，使得通过路径相连的任何两个花园中的花的种类互不相同。

     以数组形式返回选择的方案作为答案 answer，其中 answer[i] 为在第 (i+1) 个花园中种植的花的种类。花的种类用  1, 2, 3, 4 表示。保证存在答案。

      

     示例 1：

     输入：N = 3, paths = [[1,2],[2,3],[3,1]]
     输出：[1,2,3]
     示例 2：

     输入：N = 4, paths = [[1,2],[3,4]]
     输出：[1,2,1,2]
     示例 3：

     输入：N = 4, paths = [[1,2],[2,3],[3,4],[4,1],[1,3],[2,4]]
     输出：[1,2,3,4]

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/flower-planting-with-no-adjacent
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     提示：

     1 <= N <= 10000
     0 <= paths.size <= 20000
     不存在花园有 4 条或者更多路径可以进入或离开。
     保证存在答案。
     */
    public static void main(String[] args) {
        LeetCode_1042 leetCode_1042 = new LeetCode_1042();
        System.out.println(JSON.toJSONString(leetCode_1042.gardenNoAdj(3,new int[][]{{1,2},{2,3},{3,1}})));
        System.out.println(JSON.toJSONString(leetCode_1042.gardenNoAdj(4,new int[][]{{1,2},{2,3},{4,1}})));
        System.out.println(JSON.toJSONString(leetCode_1042.gardenNoAdj(4,new int[][]{{1,2},{3,4}})));
        System.out.println(JSON.toJSONString(leetCode_1042.gardenNoAdj(4,new int[][]{{1,2},{2,3},{3,4},{4,1},{1,3},{2,4}})));
        System.out.println(JSON.toJSONString(leetCode_1042.gardenNoAdj(1000,new int[][]{})));
    }

    public int[] gardenNoAdj(int N, int[][] paths) {
        //最多三个边
        int[][] dp = new int[N+1][3];
        for (int[] path : paths) {
            int temp = 0;
            //递增记录边
            while (dp[path[0]][temp] != 0) temp++;
            dp[path[0]][temp] = path[1];
            temp = 0;
            while (dp[path[1]][temp] != 0) temp++;
            dp[path[1]][temp] = path[0];
        }
        int[] tempRes = new int[N + 1];
        for (int i = 1; i <= N ; i++) {
            int temp = 1;
            //循环判断当前点的邻点的个数
            while (tempRes[dp[i][0]] == temp || tempRes[dp[i][1]] == temp || tempRes[dp[i][2]] == temp) temp++;
            tempRes[i] = temp;
        }

        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            result[i] = tempRes[i + 1];
        }
        return result;
    }
}
