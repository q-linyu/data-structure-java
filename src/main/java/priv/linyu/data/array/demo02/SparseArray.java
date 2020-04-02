package priv.linyu.data.array.demo02;

/**
 * @className: SparseArray
 * @author: q-linyu
 * @description: 稀疏数组和二维数组相互转换
 * @date: 2020/03/28 18:36
 * @version: 1.0
 */
public class SparseArray {
    public static void main(String[] args) {
        // 创建一个长度为7的二维数组
        int[][] arr = new int[7][7];
        arr[0][1] = 1;
        arr[1][2] = 2;
        arr[3][4] = 3;
        arr[5][6] = 4;

        // 打印二维数组
        System.out.println("------------------------二维数组转换稀疏数组前---------------------");
        // 记录二维数组的总数,以方便后续使用
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int z = 0; z < arr.length; z++) {
                if (arr[i][z] != 0) {
                    sum++;
                }
                System.out.printf("%d\t", arr[i][z]);
            }
            System.out.println();
        }

        System.out.println("------------------------记录二维数组的总数------------------------");
        System.out.println(sum);

        System.out.println("------------------------二维数组转换稀疏数组后---------------------");
        int[][] spaceArr = new int[sum + 1][3];
        spaceArr[0][0] = 7;
        spaceArr[0][1] = 7;
        spaceArr[0][2] = sum;

        // 记录器
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int z = 0; z < arr.length; z++) {
                if (arr[i][z] != 0) {
                    count++;
                    spaceArr[count][0] = i;
                    spaceArr[count][1] = z;
                    spaceArr[count][2] = arr[i][z];
                }
            }
        }

        // 打印稀疏数组
        for (int i = 0; i < spaceArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", spaceArr[i][0], spaceArr[i][1], spaceArr[i][2]);
        }

        System.out.println("------------------------稀疏数组转换二维数组后---------------------");
        int[][] newArr = new int[spaceArr[0][0]][spaceArr[0][1]];
        // 遍历赋值
        for (int i = 1; i < spaceArr.length; i++) {
            newArr[spaceArr[i][0]][spaceArr[i][1]] = spaceArr[i][2];
        }

        for (int[] rows : newArr) {
            for (int data : rows) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

    }

}
