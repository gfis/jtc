/* Read lines and replace all vowels by 3 letters
 * Java Training Course example file
 * 2017-11-09, Georg Fischer
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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Read lines and replace all vowels by "aha", "ele" etc.
 *
 * @author Georg Fischer &lt;dr.georg.fischer at gmail.com&gt;
 */
public class Filter1 {

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
                    line = line
                            .replaceAll("a", "aha")
                            .replaceAll("e", "ele")
                            .replaceAll("i", "iti")
                            .replaceAll("o", "obo")
                            .replaceAll("u", "uku");
                    System.out.println(line);
                } // process line
            } // while busy
        } catch (IOException exc) {
            System.err.println(exc.getMessage());
        } // try
    } // main

} // Filter1
