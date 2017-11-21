/* 
 * Java Training Course example file
 * 2017-11-21, Georg Fischer
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
 * limitations under the License. */
package org.teherba.jtc.misc;

import java.util.Map;
import java.util.regex.Pattern;
/**
 *
 * @author Georg Fischer &lt;dr.georg.fischer at gmail.com>&gt;
 */
public class SystemProps {

     /**
     * Prints the environment
     */
    public static void printEnvironment() {
        System.out.println("--------------------------");
        Map<String, String> env = System.getenv();
        for (String envName : env.keySet()) {
            if (! envName.startsWith("=")) {
                System.out.format("%s=%s%n", envName, env.get(envName));
            }
        } // for
        System.out.println("--------------------------");
        System.out.println("System path:");
        String[] dirs = env.get("Path")
                .split(Pattern.quote(System.getProperty("path.separator")));
        int idir = 0;
        while (idir < dirs.length) {
            System.out.println(dirs[idir]);
            idir++;
        } // while idir
    } // printEnvironment

   /**
     * Prints the system properties
     */
    public static void printProperties() {
        System.getProperties().list(System.out);
    } // printProperties

    /**
     * Prints the components of the current directory
     *
     */
    public static void printCurrentDirectory() {
        System.out.println("--------------------------");
        System.out.print("Current directory: ");
        String[] dirs = System.getProperty("user.dir")
                .split(Pattern.quote(System.getProperty("file.separator")));
        int idir = 0;
        while (idir < dirs.length) {
            if (idir > 0) { // not for the first 
                System.out.print("/"); // always print forward slashes
            }
            System.out.print(dirs[idir]);
            idir++;
        } // while idir
        System.out.println();
    } // printCurrentDirectory

    /**
     * Test program
     *
     * @param args commandline arguments
     */
    public static void main(String[] args) {
        if (args.length == 0) { // set default arguments
            args = new String[]{"", "", "", ""};
        } // set default arguments
        printProperties();
        printCurrentDirectory();
        printEnvironment();
    } // main

} // SystemProps
