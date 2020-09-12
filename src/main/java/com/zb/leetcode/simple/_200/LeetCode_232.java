package com.zb.leetcode.simple._200;

import java.util.Stack;

/**
 * 232.用栈实现队列
 * @author Zhang Bo
 * @date 2019/11/14 14:42
 */
public class LeetCode_232 {

    /**
     * 使用栈实现队列的下列操作：
     * <p>
     * push(x) -- 将一个元素放入队列的尾部。
     * pop() -- 从队列首部移除元素。
     * peek() -- 返回队列首部的元素。
     * empty() -- 返回队列是否为空。
     * 示例:
     * <p>
     * MyQueue queue = new MyQueue();
     * <p>
     * queue.push(1);
     * queue.push(2);
     * queue.peek();  // 返回 1
     * queue.pop();   // 返回 1
     * queue.empty(); // 返回 false
     * 说明:
     * <p>
     * 你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
     * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
     * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。
     */

    class MyQueue {

        private Stack<Integer> data;


        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            data = new Stack<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            data.push(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            Stack<Integer> temp = reverse(data);
            int result = temp.pop();
            data = reverse(temp);
            return result;
        }

        /**
         * Get the front element.
         */
        public int peek() {
            Stack<Integer> temp = reverse(data);
            int result = temp.peek();
            data = reverse(temp);
            return result;
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return data.empty();
        }

        private Stack<Integer> reverse(Stack<Integer> data) {
            Stack<Integer> temp = new Stack<>();
            while (!data.empty()) {
                temp.push(data.pop());
            }
            return temp;
        }
    }
}
