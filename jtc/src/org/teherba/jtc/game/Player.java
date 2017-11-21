/* Representation of a chess player and his pieces
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
import org.teherba.jtc.game.Game;
import org.teherba.jtc.game.Piece;
/**
 * Representation of a chess player with its pieces
 * @author Georg Fischer &lt;dr.georg.fischer at gmail.com>&gt;
 */
public class Player {
    /** The set of 16 pieces for one Player. */
    private Piece[] pieces;

    /** The overall {@link Game} object. */
    private Game game;

    /** No-args constructor
     */
    public Player() {
    } // Constructor()

    /** Constructor with color, assigns 8+8 {@link Piece}s to this Player
     *  @param game overall {@link Game} object
     *  @oaram color color of the Player's pieces
     */
    public Player(Game game, int color) {
        this.game = game;
        pieces = new Piece[8+8];
        int ip = 0;
        // the following ordering must correspond to the layout of the board
        pieces[ip ++] = new Piece(color, Piece.ROOK);
        pieces[ip ++] = new Piece(color, Piece.KNIGHT);
        pieces[ip ++] = new Piece(color, Piece.BISHOP);
        pieces[ip ++] = new Piece(color, Piece.QUEEN);
        pieces[ip ++] = new Piece(color, Piece.KING);
        pieces[ip ++] = new Piece(color, Piece.BISHOP);
        pieces[ip ++] = new Piece(color, Piece.KNIGHT);
        pieces[ip ++] = new Piece(color, Piece.ROOK);
        while (ip < 16) { // now 8 pawns
            pieces[ip ++] = new Piece(color, Piece.PAWN);
        } // while PAWNs
        // Remember that pawns later can be converted to queens.
        resetPieces();
    } // Constructor(Game,int)

    /** Sets all {@link Piece}s of <em>this</em> Player to their starting fields,
     *  and make them active
     */
    public void resetPieces() {
        int ip = 0;
        while (ip < 8) { // valuable pieces
            if (false) {
            } else if (pieces[ip].getColor() == Piece.WHITE) {
                game.getField(0, ip).setPiece(pieces[ip + 0]); // valueable pieces
                game.getField(1, ip).setPiece(pieces[ip + 8]); // pawns
            } else if (pieces[ip].getColor() == Piece.BLACK) {
                game.getField(7, ip).setPiece(pieces[ip + 0]); // valueable pieces
                game.getField(6, ip).setPiece(pieces[ip + 8]); // pawns
            }
            ip ++;
        } // while valuabe pieces
    } // resetPieces()

    public String toHTML() {
        StringBuffer result = new StringBuffer(256);
        result.append("<table style=\"border-collapse: collapse; border: 1px solid black\">\n");
        int ip = 0;
        while (ip < pieces.length) {
            if (pieces[ip].isActive()) {
                result.append("<tr>");
                result.append("<td>");
                result.append(pieces[ip].getSymbol());
                result.append("</td>");
                result.append("<td>");
                result.append(pieces[ip].getPosition());
                result.append("</td>");
                result.append("</tr>\n");
            }
            ip ++;
        }
        result.append("</table>");
        return result.toString();
    } // toHTML

    /**
     * Test program.
     * Prints a single field with some symbol
     * @param args commandline arguments (ignored)
     */
    public static void main(String[] args) {
        Game game = new Game();
        Player player = new Player(game, Piece.BLACK);
        System.out.println("<html><head><style>");
        System.out.println("table{\n" +
"   border-collapse: collapse; border: 1px solid black; \n" +
"}\n" +
"th, td {\n" +
"    width: 24px;\n" +
"}");
        System.out.println("</style></head><body>");
        System.out.println(player.toHTML());
        System.out.println("</body></html>");
    } // method main

} // Player
