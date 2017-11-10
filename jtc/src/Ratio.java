/* Fractions of integers
 * Java Training Course example file
 * @(#) $Id$
 * 2017-11-07: revised in Bekasi
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
 * Class <em>Ratio</em> represents an integer fraction together with the
 * arithmetic operations on such Ratios. The denominator is always &gt; 0. All
 * arithmetic operations return reduced fractions where GCD(numerator,
 * denominator) = 1. The methods have name, parameters and return values
 * analogous to methods of the Java object type BigInteger, see
 * https://docs.oracle.com/javase/7/docs/api/java/math/BigInteger.html
 *
 * @author Georg Fischer &lt;dr.georg.fischer at gmail.com&gt;
 */
public class Ratio {

    //----------------
    // Internal Properties
    //----------------
    /**
     * value above the bar, before the slash
     */
    public int numerator;
    /**
     * value below the bar, after the slash
     */
    public int denominator;

    /*  Implement the following methods, and make use of basic operations.
    All Ratio return values should be reduced.
    Insert proper documentation comments.
    Always arrange all methods of the class in alphabetical order, since there are many.
     */
    // public static Ratio abs(Ratio rat1) { return new Ratio(); }
    // public static Ratio add(Ratio rat1, Ratio rat2) { return new Ratio(); }
    // public static int compareTo(Ratio rat1, Ratio rat2) { return 0; } // return -1, 0, +1 iff this < = > rat2
    // public static Ratio divide(Ratio rat1, Ratio rat2) { return new Ratio(); }
    // public static boolean equals(Ratio rat1, Ratio rat2) { return rat1.compareTo(rat2) == 0; }
    // public static boolean isInteger(Ratio rat1) { return false; }
    // public static int intValue(Ratio rat1) { return 0; }
    // public static Ratio max(Ratio rat1, Ratio rat2) { return rat1; }
    // public static Ratio min(Ratio rat1, Ratio rat2) { return rat2; }
    // public static Ratio multiply(Ratio rat1, Ratio rat2) is already implemented below
    // public static Ratio negate(Ratio rat1) { return new Ratio(); }
    // public static Ratio reduce(Ratio rat1) is already implemented below
    // public static Ratio subtract(Ratio rat1, Ratio rat2) { return new Ratio(); }
    //----------------
    // Constructors
    //----------------
    /**
     * No-args constructor, creates 1/1
     */
    public Ratio() {
        numerator = 1;
        denominator = 1;
    } // no-args constructor

    /**
     * Constructor with numerator, creates a/1
     *
     * @param a numerator
     */
    public Ratio(int a) {
        numerator = a;
        denominator = 1;
    } // constructor(int)

    /**
     * Constructor with numerator and denominator, creates a/b
     *
     * @param a numerator
     * @param b denominator
     */
    public Ratio(int a, int b) {
        numerator = a;
        denominator = b;
    } // constructor(int, int)

    /**
     * Constructor from a String representation, creates a/b
     *
     * @param str String of the form "a/b"
     */
    public Ratio(String str) {
        int slashPos = str.indexOf("/");
        if (slashPos < 0) {
            str += "/1";
            slashPos = str.length() - 2;
        }
        numerator = Integer.parseInt(str.substring(0, slashPos));
        denominator = Integer.parseInt(str.substring(slashPos + 1));
    } // constructor(String)

    //----------------
    // Internal getters
    //----------------
    /**
     * Gets the numerator
     *
     * @return the numerator of this Ratio
     */
    private int getNum() {
        return numerator;
    } // getNum()

    /**
     * Gets the denominator
     *
     * @return the denominator of this Ratio
     */
    private int getDen() {
        return denominator;
    } // getDen()

