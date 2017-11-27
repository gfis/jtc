/* 
 * Java Training Course example file
 * 2017-11-27, Georg Fischer
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

package org.teherba.jtc.shape;

/**
 * Class which delivers instances of Shapes.
 * @author Georg Fischer &lt;dr.georg.fischer at gmail.com>&gt;
 */
public class ShapeFactory {
    
    /** Stores the names of the Shapes */
    private String[] shapeNames;
    
    /** No-args Constructor
     * 
     */
    public ShapeFactory() {
        shapeNames = new String[] 
                { "Circle"
                , "Square"
                , "Triangle"
                , "Hexagon"
                };
         // + Diamond, Pentagon, Hexagon etc.
    } // Shape
    
    /** Get the number of possible Shapes
     * @return the size of array shapeNames
     */
    public int size() {
        return shapeNames.length;
    } // size
    
    /** Gets an instance of a Shape
     * @param shapeType sequential index 0, 1, 2 and so on
     * @return Shape instance
     */
    public Shape getShape(int shapeType) {
        Shape result = null;
        try {
            String shapeName = shapeNames[shapeType];
            result = (Shape) Class.forName("org.teherba.jtc.shape." 
                    + shapeName).newInstance();
        } catch (Exception exc) {
            System.err.println(exc.getMessage());
            exc.printStackTrace();
        } // try
        return result;
    } // getShape
    
    /**
     * Test program
     * @param args commandline arguments
     */
    public static void main(String[] args) {
        if (args.length == 0) { // set default arguments
            args = new String[] { "", "", "", "" };
        } // set default arguments
    } // main
    
} // Shape
