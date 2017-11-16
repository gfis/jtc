package org.teherba.chess;

/* Representation of a chess board of 64 ChessFields
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
/**
 * Representation of a chess board of 64 ChessFields
 * @author Georg Fischer &lt;dr.georg.fischer at gmail.com>&gt;
 */
public class ChessBoard {
    public ChessField[][] board;
    
    /** No-args constructor: fills the board with the initial piece configuratio
     */
    public ChessBoard() {
        board = new ChessField[8][8]; 
        // preset all fields with NO_PIECE
        int row = 0;
        int col = 0;
        for (row = 0; row < 8; row ++) {
            for (col = 0; col < 8; col ++) {
                board[row][col] = new ChessField(row, col);
            } // for col
        } // for row
        
        row = 1; 
        for (col = 0; col < 8; col ++) {
            setPiece(row, col, new ChessPiece(ChessPiece.WHITE_PAWN));
        } // for col
        row = 6; 
        for (col = 0; col < 8; col ++) {
            setPiece(row, col, new ChessPiece(ChessPiece.BLACK_PAWN));
        } // for col
        
        setPiece(0, 0, new ChessPiece(ChessPiece.WHITE_ROOK));
        setPiece(0, 7, new ChessPiece(ChessPiece.WHITE_ROOK));
        setPiece(7, 0, new ChessPiece(ChessPiece.BLACK_ROOK));
        setPiece(7, 7, new ChessPiece(ChessPiece.BLACK_ROOK));
        
        setPiece(0, 1, new ChessPiece(ChessPiece.WHITE_KNIGHT));
        setPiece(0, 6, new ChessPiece(ChessPiece.WHITE_KNIGHT));
        setPiece(7, 1, new ChessPiece(ChessPiece.BLACK_KNIGHT));
        setPiece(7, 6, new ChessPiece(ChessPiece.BLACK_KNIGHT));
        
        setPiece(0, 2, new ChessPiece(ChessPiece.WHITE_BISHOP));
        setPiece(0, 5, new ChessPiece(ChessPiece.WHITE_BISHOP));
        setPiece(7, 2, new ChessPiece(ChessPiece.BLACK_BISHOP));
        setPiece(7, 5, new ChessPiece(ChessPiece.BLACK_BISHOP));
        
        setPiece(0, 3, new ChessPiece(ChessPiece.WHITE_QUEEN));
        setPiece(0, 4, new ChessPiece(ChessPiece.WHITE_KING));
        setPiece(7, 3, new ChessPiece(ChessPiece.BLACK_QUEEN));
        setPiece(7, 4, new ChessPiece(ChessPiece.BLACK_KING));
    } // Constructor()

    /** Set a piece on one field
     * @param row row whete to set the piece
     * @param col column where to set the piece
     * @param piece the piece to be set
     * @return the previous piece on the field, maybe NO_PIECE
     */
    public ChessPiece setPiece(int row, int col, ChessPiece piece) {
        ChessPiece result = board[row][col].getPiece();
        board[row][col].setPiece(piece);
        return result;
    } // setPiece

    /** Shows an HTML display of the current setting of the board 
     */
    public void show() {
        System.out.println("<table border=\"1\">");
        for (int row = 7; row >= 0; row --) {
            System.out.print("<tr style=\"\">");
            for (int col = 0; col <= 7; col ++) {
                System.out.print("<td align=\"center\">"
                        + "<span style=\"background-color:"
                        +       (board[row][col].getColor() == ChessPiece.WHITE ? "lightyellow" : "silver")
                        +       "\">" // close span's start tag
                        + board[row][col].getPiece().getPieceType()
                        + "</span>"
                        + "</td>");
            } // for col
            System.out.println("</tr>");
        } // for row
        System.out.println("</table>");       
    } // show
    
    /**
     * Test program.
     * Prints a single field with some symbol
     * @param args commandline arguments (ignored)
     */
    public static void main(String[] args) {
        ChessBoard board = new ChessBoard();
        board.show();
        
        System.out.println("</body></html>");
    } // method main
  
} // ChessBoard
