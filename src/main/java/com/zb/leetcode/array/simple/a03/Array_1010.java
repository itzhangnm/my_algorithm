package com.zb.leetcode.array.simple.a03;

/**
 *  总持续时间可被 60 整除的歌曲
 * @author Zhang Bo
 * @date 2020/1/3 16:07
 */
public class Array_1010 {
    /**
     * 在歌曲列表中，第 i 首歌曲的持续时间为 time[i] 秒。

     返回其总持续时间（以秒为单位）可被 60 整除的歌曲对的数量。形式上，我们希望索引的数字  i < j 且有 (time[i] + time[j]) % 60 == 0。

      

     示例 1：

     输入：[30,20,150,100,40]
     输出：3
     解释：这三对的总持续时间可被 60 整数：
     (time[0] = 30, time[2] = 150): 总持续时间 180
     (time[1] = 20, time[3] = 100): 总持续时间 120
     (time[1] = 20, time[4] = 40): 总持续时间 60
     示例 2：

     输入：[60,60,60]
     输出：3
     解释：所有三对的总持续时间都是 120，可以被 60 整数。
      

     提示：

     1 <= time.length <= 60000
     1 <= time[i] <= 500

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/pairs-of-songs-with-total-durations-divisible-by-60
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        Array_1010 array_1010 = new Array_1010();
        System.out.println(array_1010.numPairsDivisibleBy60(new int[]{30,20,150,100,40}));
        System.out.println(array_1010.numPairsDivisibleBy60(new int[]{60,60,60}));
    }

    public int numPairsDivisibleBy60(int[] time) {
//        for (int i = 0; i < time.length; i++) {
//            time[i] = time[i] % 60;
//        }
//        int count = 0;
//        Map<Integer, Integer> map = new HashMap<>(time.length);
//        for (int i = 0; i < time.length; i++) {
//            int target = (60 - time[i]) % 60;
//            Integer num = map.get(target);
//            if (num != null) {
//                count += num;
//            }
//            num = map.get(time[i]);
//            if (num == null) {
//                map.put(time[i], 1);
//            }else{
//                map.put(time[i], num + 1);
//            }
//        }
//        return count;

        //桶排序
        int[] bucket=new int[60];
        int count=0;
        for(int i=0;i<time.length;i++){
            bucket[time[i]%60]++;
        }
        for(int i=1;i<30;i++){
            count+=bucket[i]*bucket[60-i];
        }
        count+=bucket[0]*(bucket[0]-1)/2;
        count+=bucket[30]*(bucket[30]-1)/2;
        return count;
    }
}
