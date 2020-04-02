package priv.linyu.data.queue.demo02;

/**
 * @className: CircleArrayQueue
 * @author: q-linyu
 * @description: 环形队列
 * @date: 2020/03/29 16:09
 * @version: 1.0
 */
public class CircleArrayQueue {

    /**
     * 数组
     */
    transient Object[] elements;

    /**
     * 元素的个数
     */
    private int size;

    /**
     * 队列头
     */
    private int front;

    /**
     * 队列尾
     */
    private int rear;

    public CircleArrayQueue() {
        this(10);
    }

    public CircleArrayQueue(int size) {
        this.size = size;
        elements = new Object[size];
    }

    /**
     * 判断队列是否已满
     *
     * @return
     */
    public boolean isFull() {
        return (rear + 1) % size == front;
    }


    /**
     * 判断是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return rear == front;
    }

    /**
     * 元素的个数
     *
     * @return
     */
    public int size() {
        return (rear + size - front) % size;
    }

    /**
     * 入队
     *
     * @param element
     */
    public void pop(Object element) {
        // 判断队列是否已满
        if (isFull()) {
            System.out.println("队列已满,不能加入数据");
            return;
        }
        elements[rear] = element;
        rear = (rear + 1) % size;
    }


    /**
     * 出列
     */
    public Object pull() {
        // 判断队列是否已满
        if (isFull()) {
            System.out.println("队列已满,不能加入数据");
            return null;
        }
        Object element = elements[front];
        front = (front + 1) % size;

        return element;
    }

    /**
     * 查看队列
     */
    public void show() {
        if (isEmpty()) {
            System.out.println("队列为空,没有数据");
            return;
        }
        for (int i = front; i < front + size(); i++) {
            System.out.print(elements[i % size]);
        }
        System.out.println();
    }

    /**
     * 队头
     * @return
     */
    public Object peek(){
        if (isEmpty()) {
            System.out.println("队列为空,没有数据");
            return null;
        }
        return elements[front];
    }


    public static void main(String[] args) {
        CircleArrayQueue queue = new CircleArrayQueue();
        queue.pop(1);
        queue.pop(2);
        queue.pop(3);
        queue.pop(4);
        queue.pop(5);

        queue.pull();

        queue.show();

    }

}
