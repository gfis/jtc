/* 
 * Java Training Course example file
 * 2017-11-10, Georg Fischer
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
 * 
 * @author Georg Fischer &lt;dr.georg.fischer at gmail.com&gt;
 */
public class Age {
    
    /** Get a month's number from its name
     * @param monthName month's name, or the first 3 letters of it
     * @return number of the month: 1 to 12
     */
    public static int getMonthNumber(String monthName) {
        monthName = monthName.toLowerCase();
        int result = 0;
        if (false) {
        } else if (monthName.startsWith("jan")) {
            result = 1;
        } else if (monthName.startsWith("feb")) {
            result = 2;
        } else if (monthName.startsWith("mar")) {
            result = 3;
        } else if (monthName.startsWith("apr")) {
            result = 4;
        } else if (monthName.startsWith("m"  )) {
            result = 5;
        } else if (monthName.startsWith("jun")) {
            result = 6;
        } else if (monthName.startsWith("jul")) {
            result = 7;
        } else if (monthName.startsWith("aug")) {
            result = 8;
        } else if (monthName.startsWith("sep")) {
            result = 9;
        } else if (monthName.startsWith("o"  )) {
            result = 10;
        } else if (monthName.startsWith("nov")) {
            result = 11;
        } else if (monthName.startsWith("de ")) {
            result = 12;
        } else {
            result = 0;
        }
        return result;
    } // getMonthNumber

    /**
     * Test program
     * @param args commandline arguments
     */
    public static void main(String[] args) {
        if (args.length == 0) { // set default arguments
            args = new String[] { "29", "Jun", "1947", "" };
        } // set default arguments
        int day    = Integer.parseInt(args[0]);
        int month  = getMonthNumber  (args[1]);
        int year   = Integer.parseInt(args[2]);
        System.out.println("day=" + day + ", month=" + month + ", year=" + year);
    } // main

} // Age
