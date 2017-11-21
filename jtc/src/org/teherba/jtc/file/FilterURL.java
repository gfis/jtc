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
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Read lines with words and colorize them for several languages.
 *
 * @author Georg Fischer &lt;dr.georg.fischer at gmail.com>&gt;
 */
public class FilterURL {

    /**
     * Process a line, and output it unchanged
     *
     * @param line input line to be processed
     */
    public static void process(String line) {
        System.out.println(line);
    } // process

    /**
     * Test program.
     * Input is taken either from:Standard input is <code>jtc/jtc/allwords.manual.txt</code> ; 
     * (1) standard input, if no argmentss are given,
     * (2) from a file named as the first argument,
     * (3) from an URL named as the first argument.
     * @param args commandline arguments 
     */
    public static void main(String[] args) {
        try {
            BufferedReader reader;
            if (args.length == 0) { // no argements
                reader = new BufferedReader(new InputStreamReader(System.in));
            } else { // at least one argument
                if (args[0].matches("\\w+\\:\\/\\/.*")) { // open URL
                    URL url = new URL(args[0]);
                    reader = new BufferedReader(new InputStreamReader(url.openStream()));
                } else { // open file
                    FileInputStream stream = new FileInputStream(args[0]);
                    reader = new BufferedReader(new InputStreamReader(stream));
                }
            } // at least one argument
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

} // FilterURL
