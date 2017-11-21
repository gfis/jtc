package org.teherba.jtc.language;

/* Generate words consisting of 3 letter with conditions
 * Java Training Course example file
 * 2017-11-06, Georg Fischer
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
 * limitations under the License. 
 */

/**
 * Generate words consisting of 3 letters with the following conditions:
 * (1) the word starts with a vowel, followed by a consonant, and ends with vowel, or
 * (2) the word starts with a consonsant, fowllowed by a vowel, and ends with a consonant, and
 * (3) "y" is thereby treated as vowel and as consonant.
 *
 * @author Georg Fischer &lt;dr.georg.fischer at gmail.com>&gt;
 */
public class Word3Cond1 {

    /**
     * Test program
     *
     * @param args commandline arguments (ignored).
     * There are 3401 (= 6*21*6 + 21*6*21 - 1 (for duplicate "yyy")) resulting words.
     * 
     */
    public static void main(String[] args) {
        String letters = "abcdefghijklmnopqrstuvwxyz";
        //                01234567890123456789012345
        int counter = 0;
        int index1 = 0;
        while (index1 < 26) {
            char ch1 = letters.charAt(index1);
            int chClass1 = 3;
            switch (ch1) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    chClass1 = 1;
                    break;
                case 'y':
                    chClass1 = 2;
                    break;
                default:
                    chClass1 = 3;
                    break;
            } // switch ch1

            int index2 = 0;
            while (index2 < 26) {
                char ch2 = letters.charAt(index2);
                int chClass2 = 3;
                switch (ch2) {
                    case 'a':
                    case 'e':
                    case 'i':
                    case 'o':
                    case 'u':
                        chClass2 = 1;
                        break;
                    case 'y':
                        chClass2 = 2;
                        break;
                    default:
                        chClass2 = 3;
                        break;
                } // switch ch2

                int index3 = 0;
                while (index3 < 26) {
                    char ch3 = letters.charAt(index3);
                    int chClass3 = 3;
                    switch (ch3) {
                        case 'a':
                        case 'e':
                        case 'i':
                        case 'o':
                        case 'u':
                            chClass3 = 1;
                            break;
                        case 'y':
                            chClass3 = 2;
                            break;
                        default:
                            chClass3 = 3;
                            break;
                    } // switch ch3

                    //-----------------------------------
                    if ((chClass1 <= 2 && chClass2 >= 2 && chClass3 <= 2)
                            //  vowel          consonant       vowel
                            || (chClass1 >= 2 && chClass2 <= 2 && chClass3 >= 2) //  consonant      vowel           consonant
                            ) { // conditions
                        System.out.print(String.valueOf(ch1)
                                + String.valueOf(ch2)
                                + String.valueOf(ch3)
                                + " ");
                        counter++;
                    } // conditions
                    //------------------------------------
                    index3++;
                } // while index3
                index2++;
            } // while index2
            index1++;
        } // while index1
        System.out.println();
        System.out.println("counter = " + counter);
    } // main

} // Word3Cond1
