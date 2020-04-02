package priv.linyu.data.recursion;

/**
 * @className: RecursionDemo
 * @author: q-linyu
 * @description:
 * @date: 2020/04/01 22:59
 * @version: 1.0
 */
public class RecursionDemo {

    /**
     * 斐波那契数列:1,1,2,3,5,8,13
     * @param index 第几项
     * @return
     */
    public int fibonacci(int index){
        if (index == 1 || index == 2){
            return 1;
        }
        return fibonacci(index - 1) + fibonacci(index - 2);
    }

    /**
     * 阶乘：n!=1×2×3×...×n
     * @param index  第几项
     * @return
     */
    public int factorial(int index){
        if (index == 1){
            return 1;
        }
        return fibonacci(index - 1) * index;
    }

    /**
     * 计算1+2+.....+1000的和
     * @param index 第几项
     * @return
     */
    public int stepPlus(int index){
        if (index == 1){
            return 1;
        }
        return stepPlus(index - 1) + index;
    }

    /**
     * 汉诺塔：怎样将n个盘子全部移动到C柱上
     * @param index
     * @return
     */
    public void hanoi(int index,int p1,int p2,int p3){
        if (index == 1){
            System.out.printf("盘子从%d移动到%d",p1,p3);
        }else {
            hanoi(index - 1,p1,p3,p2);
            System.out.printf("盘子从%d移动到%d",p1,p3);
            hanoi(index - 1,p2,p1,p3);
        }
    }

    private StringBuilder sb = new StringBuilder();

    /**
     * 十进制转二进制
     * @param index
     */
    public void decimalToBinary(int index){
        if (index == 0){
            return;
        }
        decimalToBinary(index - 2);
        sb.append(index % 2);
    }

    /**
     * 打印出九九乘法表
     * @param index
     */
    public static void multiplication(int index){
        if (index == 1){
            return;
        }
        multiplication(index - 1);
        for (int i = 1; i <= index;i++){
            System.out.print(i + "*" + index + "=" + i * index + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        multiplication(9);
    }

}
