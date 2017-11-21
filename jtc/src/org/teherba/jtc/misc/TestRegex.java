package org.teherba.jtc.misc;

/* Enters a regular expression and checks it against some text
 * Java Training Course example file
 * 2017-11-20, Georg Fischer
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
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Enters a regular expression and checks it against some text
 *
 * @author Georg Fischer &lt;dr.georg.fischer at gmail.com&gt;
 */
public class TestRegex {
    
    /** Test a text against a regular expression
     * @param regex regular expression
     * @param text text to be tested
     * The result is printed on stdout.
     */
    public static void testMatch(String regex, String text) {
        Pattern pat = Pattern.compile(regex);
        Matcher mat = pat.matcher(text);
        System.out.println("matches: " + mat.matches());
        mat.reset();
        while (mat.find()) {
            int start = mat.start();
            int end   = mat.end();
            System.out.println("found \"" 
                    + text.substring(start, end) 
                    + "\" at position " + start);
        } // while
    } // testMatch

    /**
     * Test program
     * Input is from console
     */
    public static void main(String[] args) {
        // create a scanner so we can read the command-line input
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\r?\n");
        //  prompt for the user's name
        String regex = "";
        String text  = "";
        int state = 1; // state of the finite automaton
        while (state != 3) {
            switch (state) {
                case 0:
                case 1: // regex
                    System.out.print("Regular expression: ");
                    regex = scanner.next(); 
                    if (regex.length() == 0) {
                        state = 3; // break the while loop - exit
                    } else {
                        state = 2;
                    }
                    break;
                case 2: // text to be tested
                    System.out.print("Test text: ");
                    text = scanner.next();
                    if (text.length() == 0) {
                        state = 1;
                    } else {
                        testMatch(regex, text);
                        // state = 2;
                    }
                   break;
                default:
                    System.err.println("Internal error: invalid state = " + String.valueOf(state));
                    break;
            } // switch
        } // while state != endState
    } // main

} // TestRegex
