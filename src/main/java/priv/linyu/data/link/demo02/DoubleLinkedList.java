package priv.linyu.data.link.demo02;

/**
 * @className: DoubleLinkedList
 * @author: q-linyu
 * @description: 双向链表
 * @date: 2020/03/31 22:02
 * @version: 1.0
 */
public class DoubleLinkedList {

    /**
     * 当前节点
     */
    private Node currNode;

    public DoubleLinkedList() {
        currNode = new Node(0);
    }

    /**
     * 添加节点
     * @param node
     */
    public void add(Node node){
        // 定义一个指针
        Node tempNode = currNode;

        // 循环往后找
        while (true){
            if (tempNode.next == null){
                break;
            }
            tempNode = tempNode.next;
        }
        tempNode.next = node;
        node.prev = tempNode;
    }

    /**
     * 修改
     * @param node
     */
    public void set(Node node){
        if (currNode.next == null){
            return;
        }

        Node tempNode = currNode.next;
        while (true){
            if (tempNode == null) {
                break;
            }

            if (tempNode.element == node.element){
                break;
            }

            tempNode = tempNode.next;

        }

        tempNode.element = node.element;

    }

    /**
     * 移除
     * @param node
     */
    public void remove(Node node){
        if (currNode.next == null){
            return;
        }

        Node tempNode = currNode.next;
        while (true){
            if (tempNode == null) {
                break;
            }

            if (tempNode.element == node.element){
                break;
            }

            tempNode = tempNode.next;
        }

        tempNode.prev.next = tempNode.next;
        tempNode.next.prev = tempNode.prev;

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
     * 节点内部类
     */
    private static class Node{

        /**
         * 传入的数据
         */
        transient Object element;

        /**
         * 指向上一个节点
         */
        private Node prev;

        /**
         * 指向下一个节点
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

        DoubleLinkedList linkedList = new DoubleLinkedList();
        linkedList.add(node01);
        linkedList.add(node02);
        linkedList.add(node03);
        linkedList.add(node04);
        linkedList.add(node05);

        linkedList.remove(node04);

        linkedList.show();

    }


}
