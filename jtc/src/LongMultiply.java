/* Multiply 4 long numbers 4 times
 * Java Training Course example file
 * 2017-11-09, Georg Fischer
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
 * Multiply 4 long numbers 4 times
 *
 * @author Georg Fischer <dr.georg.fischer at gmail.com>
 */
public class LongMultiply {

    /**
     * Test program
     *
     * @param args commandline arguments: 4 numbers
     * Result with the default arguments is 4294967296.
     */
    public static void main(String[] args) {
        if (args.length == 0) { // set default arguments
            args = new String[]{"4", "4", "4", "4"};
        } // set default arguments
        long product
                = Long.parseLong(args[0])
                * Long.parseLong(args[1])
                * Long.parseLong(args[2])
                * Long.parseLong(args[3]);
        long product2 = product * product * product * product;
        System.out.println(product2);
    } // main

} // LongMultiply
