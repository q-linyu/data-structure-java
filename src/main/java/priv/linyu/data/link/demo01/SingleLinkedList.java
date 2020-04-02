package priv.linyu.data.link.demo01;

import java.util.Stack;

/**
 * @className: SingleLinkedListDemo
 * @author: q-linyu
 * @description: 单链表
 * @date: 2020/03/30 14:56
 * @version: 1.0
 */
public class SingleLinkedList {

    private Node currNode;


    public SingleLinkedList() {
        this.currNode = new Node(0);
    }

    /**
     * 添加节点
     *
     * @param node
     */
    public void add(Node node) {

        // 1.获取当前节点
        Node tempNode = currNode;

        // 2.循环向后找
        while (true) {
            // 取出下一个节点
            Node nextNode = tempNode.next;
            // 如果下一个节点没有找到
            if (nextNode == null) {
                break;
            }
            // 赋值给当前节点
            tempNode = nextNode;
        }
        tempNode.next = node;
    }

    /**
     * 判断是否下一个节点
     *
     * @return
     */
    public boolean isNext() {
        return currNode.next != null;
    }


    /**
     * 打印数据
     */
    public void show() {
        // 判断链表是否为空
        Node tempNode = currNode;
        if (tempNode.next == null) {
            throw new RuntimeException("空链表");
        }

        Node temp = tempNode.next;
        while (temp != null) {
            System.out.println(temp.toString());
            temp = temp.next;
        }
    }

    /**
     * 删除下一个节点
     */
    public void removeNext() {
        this.currNode.next = this.currNode.next.next;
    }

    /**
     * 删除节点
     * @param node
     */
    public void remove(Node node){
        Node temp = currNode;
        while (true){
            if (temp.next == null){
                break;
            }

            if (temp.next.element == node.element){
                break;
            }

            temp = temp.next;
        }
        temp.next = temp.next.next;
    }


    /**
     * 面试题：获取到单链表的节点的个数(如果是带头结点的链表，需求不统计头节点)
     * 思路分析：就是除了头节点之外,剩下的所有节点,就是遍历所有下一个节点
     *
     * @param head
     * @return
     */
    public int length(Node head) {
        if (head.next == null) {
            return 0;
        }

        // 记录节点数
        int len = 0;

        Node curr = head.next;
        while (curr != null) {
            len++;
            curr = curr.next;
        }
        return len;
    }


    /**
     * 面试题：查找单链表中的倒数第k个节点
     * 思路分析
     * 1. 编写一个方法，接收node节点，同时接收一个index
     * 2. index 表示是倒数第index个节点
     * 3. 先把链表从头到尾遍历，得到链表的总的长度 getLength
     * 4. 得到size 后，我们从链表的第一个开始遍历 (size-index)个
     * 5. 如果找到了，则返回该节点，否则返回null
     *
     * @param node  节点
     * @param index 倒数第几个
     * @return
     */
    public Node findLastIndexNode(Node node, int index) {
        // 判断是否是空链表
        if (node.next == null){
            return null;
        }

        int len = length(node);
        // 如果倒数第0个或者倒数大于长度的时候,返回为空
        if (index <= 0 || index > len){
            return null;
        }

        // 获取下一个节点
        Node curr = currNode.next;
        // 分析：如果长度为5,需要找倒数第2个,所以是5-2,要移动3个,就是倒数第二个
        for (int i = 0;i < len - index;i++){
            curr = curr.next;
        }
        return curr;
    }

    /**
     * 逆序
     * @param node
     */
    public static void reverse(Node node){
        if (node.next == null){
            return;
        }

        Stack<Node> stack = new Stack<>();
        Node curr = node;
        while (curr != null){
            stack.push(curr);
            curr = curr.next;
        }

        while (stack.size() > 0){
            System.out.println(stack.pop());
        }

    }

    private static class Node {
        /**
         * 节点的内容
         */
        transient Object element;

        /**
         * 下一个节点
         */
        private Node next;


        public Node(Object element) {
            this.element = element;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "element=" + element +
                    '}';
        }
    }

    public static void main(String[] args) {
        Node node01 = new Node(1);
        Node node02 = new Node(2);
        Node node03 = new Node(3);
        Node node04 = new Node(4);
        Node node05 = new Node(5);

        SingleLinkedList list = new SingleLinkedList();
        list.add(node01);
        list.add(node02);
        list.add(node03);
        list.add(node04);
        list.add(node05);

        reverse(node01);

    }
}
