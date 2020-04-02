package priv.linyu.data.queue.demo01;

import java.util.Arrays;

/**
 * @className: MyQueue
 * @author: q-linyu
 * @description: 手写队列
 * @date: 2020/03/29 15:03
 * @version: 1.0
 */
public class MyQueue {

    /**
     * 数组
     */
    private Object[] elements;

    /**
     * 数组的容量
     */
    private int size;


    public MyQueue() {
        this(16);
    }

    /**
     * 带参构造器
     * @param capacity
     */
    public MyQueue(int capacity){
        if (capacity < 0){
            throw new IllegalArgumentException("输入有误");
        }
        this.elements = new Object[capacity];
    }


    /**
     * 入队
     * @param element
     */
    public void pop(int element){
        grow(size+1);
        elements[size++] = element;
    }

    /**
     * 扩容
     * @param minCapacity
     */
    private void grow(int minCapacity){
        if (size == minCapacity){
            int oldCapacity = elements.length;
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            if (newCapacity < minCapacity){
                newCapacity = minCapacity;
            }
            elements = Arrays.copyOf(elements,newCapacity);
        }
    }

    /**
     * 出队
     */
    public Object pull(){
        // 后入先出
        Object element = elements[0];

        // 创建一个新数组
        Object[] arr = new Object[elements.length-1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = elements[i+1];
        }

        // 新数组代替老数组
        elements = arr;
        return element;
    }

    /**
     * 元素的个数
     * @return
     */
    public int size(){
        return size;
    }

    /**
     * 判断是否为空
     * @return
     */
    public boolean isEmpty(){
        return elements == null || elements.length == 0;
    }

    /**
     * 根据索引移除
     * @param index
     */
    public void remove(int index){
        // 判断数据是否越界
        if (index < 0 || index > elements.length - 1) {
            throw new RuntimeException("数组越界");
        }

        Object[] arr = new Object[elements.length-1];
        for (int i = 0; i < arr.length; i++) {
            if (i < index){
                arr[i] = elements[i];
            }else {
                arr[i] = elements[i+1];
            }
        }

        elements = arr;
        elements[--size] = null;
    }

    /**
     * 展示数据
     */
    public void show(){
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] != null){
                System.out.println("打印："+elements[i]);
            }
        }
        System.out.println();
    }




    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.pop(1);
        myQueue.pop(2);
        myQueue.pop(3);
        myQueue.pop(4);
        myQueue.pop(5);

        myQueue.show();

        // 出列
        myQueue.pull();

        // 删除
        myQueue.remove(2);

        myQueue.show();


    }

}
