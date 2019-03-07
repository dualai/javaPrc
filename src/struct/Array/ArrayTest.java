package struct.Array;

import utils.Log;

public class ArrayTest {

    public static void main(String[] args) {
        int arr[] = new int[]{21, 24, 57, 98, 101, 130, 160, 180, 181, 190, 201, 208};
        Log.log("第" + new ArrayTest().search(arr, 201) + "个");
    }

    /**
     * 有序数组的二分查找，时间复杂度Log2N
     *
     * @param arr
     * @param number
     * @return
     */
    private int search(int arr[], int number) {
        int lower = 0;
        int upper = arr.length - 1;
        int mid;
        while (lower <= upper) {
            mid = (lower + upper) / 2;
            if (arr[mid] == number) {
                return mid;
            } else if (arr[mid] < number) {
                lower = mid + 1;
            } else if (arr[mid] > number) {
                upper = mid - 1;
            }
        }
        return -1;
    }

}
