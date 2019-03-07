package struct.sort;

import utils.Log;

public class Tewst {

    private static int a[] = new int[]{8, 0, 3, 1, 10, 20, 6, 9, 14,-1,88,69,32,54};

    public static void main(String[] args) {
        xzsort(a);
        for (int i = 0; i < a.length; i++) {
            Log.log(a[i]);
        }
    }

    /**
     * 冒泡排序
     */
    private static void mpSort(int arr[]) {
        if (arr.length == 0 || arr.length == 1) {
            return;
        }
        int tmp = -1;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    /**
     * 选择排序
     */
    private static void xzsort(int arr[]) {
        if (arr.length == 0 || arr.length == 1) {
            return;
        }
        int len = a.length;
        for (int i = 0; i < len - 1; i++) {
            int min = i; //最小的下标序号
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
    }

    public static void exchange(int[] a, int i, int j) {

    }

}
