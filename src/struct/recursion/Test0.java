package struct.recursion;

import utils.Log;

public class Test0 {

    public static void main(String[] args) {
        Log.log(new Test0().getSanjiaoNumber2(10));
        Log.log(new Test0().getFb(20));
    }

    private int getSanjiaoNumber(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n + getSanjiaoNumber(n - 1);
        }
    }

    private int getSanjiaoNumber2(int n) {
        int total = 0;
        for (int i = 1; i <= n; i++) {
            total += i;
        }
        return total;
    }

    private int getFb(int n) {
        if (n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        } else {
            return getFb(n - 1) + getFb(n - 2);
        }
    }
}
