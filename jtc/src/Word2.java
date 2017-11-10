/* Generate all words consisting of 2 letters.
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
 * Generate all words consisting of 2 letters.
 *
 * @author Georg Fischer &lt;dr.georg.fischer at gmail.com>&gt;
 */
public class Word2 {

    /**
     * Test program
     *
     * @param args commandline arguments (ignored)
     * There are 676 (= 26*26) resulting words.
     */
    public static void main(String[] args) {
        String letters = "abcdefghijklmnopqrstuvwxyz";
        //                01234567890123456789012345
        int counter = 0;
        int index1 = 0;
        while (index1 < 26) {
            int index2 = 0;
            while (index2 < 26) {
                System.out.print
                        ( letters.substring(index1, index1 + 1)
                        + letters.substring(index2, index2 + 1)
                        + " "
                        );
                counter++;
                index2++;
            } // while index2
            index1++;
        } // while index1
        System.out.println();
        System.out.println("counter = " + counter);
    } // main

} // Word2
