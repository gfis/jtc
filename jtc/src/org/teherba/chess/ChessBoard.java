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
        for (int row = 0; row < 8; row ++) {
            for (int column = 0; column < 8; column ++) {
                board[row][column] = new ChessField(row, column);
            } // for column
        } // for row
        
        
    } // Constructor()
    
} // ChessBoard
