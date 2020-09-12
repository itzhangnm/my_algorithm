package com.zb.leetcode.simple._100;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * 155.最小栈
 * @author Zhang Bo
 * @date 2019/11/14 11:05
 */
public class LeetCode_155 {
    /**
     * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。

     push(x) -- 将元素 x 推入栈中。
     pop() -- 删除栈顶的元素。
     top() -- 获取栈顶元素。
     getMin() -- 检索栈中的最小元素。
     示例:

     MinStack minStack = new MinStack();
     minStack.push(-2);
     minStack.push(0);
     minStack.push(-3);
     minStack.getMin();   --> 返回 -3.
     minStack.pop();
     minStack.top();      --> 返回 0.
     minStack.getMin();   --> 返回 -2.
     */

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        stack.push(-3);
        stack.push(-3);
        stack.push(-3);
        stack.push(-3);
        stack.push(-3);
        stack.push(-3);
        stack.push(-3);
        stack.push(-3);
        stack.push(-3);
        stack.push(-3);
        stack.push(-3);
        stack.push(-3);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.top());
        System.out.println(stack.getMin());
    }

    static class MinStack {


        private int[] data;

        private int count;

        public MinStack() {

        }

        public void push(int x) {
            if (data == null) {
                data = new int[10];
            }
            if (count - data.length >= 0) {
                data = Arrays.copyOf(data, data.length + 10);
            }
            data[count++] = x;
        }

        public void pop() {
            if (count == 0) {
                throw new EmptyStackException();
            }
            count--;
            data[count] = 0;
        }

        public int top() {
            if (count == 0) {
                throw new EmptyStackException();
            }
            return data[count - 1];
        }

        public int getMin() {
            int min = data[count - 1];
            for (int i = 0; i < count; i++) {
                if (min > data[i]) {
                    min = data[i];
                }
            }
            return min;
        }
    }
}
