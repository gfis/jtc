package org.teherba.jtc.math;

/* Fractions of integers - object oriented method calls
 * Java Training Course example file
 * @(#) $Id$
 * 2017-11-14: copied and expanded from Ratio.java
 * 2017-09-23, Georg Fischer
 *
 * Copyright 2017 Georg Fischer <dr.georg.fischer at gmail.com>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. */

/** 
 * Class <em>Rational</em> represents an integer fraction together with the
 * arithmetic operations on such Rationals. The denominator is always &gt; 0. All
 * arithmetic operations return reduced fractions where GCD(numerator,
 * denominator) = 1. The methods have name, parameters and return values
 * analogous to methods of the Java object type BigInteger, see
 * https://docs.oracle.com/javase/7/docs/api/java/math/BigInteger.html
 *
 * @author Georg Fischer &lt;dr.georg.fischer at gmail.com&gt;
 */
public class Rational {

    //----------------
    // Internal Properties
    //----------------
    /**
     * value above the bar, before the slash
     */
    private int numerator;
    /**
     * value below the bar, after the slash
     */
    private int denominator;

    /*  Implement the following methods, and make use of basic operations.
    All Rational return values should be reduced.
    Insert proper documentation comments.
    Always arrange all methods of the class in alphabetical order, since there are many.
    */
    // public static Rational abs(Ratio rat1) { return new Ratio(); }
    // public static Rational add(Ratio rat1, Ratio rat2) { return new Ratio(); }
    // public static int compareTo(Ratio rat1, Ratio rat2) { return 0; } // return -1, 0, +1 iff this < = > rat2
    // public static Ratio divide(Ratio rat1, Ratio rat2) { return new Ratio(); }
    // public static boolean equals(Ratio rat1, Ratio rat2) { return rat1.compareTo(rat2) == 0; }
    // public static boolean isInteger(Ratio rat1) { return false; }
    // public static int intValue(Rational rat1) { return 0; }
    // public static Rational max(Rational rat1, Rational rat2) { return rat1; }
    // public static Rational min(Rational rat1, Rational rat2) { return rat2; }
    // public static Rational multiply(Rational rat1, Rational rat2) is already implemented below
    // public static Rational negate(Rational rat1) { return new Rational(); }
    // public static Rational reduce(Rational rat1) is already implemented below
    // public static Rational subtract(Rational rat1, Rational rat2) { return new Rational(); }
    //----------------
    // Constructors
    //----------------
    /**
     * No-args constructor, creates 1/1
     */
    public Rational() {
        this.numerator = 1;
        this.denominator = 1;
    } // no-args constructor

    /**
     * Constructor with numerator, creates a/1
     *
     * @param a numerator
     */
    public Rational(int a) {
        this.numerator = a;
        this.denominator = 1;
    } // constructor(int)

    /**
     * Constructor with numerator and denominator, creates a/b
     *
     * @param a numerator
     * @param b denominator
     */
    public Rational(int a, int b) {
        this.numerator = a;
        this.denominator = b;
    } // constructor(int, int)

    /**
     * Constructor from a String representation, creates a/b
     *
     * @param str String of the form "a/b"
     */
    public Rational(String str) {
        int slashPos = str.indexOf("/");
        if (slashPos < 0) {
            str += "/1";
            slashPos = str.length() - 2;
        }
        this.numerator = Integer.parseInt(str.substring(0, slashPos));
        this.denominator = Integer.parseInt(str.substring(slashPos + 1));
    } // constructor(String)

    //----------------
    // Internal getters
    //----------------
    /**
     * Gets the numerator
     *
     * @return the numerator of this Rational
     */
    private int getNum() {
        return numerator;
    } // getNum()

    /**
     * Gets the denominator
     *
     * @return the denominator of this Rational
     */
    private int getDen() {
        return denominator;
    } // getDen()

    //----------------
    // Public methods
    //----------------
    /**
     * Returns the absolute value of <em>this</em> Rational.
     *
     * @return abs(this)
     */
    public Rational abs() {
        Rational result = this;
        if (result.numerator < 0) {
            result = result.negate();
        }
        return result;
    } // abs()

    /**
     * Returns the sum of <em>this</em> Rational and a second.
     *
     * @param rat2 2nd Rational
     * @return (this + rat2)
     */
    public Rational add(Rational rat2) {
        int lcmb = Rational.lcm(this.denominator, rat2.denominator);
        int fact1 = lcmb / this.denominator;
        int fact2 = lcmb / rat2.denominator;
        int sum = fact1 * this.numerator
                + fact2 * rat2.numerator;
        return (new Rational(sum, lcmb)).reduce();
    } // add(Rational)

    /**
     * Compares <em>this</em> Rational with a second.
     *
     * @param rat2 2nd Rational
     * @return -1 if this &lt; rat2, 0 if this == rat2, +1 if this > rat2
     */
    public int compareTo(Rational rat2) {
        int result = 0;
        Rational difference = this.subtract(rat2);
        if (difference.numerator < 0) {
            result = -1;
        } else if (difference.numerator == 0) {
            result = 0;
        } else {
            result = +1;
        }
        return result;
    } // compareTo(Rational)
    
    /**
     * Determines whether <em>this</em> Rational is equal to a second.
     *
     * @param rat2 2nd Rational
     * @return (this == rat2)
     */
    public boolean equals(Rational rat2) {
        boolean result = false;
        if (this.compareTo(rat2) == 0) {
            result = true;
        }
        return result;
    } // equals(Rational)
    
