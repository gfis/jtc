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
    private int color;

    /**
     * * Get the color of <em>this</em> Field
     *
     * @returns BLACK or WHITE
     */
    public int getColor() {
        return this.color;
    } // getColor

    /** Sets the Field's color corresponding to its coordinates
     */
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
     * row coordinate 0:7 -> 1 to 8
     */
    private int row;
    /**
     * column coordinate 0:7 -> a to h
     */
    private int col;

    /**
     * Piece on the field, or EMPTY
     */
    private Piece piece;

    /**
     * Get the piece on the field
     *
     * @return the current piece on the field
     */
    public Piece getPiece() {
        return this.piece;
    } // getPiece

    /**
     * Set the piece on the field
     *
     * @param piece piece to be set
     */
    public void setPiece(Piece piece) {
        this.piece = piece;
    } // setPiece

    /**
     * No-args constructor: no piece on it
     */
    public Field() {
    } // constructor Field()

    /**
     * Constructor with coordinates
     *
     * @param row Java row number 0:7
     * @param col Java column number 0:7
     */
    public Field(int row, int col) {
        this();
        this.row = row;
        this.col = col;
        setColor();
    } // Constructor(position)

    // Conversion between coordinates and international position notation
    private static String letters = "abcdefgh";
    private static String digits = "12345678";

    /**
     * Get a Field's position corresponding to its coordinates
     *
     * @return for example "e2" for the pawn before the white king
     */
    public String getPosition() {
        return   letters.substring(col, col + 1)
                + digits.substring(row, row + 1);
    } // setCoordinates

    /**
     * Set a Field's coordinates corresponding to the internation notaation of
     * the position.
     *
     * @param position for example "e2" for the pawn before the white king
     */
    public void setCoordinates(String position) {
        char letter = position.toLowerCase().charAt(0);
        char digit = position.charAt(1);
        this.row = digits.indexOf(digit);
        this.col = letters.indexOf(letter);
    } // setCoordinates

     /** Gets the Unicode symbol for <em>this</em> Field
     * 
     * @return one of the Unicodes 265n
     */
    public String getSymbol() {
        return getPiece().getSymbol();
    } // getSymbol

    /**
     * Display the Field
     *
     * @return an HTML representation of the current setting of the board
     */
    public String toHTML() {
        StringBuffer result = new StringBuffer(256);
        result.append("<td style=\"background-color:");
        result.append(getColor() == WHITE ? "lightyellow" : "silver");
        result.append("\" title=\"");
        result.append(getPosition());
        result.append("\">"); // close td start tag
        result.append(getPiece().toHTML());
        result.append("</td>");
        return result.toString();
    } // toHTML

    /**
     * Constructor with position
     *
     * @param position position of the new field
     * @param piece piece to be set on the field, or NO_PIECE
     */
    public Field(String position, Piece piece) {
        this();
        setCoordinates(position);
        setPiece(piece);
   } // Constructor(position, piece)

    /**
     * Test program. Prints a single field with some symbol
     *
     * @param args commandline arguments (ignored)
     */
    public static void main(String[] args) {
        Field field = new Field(0, 3); // ("d1", Piece.QUEEN);
        field.setPiece(new Piece(Piece.WHITE, Piece.QUEEN));
        System.out.println(field.toHTML());
    } // method main

} // Field()

