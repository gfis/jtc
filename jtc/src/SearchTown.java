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
import java.util.ArrayList;

/**
 * Read lines with words and colorize them for several languages.
 *
 * @author Georg Fischer &lt;dr.georg.fischer at gmail.com>&gt;
 */
public class SearchTown {
    
    /** List of town names together with number of inhabitants, separated by tab */
    ArrayList<String> towns = new ArrayList<String>(128);

    /**
     * Searches for a town in the list and returns the corresponding 
     * number of inhabitants.
     * @param townName name of the town to be searched for
     * @return number of inhabitants
     */
    public String lookUp(String townName) {
        String result = "[not found]";
        
        return result;
    } // lookUp
    
    /**
     * Process a line, and output the corresponding word, maybe enclosed in an
     * HTML color tag.
     *
     * @param line input line to be processed, of the following form: 
     * [town name] tab [number of inhabitants]
     */
    public void process(String line) {
        towns.add(line);
    } // process

    /**
     * Test program.
     * Standard input is <code>jtc/jtc/test/id_kota.lst</code> ; 
     * Standard output is a sentence giving the number of inhabitants.
     * @param args commandline arguments: inputfile town_name
     */
    public static void main(String[] args) {
        SearchTown searchTown = new SearchTown();
        int iarg = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(args[iarg ++]));
            boolean busy = true;
            while (busy) {
                String line = reader.readLine();
                if (line == null) {
                    busy = false;
                } else { // process line
                    searchTown.process(line);
                } // process line
            } // while busy
        } catch (IOException exc) {
            System.err.println(exc.getMessage());
        } // try
        String whichTown = args[iarg ++];
        String result = searchTown.lookUp(whichTown);
        System.out.println("The indonesian town of " + whichTown 
                + " has more than " + result + " inhabitants.");
    } // method main

} // SearchTown
