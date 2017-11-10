/* Read lines with words and colorize them for several languages
 * Java Training Course example file
 * 2017-11-09, Georg Fischer
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
public class FilterMulti3 {

    /**
     * Process a line, and output the corresponding word, maybe enclosed in an
     * HTML color tag.
     *
     * @param line input line to be processed, of the following form: [language
     * codes] tab 3-letter-word tab [optional meaning] ... parts[0] parts[1]
     * parts[2] ...
     */
    public static void process(String line) {
        String[] parts = line.split("\\s+"); // split on whitespace 
        String result = parts[1] + " ";
        if (parts[0].equals("")) { // without language code(s) 
        } else { // with language code(s)
            char code = parts[0].charAt(0);
            result = "<span style=\"background-color: ";
            switch (code) {
                case 'i': // indonesian
                    result += "lightpink";
                    break;
                case 'd': // german
                    result += "yellow";
                    break;
                case 'e': // english
                    result += "lightblue";
                    break;
                case 'f': // french
                    result += "lightgreen";
                    break;
                default:
                    break;
            } // switch
            result += "\">";
            result += parts[1];
            if (parts.length >= 2) { // with meaning
                result += "</span>";
                result += "<span style=\"background-color: lightyellow\"><em>";
                int ipart = 2;
                while (ipart < parts.length) { // append all words of "meaning"
                    result += " " + parts[ipart];
                    ipart++;
                } // while ipart
                result += "</em>";
            } // with meaning
            result += "</span> ";
        } // with language code(s)
        System.out.print(result);
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
            System.out.println("<tt>"); // fixed width font
            while (busy) {
                String line = reader.readLine();
                if (line == null) {
                    busy = false;
                } else { // process line
                    process(line);
                } // process line
            } // while busy
            System.out.println("</tt>");
        } catch (IOException exc) {
            System.err.println(exc.getMessage());
        } // try
    } // method main

} // FilterMulti3
