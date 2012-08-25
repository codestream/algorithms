package org.my.algo.one;

import static java.lang.Math.*;
import static java.util.Arrays.*;

public class CoursesQueueBackwardDP {
	final int INF = 987654321;

	  public int[] getOrder(int[] t, int[] p, int[] e, int skillBound) {
	    int[][][] dp = new int[64][64][64];
	    int[][][] course = new int[64][64][64];

	    for (int[][] c1 : dp) {
	      for (int[] c2 : c1) {
	        fill(c2, INF);
	      }
	    }

	    int n = t.length;
	    for (int i = 0; i <= n; i++) {
	      for (int a = skillBound; a < 64; a++) {
	        for (int b = skillBound; b < 64; b++) {
	          dp[i][a][b] = i;
	        }
	      }
	    }

	    for (int i = n - 1; i >= 0; i--) {
	      for (int a = 0; a < 64; a++) {
	        for (int b = 0; b < 64; b++) {
	          for (int j = 0; j < n; j++) {
	            if (a >= t[j] - 1 && b >= p[j] - 1 && i < e[j]) {
	              int na = max(a, t[j]);
	              int nb = max(b, p[j]);
	              if (dp[i][a][b] > dp[i + 1][na][nb]) {
	                dp[i][a][b] = dp[i + 1][na][nb];
	                course[i][a][b] = j;
	              }
	            }
	          }
	        }
	      }
	    }

	    int d = dp[0][0][0];
	    if (d == INF) {
	      return new int[0];
	    }
	    int[] res = new int[d];
	    for (int i = 0, a = 0, b = 0; i < d; i++) {
	      int j = course[i][a][b];
	      res[i] = j;
	      a = max(a, t[j]);
	      b = max(b, p[j]);
	    }
	    return res;
	  }
}
