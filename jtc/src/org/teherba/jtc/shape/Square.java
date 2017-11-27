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
public class Square extends Shape {
    
    /** No-args Constructor
     * 
     */
    public Square() {
        super();
    } // Shape
    
    /** Constructor with all properties
     * @param color    filling color code (HTML RGB value, for example 0x44ff66
     * @param centerX  x coordinate of the center
     * @param centerY  y coordinate of the center
     * @param size     size of the object
     */
    public Square(int color, int centerX, int centerY, int size) {
        this.color = color;
        this.centerX = centerX;
        this.centerY = centerY;
        this.size = size;
    } // Square

    /** Output SVG code for the Circle
     * @return SVG code for drawing the Shape
     */
    @Override   
    public String toSVG() {
        // <circle cx="40" cy="40" r="24" style="stroke:#006600; fill:#00cc00"/>
        return "<rect x=\""
                + String.valueOf(centerX - size/2)
                + "\" y=\""
                + String.valueOf(centerY - size/2)
                + "\" height=\"" 
                + size
                + "\" width=\"" 
                + size
                + "\""
                + getStyle()
                + "/>"
                ;
    } // toSVG 

} // Square
