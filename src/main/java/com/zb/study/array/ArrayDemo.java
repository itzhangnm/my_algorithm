package com.zb.study.array;

/***
 *
 * @author once
 * @date 2019/11/24 15:06
 *
 */
public class ArrayDemo {


    private int[] data;
    private int count;
    private int resize = 2;
    private int removeCount;


    public void add(int i,int n) {
        //不考虑数据连续性与顺序
        int tmp = data[i];
        data[i] = n;
        data[count++] = tmp;
    }

    public void remove(int i) {
        //不考虑数据连续性与顺序
        data[i] = 0;
        removeCount++;
        //删除数据达到整理数据条件
        if (removeCount == resize) {
            //搬移代码
        }
    }

}
