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
            board[row][col].setPiece(ChessField.WHITE_PAWN);
        } // for col
        row = 6; 
        for (col = 0; col < 8; col ++) {
            board[row][col].setPiece(ChessField.BLACK_PAWN);
        } // for col
        
        board[0][0].setPiece(ChessField.WHITE_ROOK);
        board[0][7].setPiece(ChessField.WHITE_ROOK);
        board[7][0].setPiece(ChessField.BLACK_ROOK);
        board[7][7].setPiece(ChessField.BLACK_ROOK);
        
        board[0][1].setPiece(ChessField.WHITE_KNIGHT);
        board[0][6].setPiece(ChessField.WHITE_KNIGHT);
        board[7][1].setPiece(ChessField.BLACK_KNIGHT);
        board[7][6].setPiece(ChessField.BLACK_KNIGHT);
        
        board[0][2].setPiece(ChessField.WHITE_BISHOP);
        board[0][5].setPiece(ChessField.WHITE_BISHOP);
        board[7][2].setPiece(ChessField.BLACK_BISHOP);
        board[7][5].setPiece(ChessField.BLACK_BISHOP);
        
        board[0][3].setPiece(ChessField.WHITE_QUEEN);
        board[0][4].setPiece(ChessField.WHITE_KING);
        board[7][3].setPiece(ChessField.BLACK_QUEEN);
        board[7][4].setPiece(ChessField.BLACK_KING);
        
    } // Constructor()
    
} // ChessBoard
