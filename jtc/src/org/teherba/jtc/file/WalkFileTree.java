/* 
 * Java Training Course example file
 * 2017-11-23, Georg Fischer
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
package org.teherba.jtc.file;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Walk a file tree and print information about the files visited
 *
 * @author Georg Fischer &lt;dr.georg.fischer at gmail.com>&gt;
 */

public class WalkFileTree
        extends SimpleFileVisitor<Path> {

    /** Print information about each type of file.
     * 
     * @param file
     * @param attr
     * @return 
     */
    @Override
    public FileVisitResult visitFile(Path file,
            BasicFileAttributes attr) {
        if (attr.isSymbolicLink()) {
            System.out.format("L %s ", file);
        } else if (attr.isRegularFile()) {
            System.out.format("F %s ", file);
        } else {
            System.out.format("S %s ", file);
        }
        System.out.println("(" + attr.size() + " bytes)");
        return FileVisitResult.CONTINUE;
    }

    // Print each directory visited.
    @Override
    public FileVisitResult preVisitDirectory(Path dir,
            BasicFileAttributes attr) {
        System.out.format("D %s%n", dir);
        return FileVisitResult.CONTINUE;
    }

    // If there is some error accessing
    // the file, let the user know.
    // If you don't override this method
    // and an error occurs, an IOException 
    // is thrown.
    @Override
    public FileVisitResult visitFileFailed(Path file,
            IOException exc) {
        System.err.println(exc);
        return FileVisitResult.CONTINUE;
    }

    /**
     * Test program
     *
     * @param args commandline arguments
     */
    public static void main(String[] args) {
        if (args.length == 0) { // set default arguments
            args = new String[]{".", "", "", ""};
        } // set default arguments
        try {
            Path path = FileSystems.getDefault().getPath(args[0], "");
            Files.walkFileTree(path, new WalkFileTree());
        } catch (Exception exc) {
            System.err.println(exc.getMessage());
        }
    } // main

} // WalkFileTree
