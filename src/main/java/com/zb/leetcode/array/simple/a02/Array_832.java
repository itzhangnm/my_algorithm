package com.zb.leetcode.array.simple.a02;

import com.alibaba.fastjson.JSON;

/**
 * @author Zhang Bo
 * @date 2019/12/23 19:26
 */
public class Array_832 {

    /**
     * 给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。

     水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。

     反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。

     示例 1:

     输入: [[1,1,0],[1,0,1],[0,0,0]]
     输出: [[1,0,0],[0,1,0],[1,1,1]]
     解释: 首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
     然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
     示例 2:

     输入: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
     输出: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
     解释: 首先翻转每一行: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；
     然后反转图片: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
     说明:

     1 <= A.length = A[0].length <= 20
     0 <= A[i][j] <= 1

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/flipping-an-image
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        Array_832 array_832 = new Array_832();
        System.out.println(JSON.toJSONString(array_832.flipAndInvertImage(new int[][]{
                {1,1,0},
                {1,0,1},
                {0,0,0}
        })));
        System.out.println(JSON.toJSONString(array_832.flipAndInvertImage(new int[][]{
                {1,1,0,0},
                {1,0,0,1},
                {0,1,1,1},
                {1,0,1,0}
        })));
    }

    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            int n = A[0].length - 1;
            for (int j = 0; j <= n / 2 ; j++) {
                if (A[i][j] == A[i][n - j]) {
                    A[i][j] = A[i][n - j] = (A[i][j] + 1) & 1;
                }
            }
        }
        return A;
    }
}
