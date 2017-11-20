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
import java.util.Iterator;
import java.util.TreeMap;

/**
 * Read lines with town names and number of inhabation, 
 * and print a list sorted by town names.
 *
 * @author Georg Fischer &lt;dr.georg.fischer at gmail.com>&gt;
 */
public class SortTowns {
    
    /** Map of town names tp their number of inhabitants */
    TreeMap<String, String> townsMap = new TreeMap<String, String>();
 
    /**
     * Prints the sorted list of towns with their inhabitants.
     */
    public void listTowns() {
        Iterator<String> iter = townsMap.keySet().iterator();
        while(iter.hasNext()) {
            String townName = iter.next();
            String noInhabitants = townsMap.get(townName);
            System.out.println(String.format("%-30s %10s"
                    , townName, noInhabitants));
        } // while iter
    } // listTowns
    
    /**
     * Process a line, and store a (key, value) pair in the HashMap.
     *
     * @param line input line to be processed, of the following form: 
     * [town name] tab [number of inhabitants]
     */
    public void process(String line) {
        String[] parts = line.split("\\t");
        townsMap.put(parts[0], parts[1]); // key = townName, value = inhabitants
    } // process

    /**
     * Test program.
     * Standard input is <code>jtc/jtc/test/id_kota.lst</code> ; 
     * Standard output is a sentence giving the number of inhabitants.
     * @param args commandline arguments: inputfile town_name
     */
    public static void main(String[] args) {
        SortTowns sortTowns = new SortTowns();
        int iarg = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(args[iarg ++]));
            boolean busy = true;
            while (busy) {
                String line = reader.readLine();
                if (line == null) {
                    busy = false;
                } else { // process line
                    // searchTown.process1(line);
                    sortTowns.process(line);
                } // process line
            } // while busy
            reader.close();
        } catch (IOException exc) {
            System.err.println(exc.getMessage());
        } // try
        sortTowns.listTowns();
    } // method main

} // SearchTown
