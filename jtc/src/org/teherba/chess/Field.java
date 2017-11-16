/* Represenation of a chess field
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
 * Representation of a single chess field on a ChessBoard
 *
 * @author Georg Fischer &lt;dr.georg.fischer at gmail.com>&gt;
 */
public class Field {

    public static final int BLACK = 1;
    public static final int WHITE = 0;
    /**
     * Color of the field: BLACK or WHITE
     */
    public int color;
    
    /** *  Get the color of <em>this</em> Field
     * @returns BLACK or WHITE
     */
    public int getColor() {
        return this.color;
    } // getColor

    /**
     * International code for the field's position on the board, for example
     * "d2" for the white pawn before the white queen on "d1".
     */
    public String position;
    
    /** row number 0:7 -> 1 to 8*/
    public int row;
    /** col number 0:7 -> a to h*/
    public int col;

    /**
     * Piece on the field, or NO_PIECE
     */
    private Piece piece;
    
    /** Set the piece on the field
     * @param piece piece to be set
     * @return the previous piece on the field
     */
    public Piece setPiece(Piece piece) {
        Piece result = this.piece;
        this.piece = piece;
        return result;
    } // setPiece

    /** Get the piece on the field
     * @return the current piece on the field
     */
    public Piece getPiece() {
        return this.piece;
    } // getPiece

    /**
     * No-args constructor: no piece on it
     */
    public Field() {
        // setPiece(Piece.NO_PIECE);
    } // constructor Field()

    private static String letters = "abcdefgh";
    private static String digits  = "12345678";

    /**
     * Constructor with position
     *
     * @param position position of the new field
     */
    public Field(String position) {
        this();
        this.position = position.toLowerCase();
        char letter = this.position.charAt(0);
        char digit  = this.position.charAt(1);
        row    = digits.indexOf(digit);
        col = letters.indexOf(letter);
        setColor();
    } // Constructor(position)
    
    /**
     * Constructor with position
     * @param row Java row number 0:7
     * @param col Java column number 0:7
    */
    public Field(int row, int col) {
        this();
        this.row = row;
        this.col = col;
        position = letters.substring(col, col + 1) 
                 + digits .substring(row, row + 1);
        setColor();
    } // Constructor(position)
    
    /**
     * Constructor with position
     * @param position position of the new field
     * @param piece piece to be set on the field, or NO_PIECE
     */
    public Field(String position, String piece) {
        this(position);
        // setPiece(piece);
    } // Constructor(position, piece)

    public void setColor() {
        this.color = BLACK;
        if (false) {
        } else if (row % 2 == 0 && col % 2 == 1) { // even row and odd col
            this.color = WHITE;
        } else if (row % 2 == 1 && col % 2 == 0) { // odd row and even col
            this.color = WHITE;
        }
    } // setColor

    /**
     * Test program.
     * Prints a single field with some symbol
      * @param args commandline arguments (ignored)
     */
    public static void main(String[] args) {
        Field field = new Field(); // ("d1", Piece.QUEEN);
        System.out.println("<html><body>"
                + "<table border=\"1\"><tr><td>"
                + "<span style=\"background-color:"
                +       (field.color == WHITE ? "lightyellow" : "silver")
                +       "\">" // close span's start tag
                + field.getPiece()
                + "</span>"
                + "</td></tr></table>"
                + "</body></html>");
    } // method main
    
} // Field()

