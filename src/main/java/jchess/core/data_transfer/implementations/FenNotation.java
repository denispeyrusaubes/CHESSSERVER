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
package jchess.core.data_transfer.implementations;

import jchess.core.Chessboard;
import jchess.core.Colors;
import jchess.core.Game;
import jchess.core.Square;
import jchess.core.data_transfer.DataExporter;
import jchess.core.data_transfer.DataImporter;
import jchess.core.moves.Move;
import jchess.core.pieces.Piece;
import jchess.core.pieces.implementation.King;
import jchess.core.pieces.implementation.Pawn;
import jchess.core.pieces.implementation.Rook;

/**
 *
 * @author Mateusz Sławomir Lach (matlak, msl)
 */
public class FenNotation implements DataImporter, DataExporter
{
    
    public static final String ROW_SEPARATOR = "/";
    
    public static final String FIELD_SEPARATOR = " ";
    
    public static final String FIELD_EMPTY = "-";

    @Override
    public Game importData(String data)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String exportData(Game game)
    {
        String result = "";
        result += exportChessboardFields(game);
        result += FIELD_SEPARATOR;
        result += exportActivePlayer(game);
        result += FIELD_SEPARATOR;
        result += exportCastlingState(game);
        result += FIELD_SEPARATOR;
        result += exportEnPassantState(game);
        result += FIELD_SEPARATOR;
        result += exportHalfCounter(game);
        result += exportFullMoveCounter(game);
        return result;
    }

    private int exportHalfCounter(Game game) 
    {
        Object[] moves = game.getMoves().getMoveBackStack().toArray();
        Move move;
        int halfCounter = 0;
        for (int i = moves.length - 1; i >= 0; i--)
        {
            move = (Move)moves[i];
            if (!(move.getMovedPiece() instanceof Pawn) && null == move.getTakenPiece())
            {
                halfCounter++;
            }
            else
            {
                break;
            }
        }
        return halfCounter;
    }

    private String exportFullMoveCounter(Game game) 
    {
        String result = "";
        int size = game.getMoves().getMoveBackStack().size();
        result += FIELD_SEPARATOR + (((int)(size / 2)) + 1);
        return result;
    }

    private String exportEnPassantState(Game game) 
    {
        String result = "";
        Pawn pawn = (Pawn)game.getChessboard().getTwoSquareMovedPawn();
        if (null != pawn)
        {
            Square pawnSquare = pawn.getSquare();
            Square testSquare = null;
            if (Colors.WHITE == pawn.getPlayer().getColor())
            {
                testSquare = new Square(pawnSquare.getPozX(), pawnSquare.getPozY() + 1, null);
            }
            else
            {
                testSquare = new Square(pawnSquare.getPozX(), pawnSquare.getPozY() - 1, null);
            }
            result += testSquare.getAlgebraicNotation();
        }
        else
        {
            result += FIELD_EMPTY;
        }
        return result;
    }

    private String exportCastlingState(Game game) 
    {
        String result = "";
        Chessboard chessboard = game.getChessboard();
        King whiteKing = chessboard.getKingWhite();
        King blackKing = chessboard.getKingBlack();
        if (!whiteKing.getWasMotioned())
        {
            Piece piece = chessboard.getSquare(0, 7).getPiece();
            if (piece instanceof Rook)
            {
                Rook rightRook = (Rook)piece;
                if (rightRook.getWasMotioned())
                {
                    result += FIELD_EMPTY;
                }
                else 
                {
                    result += "K";
                }
            }
            
            piece = chessboard.getSquare(7, 7).getPiece();
            if (piece instanceof Rook)
            {
                Rook leftRook = (Rook)piece;
                if (leftRook.getWasMotioned())
                {
                    result += FIELD_EMPTY;
                }
                else 
                {
                    result += "Q";
                }
            }
            
        }
        else
        {
            result += "-";
        }
        if (!blackKing.getWasMotioned())
        {
            Piece piece = chessboard.getSquare(0, 0).getPiece();
            if (piece instanceof Rook)
            {
                Rook rightRook = (Rook)piece;
                if (rightRook.getWasMotioned())
                {
                    result += FIELD_EMPTY;
                }
                else 
                {
                    result += "k";
                }
            }
            
            piece = chessboard.getSquare(7, 0).getPiece();
            if (piece instanceof Rook)
            {
                Rook leftRook = (Rook)piece;
                if (leftRook.getWasMotioned())
                {
                    result += FIELD_EMPTY;
                }
                else 
                {
                    result += "q";
                }
            }
            
        }
        else
        {
            result += FIELD_EMPTY;
        }
        return result;
    }

    private String exportChessboardFields(Game game)
    {
        String result = "";
        Chessboard chessboard = game.getChessboard();
        for (int y = Chessboard.FIRST_SQUARE; y <= Chessboard.LAST_SQUARE; y++) 
        {
            int emptySquares = 0;
            for (int x = Chessboard.FIRST_SQUARE; x <= Chessboard.LAST_SQUARE; x++)
            {
                Square sq = chessboard.getSquare(x, y);
                Piece piece = sq.getPiece();
                if (null == piece)
                {
                    emptySquares++;
                }
                else
                {
                    if (0 != emptySquares)
                    {
                        result += emptySquares;
                        emptySquares = 0;
                    }
                    String symbol = null;
                    if (piece instanceof Pawn)
                    {
                        symbol = "P";
                    }
                    else
                    {
                        symbol = piece.getSymbol();
                    }
                    result += piece.getPlayer().getColor() == Colors.WHITE ? symbol.toUpperCase() : symbol.toLowerCase();
                }
            }
            if (0 != emptySquares) 
            {
                result += emptySquares;
            }
            if (Chessboard.LAST_SQUARE != y)
            {
                result += ROW_SEPARATOR;
            }
            emptySquares = 0;
        }
        return result;
    }

    private String exportActivePlayer(Game game)
    {
        String result = "";
        if (Colors.WHITE == game.getActivePlayer().getColor())
        {
            result += "w";
        }
        else
        {
            result += "b";
        }
        return result;
    }
    
}
