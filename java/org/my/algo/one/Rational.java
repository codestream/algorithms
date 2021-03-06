package org.my.algo.one;

import java.math.BigInteger;

public class Rational implements Comparable<Rational>{
	  BigInteger num;
	  BigInteger den;

	  public static final Rational ZERO = new Rational(0);
	  public static final Rational ONE = new Rational(1);
	  public static final Rational TWO = new Rational(2);
	  public static final Rational POSITIVE_INFINITY = new Rational(1, 0);
	  public static final Rational NEGATIVE_INFINITY = new Rational(-1, 0);

	  public Rational(long num) {
	    this.num = BigInteger.valueOf(num);
	    this.den = BigInteger.ONE;
	  }

	  public Rational(long num, long den) {
	    this(BigInteger.valueOf(num), BigInteger.valueOf(den));
	  }

	  public Rational(BigInteger num, BigInteger den) {
	    this.num = num;
	    this.den = den;
	    reduce();
	  }

	  void reduce() {
	    if (!den.abs().equals(BigInteger.ONE)) {
	      BigInteger gcd = num.gcd(den);
	      if (gcd.signum() != 0 && !gcd.equals(BigInteger.ONE)) {
	        num = num.divide(gcd);
	        den = den.divide(gcd);
	      }
	    }
	    if (den.signum() < 0 || den.signum() == 0 && num.signum() < 0) {
	      num = num.negate();
	      den = den.negate();
	    }
	  }

	  public Rational add(Rational r) {
	    return new Rational(num.multiply(r.den).add(r.num.multiply(den)), den.multiply(r.den));
	  }

	  public Rational sub(Rational r) {
	    return new Rational(num.multiply(r.den).subtract(r.num.multiply(den)), den.multiply(r.den));
	  }

	  public Rational mul(Rational r) {
	    return new Rational(num.multiply(r.num), den.multiply(r.den));
	  }

	  public Rational div(Rational r) {
	    return new Rational(num.multiply(r.den), den.multiply(r.num));
	  }

	  public Rational negate() {
	    return new Rational(num.negate(), den);
	  }

	  public Rational inverse() {
	    return new Rational(den, num);
	  }

	  public Rational abs() {
	    return new Rational(num.abs(), den);
	  }

	  public int signum() {
	    return num.signum();
	  }

	  public double doubleValue() {
	    return num.doubleValue() / den.doubleValue();
	  }

	  public double longValue() {
	    return num.longValue() / den.longValue();
	  }

	  public int compareTo(Rational other) {
	    return (num.multiply(other.den).compareTo(other.num.multiply(den)));
	  }

	  public boolean equals(Object obj) {
	    return num.equals(((Rational) obj).num) && den.equals(((Rational) obj).den);
	  }

	  public int hashCode() {
	    return num.hashCode() * 31 + den.hashCode();
	  }

	  public String toString() {
	    return num + "/" + den;
	  }

	  // Usage example
	  public static void main(String[] args) {
	    Rational a = new Rational(1, 3);
	    Rational b = new Rational(1, 6);
	    Rational c = new Rational(1, 2);
	    System.out.println(true == c.equals(a.add(b)));
	  }
}
