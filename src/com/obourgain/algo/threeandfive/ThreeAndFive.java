package com.obourgain.algo.threeandfive;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a number N, starting with number 1, you can only multiply the result by 5 or add 3 to the result.
 * If there's no way to get N through this method, return "Can't generate it".
 *
 * Voir http://stackoverflow.com/questions/17652190/how-to-get-the-target-number-with-3-or-5-operations-without-recursion
 */
public class ThreeAndFive {

    /**
     * Algorithme récursif.
     */
    public String decomposeRecursif(int n) {
        if (n == 1) return "1";
        if (n == 2) return "Pas de décomposition";
        if (n == 5) return "1*5"; // Pour éviter (1)*5
        if (n % 3 == 0) return "Pas de décomposition";

        if (n % 5 == 0 && n != 10) {
            return "(" + decomposeRecursif(n / 5) + ")*5";
        } else {
            return decomposeRecursif(n - 3) + "+3";
        }
    }


    public static final int ADD3 = 3;
    public static final int MULT5 = 5;

    /**
     * Algorithme itératif.
     */
    public String decomposeIteratif(int n) {
        if (n == 2) return "Pas de décomposition";
        if (n % 3 == 0) return "Pas de décomposition";

        Stack<Integer> ops = new Stack<Integer>();
        int k = n;
        while (k > 1) {
            if (k == 10 || k % 5 != 0) {
                ops.push(ADD3);
                k = k - 3;
            } else {
                ops.push(MULT5);
                k = k / 5;
            }
        }
        String res = "1";

        while (!ops.empty()) {
            if (ops.pop() == ADD3) res = res + "+3";
            else if (res.length() == 1) res = res + "*5";
            else res = "(" + res + ")*5";
        }
        return res;
    }
}
