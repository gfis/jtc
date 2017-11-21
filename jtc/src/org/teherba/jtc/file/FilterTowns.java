package org.teherba.jtc.file;

/* Read lines with words and colorize them for several languages
 * Java Training Course example file
 * 2017-11-16, Georg Fischer
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
 * Read lines with words and colorize them for several languages.
 *
 * @author Georg Fischer &lt;dr.georg.fischer at gmail.com>&gt;
 */
public class FilterTowns {

    /**
     * Process a line, and output the corresponding word, maybe enclosed in an
     * HTML color tag.
     *
     * @param line input line to be processed, of the following form: [language
     * codes] tab 3-letter-word tab [optional meaning] ... parts[0] parts[1]
     * parts[2] ...
     */
    public static void process(String line) {
        String[] parts = line.split("\\t"); // split on whitespace 
        String result = parts[1].replaceAll("Kota ", "")
                + "\t" + parts[4].replaceAll("\\.", "");
        System.out.println(result);
    } // process

    /**
     * Test program.
     * Standard input is <code>jtc/jtc/allwords.manual.txt</code> ; 
     * Standard output is the resulting HTML file.
     * @param args commandline arguments (ignored)
     */
    public static void main(String[] args) {
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
    } // method main

} // FilterTowns
