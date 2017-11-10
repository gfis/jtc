/* Compute powers of 2 (1, 2, 4, 8 and so on) in reverse order
 * Java Training Course example file
 * 2017-11-10, Georg Fischer
 *
 * Copyright 2017 Georg Fischer &lt;dr.georg.fischer at gmail.com>&gt;.
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
 * Compute powers of 2 (1, 2, 4, 8 and so on) in reverse order
 *
 * @author Georg Fischer &lt;dr.georg.fischer at gmail.com>&gt;
 */
public class PowersOf2Array {

    /**
     * Test program
     *
     * @param args commandline arguments (ignored)
     */
    public static void main(String[] args) {
        int[] powers = new int[200];
        int previousValue = 0;
        int currentValue = 1;
        // duplicate each value and store it in an array
        int exponent = 0;
        while (exponent < 200 && previousValue < currentValue) {
            // as long as the sequence is increasing
            powers[exponent] = currentValue;
            previousValue = currentValue;
            currentValue *= 2; // duplicate
            exponent++;
        } // while 1 exponent 

        // now print the first 26 array elements backwards
        exponent = 25;
        while (exponent >= 0) {
            System.out.println(String.format("%4d %16d", exponent, powers[exponent]));
            exponent--;
        } // while 2 exponent
    } // main

} // PowersOf2Array
