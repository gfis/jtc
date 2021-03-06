/* Representation of a chess board of 64 Fields
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
package org.teherba.jtc.game;

/**
 * Representation of a chess game with a board of 8x8 {@link Fields} and 2
 * {@link ChessPlayer}s
 *
 * @author Georg Fischer &lt;dr.georg.fischer at gmail.com>&gt;
 */
public class ChessGame {

    /**
     * current state of the 8x8 fields of the board
     */
    private ChessField[][] board;

    /**
     * Gets a {@link ChessField} of the board
     *
     * @param row ChessField coordinate
     * @param col ChessField coordinate
     * @return the specified ChessField
     */
    public ChessField getField(int row, int col) {
        return board[row][col];
    } // getField

    /**
     * current state of the 2 {@link ChessPlayer}s
     */
    private ChessPlayer[] players;

    /**
     * No-args constructor: fills the {@link #board} with the initial piece
     * configuration
     */
    public ChessGame() {
        board = new ChessField[8][8];
        int row = 0;
        while (row < 8) { // preset all Fields
            int col = 0;
            while (col < 8) {
                ChessField field = new ChessField(row, col);
                field.setPiece(new ChessPiece(ChessPiece.WHITE, ChessPiece.EMPTY)); // empty
                board[row][col] = field;
                col++;
            } // while col
            row++;
        } // while row

        players = new ChessPlayer[2];
        players[ChessPiece.WHITE] = new ChessPlayer(this, ChessPiece.WHITE);
        players[ChessPiece.BLACK] = new ChessPlayer(this, ChessPiece.BLACK);
    } // Constructor()

    /**
     * Returns an HTML display of the current setting of the board
     * @return an HTML table
     */
    public String toHTML() {
        StringBuffer result = new StringBuffer(256);
        result.append("<table>\n");
        int row = 8 - 1;
        while (row >= 0) { // preset all Fields
            result.append("<tr id=\"");
            result.append(String.valueOf(row));
            result.append("\">");
            int col = 0;
            while (col < 8) {
                result.append(getField(row, col).toHTML());
                col++;
            } // while col
            result.append("</tr>\n");
            row--;
        } // while row
        result.append("</table>");
        return result.toString();
    } // toHTML

    /**
     * Test program. Prints a single field with some symbol
     *
     * @param args commandline arguments (ignored)
     */
    public static void main(String[] args) {
        System.out.println("<html><head><style>");
        System.out.println("table{\n"
                + "   border-collapse: collapse; border: 1px solid black; \n"
                + "}\n"
                + "th, td { text-align: center;\n"
                + "    width: 20px;\n"
                + "}");
        System.out.println("</style></head><body>");
        ChessGame game = new ChessGame();
        System.out.println(game.toHTML());
        System.out.println("</body></html>");
    } // method main

} // ChessGame
