package com.zb.leetcode.simple._200;


import java.util.LinkedList;

/**
 * 225.用队列实现栈
 * @author Zhang Bo
 * @date 2019/11/14 14:00
 */
public class LeetCode_225 {

    /*使用队列实现栈的下列操作：

    push(x) -- 元素 x 入栈
    pop() -- 移除栈顶元素
    top() -- 获取栈顶元素
    empty() -- 返回栈是否为空
    注意:

    你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
    你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
    你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。

    */

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }

    static class MyStack {

        private LinkedList<Integer> data;

        public MyStack() {
            data = new LinkedList<>();

        }

        public void push(int x) {
            data.add(x);
        }

        public int pop() {
            LinkedList<Integer> temp = new LinkedList<>();
            Integer pop = 0;
            while (data.size() > 1) {
                pop = data.poll();
                temp.add(pop);
            }
            pop = data.poll();
            data = temp;
            return pop;
        }

        public int top() {
            LinkedList<Integer> temp = new LinkedList<>();
            Integer pop = 0;
            while (!data.isEmpty()) {
                pop = data.poll();
                temp.add(pop);
            }
            data = temp;
            return pop;
        }

        public boolean empty() {
            return data.isEmpty();
        }
    }

}
