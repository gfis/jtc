/* Represenation of a chess field
 * Java Training Course example file
 * 2017-11-15, Georg Fischer
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
public class ChessField {

    public static final short BLACK = 1;
    public static final short WHITE = 0;
    /**
     * Color of the field: BLACK or WHITE
     */
    public short color;

    /**
     * International code for the field's position on the board, for example
     * "d2" for the white pawn before the white queen on "d1".
     */
    public String position;
    
    /** row number 0:7 -> 1 to 8*/
    public int row;
    /** column number 0:7 -> a to h*/
    public int column;

    public static final String NO_PIECE = "";
    public static final String WHITE_KING = "&#x2654;";
    public static final String WHITE_QUEEN = "&#x2655;";
    public static final String WHITE_ROOK = "&#x2656;";
    public static final String WHITE_BISHOP = "&#x2657;";
    public static final String WHITE_KNIGHT = "&#x2658;";
    public static final String WHITE_PAWN = "&#x2659;"; 
    public static final String BLACK_KING = "&#x265A;";
    public static final String BLACK_QUEEN = "&#x265B;";
    public static final String BLACK_ROOK = "&#x265C;";
    public static final String BLACK_BISHOP = "&#x265D;";
    public static final String BLACK_KNIGHT = "&#x265E;";
    public static final String BLACK_PAWN = "&#x265F;";

    /**
     * Piece on the field, or NO_PIECE
     */
    public String piece;

    /**
     * No-args constructor: no piece on it
     */
    public ChessField() {
        piece = NO_PIECE;
    } // ChessField()

    private static String letters = "abcdefgh";
    private static String digits  = "12345678";

    /**
     * Constructor with position
     *
     * @param position position of the new field
     */
    public ChessField(String position) {
        this();
        this.position = position.toLowerCase();
        char letter = this.position.charAt(0);
        char digit  = this.position.charAt(1);
        row    = digits.indexOf(digit);
        column = letters.indexOf(letter);
        setColor();
   
    } // Constructor(position)
    
    /**
     * Constructor with position
     * @param row Java row number 0:7
     * @param column Java column number 0:7
    */
    public ChessField(int row, int column) {
        this();
        this.row = row;
        this.column = column;
        position = letters.substring(column, column + 1) 
                 + digits .substring(row, row + 1);
        setColor();
    } // Constructor(position)
    
    /**
     * Constructor with position
     * @param position position of the new field
     * @param piece piece to be set on the field, or NO_PIECE
     */
    public ChessField(String position, String piece) {
        this(position);
        this.piece = piece;
    } // Constructor(position, piece)

    public void setColor() {
        this.color = BLACK;
        if (false) {
        } else if (row % 2 == 0 && column % 2 == 1) { // even row and odd column
            this.color = WHITE;
        } else if (row % 2 == 1 && column % 2 == 0) { // odd row and even column
            this.color = WHITE;
        }
    } // setColor

    /** Set the piece of the field
     * 
     * @param piece one of the constants BLACK_PAWN etc.
     */
    public void setPiece(String piece) {
        this.piece = piece;
    } // setPiece

    /**
     * Test program.
     * Prints a single field with some symbol
      * @param args commandline arguments (ignored)
     */
    public static void main(String[] args) {
        ChessField field = new ChessField("d1", ChessField.WHITE_QUEEN);
        System.out.println("<html><body>"
                + "<table border=\"1\"><tr><td>"
                + "<span style=\"background-color:"
                +       (field.color == WHITE ? "lightyellow" : "silver")
                +       "\">" // close span's start tag
                + field.piece
                + "</span>"
                + "</td></tr></table>"
                + "</body></html>");
    } // method main
    
} // ChessField()

