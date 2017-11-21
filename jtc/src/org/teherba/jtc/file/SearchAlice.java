package org.teherba.jtc.file;

/* Read lines from an URL and extract names
 * Java Training Course example file
 * 2017-11-20, Georg Fischer
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
import java.util.Iterator;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Read lines from an URL and extract names
 *
 * @author Georg Fischer &lt;dr.georg.fischer at gmail.com>&gt;
 */
public class SearchAlice {

    /**
     * Map of town names tp their number of inhabitants
     */
    private static TreeMap<String, Integer> nameMap = new TreeMap<String, Integer>();

    /**
     * Process a line, and output any names which are found. A name is assumed
     * if a lowercase letter is followed by some spaces, an uppercase letter and
     * several lowercase letters.
     *
     * @param line input line to be processed
     */
    public static void process(String line) {
        String regex = "[a-z]\\s+[A-Z][a-z]+";
        // lowercase spaces 1Uppercase nLowercase
        Pattern pat = Pattern.compile(regex);
        Matcher mat = pat.matcher(line);
        mat.reset();
        while (mat.find()) {
            int start = mat.start();
            int end = mat.end();
            String name = line.substring(start, end)
                    .replaceAll("\\A[a-z]\\s+", "");
            Integer occurs = nameMap.get(name);
            if (occurs == null) { // key = name was not found
                occurs = new Integer(1);
                System.out.print(name + " ");
            } else {
                occurs = new Integer(occurs.intValue() + 1);
            }
            nameMap.put(name, occurs);
        } // while
    } // process

    /**
     * Test program. Input is taken either from:Standard input is
     * <code>jtc/jtc/allwords.manual.txt</code> ; (1) standard input, if no
     * argmentss are given, (2) from a file named as the first argument, (3)
     * from an URL named as the first argument.
     *
     * @param args commandline arguments
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            args = new String[]{"https://www.gutenberg.org/files/11/11-0.txt"};
        } // default URL argument
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

            // now we print the sorted list of names
            Iterator<String> iter = nameMap.keySet().iterator();
            while (iter.hasNext()) {
                String name = iter.next();
                int occurs = nameMap.get(name).intValue();
                System.out.println(String.format("%-16s %10d",
                         name, occurs));
            } // while iter

        } catch (IOException exc) {
            System.err.println(exc.getMessage());
        } // try
    } // method main

} // SearchAlice
