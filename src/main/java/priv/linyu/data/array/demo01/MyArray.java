package priv.linyu.data.array.demo01;


import java.util.Arrays;

/**
 * @className: MyArray
 * @author: q-linyu
 * @description: 自定义数组
 * @date: 2020/03/28 10:03
 * @version: 1.0
 */
public class MyArray {

    /**
     * 定义一个数组
     */
    transient Object[] elements;

    /**
     * 元素的个数
     */
    private int size;


    public MyArray() {
        this(10);
    }

    public MyArray(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("输入有误" + capacity);
        }
        elements = new Object[capacity];
    }

    /**
     * 添加
     *
     * @param element
     */
    public void add(Object element) {
        grow(size + 1);
        elements[size++] = element;
    }

    /**
     * 扩容
     *
     * @param minCapacity
     */
    public void grow(int minCapacity) {
        if (size == minCapacity) {
            int oldCapacity = elements.length;
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    /**
     * 元素的个数
     *
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * 移除元素
     *
     * @param index
     */
    public void remove(int index) {
        // 判断数据是否越界
        if (index < 0 || index > elements.length - 1) {
            throw new RuntimeException("数组越界");
        }

        // 创建一个新的数组
        Object[] newArr = new Object[elements.length - 1];
        for (int i = 0; i < newArr.length; i++) {
            if (i < index){
                // 设置左边的元素
                newArr[i] = elements[i];
            }else {
                // 设置右边的元素
                newArr[i] = elements[i+1];
            }
        }
        // 把新数组替换老数组
        elements = newArr;
        // 移除不必要的空值
        elements[--size] = null;
    }

    /**
     * 替换
     * @param index
     * @param element
     */
    public void set(int index,Object element){
        elements[index] = element;
    }

    /**
     * 根据索引查找
     * @param index
     * @return
     */
    public Object get(int index){
        return elements[index];
    }


    public static void main(String[] args) {
        MyArray myArray = new MyArray();
        myArray.add(1);
        myArray.add(2);
        myArray.add(3);
        myArray.add(4);

        System.out.println("元素的个数："+myArray.size());

        for (int i = 0; i < myArray.size(); i++) {
            Object obj = myArray.get(i);
            System.out.print(obj);
        }
        System.out.println();

        myArray.remove(1);
        myArray.set(0,7);
        System.out.println(myArray.get(2));

        for (int i = 0; i < myArray.size(); i++) {
            Object obj = myArray.get(i);
            System.out.print(obj);
        }
    }

}
