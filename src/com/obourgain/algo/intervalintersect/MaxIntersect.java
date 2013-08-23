package com.obourgain.algo.intervalintersect;

import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class MaxIntersect {


    public int findMaxIntersect(List<Interval> list) {
        int n = list.size();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = list.get(i).getStart();
            b[i] = list.get(i).getEnd();
        }

        Arrays.sort(a);
        Arrays.sort(b);

        int q = 0;
        int maxq = 0;
        int idxa = 0;
        int idxb = 0;
        while (idxa < n) {
            if (a[idxa] < b[idxb]) {
                idxa++;
                q++;
                if (q > maxq) maxq = q;
            } else if (a[idxa] > b[idxb]) {
                idxb++;
                q--;
            } else {// a[idxa] = b[idxb]
                idxa++;
                idxb++;
            }
        }

        return maxq;
    }
}
