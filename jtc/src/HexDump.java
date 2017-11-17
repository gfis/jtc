/* Read lines and print them in hexadecimal and ASCII 
 * Java Training Course example file
 * 2017-11-15, Georg Fischer
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
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Read lines and print them in hexadecimal and ASCII
 *
 * @author Georg Fischer &lt;dr.georg.fischer at gmail.com&gt;
 */
public class HexDump {

    private static final int MAX_BUF = 16;

    /**
     * Test program: Filters standard input and writes it to standard output.
     *
     * @param args commandline arguments
     */
    public static void main(String[] args) {
        if (args.length == 0) { // set default arguments
            args = new String[]{"jtc/jtc/src/HexDump.java"};
        } // set default arguments
        try {
            FileInputStream stream = new FileInputStream(args[0]);
            byte[] buffer = new byte[MAX_BUF];
            boolean busy = true;
            long offset = 0;
            while (busy) {
                int lengthRead = stream.read(buffer);
                busy = lengthRead > 0;
                if (busy) {
                    System.out.print(String.format("%08x: ", offset));
                    int index = 0;
                    while (index < MAX_BUF) { // dump 16 bytes in one line
                        if (index < lengthRead) {
                            System.out.print(String.format("%02x ", buffer[index]));
                        } else {
                            System.out.print("   ");
                        }
                        index++;
                    } // while 1 line
                    String readable = new String(buffer, "ISO-8859-1");
                    readable = readable.substring(0, lengthRead).replaceAll("[\\r\\n\\t]", ".");
                    System.out.println(readable);
                } // still busy
                offset += MAX_BUF; // buffer.length
            } // while busy
            stream.close();
        } catch (IOException exc) {
            System.err.println(exc.getMessage());
        } // try
    } // main

} // HexDump
