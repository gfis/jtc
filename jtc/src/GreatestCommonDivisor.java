
/** Computes the greatest common divisor with Euclid's algorithm
 *
 * 2017-11-06, JTC example
 *
 * @author Georg Fischer
 */
public class GreatestCommonDivisor {

    /**
     * Computes the greatest common divisor (GCD) of 2 integer numbers. The GCD
     * is always positive. It is defined to be 0 if both arguments are 0, and 1
     * if they have no common divisor
     *
     * @param a first integer
     * @param b second integer
     * @return the maximum positive number which divides both a and b
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
            } // while q
            result = p;
        } // if > 1
        return Math.abs(result);
    } // gcd(a, b)

    /**
     * Test program.
     *
     * @param args commandline arguments: two numbers. 
     * Result with the default arguments is 16.
     */
    public static void main(String[] args) {
        if (args.length == 0) { // set default arguments
            args = new String[]{"400", "-64"};
        } // set default arguments
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        System.out.println("gcd(" + a + "," + b + ") = " + gcd(a, b));
    } // main

} // GreatestCommonDivisor