    //----------------
    // Public methods
    //----------------
    /**
     * Returns the sum of one Ratio and a second.
     *
     * @param rat1 1st Ratio
     * @param rat2 2nd Ratio
     * @return (rat1 + rat2)
     */
    public static Ratio add(Ratio rat1, Ratio rat2) {
        int lcmb = Ratio.lcm(rat1.denominator, rat2.denominator);
        int fact1 = lcmb / rat1.denominator;
        int fact2 = lcmb / rat2.denominator;
        int sum = rat1.numerator * fact1
                + rat2.numerator * fact2;
        return Ratio.reduce(new Ratio(sum, lcmb));
    } // add(Ratio)

    /**
     * Returns the quotient of one Ratio and a second.
     *
     * @param rat1 1st Ratio
     * @param rat2 2nd Ratio
     * @return (rat1 / rat2)
     */
    public static Ratio divide(Ratio rat1, Ratio rat2) {
        return Ratio.reduce(new Ratio(rat1.numerator * rat2.denominator,
                rat1.denominator * rat2.numerator)
        );
    } // divide(Ratio)

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
     * Returns the product of one Ratio and a second.
     *
     * @param rat1 1st Ratio
     * @param rat2 2nd Ratio
     * @return (rat1 * rat2)
     */
    public static Ratio multiply(Ratio rat1, Ratio rat2) {
        return Ratio.reduce(new Ratio(rat1.numerator * rat2.numerator,
                rat1.denominator * rat2.denominator)
        );
    } // multiply(Ratio)

    /**
     * Returns the negative of a Ratio.
     *
     * @param rat1 Ratio to be negated
     * @return (- rat1)
     */
    public static Ratio negate(Ratio rat1) {
        return Ratio.reduce(new Ratio(-rat1.numerator, rat1.denominator));
    } // negate(Ratio)

    /**
     * Reduces and normalizes the fraction, that means:
     * <ul>
     * <li>divides the numerator and the denominator by their greatest common
     * divisor, if that is &gt; 1,</li>
     * <li>makes the denominator always positive,</li>
     * <li>normalizes the denominator to 1 if the numerator is 0.</li>
     * </ul>
     *
     * @param rat1 the Ratio to be reduced
     * @return the reduced Ratio
     */
    public static Ratio reduce(Ratio rat1) {
        Ratio result = new Ratio(rat1.numerator, rat1.denominator);
        int common = gcd(rat1.numerator, rat1.denominator);
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
    } // reduce(Ratio)

    /**
     * Returns the difference of one Ratio and a second.
     *
     * @param rat1 1st Ratio
     * @param rat2 2nd Ratio
     * @return (rat1 - rat2)
     */
    public static Ratio subtract(Ratio rat1, Ratio rat2) {
        return Ratio.add(rat1, Ratio.negate(rat2));
    } // subtract(Ratio)

    /**
     * Returns this Ratio as a String.
     *
     * @return a String of the form "a/b", or only "a" if b is 1.
     */
    public String toString() {
        String result = String.valueOf(numerator);
        if (denominator != 1) {
            result += "/" + String.valueOf(denominator);
        }
        return result;
    } // toString()

    /**
     * Test program, shows a series of fixed operations on Ratios
     *
     * @param args String array of commandline arguments
     */
    public static void main(String[] args) {
        if (args.length == 0) { // set default arguments
            args = new String[]{"1", "1/2", "3/4", "5/6"};
        } // set default arguments

        int iarg = 0;
        String str0 = "0/1";
        Ratio rat0 = new Ratio(str0);
        while (iarg < args.length) {
            String str1 = args[iarg];
            Ratio rat1 = new Ratio(str1);
            System.out.println(str0 + " + " + str1 + " = " + Ratio.add(rat0, rat1).toString());
            System.out.println(str0 + " - " + str1 + " = " + Ratio.subtract(rat0, rat1).toString());
            System.out.println(str0 + " * " + str1 + " = " + Ratio.multiply(rat0, rat1).toString());
            System.out.println(str0 + " / " + str1 + " = " + Ratio.divide(rat0, rat1).toString());
            System.out.println();
            str0 = str1;
            rat0 = rat1;
            iarg++;
        } // while iarg
    } // main

} // Ratio
