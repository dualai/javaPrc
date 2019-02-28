package struct.recursion;

import utils.Log;

public class Recursion {

    /**
     * 模型一： 在递去的过程中解决问题
     * <p>
     * function recursion(大规模){
     * if (end_condition){      // 明确的递归终止条件
     * end;   // 简单情景
     * }else{            // 在将问题转换为子问题的每一步，解决该步中剩余部分的问题
     * solve;                // 递去
     * recursion(小规模);     // 递到最深处后，不断地归来
     * }
     * }
     * 1
     * 2
     * 3
     * 4
     * 5
     * 6
     * 7
     * 8
     * 模型二： 在归来的过程中解决问题
     * <p>
     * function recursion(大规模){
     * if (end_condition){      // 明确的递归终止条件
     * end;   // 简单情景
     * }else{            // 先将问题全部描述展开，再由尽头“返回”依次解决每步中剩余部分的问题
     * recursion(小规模);     // 递去
     * solve;                // 归来
     * }
     * }
     * ---------------------
     * <p>
     * <p>
     * <p>
     * 　　 在我们实际学习工作中，递归算法一般用于解决三类问题：
     * <p>
     * 　　 (1). 问题的定义是按递归定义的（Fibonacci函数，阶乘，…）；
     * <p>
     * 　　 (2). 问题的解法是递归的（有些问题只能使用递归方法来解决，例如，汉诺塔问题，…）；
     * <p>
     * 　　 (3). 数据结构是递归的（链表、树等的操作，包括树的遍历，树的深度，…）。
     **/
    public static void main(String[] args) {
        Recursion recursion = new Recursion();
        int result = 0;
//        result = recursion.factorial(5);
//        Log.log(result);
//        recursion.hanoi(4, "A", "B", "C");
//        int[] arr = new int[]{1,5,7,9,10,12,16,20};
//        result = recursion.binarySearch(arr,0,arr.length - 1,17);
//        result = optimizeFibonacci(1, 1, 5);
//        Log.log(result);
//        result = yhsj(5,3);
        result = Fibonacci2(1,1,6);
        Log.log(result);
    }


    public int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            int total = n * factorial(n - 1);
            return total;
        }
    }

    /**
     * 汉诺塔,A,B,C 三个盘子
     * 先将n-1个盘子移动到B，再将第n个盘子移动到C，最后将n-1个盘子
     */
    public void hanoi(int n, String from, String inter, String to) {
        if (n == 1) {
            Log.log("将第" + n + "个盘子，从" + from + "移动到" + to);
        } else {
            hanoi(n - 1, from, to, inter);
            Log.log("将第" + n + "个盘子，从" + from + "移动到" + to);
            hanoi(n - 1, inter, from, to);
        }
    }


    public int binarySearch(int arr[], int lower, int uper, int target) {
        if (lower > uper) {
            return -1;
        }
        int current = (lower + uper) / 2;
        if (target == arr[current]) {
            return current;
        } else if (target < arr[current]) {
            return binarySearch(arr, lower, current - 1, target);
        } else {
            return binarySearch(arr, current + 1, uper, target);
        }
    }


    /**
     * @param first  数列的第一项
     * @param second 数列的第二项
     * @param n      目标项
     * @return 尾递归
     * @description 对经典递归法的优化
     * <p>
     * 斐波那契数列如下：
     * <p>
     * 1,1,2,3,5,8,13,21,34,...
     * <p>
     * 那么，我们可以这样看：fib(1,1,5) = fib(1,2,4) = fib(2,3,3) = 5
     * <p>
     * 也就是说，以1,1开头的斐波那契数列的第五项正是以1,2开头的斐波那契数列的第四项，
     * 而以1,2开头的斐波那契数列的第四项也正是以2,3开头的斐波那契数列的第三项，
     * 更直接地，我们就可以一步到位：fib(2,3,3) = 2 + 3 = 5,计算结束。
     * <p>
     * 注意，前两个参数是数列的开头两项，第三个参数是我们想求的以前两个参数开头的数列的第几项。
     * <p>
     * 时间复杂度：O(n)
     * @author rico
     */
    public static int optimizeFibonacci(int first, int second, int n) {
        if (n > 0) {
            if (n == 1) {    // 递归终止条件
                return first;       // 简单情景
            } else if (n == 2) {            // 递归终止条件
                return second;      // 简单情景
            } else if (n == 3) {         // 递归终止条件
                return first + second;      // 简单情景
            }
            return optimizeFibonacci(second, first + second, n - 1);  // 相同重复逻辑，缩小问题规模
        }
        return -1;
    }


    /**
     *     *     1
     *     *   1  1
     *     *  1  2  1
     *     * 1  3  3  1
     *     *1  4  6  4  1
     */

    /**
     * @param x 行数
     * @param y 第x行第y列
     * @return
     */
    public static int yhsj(int x, int y) {
        if (x < 0 || y < 0 || y > x) {
            return -1;
        } else if (x == 0 || y == 0 || y == x) {
            return 1;
        } else {
            return yhsj(x - 1, y - 1) + yhsj(x - 1, y);
        }
    }

    /**
     *
     * @param first 第first项的数值
     * @param secend 第secend项的数值
     * @param n 从first 算起，他的第n项的数值
     * @return
     */
    public static int Fibonacci2(int first,int secend,int n){
        if(n <= 0){
            return 0;
        }
        if(n == 1){
            return first;
        }else if(n == 2){
            return secend;
        }else if(n == 3){
            return first + secend;
        }else {
            return Fibonacci2(secend,first + secend,n - 1);
        }
    }
}
