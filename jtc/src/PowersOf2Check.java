/* Compute powers of 2: 1, 2, 4, 8, 16, 32, 64 ...
 * Java Training Course example file
 * 2017-11-06 , Georg Fischer
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

/**
 * Compute powers of 2: 1, 2, 4, 8, 16, 32, 64 ...
 *
 * @author Georg Fischer &lt;dr.georg.fischer at gmail.com&lt;
 */
public class PowersOf2Check {

    /**
     * Test program.
     *
     * @param args commandline arguments (ignored).
     * Powers will be written up to 2**30.
     */
    public static void main(String[] args) {
        int previousValue = 0;
        int currentValue = 1;
        int exponent = 0;
        while (exponent <= 36 && previousValue < currentValue) {
            System.out.println(String.format("%4d %16d", exponent, currentValue));
            previousValue = currentValue;
            currentValue *= 2;
            exponent++;
        } // while exponent
    } // main

} // PowersOf2Check
