/* Computes and prints Pascal's Triangle for binomial coefficients
 * Java Training Course example file
 * 2017-11-07, Georg Fischer
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
 * limitations under the License.
 */
package org.teherba.jtc.math;
/**
 * Computes and prints Pascal's Triangle for binomial coefficients.
 * The first and the last element in each row of the triangle is 1.
 * Row 0 for exponent 0 contains a single 1. Row n has n-1 elements.
 * Any "inner" element is the sum of the two elements above it.
 * (n m) = n! / (n-k)! For example, (3 2) = 6 / 1 = 6 
 * @author Georg Fischer &lt;dr.georg.fischer at gmail.com&gt;
 */
public class PascalTriangle {

    /** one row of the triangle */
    public static int[] row;
    
    /** many spaces */
    public static final String SPACES = "                                " 
            +  "                                " ;
    
    /** Prints a single row of the triangle
     * @param rowNo number of the row to be printed
     * @param maxRow number of the last row to be printed
     */
    public static void printRow(int rowNo, int maxRow) {
        int krow = 0;
        System.out.print(SPACES.substring(0, 3*(maxRow - rowNo)));
        while (krow <= rowNo) {
            System.out.print(String.format("%6d", row[krow]));
            krow ++;
        } // while krow
        System.out.println();
    } // printRow
    
    /** Computes and prints Pascal's triangle
     * @param maxRow maximum row to be printed ("1 1" is row 1)
     */
    public static void printTriangle(int maxRow) {
        row = new int[maxRow + 1];
        int irow = 0;
        while (irow <= maxRow) {
            int jrow = irow;
            row[jrow] = 1;
            jrow --;
            while (jrow >= 1) {
                row[jrow] = row[jrow] + row[jrow - 1];
                jrow --;
            } // while jrow
            printRow(irow, maxRow);
            irow ++;
        } // while irow
    } // printTriangle
    
    /**
     * Test Program.
     *
     * @param args commandline arguments: 4 numbers.
     * Result with the default arguments is 331776.
     */
    public static void main(String[] args) {
        if (args.length == 0) { // set default arguments
            args = new String[] { "16" };
        } // set default arguments
        int maxRow = Integer.parseInt(args[0]);
        printTriangle(maxRow);
    } // main

} // PascalTriangle
