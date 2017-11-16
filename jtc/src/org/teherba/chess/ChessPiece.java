/* Represenation of a chess piece
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
public class ChessPiece {

    public static final int BLACK = 1;
    public static final int WHITE = 0;
    /**
     * Color of the field: BLACK or WHITE
     */
    public int color;
    
    /** Get the color of <em>this</em> ChessField
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

    public static final String NO_PIECE = "&#x2800;";
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
    private String pieceType;
    
    /** Set the piece on the field
     * @param pieceType type of the piece to be set
     * @return the previous piece type on the field
     */
    public String setPieceType(String pieceType) {
        String result = this.pieceType;
        this.pieceType = pieceType;
        return result;
    } // setPieceType

    /** Get the piece on the field
     * @return the current piece on the field
     */
    public String getPieceType() {
        return this.pieceType;
    } // getPieceType

    /**
     * No-args constructor: no piece on it
     */
    public ChessPiece() {
        setPieceType(NO_PIECE);
    } // constructor()

    /**
     * Constructor from int
     */
    public ChessPiece(String pieceType) {
        setPieceType(pieceType);
    } // constructor(String)

    private static String letters = "abcdefgh";
    private static String digits  = "12345678";

    /**
     * Test program.
     * Prints a single field with some symbol
      * @param args commandline arguments (ignored)
     */
    public static void main(String[] args) {
    /*
        ChessPiece field = new ChessPiece("d1", ChessPiece.WHITE_QUEEN);
        System.out.println("<html><body>"
                + "<table border=\"1\"><tr><td>"
                + "<span style=\"background-color:"
                +       (field.color == WHITE ? "lightyellow" : "silver")
                +       "\">" // close span's start tag
                + field.getPiece()
                + "</span>"
                + "</td></tr></table>"
                + "</body></html>");
    */
    } // method main
    
} // ChessPiece()

