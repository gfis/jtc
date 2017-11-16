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
package org.teherba.chess;
/**
 * Representation of a chess player with its pieces
 * @author Georg Fischer &lt;dr.georg.fischer at gmail.com>&gt;
 */
public class Player {
    /** The set of pieces for a Player. */
    public Piece[] pieces;
    
    /** No-args constructor
     */
    public Player() {
        pieces = new Piece[8+8];
    } // Constructor()
    
      /** Constructor with color
     */
    public Player(int color) {
        this();
        int ip = 0;
        pieces[ip ++] = new Piece(color, Piece.ROOK);
        pieces[ip ++] = new Piece(color, Piece.KNIGHT);
        pieces[ip ++] = new Piece(color, Piece.BISHOP);
        pieces[ip ++] = new Piece(color, Piece.QUEEN);
        pieces[ip ++] = new Piece(color, Piece.KING);
        pieces[ip ++] = new Piece(color, Piece.BISHOP);
        pieces[ip ++] = new Piece(color, Piece.KNIGHT);
        pieces[ip ++] = new Piece(color, Piece.ROOK);
        while (ip < 16) {
            pieces[ip ++] = new Piece(color, Piece.PAWN);
        } // while PAWNs
        // remember that pawns later can be converted to queens.
    } // Constructor(int)

    /** Shows all FIGHTING pieces of a player with their positions
     * @return HTML table 
     */
    public String toTable() {
        StringBuffer result = new StringBuffer(256);
        result.append("<table style=\"border-collapse: collapse; border: 1px solid black\">");
        int ip = 0;
        while (ip < pieces.length) {
            if (pieces[ip].isActive()) {
                result.append("<tr>");
                result.append("<td>");
                result.append(pieces[ip].getSymbol());
                result.append("</td>");
                result.append("</tr>");
            }
            ip ++;
        }
        result.append("</table>");
        return result.toString();
    } // toString
    
    /**
     * Test program.
     * Prints a single field with some symbol
     * @param args commandline arguments (ignored)
     */
    public static void main(String[] args) {
        Player player = new Player(Piece.WHITE);
        System.out.println(player.toTable());
    } // method main
  
} // Board
