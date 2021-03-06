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

import java.util.Locale;

/**
 * Define a triangle Shape with 3 equal sides
 * @author Georg Fischer &lt;dr.georg.fischer at gmail.com>&gt;
 */
public class Triangle extends Shape {
    
    /** No-args Constructor
     * 
     */
    public Triangle() {
        super();
    } // Triangle
    
    /** Constructor with all properties
     * @param color    filling color code (HTML RGB value, for example 0x44ff66
     * @param centerX  x coordinate of the center
     * @param centerY  y coordinate of the center
     * @param size     size of the object
     */
    public Triangle(int color, int centerX, int centerY, int size) {
        this.color = color;
        this.centerX = centerX;
        this.centerY = centerY;
        this.size = size;
    } // Shape

    /** Output SVG code for the Triangle
     * @return SVG code for drawing the Shape
     */
    @Override   
    public String toSVG() {
        // <path d="M150 0 L75 200 L225 200 Z" />
        Double dSize2  = size / 2.0;
        Double dHeight = Math.sqrt(size * size * 3.0 / 4.0); 
        String height  = String.format(Locale.ROOT, "%.2f ", dHeight);
        String height3 = String.format(Locale.ROOT, "%.2f ", dHeight / 3.0);
        String size2   = String.format(Locale.ROOT, "%.2f ", dSize2);
        return "<!--Triangle--><path d=\""
                + "M" + centerX + " " + centerY // absolute move to center
                + " m-" + size2 + "+" + height3 // relative move lower left corner
                + " l"  + size2 + "-" + height // relative line to upper corner
                + " l"  + size2 + "+" + height // lower right corner
                + " Z" // close path
                + "\" " + getStyle() + "/>";
    } // toSVG 

} // Triangle
