package org.teherba.jtc.language;

/* Write a greeting in indonesian depending on the hour - variant with "switch".
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
public class SelamatSwitch {

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
        switch (hour) {
            case 7:
            case 8:
            case 9:
            case 10:
                suffix = "pagi";
                break;
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                suffix = "siang";
                break;
            case 16:
            case 17:
            case 18:
                suffix = "sore";
                break;
            default:
                suffix = "malam";
                break;
        } // switch
        System.out.println("Salamat " + suffix);
   } // main

} // SelamatSwitch
