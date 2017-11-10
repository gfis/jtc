/* Spell the numbers up to 10 in indonesian language
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
 * Spell the numbers up to 10 in indonesian language, using a Java method
 *
 * @author Georg Fischer &lt;dr.georg.fischer at gmail.com&gt;
 */
public class Number10Method {

    /**
     * Convert a number up to 10 into a word in indonese.
     *
     * @param num number to be converted, less than 11.
     * @return indonesian number word
     */
    public static String speakNumber(int num) {
        String word = "";
        switch (num) {
            case 0:
                word = "nol";
                break;
            case 1:
                word = "satu";
                break;
            case 2:
                word = "dua";
                break;
            case 3:
                word = "tiga";
                break;
            case 4:
                word = "empat";
                break;
            case 5:
                word = "lima";
                break;
            case 6:
                word = "enam";
                break;
            case 7:
                word = "tujuh";
                break;
            case 8:
                word = "delapan";
                break;
            case 9:
                word = "sembilan";
                break;
            case 10:
                word = "sepuluh";
                break;
            default:
                word = String.valueOf(num);
                break;
        } // switch
        return word;
    } // speakNumber

    /**
     * Test program.
     *
     * @param args commandline arguments: a number &lt;= 10. Result with the
     * default argument is "sembilan".
     */
    public static void main(String[] args) {
        if (args.length == 0) { // set default arguments
            args = new String[] { "9" };
        } // set default arguments
        int num = Integer.parseInt(args[0]);
        String word = speakNumber(num);
        System.out.println(word);
    } // main

} // Number10Method
