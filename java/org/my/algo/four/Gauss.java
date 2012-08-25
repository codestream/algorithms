package org.my.algo.four;

public class Gauss {
	public static double[] gauss(double[][] a, double[] b) {
	    int n = a.length;
	    for (int i = 0; i < n; i++) {
	      int best = i;
	      for (int j = i + 1; j < n; j++) {
	        if (Math.abs(a[j][i]) > Math.abs(a[best][i])) {
	          best = j;
	        }
	      }
	      double[] tmp = a[i];
	      a[i] = a[best];
	      a[best] = tmp;
	      double t = b[i];
	      b[i] = b[best];
	      b[best] = t;
	      
	      for (int j = i + 1; j < n; j++) {
	        a[i][j] /= a[i][i];
	      }
	      b[i] /= a[i][i];
	      
	      for (int j = 0; j < n; j++) {
	        if (j != i && a[j][i] != 0) {
	          for (int p = i + 1; p < n; p++) {
	            a[j][p] -= a[i][p] * a[j][i];
	          }
	          b[j] -= b[i] * a[j][i];
	        }
	      }
	    }
	    return b;
	  }

	  // Usage example
	  public static void main(String[] args) {

	  }
}
