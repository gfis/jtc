/* Write a greeting in indonesian depending on the hour.
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
 * Write a greeting in indonesian depending on the hour.
 *
 * @author Georg Fischer &lt;dr.georg.fischer at gmail.com>&gt;
 */
public class Selamat {

    /**
     * Test program
     *
     * @param args commandline arguments: an hour between 0 and 24. 
     * Result for the default argument is
     * "Salamat pagi".
     */
    public static void main(String[] args) {
        if (args.length == 0) { // set default arguments
            args = new String[]{"7"};
        } // set default arguments
        int hour = Integer.parseInt(args[0]);
        String suffix = "";
        if (false) {
        } else if (hour <= 6) {
            suffix = "malam";
        } else if (hour <= 10) {
            suffix = "pagi";
        } else if (hour <= 15) {
            suffix = "siang";
        } else if (hour <= 18) {
            suffix = "sore";
        } else if (hour <= 24) {
            suffix = "malam";
        } else {
            suffix = "???";
        }
        System.out.println("Salamat " + suffix);
    } // main

} // Selamat
