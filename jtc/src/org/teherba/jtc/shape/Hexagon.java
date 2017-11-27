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
public class Hexagon extends Shape {
    
    /** No-args Constructor
     * 
     */
    public Hexagon() {
        super();
    } // Triangle
    
    /** Constructor with all properties
     * @param color    filling color code (HTML RGB value, for example 0x44ff66
     * @param centerX  x coordinate of the center
     * @param centerY  y coordinate of the center
     * @param size     size of the object
     */
    public Hexagon(int color, int centerX, int centerY, int size) {
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
        Double dSize2  = size / 2.0;
        Double dHeight = Math.sqrt(dSize2 * dSize2 * 3.0 / 4.0); 
        String height  = String.format(Locale.ROOT, "%.2f ", dHeight);
        String height3 = String.format(Locale.ROOT, "%.2f ", dHeight / 3.0);
        String size2   = String.format(Locale.ROOT, "%.2f ", dSize2);
        String size4   = String.format(Locale.ROOT, "%.2f ", dSize2 / 2.0);
        return "<!--Hexagon--><path d=\""
                + "M" + centerX + " " + centerY // absolute move to center
                + " m-" + height + "+" + size4 // relative move to lower left corner
                + " l"  + "0"    + "-" + size2 // upper left corner
                + " l"  + height + "-" + size4 // top corner
                + " l"  + height + "+" + size4 // upper right corner
                + " l"  + "0"    + "+" + size2 // lower right corner
                + " l-" + height + "+" + size4 // bottom corner
                + " Z" // close path
                + "\" " + getStyle() + "/>";
    } // toSVG 

} // Triangle
