package org.teherba.jtc.language;

/* Generate words consisting of 3 letter with conditions in a method
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
public class Word3Cond2 {

    /**
     * Determines the class of a character.
     * @param pletters String with all possible letters
     * @param pindex index into {@link #pletters}
     * @return a code which determines the class:
     * 1 = vowel ("a", "e", "i", "o", "u"),
     * 2 = "y" (vowel and consonant)
     * 3 = consonant.
     */
    public static int getCharClass(String pletters, int pindex) {
        int result = 3;
        char ch1 = pletters.charAt(pindex);
        switch (ch1) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                result = 1; // only vowel 
                break;
            case 'y':
                result = 2; // both vowel and consonant
                break;
            default:
                result = 3; // only consonant
                break;
        } // switch ch1
        return result;
    } // getCharClass

    /**
     * Test program.
     *
     * @param args commandline arguments (ignored). 
     * There are 3401 (= 6*21*6 + 21*6*21 - 1 (for duplicate "yyy")) 
     * resulting words.
     */
    public static void main(String[] args) {
        String letters = "abcdefghijklmnopqrstuvwxyz";
        //                01234567890123456789012345
        int counter = 0;
        int index1 = 0;
        while (index1 < 26) {
            int index2 = 0;
            while (index2 < 26) {
                int index3 = 0;
                while (index3 < 26) {
                    if (    (  getCharClass(letters, index1) <= 2 // vowel
                            && getCharClass(letters, index2) >= 2 // consonant
                            && getCharClass(letters, index3) <= 2 // vowel
                            )
                            || 
                            (  getCharClass(letters, index1) >= 2 // consonant
                            && getCharClass(letters, index2) <= 2 // vowel
                            && getCharClass(letters, index3) >= 2 // consonant
                            )) { // conditions
                        System.out.print
                                ( letters.substring(index1, index1 + 1)
                                + letters.substring(index2, index2 + 1)
                                + letters.substring(index3, index3 + 1)
                                + " ");
                        counter++;
                    } // conditions
                    index3++;
                } // while index3
                index2++;
            } // while index2
            index1++;
        } // while index1
        System.out.println();
        System.out.println("counter = " + counter);
    } // main

} // Word3Cond2
