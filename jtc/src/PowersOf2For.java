/* Compute powers of 2 - variant with "for" statement
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
 * Compute powers of 2 - variant with "for" statement
 *
 * @author Georg Fischer &lt;dr.georg.fischer at gmail.com>&gt;
 */
public class PowersOf2For {

    /**
     * Test program
     *
     * @param args commandline arguments (ignored). Results are correct up to
     * 2**30, 2**31 is negative, and above there are zeroes.
     */
    public static void main(String[] args) {
        int value = 1;
        for (int exponent = 0; exponent <= 36; exponent++) {
            System.out.println(String.format("%4d %16d", exponent, value));
            value = value * 2;
        } // for exponent
    } // main

} // PowersOf2For
