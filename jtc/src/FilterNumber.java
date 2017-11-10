/* Read lines and replace digits by indonesian number words
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
 * limitations under the License. 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Read lines and replace digits by indonesian number words.
 *
 * @author Georg Fischer &lt;dr.georg.fischer at gmail.com>&gt;
 */
public class FilterNumber {

    /**
     * Convert a number up to 10 into a word in indonese.
     *
     * @param num number to be converted, less than 11
     * @return indonese number word
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
     * Process a line and print it.
     *
     * @param line the line to be processed
     */
    public static void process(String line) {
        // further processing goes here
        String result = "";
        String[] parts = line.split("\\b"); // split on one or more spaces or tabs
        int ipart = 0;
        while (ipart < parts.length) {
            if (Character.isDigit(parts[ipart].charAt(0))) {
                result += speakNumber(Integer.parseInt(parts[ipart]));
            } else {
                result += parts[ipart]; // append it to the new line
            }
            ipart++;
        } // while 
        System.out.println(result);
    } // process

    /**
     * Test program: Filters standard input and writes it to standard output.
     *
     * @param args commandline arguments
     */
    public static void main(String[] args) {
        if (args.length == 0) { // set default arguments
            args = new String[]{"", "", "", ""};
        } // set default arguments
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            boolean busy = true;
            while (busy) {
                String line = reader.readLine();
                if (line == null) {
                    busy = false;
                } else { // process line
                    process(line);
                } // process line
            } // while busy
        } catch (IOException exc) {
            System.err.println(exc.getMessage());
        } // try
    } // main

} // FilterNumber
