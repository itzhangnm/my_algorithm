package com.zb.leetcode.simple._900;

/**
 * 997. 找到小镇的法官
 * @author Zhang Bo
 * @date 2020/9/29 15:08
 */
public class LeetCode_997 {

    /**
     * 在一个小镇里，按从 1 到 N 标记了 N 个人。传言称，这些人中有一个是小镇上的秘密法官。

     如果小镇的法官真的存在，那么：

     小镇的法官不相信任何人。
     每个人（除了小镇法官外）都信任小镇的法官。
     只有一个人同时满足属性 1 和属性 2 。
     给定数组 trust，该数组由信任对 trust[i] = [a, b] 组成，表示标记为 a 的人信任标记为 b 的人。

     如果小镇存在秘密法官并且可以确定他的身份，请返回该法官的标记。否则，返回 -1。

      

     示例 1：

     输入：N = 2, trust = [[1,2]]
     输出：2
     示例 2：

     输入：N = 3, trust = [[1,3],[2,3]]
     输出：3
     示例 3：

     输入：N = 3, trust = [[1,3],[2,3],[3,1]]
     输出：-1
     示例 4：

     输入：N = 3, trust = [[1,2],[2,3]]
     输出：-1
     示例 5：

     输入：N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
     输出：3
      

     提示：

     1 <= N <= 1000
     trust.length <= 10000
     trust[i] 是完全不同的
     trust[i][0] != trust[i][1]
     1 <= trust[i][0], trust[i][1] <= N

     来源：力扣（LeetCode_148）
     链接：https://leetcode-cn.com/problems/find-the-town-judge
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param args
     */
    public static void main(String[] args) {
        LeetCode_997 leetCode_997 = new LeetCode_997();
        System.out.println(leetCode_997.findJudge(2,new int[][]{{1,2}}));
        System.out.println(leetCode_997.findJudge(3,new int[][]{{1,3},{2,3}}));
        System.out.println(leetCode_997.findJudge(3,new int[][]{{1,3},{2,3},{3,1}}));
        System.out.println(leetCode_997.findJudge(3,new int[][]{{1,2},{2,3}}));
        System.out.println(leetCode_997.findJudge(4,new int[][]{{1,3},{1,4},{2,3},{2,4},{4,3}}));
    }
    public int findJudge(int N, int[][] trust) {
//        int[][] graph = new int[N+1][N+1];
//        for (int i = 0; i < trust.length; i++) {
//            graph[trust[i][0]][trust[i][1]] = 1;
//        }
//        bk:for (int i = 1; i < graph.length; i++) {
//            for (int j = 1; j < graph.length; j++) {
//                if (graph[i][j] == 1) {
//                    continue bk;
//                }
//            }
//            for (int j = 1; j < graph.length; j++) {
//                if (graph[j][i] == 0 && j != i) {
//                    continue bk;
//                }
//            }
//            return i;
//        }
        //优化成O(N)
        int[] degree = new int[N + 1];
        for (int i = 0; i < trust.length; i++) {
            degree[trust[i][0]]--;
            degree[trust[i][1]]++;
        }
        for (int i = 1; i < degree.length; i++) {
            if (degree[i] == N - 1) {
                return i;
            }
        }
        return -1;
    }
}
