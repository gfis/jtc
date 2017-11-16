/* Represenation of a chess piece
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
package org.teherba.chess;

/**
 * Representation of a single chess piece.
 *
 * @author Georg Fischer &lt;dr.georg.fischer at gmail.com>&gt;
 */
public class Piece {

    /**
     * No-args constructor: a white queen
     */
    public Piece() {
        setColor(WHITE);
        setType(QUEEN);
        setCoordinates(-1, -1);
        setState(FIGHTING);
    } // constructor()

    /**
     * Constructor from color and type
     * @param color color of the new piece
     * @param type type of the new piece
     */
    public Piece(int color, int type) {
        setColor(color);
        setType(type);
        setCoordinates(-1, -1);
        setState(FIGHTING);
    } // constructor(int, int)

    /** Color code for black pieces */
    public static final int BLACK = 1;
    /** Color code for white pieces */
    public static final int WHITE = 0;
    /**
     * Color of the piece: BLACK or WHITE
     */
    private int color;
    
    /** Gets the color of <em>this</em> Piece
     * @return BLACK or WHITE
     */
    public int getColor() {
        return this.color;
    } // getColor
    
    /** Sets the color of <em>this</em> Piece
     * @param color BLACK or WHITE
     */
    public void setColor(int color) {
        this.color = color;
    } // setColor

    /**
     * Field where the piece is placed, or null: LOST
     */
    private int field;
    
    /** Gets the field 
     * @return Field where the piece is placed, or null: LOST
     */
    public int getField() {
        return this.field;
    } // getField
    
    /** Sets the field where the piece is placed, or null: LOST
     * @param field where the piece is placed, or null: LOST
     */
    public void setField(int field) {
        this.field = field;
    } // setField

    /** row number where the piece is currently placed, 0:7 or -1 for unknown */
    private int row;
    /** column number where the piece is currently placed, 0:7 or -1 for unknown */
    private int col;
    
    /** Gets the row coordinate of <em>this</em> Piece.
     * @return row index 0:7 or -1 for unknown
     */
    public int getRow() {
        return this.row;
    } // getRow
    
    /** Gets the column coordinate of <em>this</em> Piece.
     * @return column index 0:7 or -1 for unknown
     */
    public int getCol() {
        return this.col;
    } // getCol
    
    /** Sets the coordinates of <em>this</em> Piece.
     * @param row row    index 0:7 or -1 for unknown
     * @param col column index 0:7 or -1 for unknown
     */
    public void setCoordinates(int row, int col) {
        this.row = row;
        this.col = col;
    } // setCoordinates

    /** Gets the international position notation of <em>this</em> Piece.
     * @return "e1" for the pawn before the white king, for example
     */
    public String getPosition() {
        // return field.getPosition();
        return null;
   } // getPosition

    /** Caution, the following constants must be synchronized with the Unicodes */
    public static final int KING   = 0;
    public static final int QUEEN  = 1;
    public static final int ROOK   = 2;
    public static final int BISHOP = 3;
    public static final int KNIGHT = 4;
    public static final int PAWN   = 5; 
    /** type of the piece: king, queen, rook, bishop, knight, pawn */
    private int type; 
    
    /** Gets the type of <em>this</em> Piece
     * @return BLACK or WHITE
     */
    public int getType() {
        return this.type;
    } // getType
    
    /** Sets the type of <em>this</em> Piece
     * @param type BLACK or WHITE
     */
    public void setType(int type) {
        this.type = type;
    } // setType

    /** Gets the Unicode symbol for <em>this</em> piece
     * 
     * @return one of the Unicodes 265n
     */
    public String getSymbol() {
        String result = null;
        if (false) {
        } else if (color == WHITE) {
            result = String.valueOf('\u2654' + getType()); 
        } else if (color == BLACK) {
            result = String.valueOf('\u265A' + getType()); 
        }
        return result;
    } // getSymbol

    /** Code for active pieces */
    public static final int FIGHTING = 1;
    /** Code for lost   pieces */
    public static final int LOST     = 0;
    /**
     * State of the piece: FIGHTING or LOST
     */
    private int state;
    
    /** Gets the state of <em>this</em> Piece
     * @return FIGHTING or LOST
     */
    public int getState() {
        return this.state;
    } // getState
    
    /** Sets the state of <em>this</em> Piece
     * @param state FIGHTING or LOST
     */
    public void setState(int state) {
        this.state = state;
    } // setState

    /** Determines whether a piece is FIGHTING
     * @return true if state == FIGHTING, false otherwise
     */
    public boolean isActive() {
        return state == FIGHTING;
    } // isActive

    /**
     * Test program.
     * Shows the Unicode symbol of a whit queen
     * @param args commandline arguments (ignored)
     */
    public static void main(String[] args) {
        Piece whiteQueen = new Piece(Piece.WHITE, Piece.QUEEN);
        System.out.println(whiteQueen);
    } // method main
    
} // Piece()