    /**
     * Returns the quotient of <em>this</em> Rational and a second.
     *
     * @param rat2 2nd Rational
     * @return (this / rat2)
     */
    public Rational divide(Rational rat2) {
        return (new Rational(this.numerator * rat2.denominator,
                this.denominator * rat2.numerator)).reduce();
    } // divide(Rational)

    /**
     * Returns the greatest common divisor of 2 integers.
     *
     * @param a 1st integer
     * @param b 2nd integer
     * @return gcd(a,b), which is always positive
     */
    public static int gcd(int a, int b) {
        int result = Math.abs(a);
        if (result != 1) {
            int p = result;
            int q = Math.abs(b);
            while (q != 0) {
                int temp = q;
                q = p % q;
                p = temp;
            }
            result = p;
        } // if > 1
        return Math.abs(result);
    } // gcd(a, b)

    /**
     * Returns the least common multiple of 2 integers.
     *
     * @param a 1st integer
     * @param b 2nd integer
     * @return lcm(a,b)
     */
    public static int lcm(int a, int b) {
        int result = a * b;
        if (result < 0) { // absolute, make positive
            result = -result;
        } // abs
        return result / gcd(a, b);
    } // lcm(int,int)

    /**
     * Returns the maximum of <em>this</em> Rational and a second.
     *
     * @param rat2 2nd Rational
     * @return the bigger one
     */
    public Rational max(Rational rat2) {
        Rational result = this;
        if (this.compareTo(rat2) < 0) {
            result = rat2;
        }
        return result;
    } // max(Rational)

    /**
     * Returns the minimum of <em>this</em> Rational and a second.
     *
     * @param rat2 2nd Rational
     * @return the bigger one
     */
    public Rational min(Rational rat2) {
        Rational result = this;
        if (this.compareTo(rat2) > 0) {
            result = rat2;
        }
        return result;
    } // min(Rational)

    /**
     * Returns the product of <em>this</em> Rational and a second.
     *
     * @param rat2 2nd Rational
     * @return (this * rat2)
     */
    public Rational multiply(Rational rat2) {
        return (new Rational(this.numerator * rat2.numerator,
                this.denominator * rat2.denominator)).reduce();
    } // multiply(Rational)

    /**
     * Returns the negative of <em>this</em> Rational.
     *
     * @return (- this)
     */
    public Rational negate() {
        return (new Rational(- this.numerator, this.denominator)).reduce();
    } // negate(Rational)

    /**
     * Reduces and normalizes <em>this</em> Rational, that means:
     * <ul>
     * <li>divides the numerator and the denominator by their greatest common
     * divisor, if that is &gt; 1,</li>
     * <li>makes the denominator always positive,</li>
     * <li>normalizes the denominator to 1 if the numerator is 0.</li>
     * </ul>
     *
     * @return the reduced Rational
     */
    public Rational reduce() {
        Rational result = new Rational(this.numerator, this.denominator);
        int common = gcd(this.numerator, this.denominator);
        if (common > 1) {
            result.numerator /= common;
            result.denominator /= common;
        }
        if (result.numerator == 0) {
            result.denominator = 1;
        } else if (result.denominator < 0) {
            result.numerator = -result.numerator;
            result.denominator = -result.denominator;
        }
        return result;
    } // reduce(Rational)

    /**
     * Returns the difference of one Rational and a second.
     *
     * @param rat2 2nd Rational
     * @return (this - rat2)
     */
    public Rational subtract(Rational rat2) {
        return this.add(rat2.negate());
    } // subtract(Rational)

    /**
     * Returns <em>this</em> Rational as a String.
     *
     * @return a String of the form "a/b", or only "a" if b is 1.
     */
    public String toString() {
        String result = String.valueOf(this.numerator);
        if (this.denominator != 1) {
            result += "/" + String.valueOf(this.denominator);
        }
        return result;
    } // toString()

    /**
     * Test program, shows a series of fixed operations on Rationals
     *
     * @param args String array of commandline arguments
     */
    public static void main(String[] args) {
        if (args.length == 0) { // set default arguments
            args = new String[]{"1", "1/2", "3/4", "5/6"};
        } // set default arguments

        int iarg = 0;
        String str0 = "0/1";
        Rational rat0 = new Rational(str0);
        while (iarg < args.length) {
            String str1 = args[iarg];
            Rational rat1 = new Rational(str1);
            System.out.println(str0 + " + " + str1 + " = " + rat0.add(rat1).toString());
            System.out.println(str0 + " - " + str1 + " = " + rat0.subtract(rat1).toString());
            System.out.println(str0 + " * " + str1 + " = " + rat0.multiply(rat1).toString());
            System.out.println(str0 + " / " + str1 + " = " + rat0.divide(rat1).toString());
            System.out.println("(" + str0 + ").compareTo(" + str1 + ") = " + rat0.compareTo(rat1));
            System.out.println("(" + str0 + ").equals(" + str1 + ") = " + rat0.equals(rat1));
            System.out.println("(" + str0 + ").max(" + str1 + ") = " + rat0.max(rat1));
            System.out.println("(" + str0 + ").min(" + str1 + ") = " + rat0.min(rat1));
            System.out.println();
            str0 = str1;
            rat0 = rat1;
            iarg++;
        } // while iarg
    } // main

} // Rationalnal

