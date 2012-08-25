package org.my.algo.four;

import java.util.Arrays;

public class LIS2 {
	static int upper_bound(int[] a, int key) {
	    int lo = -1;
	    int hi = a.length;
	    while (hi - lo > 1) {
	      int mid = (lo + hi) / 2;
	      int midVal = a[mid];
	      if (midVal <= key) {
	        lo = mid;
	      } else {
	        hi = mid;
	      }
	    }
	    return hi;
	  }

	  public static int[] getLIS(int[] x) {
	    int n = x.length;
	    int[] pred = new int[n];
	    int[] heaps = new int[n + 1];
	    Arrays.fill(heaps, Integer.MAX_VALUE);
	    heaps[0] = Integer.MIN_VALUE;
	    int[] no = new int[n + 1];
	    no[0] = -1;
	    for (int i = 0; i < n; i++) {
	      int j = upper_bound(heaps, x[i]);
	      if (heaps[j - 1] < x[i]) {
	        heaps[j] = x[i];
	        no[j] = i;
	        pred[i] = no[j - 1];
	      }
	    }
	    for (int pos = n;; pos--) {
	      if (heaps[pos] != Integer.MAX_VALUE) {
	        int[] res = new int[pos];
	        for (int j = no[pos]; j != -1; j = pred[j]) {
	          res[--pos] = x[j];
	        }
	        return res;
	      }
	    }
	  }

	  // Usage example
	  public static void main(String[] args) {
	    int[] a = { 1, 5, 4, 2, 3, 7, 6 };
	    int[] lis = getLIS(a);
	    System.out.println(Arrays.toString(lis));
	  }
}
