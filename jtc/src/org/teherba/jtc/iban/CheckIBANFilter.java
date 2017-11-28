package org.teherba.jtc.iban;

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
import java.io.FileReader;
import java.io.IOException;

/**
 * Read lines IBANs and checks them for proper checkdigits.
 *
 * @author Georg Fischer &lt;dr.georg.fischer at gmail.com>&gt;
 */
public class CheckIBANFilter {
    
    /**
     * Process a line with a single IBAN., and store it in an ArrayList.
     * Remove any non-word characters, and convert the letters to uppercase.
     * Prints the original number, the correct check digits, and a message
     *
     * @param line input line with a single IBAN to be processed
     */
    public void process(String line) {
        String checkResult = "";
        checkResult = CheckIBAN.process(line
                .replaceAll("\\W", "")
                .toUpperCase()
                );
        System.out.println(line + " " + checkResult);
    } // process

    public static void main(String[] args) {
        if (args.length == 0) { // no argements
            args = new String[] {"jtc/jtc/test/iban.txt" };
        }
        CheckIBANFilter filter = new CheckIBANFilter();
        int iarg = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(args[iarg ++]));
            boolean busy = true;
            while (busy) {
                String line = reader.readLine();
                if (line == null) {
                    busy = false;
                } else { // process line
                    // filter.process1(line);
                    filter.process(line);
                } // process line
            } // while busy
            reader.close();
        } catch (IOException exc) {
            System.err.println(exc.getMessage());
        } // try
   } // method main

} // CheckIBANFilter
