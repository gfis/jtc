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
 * General class for geomatrical shapes.
 * @author Georg Fischer &lt;dr.georg.fischer at gmail.com>&gt;
 */
public class Shape {
    /** Fill the Shape with this color
     */
    public int color;
    
    /** horizontal coordinate of the center point
      * left -> right
     */
    public int centerX;
    
    /** vertical coordinate of the center point.
     * top -> bottom
     */
    public int centerY;
    
    /** extension, size pf the Shape
     */
    public int size;
    
    /** No-args Constructor
     * 
     */
    public Shape() {
        color = 0;
        centerX = 0;
        centerY = 0;
        size = 0;
    } // Shape
    
    /** Constructor with all properties
     * @param color
     * @param centerX
     * @param centerY
     * @param size
     */
    public Shape(int color, int centerX, int enterY, int size) {
        this.color = color;
        this.centerX = centerX;
        this.centerY = centerY;
        this.size = size;
    } // Shape

    /** Output SVG code for the Shape
     * @return SVG code for drawing the Shape
     */
    public String toSVG() {
        return "";
    } // toSVG
    
    /** Output SVG code for the header of the drawing
     * @return SVG declaration, viewport etc.
     */
    public String startDrawing() {
        return
"<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n" +
"<!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 1.0//EN\"\n" +
" \"http://www.w3.org/TR/2001/REC-SVG-20010904/DTD/svg10.dtd\" [\n" +
" <!ATTLIST svg xmlns:xlink CDATA #FIXED \"http://www.w3.org/1999/xlink\">\n" +
"]>\n" +
"<svg width=\"200mm\" height=\"200mm\"\n" +
"    viewBox=\"0 0 100 100\" \n" +
"    xmlns=\"http://www.w3.org/2000/svg\"\n" + 
"    xmlns:xlink=\"http://www.w3.org/1999/xlink\"\n" +
"    >\n" +
"<title>Shapes</title>\n"
;
    } // startDrawing
    
    /** Output SVG code for the header of the drawing
     * @return SVG declaration, viewport etc.
     */
    public String endDrawing() {
        return "</svg>\n";
    } // endDrawing
    
    /**
     * Test program
     * @param args commandline arguments
     */
    public static void main(String[] args) {
        if (args.length == 0) { // set default arguments
            args = new String[] { "", "", "", "" };
        } // set default arguments
        Shape shape = new Circle(0x223344, 50, 50, 20);
        System.out.println(shape.startDrawing());
        System.out.println(shape.toSVG());
        System.out.println(shape.endDrawing());
    } // main
    
} // Shape
