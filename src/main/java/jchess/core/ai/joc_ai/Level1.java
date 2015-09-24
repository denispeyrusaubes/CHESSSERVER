/*
#    This program is free software: you can redistribute it and/or modify
#    it under the terms of the GNU General Public License as published by
#    the Free Software Foundation, either version 3 of the License, or
#    (at your option) any later version.
#
#    This program is distributed in the hope that it will be useful,
#    but WITHOUT ANY WARRANTY; without even the implied warranty of
#    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
#    GNU General Public License for more details.
#
#    You should have received a copy of the GNU General Public License
#    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package jchess.core.ai.joc_ai;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import jchess.core.Chessboard;
import jchess.core.Game;
import jchess.core.Square;
import jchess.core.ai.AI;
import jchess.core.moves.Move; 
import jchess.core.pieces.Piece;
import jchess.core.pieces.implementation.Pawn;
import jchess.core.pieces.implementation.Queen;

/**
 * Basic AI implementation with random moves.
 * @author Mateusz Sławomir Lach (matlak, msl)
 */
public class Level1 implements AI
{

    @Override
    public Move getMove(Game game, Move lastMove)
    {
        Chessboard chessboard = game.getChessboard();
        List<Piece> pieces = chessboard.getAllPieces(game.getActivePlayer().getColor());
        List<Piece> moveAblePieces = new ArrayList<>();
        
        for (Piece piece : pieces)
        {
            if (0 < piece.getAllMoves().size())
            {
                moveAblePieces.add(piece);
            }
        }
        
        int size = moveAblePieces.size();
        Random rand = new Random();
        int random = rand.nextInt(size);
       
        Piece piece = moveAblePieces.get(random);
        Piece promotedPiece = null;
        size = piece.getAllMoves().size();
        random = rand.nextInt(size);
        
        List<Square> squares = new ArrayList<>(piece.getAllMoves());
        Square sq = squares.get(random);
        if (piece instanceof Pawn)
        {
            if (Pawn.canBePromoted(sq)) 
            {
                promotedPiece = new Queen(chessboard, game.getActivePlayer());
            }
        }
        return new Move(piece.getSquare(), sq, piece, sq.getPiece(), promotedPiece);
    }
    
}
