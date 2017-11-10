/* Concatenate 4 strings 4 times
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
 * Concatenates 4 strings on the commandline 4 times
 *
 * @author Georg Fischer <dr.georg.fischer at gmail.com>
 */
public class Filter1 {

    /**
     * Test program
     *
     * @param args commandline arguments: 4 words
     */
    public static void main(String[] args) {
        String sum = args[0] + " " + args[1] + " " + args[2] + " " + args[3] + " ";
        String sum2 = sum + sum + sum + sum;
        System.out.println(sum2);
    } // main

} // Filter1
