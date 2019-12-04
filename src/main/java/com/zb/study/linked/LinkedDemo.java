package com.zb.study.linked;

/***
 * 链表操作练习
 * @author once
 * @date 2019/11/24 15:52
 *
 */
public class LinkedDemo {

    public static void main(String[] args) {
        LinkedDemo linkedDemo = new LinkedDemo();

        //链表反转
        Node<String> node = new Node<>("a");
        node.next = new Node<>( "b");
        node.next.next = new Node<>("c");
        Node reverse = linkedDemo.reverse(node);
//        System.out.println(reverse);

        //环形检测
        node = new Node<>("a");
        node.next = new Node<>("b");
        node.next.next = new Node<>("c");
        node.next.next.next = new Node<>("d");
        node.next.next.next.next = new Node<>("e");
        node.next.next.next.next.next = node.next.next;
        System.out.println(linkedDemo.isRing(node));


        Node<Integer> n1 = new Node<>(1);
        n1.next = new Node<>(3);
        n1.next.next = new Node<>(4);
        n1.next.next.next = new Node<>(6);
        n1.next.next.next.next = new Node<>(9);
        Node<Integer> n2 = new Node<>(2);
        n2.next = new Node<>(5);
        n2.next.next = new Node<>(6);
        n2.next.next.next = new Node<>(7);
        n2.next.next.next.next = new Node<>(8);
        linkedDemo.merge(n1, n2);
    }

    /**
     * 反转链表
     *
     * @param node 链表
     */
    public Node reverse(Node node) {
        Node newNode = null;
        while (node != null) {
            Node tmp = node;
            node = node.next;
            tmp.next = newNode;
            newNode = tmp;
        }
        return newNode;
    }

    /**
     * 判断是否环形
     * @param node
     * @return
     */
    public boolean isRing(Node node) {
        if (node == null || node.next == null) {
            return false;
        }
        //快慢指针
        Node n = node;
        Node l = node.next.next;
        while (n != null && l != null) {
            //如果存在环形,快慢指针一定会相遇
            if (n == l) {
                return true;
            }
            n = n.next;
            l = l.next.next;
        }
        return false;
    }

    /**
     * 合并两个有序链表
     * @param n
     * @param d
     * @return
     */
    public Node merge(Node<Integer> n, Node<Integer> d) {
        Node<Integer> newNode = new Node<>(null);
        Node<Integer> tmp = newNode;
        while (n != null && d != null) {
            if (n.t < d.t) {
                tmp.next = n;
                n = n.next;
            }else{
                tmp.next = d;
                d = d.next;
            }
            tmp = tmp.next;
        }
        //剩余节点
        if (n == null) {
            tmp.next = d;
        }else{
            tmp.next = n;
        }
        return newNode.next;
    }


    public static class Node<T> {
        T t;
        Node<T> next;

        public Node(T t) {
            this.t = t;
        }
    }
}
